package org.example.imfutures.service.Impl;


import com.huaweicloud.sdk.core.auth.AbstractCredentials;
import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.auth.ICredential;
import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.core.region.Region;
import com.huaweicloud.sdk.iotda.v5.IoTDAClient;
import com.huaweicloud.sdk.iotda.v5.model.*;
import org.apache.commons.codec.binary.Hex;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.imfutures.dto.CheckProperties;
import org.example.imfutures.dto.CommandDevice;
import org.example.imfutures.dto.InsertCar;
import org.example.imfutures.dto.Properties;
import org.example.imfutures.mapper.CarMapper;
import org.example.imfutures.pojo.Car;
import org.example.imfutures.pojo.DeviceConnect;
import org.example.imfutures.service.CarService;
import org.example.imfutures.utils.Callback;
import org.example.imfutures.utils.MQTTConnectUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarMapper mapper;

    //参数设置暂时写在代码里
    private static final String ak = "";
    private static final String sk = "";
    // ENDPOINT：请在控制台的"总览"界面的"平台接入地址"中查看“应用侧”的https接入地址。
    private static final String iotdaEndpoint = ";
    //地区
    private static final String region = "cn-north-4";

    ICredential auth = new BasicCredentials()
            // 标准版/企业版需要使用衍生算法，基础版请删除配置"withDerivedPredicate";
            .withDerivedPredicate(AbstractCredentials.DEFAULT_DERIVED_PREDICATE) // Used in derivative ak/sk authentication scenarios
            .withAk(ak)
            .withSk(sk);

    IoTDAClient client = IoTDAClient.newBuilder()
            .withCredential(auth)
            // 标准版/企业版：需自行创建Region对象，基础版：请使用IoTDARegion的region对象，如"withRegion(IoTDARegion.CN_NORTH_4)"
            .withRegion(new Region(region, iotdaEndpoint))
            .build();

    /**
     * 查询设备信息
     * @param id
     * @return
     */
    @Override
    public List<Car> selectCar(Integer id) {
        return mapper.selectCar(id);
    }

    /**
     * 添加设备
     * @param car
     */
    @Override
    public void insertCar(InsertCar car) {
        Car car1 = new Car();
        BeanUtils.copyProperties(car, car1);
        car1.setStatus(0);  //设置状态未连接
        AddDeviceRequest request = new AddDeviceRequest();
        AddDevice body = new AddDevice();
        List<InitialDesired> listbodyShadow = new ArrayList<>();
        listbodyShadow.add(new InitialDesired().withServiceId("Base")
                .withDesired("{\"温度\":\"20\""));
        body.withShadow(listbodyShadow);
        Random random = new Random();
        body.withDeviceName(car1.getType()+(random.nextInt(9000)+1000));  //设备名称
        body.withProductId("6819aa6284adf27cda55e622");  //产品id
        body.withDeviceId(car1.getFrameNumber());  //设备id
        body.withNodeId(car1.getFrameNumber());  //设备唯一标识(设备标识码)
        request.withBody(body);
        try {
            AddDeviceResponse response = client.addDevice(request);
            String secret = response.getAuthInfo().getSecret(); //获取密钥
            String time = response.getCreateTime().substring(0, 8);  //分割时间戳
            String stamp = response.getCreateTime().substring(9, 11);  //分割时间戳
            String timestamp = time + stamp;  //连接正确时间戳
            String password = encryptWithHmacSha256(timestamp, secret);  //生成密码
            String deviceId = response.getDeviceId();
            DeviceConnect device = new DeviceConnect();
            device.setDeviceId(deviceId);
            device.setSecret(secret);
            device.setPassword(password);
            device.setTimestamp(timestamp);
            device.setClientId(deviceId+"_0_0_"+timestamp);

            //转发到设备端
            String url = "http://localhost:8080/IMFuture/device/connect";
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.postForObject(url, device, String.class);
            System.out.println(result);
            car1.setClientId(deviceId+"_0_0_"+timestamp);
            car1.setPassword(password);
            car1.setType(response.getDeviceName());
            mapper.insertCar(car1);
        } catch (ConnectionException | RequestTimeoutException | ServiceResponseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserId(InsertCar car) {
        mapper.updateUserId(car);
    }

    /**
     * 断开设备连接
     *
     * @param id
     */
    @Override
    public void deleteCar(Integer[] id, String[] deviceIds) {
        for (int i = 0 ; i < id.length ; i++) {
            DeleteDeviceRequest request = new DeleteDeviceRequest();
            request.withDeviceId(deviceIds[i]);
            try {
                //删除云平台设备
//                DeleteDeviceResponse response = client.deleteDevice(request);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.delete("http://localhost:8080//IMFuture/device/disconnect/"+deviceIds[i]);
                mapper.deleteCar(id[i]);
            } catch (ConnectionException | RequestTimeoutException | ServiceResponseException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询设备是否存在
     * @param frameNumber
     * @return
     */
    @Override
    public Boolean selectCarIsHaving(String frameNumber) {
        return mapper.selectCarIsHaving(frameNumber);
    }

    /**
     * 查询设备基础属性
     *
     * @param serviceId
     * @param deviceId
     * @return
     */
    @Override
    public Properties listProperties(String serviceId, String deviceId) {
        ListPropertiesRequest request = new ListPropertiesRequest().withDeviceId(deviceId).withServiceId(serviceId);
        Properties properties = new Properties();
        try {
            ListPropertiesResponse response = client.listProperties(request);
            Object rawResponse = response.getResponse();
            if (rawResponse != null) {
                // 1. 操作反序列化的 Map/List 结构
                if (rawResponse instanceof Map) {
                    Map<String, Object> responseMap = (Map<String, Object>) rawResponse;
                    List<Map<String, Object>> services = (List<Map<String, Object>>) responseMap.get("services");
                    if (services != null && !services.isEmpty()) {
                        Map<String, Object> firstService = services.get(0);
                        Map<String, Object> props = (Map<String, Object>) firstService.get("properties");
                        // 2. 将属性值赋给 Properties 对象
                        if (props != null) {
                            properties.setLock((Boolean) props.get("车锁"));
                            properties.setWindows((Boolean) props.get("车窗"));
                            properties.setTemperature(((Number) props.get("温度")).intValue());
                            properties.setSentryMode((Boolean) props.get("哨兵模式"));
                            properties.setTrunk((Boolean) props.get("后备箱"));
                            properties.setVideo((Boolean) props.get("行车录像"));
                            properties.setHeatSeat((Boolean) props.get("座椅加热"));
                            properties.setSteer((Boolean) props.get("方向盘加热"));
                            properties.setCruise((Boolean) props.get("定速巡航"));
                            properties.setAutonomous((Boolean) props.get("自动驾驶"));
                            properties.setLocation((String) props.get("位置"));
                            properties.setCharging(((Number) props.get("电量")).intValue());
                            properties.setTotalMileage(((Number) props.get("总里程")).intValue());
                            properties.setMileage(((Number) props.get("行驶里程")).intValue());
                            properties.setRemainingMileage(((Number) props.get("剩余里程")).intValue());
                            properties.setEngine((Boolean) props.get("发动机状态"));
                            properties.setHac((Boolean) props.get("空调状态"));
                            properties.setHacTemperature(((Number) props.get("空调温度")).intValue());
                        }
                    }
                }
            }
            return properties;
        } catch (ConnectionException | RequestTimeoutException | ServiceResponseException e) {
            System.err.println("请求失败: " + e.getMessage());
            return null;
        }
    }


    /**
     * 查询设备检查属性
     *
     * @param serviceId
     * @param deviceId
     * @return
     */
    @Override
    public CheckProperties checkProperties(String serviceId, String deviceId) {
        ListPropertiesRequest request = new ListPropertiesRequest();
        request.withDeviceId(deviceId);
        request.withServiceId(serviceId);
        CheckProperties checkProperties = new CheckProperties();
        try {
            ListPropertiesResponse response = client.listProperties(request);
            Object rawResponse = response.getResponse();
            if (rawResponse != null) {
                Map<String, Object> responseMap = (Map<String, Object>) rawResponse;
                List<Map<String, Object>> services = (List<Map<String, Object>>) responseMap.get("services");
                if (services != null && !services.isEmpty()) {
                    Map<String, Object> firstService = services.get(0);
                    Map<String, Object> props = (Map<String, Object>) firstService.get("properties");
                    if (props != null) {
                        checkProperties.setFrontCover((Boolean) props.get("前舱盖"));
                        checkProperties.setEngine((Boolean) props.get("发动机状态"));
                        checkProperties.setBrake((Boolean) props.get("制动器"));
                        checkProperties.setABS((Boolean) props.get("ABS系统"));
                        checkProperties.setSteering((Boolean) props.get("转向系统"));
                        checkProperties.setCooling((Boolean) props.get("冷却系统"));
                        checkProperties.setElectric((Boolean) props.get("电力系统"));
                        checkProperties.setPower((Boolean) props.get("动力系统"));
                        checkProperties.setTire((Boolean) props.get("胎压系统"));
                        checkProperties.setLights((Boolean) props.get("照明系统"));
                        checkProperties.setAverageEnergy((Double) props.get("近50km平均能耗"));
                        checkProperties.setTotalAverageEnergy((Double) props.get("累计平均能耗"));
                    }
                }
            }
            return checkProperties;
        } catch (ConnectionException | RequestTimeoutException | ServiceResponseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 下发控制设备命令
     *
     * @param device
     * @return
     */
    @Override
    public Boolean commandDevice(CommandDevice device) {
        CreateCommandRequest request = new CreateCommandRequest();
        System.out.println("设备id为："+device.getDeviceId());
        request.withDeviceId(device.getDeviceId());
        DeviceCommandRequest body = new DeviceCommandRequest();
        // 判断data的类型，构造对应的paras字符串
        String paras = "";
        if (device.getDataBoolean() != null){
            paras = "{\"" + device.getName() + "\":" + device.getDataBoolean() + "}";
        }else if (device.getDataInteger() != null){
            paras = "{\"" + device.getName() + "\":" + device.getDataInteger() + "}";
        }
        System.out.println("paras字符串为："+paras);
        body.withParas(paras);
        body.withCommandName(device.getCommandName());
        body.withServiceId(device.getServiceId());
        request.withBody(body);
        try {
            CreateCommandResponse response = client.createCommand(request);
            Map<String, Object> responseMap = (Map<String, Object>) response.getResponse();
            Map<String, Object> props = (Map<String, Object>) responseMap.get("paras");
            System.out.println(props.get("响应参数名称："+device.getName()));
            return props.get("result").equals("success");
        } catch (ConnectionException | RequestTimeoutException | ServiceResponseException e) {
            System.out.println(e);
            return false;
        }
    }

    //将获取到的密钥和创建时间加密获取密码
    private static String encryptWithHmacSha256(String secret, String content) {
        try {
            Mac hmac = Mac.getInstance("HmacSHA256");
            hmac.init(new SecretKeySpec(secret.getBytes(), "HmacSHA256"));
            byte[] hash = hmac.doFinal(content.getBytes());
            return Hex.encodeHexString(hash);
        } catch (Exception e) {
            throw new RuntimeException("加密失败", e);
        }
    }

    /**
     * 查询连接参数
     * @param frameNumber
     * @return
     */
    @Override
    public Car selectConnect(String frameNumber) {
        return mapper.selectConnect(frameNumber);
    }
}

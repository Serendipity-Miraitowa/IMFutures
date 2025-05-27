package org.example.imfutures.controller;


import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.imfutures.dto.CheckProperties;
import org.example.imfutures.dto.Properties;
import org.example.imfutures.pojo.DeviceConnect;
import org.example.imfutures.utils.Callback;
import org.example.imfutures.utils.MQTTConnectUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Timer;
import java.util.TimerTask;


@CrossOrigin("*")
@RestController
@RequestMapping("/IMFuture/device")
public class VirtualDeviceController {

    //基础属性
    Properties properties = new Properties(false,false,true,false,false,false,false,false,false,false,false,"湖北省武汉市洪山区关山大道凌家山北路456号",23,60,43510,326,261,32);
    //检查属性
    CheckProperties check = new CheckProperties(true,true,true,true,true,true,true,true,true,false,32.8,30.6);
    MQTTConnectUtils mqttConnectUtils = new MQTTConnectUtils();
    MqttCallback callback = new Callback();




    /**
     * 连接云平台
     * @param device
     * @return
     */
    @PostMapping("/connect")
    public String connect(@RequestBody DeviceConnect device) {
        try {
            //连接平台
            mqttConnectUtils.connect(device.getClientId(), device.getPassword(), device.getDeviceId(), callback);
            //设备属性上报
            mqttConnectUtils.publish("$oc/devices/"+device.getDeviceId()+"/sys/properties/report", properties, "Base");
            mqttConnectUtils.publish("$oc/devices/"+device.getDeviceId()+"/sys/properties/report", check, "Check");
            return "设备连接成功";
        } catch (MqttException e) {
            e.printStackTrace();
            return "设备连接失败";
        }
    }


    /**
     * 获取属性数据
     * @return
     */
    @GetMapping("/property")
    public ResponseEntity<String> getProperty(@RequestParam("topic") String topic, @RequestParam("serviceId") String serviceId, @RequestParam("deviceId") String deviceId) {

        try {
            if (serviceId.equals("Base")){
                //设备属性上报
                mqttConnectUtils.publish(topic, properties, serviceId);
                mqttConnectUtils.publish("$oc/devices/"+deviceId+"/sys/properties/report", properties, "Base");
                mqttConnectUtils.publish("$oc/devices/"+deviceId+"/sys/properties/report", check, "Check");
                return ResponseEntity.ok().body("获取Base属性数据成功");
            }else if (serviceId.equals("Check")){
                mqttConnectUtils.publish(topic, check, serviceId);
                mqttConnectUtils.publish("$oc/devices/"+deviceId+"/sys/properties/report", properties, "Base");
                mqttConnectUtils.publish("$oc/devices/"+deviceId+"/sys/properties/report", check, "Check");
                return ResponseEntity.ok().body("获取Check属性数据成功");
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("获取属性数据失败");
    }


    /**
     * 执行命令
     * @return
     */
    @GetMapping("/command")
    public ResponseEntity<String> setCommand(@RequestParam("topic") String topic, @RequestParam("data") String data, @RequestParam("values") String values, @RequestParam("deviceId") String deviceId){
        try {
            switch (data) {
                case "空调开启":
                    Boolean value = Boolean.parseBoolean(values);
                    properties.setHac(value);
                    break;
                case "温度":
                    Integer valueTemp = Integer.parseInt(values);
                    properties.setHacTemperature(valueTemp);
                    // 如果车内温度小于空调温度，变化车内温度
                    Timer timer = new Timer();
                    if (properties.getTemperature() < properties.getHacTemperature()) {
                        TimerTask timerTaskIncrease = new TimerTask() {
                            @Override
                            public void run() {
                                synchronized (properties) {
                                    int num = properties.getTemperature();
                                    num = num + 1;
                                    properties.setTemperature(num);
                                    if (num >= properties.getHacTemperature()) {
                                        // 关闭定时任务
                                        timer.purge();
                                        timer.cancel();
                                    }
                                }
                            }
                        };
                        // 开启定时任务
                        timer.schedule(timerTaskIncrease, 0, 1000);
                    } else if (properties.getTemperature() > properties.getHacTemperature()) {
                        // 如果车内温度大于空调温度，变化车内温度
                        TimerTask timerTaskDecrease = new TimerTask() {
                            @Override
                            public void run() {
                                synchronized (properties) {
                                    int num = properties.getTemperature();
                                    num = num - 1;
                                    properties.setTemperature(num);
                                    if (num <= properties.getHacTemperature()) { // 修改条件为 <=
                                        // 关闭定时任务
                                        timer.purge();
                                        timer.cancel();
                                    }
                                }
                            }
                        };
                        // 开启定时任务
                        timer.schedule(timerTaskDecrease, 0, 1000);
                    }
                    break;
                case "车锁":
                    Boolean valueLock = Boolean.parseBoolean(values);
                    properties.setLock(valueLock);
                    break;
                case "哨兵模式":
                    Boolean valueSentry = Boolean.parseBoolean(values);
                    properties.setSentryMode(valueSentry);
                    break;
                case "后备箱":
                    Boolean valueTrunk = Boolean.parseBoolean(values);
                    properties.setTrunk(valueTrunk);
                    break;
                case "行车录像":
                    Boolean valueVideo = Boolean.parseBoolean(values);
                    properties.setVideo(valueVideo);
                    break;
                case "座椅加热":
                    Boolean valueHeatSeat = Boolean.parseBoolean(values);
                    properties.setHeatSeat(valueHeatSeat);
                    break;
                case "方向盘加热":
                    Boolean valueSteer = Boolean.parseBoolean(values);
                    properties.setSteer(valueSteer);
                    break;
                case "定速巡航":
                    Boolean valueCruise = Boolean.parseBoolean(values);
                    properties.setCruise(valueCruise);
                    break;
                case "自动驾驶":
                    Boolean valueAutonomous = Boolean.parseBoolean(values);
                    properties.setAutonomous(valueAutonomous);
                    break;
                case "一键召唤":
                    // TODO: 一键召唤的实现
                    break;
                case "一键泊车":
                    // TODO: 一键泊车的实现
                    break;
                case "闪灯鸣笛":
                    // TODO: 闪灯鸣笛的实现
                    break;
                case "车窗":
                    Boolean valueWindows = Boolean.parseBoolean(values);
                    properties.setWindows(valueWindows);
                    break;
                case "开启音乐":
                    // TODO: 开启音乐的实现
                    break;
                default:
                    // 处理未知的 data 值
                    System.out.println("未知的控制命令: " + data);
                    break;
            }
            mqttConnectUtils.publishCommand(topic);
            //上报消息
            mqttConnectUtils.publish("$oc/devices/"+deviceId+"/sys/properties/report", properties, "Base");
            System.out.println("上报消息成功");
            mqttConnectUtils.publish("$oc/devices/"+deviceId+"/sys/properties/report", check, "Check");
            return ResponseEntity.ok().body("命令执行成功");
        } catch (MqttException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("命令执行失败");
    }
}

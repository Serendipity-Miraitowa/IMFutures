package org.example.imfutures;

import com.huaweicloud.sdk.core.auth.AbstractCredentials;
import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.auth.ICredential;
import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.core.region.Region;
import com.huaweicloud.sdk.iotda.v5.*;
import com.huaweicloud.sdk.iotda.v5.model.*;
import org.apache.commons.codec.binary.Hex;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.imfutures.dto.CheckProperties;
import org.example.imfutures.dto.Properties;
import org.example.imfutures.utils.Callback;
import org.example.imfutures.utils.MQTTConnectUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.text.SimpleDateFormat;
import java.util.*;

public class demo {

    // The AK and SK used for authentication are hard-coded or stored in plaintext, which has great security risks. It is recommended that the AK and SK be stored in ciphertext in configuration files or environment variables and decrypted during use to ensure security.
    // In this example, AK and SK are stored in environment variables for authentication. Before running this example, set environment variables CLOUD_SDK_AK and CLOUD_SDK_SK in the local environment
    private static final String ak = "";
    private static final String sk = "";
    // ENDPOINT：请在控制台的"总览"界面的"平台接入地址"中查看“应用侧”的https接入地址。
    private static final String iotdaEndpoint = "99fbda0a9a.st1.iotda-app.cn-north-4.myhuaweicloud.com";

    private static final ICredential auth = new BasicCredentials()
            // 标准版/企业版需要使用衍生算法，基础版请删除配置"withDerivedPredicate";
            .withDerivedPredicate(AbstractCredentials.DEFAULT_DERIVED_PREDICATE) // Used in derivative ak/sk authentication scenarios
            .withAk(ak)
            .withSk(sk);

    private static final IoTDAClient client = IoTDAClient.newBuilder()
            .withCredential(auth)
            // 标准版/企业版：需自行创建Region对象，基础版：请使用IoTDARegion的region对象，如"withRegion(IoTDARegion.CN_NORTH_4)"
            .withRegion(new Region("cn-north-4", iotdaEndpoint))
            .build();

    //平台查询设备属性
/*    public static void main(String[] args) {
        ListPropertiesRequest request = new ListPropertiesRequest();
        request.withDeviceId("6819aa6284adf27cda55e622_1230123");
        request.withServiceId("Base");
        try {
            ListPropertiesResponse response = client.listProperties(request);
            System.out.println(response);
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (RequestTimeoutException e) {
            e.printStackTrace();
        } catch (ServiceResponseException e) {
            e.printStackTrace();
            System.out.println(e.getHttpStatusCode());
            System.out.println(e.getRequestId());
            System.out.println(e.getErrorCode());
            System.out.println(e.getErrorMsg());
        }
    }*/

    /*public class ListDevicesSolution {

        // REGION_ID：如果是上海一，请填写"cn-east-3"；如果是北京四，请填写"cn-north-4";如果是华南广州，请填写"cn-south-1"
        private static final String REGION_ID = "cn-north-4";
        // ENDPOINT：请在控制台的"总览"界面的"平台接入地址"中查看“应用侧”的https接入地址。
        private static final String ENDPOINT = "99fbda0a9a.st1.iotda-app.cn-north-4.myhuaweicloud.com";

        public static void main(String[] args) {
            // 认证用的ak和sk直接写到代码中有很大的安全风险，建议在配置文件或者环境变量中密文存放，使用时解密，确保安全；
            // 本示例以ak和sk保存在环境变量中为例，运行本示例前请先在本地环境中设置环境变量HUAWEICLOUD_SDK_AK和HUAWEICLOUD_SDK_SK。
            String ak = System.getenv("HPUAKUVCFBBGOVHLURA7");
            String sk = System.getenv("97hdkUcs5e4q7ruBKbytXuGXUs2xCgbTb4x1cZ3c");
            String projectId = "2a3e71492a0540f7be993a30d5cd9962";

            // 创建认证
            ICredential auth = new BasicCredentials()
                    .withAk(ak)
                    .withSk(sk)
                    // 标准版/企业版需要使用衍生算法，基础版请删除配置"withDerivedPredicate"
                    .withDerivedPredicate(BasicCredentials.DEFAULT_DERIVED_PREDICATE)
                    .withProjectId(projectId);

            // 创建IoTDAClient实例并初始化
            IoTDAClient client = IoTDAClient.newBuilder()
                    .withCredential(auth)
                    // 标准版/企业版：需自行创建Region对象，基础版：请使用IoTDARegion的region对象，如"withRegion(IoTDARegion.CN_NORTH_4)"
                    .withRegion(new Region(REGION_ID, ENDPOINT))
                    // .withRegion(IoTDARegion.CN_NORTH_4)
                    // 配置是否忽略SSL证书校验， 默认不忽略
                    // .withHttpConfig(new HttpConfig().withIgnoreSSLVerification(true))
                    .build();

            // 实例化请求对象
            ListDevicesRequest request = new ListDevicesRequest();
            try {
                // 调用查询设备列表接口
                ListDevicesResponse response = client.listDevices(request);
                System.out.println(response.toString());
            } catch (ConnectionException e) {
                e.printStackTrace();
            } catch (RequestTimeoutException e) {
                e.printStackTrace();
            } catch (ServiceResponseException e) {
                e.printStackTrace();
                System.out.println(e.getHttpStatusCode());
                System.out.println(e.getErrorCode());
                System.out.println(e.getErrorMsg());
            }
        }
    }*/

    //命令参数类
    public static class Paras {
        String name;
        Boolean value;

        public Paras() {
        }

        public Paras(String name, Boolean value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getValue() {
            return value;
        }

        public void setValue(Boolean value) {
            this.value = value;
        }
    }

    /*//平台下发命令
    public static void main(String[] args) {
        IoTDAClient client = IoTDAClient.newBuilder()
                .withCredential(auth)
                // 标准版/企业版：需自行创建Region对象，基础版：请使用IoTDARegion的region对象，如"withRegion(IoTDARegion.CN_NORTH_4)"
                .withRegion(new Region("cn-north-4", iotdaEndpoint))
                .build();
        CreateCommandRequest request = new CreateCommandRequest();
        DeviceCommandRequest body = new DeviceCommandRequest();
        body.setServiceId("Base");
        body.setCommandName("后备箱");
        Paras paras = new Paras();
        paras.setName("后备箱");
        paras.setValue(false);
        body.setParas(paras);
        request.withDeviceId("681f679b84adf27cda57577e_123456");
        request.withBody(body);
        try {
            CreateCommandResponse response = client.createCommand(request);
            System.out.println(response.toString());
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (RequestTimeoutException e) {
            e.printStackTrace();
        } catch (ServiceResponseException e) {
            e.printStackTrace();
            System.out.println(e.getHttpStatusCode());
            System.out.println(e.getRequestId());
            System.out.println(e.getErrorCode());
            System.out.println(e.getErrorMsg());
        }
    }*/

    //创建设备
    public static void main(String[] args) {
        AddDeviceRequest request = new AddDeviceRequest();
        AddDevice body = new AddDevice();
        List<InitialDesired> listbodyShadow = new ArrayList<>();
        listbodyShadow.add(
                new InitialDesired()
                        .withServiceId("Base")
                        .withDesired("{\"温度\":\"20\"}")
                        /*.withServiceId("check")
                        .withDesired("{\"后备箱\":true}")*/
        );
        body.withShadow(listbodyShadow);
        body.withProductId("6819aa6284adf27cda55e622");
        body.withNodeId(String.valueOf((new Random().nextInt(900000)+100000)));  //设备唯一标识(设备标识码)
        request.withBody(body);
        try {
            AddDeviceResponse response = client.addDevice(request);
            String secret = response.getAuthInfo().getSecret();
            System.out.println("密钥为："+response.getAuthInfo().getSecret());
            System.out.println("时间戳为："+response.getCreateTime());
            System.out.println("用户名为：" + response.getDeviceId());
            String time = response.getCreateTime().substring(0, 8);
            String stamp = response.getCreateTime().substring(9, 11);
            String timestamp = time + stamp;
            String password = encryptWithHmacSha256(timestamp, secret);
            MQTTConnectUtils mqttConnectUtils = new MQTTConnectUtils();
            MqttCallback callback = new Callback();
            mqttConnectUtils.connect(response.getDeviceId()+"_0_0_"+timestamp, password, response.getDeviceId(), callback);

            ShowDeviceShadowRequest requests = new ShowDeviceShadowRequest();
            requests.withDeviceId(response.getDeviceId());
            ShowDeviceShadowResponse responses = client.showDeviceShadow(requests);
            System.out.println("设备影子数据："+responses.toString());
        } catch (ConnectionException | RequestTimeoutException | ServiceResponseException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }

    //删除设备
    /*public static void main(String[] args) {
        DeleteDeviceRequest request = new DeleteDeviceRequest();
        request.withDeviceId("6819aa6284adf27cda55e622_1230203");
        try {
            DeleteDeviceResponse response = client.deleteDevice(request);
            System.out.println(response.toString());
        } catch (ConnectionException | RequestTimeoutException | ServiceResponseException e) {
            e.printStackTrace();
        }
    }*/

    /*public static void main(String[] args) {

    }*/

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
}

package org.example.imfutures.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.example.imfutures.dto.CheckProperties;
import org.example.imfutures.dto.Properties;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 常规MQTT回调函数
 *
 * @author Mr.Qu
 * @since 2020/1/9 16:26
 */
@Slf4j
public class Callback implements MqttCallback {

    /**
     * MQTT 断开连接会执行此方法
     */
    @Override
    public void connectionLost(Throwable throwable) {
        /*log.info("断开了MQTT连接 ：{}", throwable.getMessage());
        log.error(throwable.getMessage(), throwable);*/
    }

    /**
     * publish发布成功后会执行到这里
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        /*log.info("发布消息成功");*/
        System.out.println("发布消息成功");
    }

    /**
     * subscribe订阅后得到的消息会执行到这里
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        //  TODO    此处可以将订阅得到的消息进行业务处理、数据存储
        /*log.info("收到来自 " + topic + " 的消息：{}", new String(message.getPayload()));*/
        System.out.println("收到来自 " + topic + " 的消息：" + new String(message.getPayload()));

        String payload = new String(message.getPayload());
        JsonObject json = new Gson().fromJson(payload, JsonObject.class);

        String[] topics = topic.split("=");
        String[] topices = topic.split("/");
        String deviceId = topices[2];
        String request_id = topics[1];
        System.out.println("aaa主题是：" + topices[4]);
        RestTemplate restTemplate = new RestTemplate();
        //属性查询
        if (topices[4].equals("properties")) {
            String topicProperties = "$oc/devices/" + deviceId + "/sys/properties/get/response/request_id=" + request_id;
            String url = "http://localhost:8080/IMFuture/device/property";
            String serviceId = null;
            //判断返回的参数类型
            if (json.has("services") && json.get("services").isJsonArray()) {
                JsonArray array = json.getAsJsonArray("services");
                System.out.println("获取到的json数组:" + array.toString());
                if (array.size() > 0) {
                    JsonObject firstService = array.get(0).getAsJsonObject();
                    System.out.println("数组的第一个json对象：" + firstService);
                    serviceId = firstService.get("service_id").getAsString();
                } else {
                    System.out.println("json数组为空");
                }
            } else {
                if (json.has("service_id")) {
                    serviceId = json.get("service_id").getAsString();
                }else {
                    System.out.println("没有service_id字段");
                }
            }
            UriComponents components = UriComponentsBuilder.fromUriString(url)
                    .queryParam("topic", topicProperties)
                    .queryParam("serviceId", serviceId)
                    .queryParam("deviceId", deviceId)
                    .encode()
                    .build();
            String result = null;
            try {
                result = String.valueOf(restTemplate.getForEntity(components.toUri(), String.class));
            } catch (RestClientException e) {
                e.printStackTrace();
            }
            System.out.println("执行结果是：" + result);
            //命令响应
        } else if (topices[4].equals("commands")) {
            String topicCommand = "$oc/devices/" + deviceId + "/sys/commands/response/request_id=" + request_id;
            String urls = "http://localhost:8080/IMFuture/device/command";
            JsonObject object = json.getAsJsonObject("paras");
            String data = "";
            String values = "";
            if (!object.entrySet().isEmpty()){
                Map.Entry<String, JsonElement> entry = object.entrySet().iterator().next();
                data = entry.getKey();  //获取参数名
                System.out.println("参数名："+data);
                JsonElement value = entry.getValue();
                //判断是否为基本类型
                if (value.isJsonPrimitive()) {
                    values = value.getAsString();
                    System.out.println("参数值："+values);
                }
            }
            UriComponents components = UriComponentsBuilder.fromUriString(urls)
                    .queryParam("topic", topicCommand)
                    .queryParam("data", data)
                    .queryParam("values", values)
                    .queryParam("deviceId", deviceId)
                    .encode()
                    .build();
            try {
                String result = String.valueOf(restTemplate.getForEntity(components.toUri(), String.class));
                System.out.println("执行结果是：" + result);
            } catch (RestClientException e) {
                e.printStackTrace();
            }
        }
    }
}

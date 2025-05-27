package org.example.imfutures.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.eclipse.paho.client.mqttv3.*;
import org.example.imfutures.dto.CheckProperties;
import org.example.imfutures.dto.Properties;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class MQTTConnectUtils {

    private final static String address = "SSL://99fbda0a9a.st1.iotda-device.cn-north-4.myhuaweicloud.com:8883";

    MqttClient client;

    /**
     * 客户端连接华为云平台
     * @param clientId
     * @param password
     * @param username
     * @param callback
     * @throws MqttException
     */
    public void connect(String clientId, String password, String username, MqttCallback callback) throws MqttException {
        client = new MqttClient(address, clientId);
        MqttConnectOptions options = new MqttConnectOptions();  //连接参数设置
        options.setCleanSession(true);
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        options.setAutomaticReconnect(true);
        if (callback == null){
            client.setCallback(new Callback());
        }else {
            client.setCallback(callback);
        }
        client.connect(options);
        System.out.println("连接成功");
    }

    /**
     * 订阅某一主题，此方法默认的的Qos等级为：1
     * @param topic
     * @throws MqttException
     */
    public void subscribe(String topic) throws MqttException {
        client.subscribe(topic, 0);
    }

    /**
     * 向某一主题发送消息
     * @param topic
     * @param message
     * @throws MqttException
     */
    public void publish(String topic, String message) throws MqttException {
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload(message.getBytes(StandardCharsets.UTF_8));
        MqttTopic top = client.getTopic(topic);
        MqttDeliveryToken token = top.publish(mqttMessage);
        token.waitForCompletion();
    }

    /**
     * 向某个主题发送对象类型的消息
     * @param topic
     * @param o
     * @throws MqttException
     */
    public void publish(String topic, Object o) throws MqttException {
        MqttMessage message = new MqttMessage();
        message.setPayload(o.toString().getBytes(StandardCharsets.UTF_8));
        MqttTopic top = client.getTopic(topic);
        MqttDeliveryToken token = top.publish(message);
        token.waitForCompletion();
    }

    /**
     * 向某个主题发送JSON类型消息
     * @param topic
     * @param o
     * @throws MqttException
     */
    public void publishJSON(String topic, Object o) throws MqttException {
        MqttMessage message = new MqttMessage();  //封装要发布的消息
        JsonObject json = new Gson().toJsonTree(o).getAsJsonObject();  //将对象转化为json对象
        message.setPayload(json.toString().getBytes(StandardCharsets.UTF_8));  //设置消息内容为JSON字符串的字节数组，StandardCharsets.UTF_8:明确指定UTF-8编码
        MqttTopic top = client.getTopic(topic);  //获取要发布的主题
        MqttDeliveryToken token = top.publish(message);
        token.waitForCompletion();  //等待消息发布完成。这会阻塞当前线程，直到消息发布完成或超时
    }


    /**
     * 向华为云lot平台某个设备某个主题发送JSON类型消息
     * @param topic  //主题
     * @param o  //属性对象
     * @param serviceId  //服务id
     */
    public void publish(String topic, Object o, String serviceId) throws MqttException {
        MqttMessage message = new MqttMessage();
        JsonObject json = new Gson().toJsonTree(o).getAsJsonObject();
        JsonObject service = new JsonObject();
        service.addProperty("serviceId", serviceId);
        service.addProperty("eventTime", formatIsoTime(new Timestamp(System.currentTimeMillis())));  //时间戳
        service.add("properties", json);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(service);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("services", jsonArray);

        message.setPayload(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        MqttTopic top = client.getTopic(topic);
        MqttDeliveryToken token = top.publish(message);
        token.waitForCompletion();
    }

    /**
     * 向华为云lot平台某一主题发送命令响应消息
     * @param topic
     * @throws MqttException
     */
    public void publishCommand(String topic) throws MqttException {
        MqttMessage message = new MqttMessage();
        JsonObject json = new JsonObject();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result", "success");
        json.addProperty("result_code", 0);
        json.addProperty("response_name", "COMMAND_RESPONSE");
        json.add("paras", jsonObject);
        message.setPayload(json.toString().getBytes(StandardCharsets.UTF_8));
        MqttTopic top = client.getTopic(topic);
        MqttDeliveryToken token = top.publish(message);
        token.waitForCompletion();
    }

    /**
     * 关闭连接
     */
    public void close() throws MqttException {
        client.disconnect();
        client.close();
    }

    /**
     * ISO 8601时间格式化
     * @param timestamp
     * @return
     */
    private String formatIsoTime(Timestamp timestamp) {
        Instant instant = timestamp.toInstant();
        return DateTimeFormatter.ISO_INSTANT.format(instant);
    }

}

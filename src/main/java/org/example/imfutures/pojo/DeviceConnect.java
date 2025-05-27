package org.example.imfutures.pojo;

public class DeviceConnect {
    private String deviceId;  //设备id(用户名)
    private String clientId;  //实例id
    private String timestamp;  //连接时间戳
    private String password;  //密码
    private String secret;  //密钥

    public DeviceConnect() {
    }

    public DeviceConnect(String deviceId, String clientId, String timestamp, String password, String secret) {
        this.deviceId = deviceId;
        this.clientId = clientId;
        this.timestamp = timestamp;
        this.password = password;
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DeviceConnect{" +
                "deviceId='" + deviceId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

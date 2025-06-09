package org.example.imfutures.pojo;


import lombok.Data;

@Data
public class DeviceConnect {
    private String deviceId;  //设备id(用户名)
    private String clientId;  //实例id
    private String timestamp;  //连接时间戳
    private String password;  //密码
    private String secret;  //密钥

}

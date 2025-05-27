package org.example.imfutures.pojo;

import lombok.Data;

@Data
//车辆实体类
public class Car {
    private Integer id;
    private String type; //车辆类型
    private String frameNumber;  //车辆vin号
    private Integer userId; //用户id
    private Integer status; //状态
    private String clientId;  //实例id
    private String password;  //密码
    private String img;

    public Car() {
    }

    public Car(Integer id, String type, String frameNumber, Integer userId, Integer status, String clientId, String password, String img) {
        this.id = id;
        this.type = type;
        this.frameNumber = frameNumber;
        this.userId = userId;
        this.status = status;
        this.clientId = clientId;
        this.password = password;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(String frameNumber) {
        this.frameNumber = frameNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

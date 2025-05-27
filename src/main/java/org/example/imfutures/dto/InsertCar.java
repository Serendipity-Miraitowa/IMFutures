package org.example.imfutures.dto;

import lombok.Data;

//添加车辆类
@Data
public class InsertCar {
    private String type; //车辆类型
    private String frameNumber;  //车辆vin号
    private Integer userId; //用户id
    private String img;

    public InsertCar() {
    }

    public InsertCar(String type, String frameNumber, Integer userId, String img) {
        this.type = type;
        this.frameNumber = frameNumber;
        this.userId = userId;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

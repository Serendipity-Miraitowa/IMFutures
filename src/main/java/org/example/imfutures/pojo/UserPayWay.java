package org.example.imfutures.pojo;

import lombok.Data;

//支付方式
@Data
public class UserPayWay {
    private Integer id;
    private Integer userId; //用户id
    private String name; //支付方式名称
    private String number; //支付方式号码

    public UserPayWay() {
    }

    public UserPayWay(Integer id, Integer userId, String name, String number) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

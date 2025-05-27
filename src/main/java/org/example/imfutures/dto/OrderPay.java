package org.example.imfutures.dto;


import lombok.Data;

import java.util.Date;

//充电预定订单实体类
@Data
public class OrderPay {
    private double amount;  //账单金额
    private Integer id;  //订单id
    private Integer userId; //用户id
    private Date date; //预定日期
    private String time; //预定时间
    private Integer chargingPiesId; //充电桩
    private Integer chargingStationsId; //充电站
    private Integer status; //状态
    private String serialNo; //订单号
    private Integer commentId;  //评论id

    public OrderPay() {
    }

    public OrderPay(double amount, Integer id, Integer userId, Date date, String time, Integer chargingPiesId, Integer chargingStationsId, Integer status, String serialNo, Integer commentId) {
        this.amount = amount;
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.time = time;
        this.chargingPiesId = chargingPiesId;
        this.chargingStationsId = chargingStationsId;
        this.status = status;
        this.serialNo = serialNo;
        this.commentId = commentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getChargingPiesId() {
        return chargingPiesId;
    }

    public void setChargingPiesId(Integer chargingPiesId) {
        this.chargingPiesId = chargingPiesId;
    }

    public Integer getChargingStationsId() {
        return chargingStationsId;
    }

    public void setChargingStationsId(Integer chargingStationsId) {
        this.chargingStationsId = chargingStationsId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}

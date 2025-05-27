package org.example.imfutures.pojo;

import lombok.Data;

import java.util.Date;

//支付账单实体类
@Data
public class Pay {
    private Integer id;  //账单id
    private Integer userId; //用户id
    private Integer chargingStationId; //充电站
    private Integer chargingPieId;  //充电桩id
    private String serialNo;  //账单号
    private String payWay;  //支付方式
    private String chargingTime; //充电时间
    private Integer orderId; //订单id
    private Date date; //账单日期
    private double amount; //订单金额
    private String time; //开始充电的时间

    public Pay() {
    }

    public Pay(Integer id, Integer userId, Integer chargingStationId, Integer chargingPieId, String serialNo, String payWay, String chargingTime, Integer orderId, Date date, double amount, String time) {
        this.id = id;
        this.userId = userId;
        this.chargingStationId = chargingStationId;
        this.chargingPieId = chargingPieId;
        this.serialNo = serialNo;
        this.payWay = payWay;
        this.chargingTime = chargingTime;
        this.orderId = orderId;
        this.date = date;
        this.amount = amount;
        this.time = time;
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

    public Integer getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(Integer chargingStationId) {
        this.chargingStationId = chargingStationId;
    }

    public Integer getChargingPieId() {
        return chargingPieId;
    }

    public void setChargingPieId(Integer chargingPieId) {
        this.chargingPieId = chargingPieId;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getChargingTime() {
        return chargingTime;
    }

    public void setChargingTime(String chargingTime) {
        this.chargingTime = chargingTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "id=" + id +
                ", userId=" + userId +
                ", chargingStationId=" + chargingStationId +
                ", chargingPieId=" + chargingPieId +
                ", serialNo='" + serialNo + '\'' +
                ", payWay='" + payWay + '\'' +
                ", chargingTime='" + chargingTime + '\'' +
                ", orderId=" + orderId +
                ", date=" + date +
                ", amount=" + amount +
                ", time='" + time + '\'' +
                '}';
    }
}

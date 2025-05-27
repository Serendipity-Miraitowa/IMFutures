package org.example.imfutures.dto;

import java.util.Date;

public class PayDetail {
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
    private String address;  //地址
    private String company;  //充电公司

    public PayDetail() {
    }

    public PayDetail(Integer id, Integer userId, Integer chargingStationId, Integer chargingPieId, String serialNo, String payWay, String chargingTime, Integer orderId, Date date, double amount, String address, String company) {
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
        this.address = address;
        this.company = company;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

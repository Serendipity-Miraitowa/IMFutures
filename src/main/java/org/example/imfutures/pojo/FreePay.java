package org.example.imfutures.pojo;

import java.sql.Time;

public class FreePay {

    private Integer id;
    private Integer chargingStationId;
    private String serialNo;
    private Time time;
    private String account;
    private Integer userId;

    public FreePay() {
    }

    public FreePay(Integer id, Integer chargingStationId, String serialNo, Time time, String account, Integer userId) {
        this.id = id;
        this.chargingStationId = chargingStationId;
        this.serialNo = serialNo;
        this.time = time;
        this.account = account;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(Integer chargingStationId) {
        this.chargingStationId = chargingStationId;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

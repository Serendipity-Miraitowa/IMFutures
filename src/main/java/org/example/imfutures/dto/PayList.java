package org.example.imfutures.dto;

public class PayList {
    private Integer uid;
    private Integer chargingStationId;

    public PayList() {
    }

    public PayList(Integer uid, Integer chargingStationId) {
        this.uid = uid;
        this.chargingStationId = chargingStationId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(Integer chargingStationId) {
        this.chargingStationId = chargingStationId;
    }
}

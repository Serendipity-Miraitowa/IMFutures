package org.example.imfutures.pojo;

import lombok.Data;

@Data
//充电桩实体类
public class ChargingPies {
    private Integer id;
    private String name; //充电桩名称
    private String type; //充电桩类型
    private String energy; //充电桩瓦数
    private Integer status; //充电桩状态
    private Integer chargingStationId; //充电柱所属充电站id
    private String speed; //充电速度

    public ChargingPies() {
    }

    public ChargingPies(Integer id, String name, String type, String energy, Integer status, Integer chargingStationId, String speed) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.energy = energy;
        this.status = status;
        this.chargingStationId = chargingStationId;
        this.speed = speed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(Integer chargingStationId) {
        this.chargingStationId = chargingStationId;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}

package org.example.imfutures.dto;


import lombok.Data;


//命令下发实体
@Data
public class CommandDevice {
    private String serviceId;  //服务id
    private String deviceId;  //设备id
    private String commandName;  //命令名称
    private String name;  //命令参数名称
    private Integer dataInteger;  //命令参数值
    private Boolean dataBoolean;  //命令参数值

    public CommandDevice() {
    }

    public CommandDevice(String serviceId, String deviceId, String commandName, String name, Integer dataInteger, Boolean dataBoolean) {
        this.serviceId = serviceId;
        this.deviceId = deviceId;
        this.commandName = commandName;
        this.name = name;
        this.dataInteger = dataInteger;
        this.dataBoolean = dataBoolean;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDataInteger() {
        return dataInteger;
    }

    public void setDataInteger(Integer dataInteger) {
        this.dataInteger = dataInteger;
    }

    public Boolean getDataBoolean() {
        return dataBoolean;
    }

    public void setDataBoolean(Boolean dataBoolean) {
        this.dataBoolean = dataBoolean;
    }
}

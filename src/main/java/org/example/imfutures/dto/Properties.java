package org.example.imfutures.dto;

import com.google.gson.annotations.SerializedName;

//设备基础属性实体
public class Properties {

    @SerializedName("车锁")
    private Boolean lock;  //车锁
    @SerializedName("车窗")
    private Boolean windows; //车窗
    @SerializedName("哨兵模式")
    private Boolean sentryMode; //哨兵模式
    @SerializedName("后备箱")
    private Boolean trunk; //后备箱
    @SerializedName("行车录像")
    private Boolean video; //行车录像
    @SerializedName("座椅加热")
    private Boolean heatSeat; //座椅加热
    @SerializedName("方向盘加热")
    private Boolean steer; //方向盘加热
    @SerializedName("定速巡航")
    private Boolean cruise; //定速巡航
    @SerializedName("自动驾驶")
    private Boolean autonomous; //自动驾驶
    @SerializedName("发动机状态")
    private Boolean engine; //发动机状态
    @SerializedName("空调状态")
    private Boolean hac; //空调状态
    @SerializedName("位置")
    private String location; //位置
    @SerializedName("温度")
    private Integer temperature;  //温度
    @SerializedName("电量")
    private Integer charging; //电量
    @SerializedName("总里程")
    private Integer totalMileage; //总里程
    @SerializedName("行驶里程")
    private Integer mileage; //行驶里程
    @SerializedName("剩余里程")
    private Integer remainingMileage; //剩余里程
    @SerializedName("空调温度")
    private Integer hacTemperature; //空调温度

    public Properties() {
    }

    public Properties(Boolean lock, Boolean windows, Boolean sentryMode, Boolean trunk, Boolean video, Boolean heatSeat, Boolean steer, Boolean cruise, Boolean autonomous, Boolean engine, Boolean hac, String location, Integer temperature, Integer charging, Integer totalMileage, Integer mileage, Integer remainingMileage, Integer hacTemperature) {
        this.lock = lock;
        this.windows = windows;
        this.sentryMode = sentryMode;
        this.trunk = trunk;
        this.video = video;
        this.heatSeat = heatSeat;
        this.steer = steer;
        this.cruise = cruise;
        this.autonomous = autonomous;
        this.engine = engine;
        this.hac = hac;
        this.location = location;
        this.temperature = temperature;
        this.charging = charging;
        this.totalMileage = totalMileage;
        this.mileage = mileage;
        this.remainingMileage = remainingMileage;
        this.hacTemperature = hacTemperature;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    public Boolean getWindows() {
        return windows;
    }

    public void setWindows(Boolean windows) {
        this.windows = windows;
    }

    public Boolean getSentryMode() {
        return sentryMode;
    }

    public void setSentryMode(Boolean sentryMode) {
        this.sentryMode = sentryMode;
    }

    public Boolean getTrunk() {
        return trunk;
    }

    public void setTrunk(Boolean trunk) {
        this.trunk = trunk;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Boolean getHeatSeat() {
        return heatSeat;
    }

    public void setHeatSeat(Boolean heatSeat) {
        this.heatSeat = heatSeat;
    }

    public Boolean getSteer() {
        return steer;
    }

    public void setSteer(Boolean steer) {
        this.steer = steer;
    }

    public Boolean getCruise() {
        return cruise;
    }

    public void setCruise(Boolean cruise) {
        this.cruise = cruise;
    }

    public Boolean getAutonomous() {
        return autonomous;
    }

    public void setAutonomous(Boolean autonomous) {
        this.autonomous = autonomous;
    }

    public Boolean getEngine() {
        return engine;
    }

    public void setEngine(Boolean engine) {
        this.engine = engine;
    }

    public Boolean getHac() {
        return hac;
    }

    public void setHac(Boolean hac) {
        this.hac = hac;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getCharging() {
        return charging;
    }

    public void setCharging(Integer charging) {
        this.charging = charging;
    }

    public Integer getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(Integer totalMileage) {
        this.totalMileage = totalMileage;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getRemainingMileage() {
        return remainingMileage;
    }

    public void setRemainingMileage(Integer remainingMileage) {
        this.remainingMileage = remainingMileage;
    }

    public Integer getHacTemperature() {
        return hacTemperature;
    }

    public void setHacTemperature(Integer hacTemperature) {
        this.hacTemperature = hacTemperature;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "lock=" + lock +
                ", windows=" + windows +
                ", sentryMode=" + sentryMode +
                ", trunk=" + trunk +
                ", video=" + video +
                ", heatSeat=" + heatSeat +
                ", steer=" + steer +
                ", cruise=" + cruise +
                ", autonomous=" + autonomous +
                ", engine=" + engine +
                ", hac=" + hac +
                ", location='" + location + '\'' +
                ", temperature=" + temperature +
                ", charging=" + charging +
                ", totalMileage=" + totalMileage +
                ", mileage=" + mileage +
                ", remainingMileage=" + remainingMileage +
                ", hacTemperature=" + hacTemperature +
                '}';
    }
}

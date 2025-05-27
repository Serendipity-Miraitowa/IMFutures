package org.example.imfutures.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

//设备检查属性实体
@Data
public class CheckProperties {
    @SerializedName("前舱盖")
    private Boolean frontCover; //前舱盖
    @SerializedName("发动机状态")
    private Boolean engine; //发动机状态
    @SerializedName("制动器")
    private Boolean brake; //制动器
    @SerializedName("ABS系统")
    private Boolean ABS; //ABS系统
    @SerializedName("转向系统")
    private Boolean steering; //转向系统
    @SerializedName("冷却系统")
    private Boolean cooling; //冷却系统
    @SerializedName("电力系统")
    private Boolean electric; //电力系统
    @SerializedName("动力系统")
    private Boolean power; //动力系统
    @SerializedName("胎压系统")
    private Boolean tire; //胎压系统
    @SerializedName("照明系统")
    private Boolean lights; //照明系统
    @SerializedName("近50km平均能耗")
    private Double averageEnergy;  //近50km平均能耗
    @SerializedName("累计平均能耗")
    private Double totalAverageEnergy; //累计平均能耗

    public CheckProperties() {
    }

    public CheckProperties(Boolean frontCover, Boolean engine, Boolean brake, Boolean ABS, Boolean steering, Boolean cooling, Boolean electric, Boolean power, Boolean tire, Boolean lights, Double averageEnergy, Double totalAverageEnergy) {
        this.frontCover = frontCover;
        this.engine = engine;
        this.brake = brake;
        this.ABS = ABS;
        this.steering = steering;
        this.cooling = cooling;
        this.electric = electric;
        this.power = power;
        this.tire = tire;
        this.lights = lights;
        this.averageEnergy = averageEnergy;
        this.totalAverageEnergy = totalAverageEnergy;
    }

    public Boolean getFrontCover() {
        return frontCover;
    }

    public void setFrontCover(Boolean frontCover) {
        this.frontCover = frontCover;
    }

    public Boolean getEngine() {
        return engine;
    }

    public void setEngine(Boolean engine) {
        this.engine = engine;
    }

    public Boolean getBrake() {
        return brake;
    }

    public void setBrake(Boolean brake) {
        this.brake = brake;
    }

    public Boolean getABS() {
        return ABS;
    }

    public void setABS(Boolean ABS) {
        this.ABS = ABS;
    }

    public Boolean getSteering() {
        return steering;
    }

    public void setSteering(Boolean steering) {
        this.steering = steering;
    }

    public Boolean getCooling() {
        return cooling;
    }

    public void setCooling(Boolean cooling) {
        this.cooling = cooling;
    }

    public Boolean getElectric() {
        return electric;
    }

    public void setElectric(Boolean electric) {
        this.electric = electric;
    }

    public Boolean getPower() {
        return power;
    }

    public void setPower(Boolean power) {
        this.power = power;
    }

    public Boolean getTire() {
        return tire;
    }

    public void setTire(Boolean tire) {
        this.tire = tire;
    }

    public Boolean getLights() {
        return lights;
    }

    public void setLights(Boolean lights) {
        this.lights = lights;
    }

    public Double getAverageEnergy() {
        return averageEnergy;
    }

    public void setAverageEnergy(Double averageEnergy) {
        this.averageEnergy = averageEnergy;
    }

    public Double getTotalAverageEnergy() {
        return totalAverageEnergy;
    }

    public void setTotalAverageEnergy(Double totalAverageEnergy) {
        this.totalAverageEnergy = totalAverageEnergy;
    }

    @Override
    public String toString() {
        return "CheckProperties{" +
                "frontCover=" + frontCover +
                ", engine=" + engine +
                ", brake=" + brake +
                ", ABS=" + ABS +
                ", steering=" + steering +
                ", cooling=" + cooling +
                ", electric=" + electric +
                ", power=" + power +
                ", tire=" + tire +
                ", lights=" + lights +
                ", averageEnergy=" + averageEnergy +
                ", totalAverageEnergy=" + totalAverageEnergy +
                '}';
    }
}

package org.example.imfutures.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

//设备检查属性实体
@Data
@Schema(name = "设备检查属性实体类")
public class CheckProperties {

    @SerializedName("前舱盖")
    @Schema(name = "前舱盖", description = "前舱盖状态", example = "true")
    private Boolean frontCover; //前舱盖

    @SerializedName("发动机状态")
    @Schema(name = "发动机状态", description = "发动机状态状态", example = "true")
    private Boolean engine; //发动机状态

    @SerializedName("制动器")
    @Schema(name = "制动器", description = "制动器状态", example = "true")
    private Boolean brake; //制动器

    @SerializedName("ABS系统")
    @Schema(name = "ABS系统", description = "ABS系统状态", example = "true")
    private Boolean ABS; //ABS系统

    @SerializedName("转向系统")
    @Schema(name = "转向系统", description = "转向系统状态", example = "true")
    private Boolean steering; //转向系统

    @SerializedName("冷却系统")
    @Schema(name = "前舱盖", description = "前舱盖状态", example = "true")
    private Boolean cooling; //冷却系统

    @SerializedName("电力系统")
    @Schema(name = "电力系统", description = "电力系统状态", example = "true")
    private Boolean electric; //电力系统

    @SerializedName("动力系统")
    @Schema(name = "动力系统", description = "动力系统状态", example = "true")
    private Boolean power; //动力系统

    @SerializedName("胎压系统")
    @Schema(name = "胎压系统", description = "胎压系统状态", example = "true")
    private Boolean tire; //胎压系统

    @SerializedName("照明系统")
    @Schema(name = "照明系统", description = "照明系统状态", example = "true")
    private Boolean lights; //照明系统

    @SerializedName("近50km平均能耗")
    @Schema(name = "近50km平均能耗", description = "近50km平均能耗", example = "32.5")
    private Double averageEnergy;  //近50km平均能耗

    @SerializedName("累计平均能耗")
    @Schema(name = "累计平均能耗", description = "累计平均能耗", example = "32.5")
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
}

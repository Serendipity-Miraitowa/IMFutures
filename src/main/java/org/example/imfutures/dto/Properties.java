package org.example.imfutures.dto;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

//设备基础属性实体
@Data
@Schema(name = "设备基础属性实体")
public class Properties {

    @SerializedName("车锁")
    @Schema(name = "车锁", description = "车锁状态", example = "true")
    private Boolean lock;  //车锁

    @SerializedName("车窗")
    @Schema(name = "车窗", description = "车窗状态", example = "true")
    private Boolean windows; //车窗

    @SerializedName("哨兵模式")
    @Schema(name = "哨兵模式", description = "哨兵模式状态", example = "true")
    private Boolean sentryMode; //哨兵模式

    @SerializedName("后备箱")
    @Schema(name = "后备箱", description = "后备箱状态", example = "true")
    private Boolean trunk; //后备箱

    @SerializedName("行车录像")
    @Schema(name = "行车录像", description = "行车录像状态", example = "true")
    private Boolean video; //行车录像

    @SerializedName("座椅加热")
    @Schema(name = "座椅加热", description = "座椅加热状态", example = "true")
    private Boolean heatSeat; //座椅加热

    @SerializedName("方向盘加热")
    @Schema(name = "方向盘加热", description = "方向盘加热状态", example = "true")
    private Boolean steer; //方向盘加热

    @SerializedName("定速巡航")
    @Schema(name = "定速巡航", description = "定速巡航状态", example = "true")
    private Boolean cruise; //定速巡航

    @SerializedName("自动驾驶")
    @Schema(name = "自动驾驶", description = "自动驾驶状态", example = "true")
    private Boolean autonomous; //自动驾驶

    @SerializedName("发动机状态")
    @Schema(name = "发动机状态", description = "发动机状态状态", example = "true")
    private Boolean engine; //发动机状态

    @SerializedName("空调状态")
    @Schema(name = "空调状态", description = "空调状态", example = "true")
    private Boolean hac; //空调状态

    @SerializedName("位置")
    @Schema(name = "位置", description = "位置信息", example = "关山大道大刘村")
    private String location; //位置

    @SerializedName("温度")
    @Schema(name = "温度", description = "温度", example = "18")
    private Integer temperature;  //温度

    @SerializedName("电量")
    @Schema(name = "电量", description = "电量", example = "35")
    private Integer charging; //电量

    @SerializedName("总里程")
    @Schema(name = "总里程", description = "总里程", example = "36598")
    private Integer totalMileage; //总里程

    @SerializedName("行驶里程")
    @Schema(name = "行驶里程", description = "行驶里程", example = "156")
    private Integer mileage; //行驶里程

    @SerializedName("剩余里程")
    @Schema(name = "剩余里程", description = "剩余里程", example = "652")
    private Integer remainingMileage; //剩余里程

    @SerializedName("空调温度")
    @Schema(name = "空调温度", description = "空调温度", example = "30")
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
}

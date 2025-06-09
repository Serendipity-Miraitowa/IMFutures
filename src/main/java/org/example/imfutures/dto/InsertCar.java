package org.example.imfutures.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

//添加车辆类
@Data
@Schema(name = "添加设备实体")
public class InsertCar {

    @Schema(name = "车辆类型", description = "车辆的类型，用于分辨车辆", example = "问界")
    private String type; //车辆类型

    @Schema(name = "车辆vin号", description = "车架号，每辆车的单独标识，用于在云平台做标识", example = "25918941561561561")
    private String frameNumber;  //车辆vin号

    @Schema(name = "用户id", description = "关联的用户", example = "1")
    private Integer userId; //用户id

    @Schema(name = "车辆图片", description = "车辆图片", example = "http://aliyun.com/159631031/56156210236")
    private String img;


}

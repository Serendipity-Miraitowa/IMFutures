package org.example.imfutures.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
//车辆实体类
public class Car {
    @Schema(name = "车辆id", example = "1")
    private Integer id;
    @Schema(name = "车辆类型", example = "问界")
    private String type; //车辆类型
    @Schema(name = "车辆vin号", example = "25918941561561561")
    private String frameNumber;  //车辆vin号
    @Schema(name = "用户id", example = "1")
    private Integer userId; //用户id
    @Schema(name = "状态", example = "true")
    private Integer status; //状态
    @Schema(name = "云平台实例id", example = "25918941561561561_0_0_2025060614")
    private String clientId;  //实例id
    @Schema(name = "云平台连接密码", example = "e9b7a89c2f3f3c01f59612ebbcce61671847101da27e5d14889ff1546e144eb1")
    private String password;  //密码
    @Schema(name = "车辆图片", example = "http://aliyun.com/159631031/56156210236")
    private String img;


}

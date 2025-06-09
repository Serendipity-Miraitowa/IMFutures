package org.example.imfutures.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


//命令下发实体
@Data
@Schema(name = "命令下发实体")
public class CommandDevice {
    @Schema(name = "服务id", description = "服务id", example = "Base")
    private String serviceId;  //服务id

    @Schema(name = "设备id", description = "设备id", example = "1561589156161")
    private String deviceId;  //设备id

    @Schema(name = "命令名称", description = "命令名称", example = "车窗")
    private String commandName;  //命令名称

    @Schema(name = "命令参数名称", description = "命令参数名称", example = "车窗")
    private String name;  //命令参数名称

    @Schema(name = "命令参数值(int)", description = "int类型", example = "32")
    private Integer dataInteger;  //命令参数值

    @Schema(name = "命令参数值(boolean)", description = "boolean类型", example = "true")
    private Boolean dataBoolean;  //命令参数值


}

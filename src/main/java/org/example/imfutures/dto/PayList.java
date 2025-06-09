package org.example.imfutures.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "支付订单列表")
public class PayList {

    @Schema(name = "用户id", example = "1", description = "关联用户id")
    private Integer uid;

    @Schema(name = "充电站", description = "关联充电站", example = "1")
    private Integer chargingStationId;

}

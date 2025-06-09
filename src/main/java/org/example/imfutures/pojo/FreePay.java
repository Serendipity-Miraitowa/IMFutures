package org.example.imfutures.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Time;


@Data
@Schema(name = "用户免密支付实体")
public class FreePay {

    @Schema(name = "免密支付id", description = "免密支付唯一标识", example = "1")
    private Integer id;

    @Schema(name = "充电站", description = "关联充电站", example = "1")
    private Integer chargingStationId;

    @Schema(name = "免密支付单号", description = "开通免密支付单号", example = "4598415641489456")
    private String serialNo;

    @Schema(name = "开通时间", description = "开通时间", example = "16:05:36")
    private String time;

    @Schema(name = "商家账号", description = "商家账号", example = "48951256")
    private String account;

    @Schema(name = "用户id", description = "用户关联id", example = "1")
    private Integer userId;

}

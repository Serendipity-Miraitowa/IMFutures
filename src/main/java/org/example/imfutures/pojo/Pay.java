package org.example.imfutures.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

//支付账单实体类
@Data
@Schema(name = "支付账单实体类")
public class Pay {

    @Schema(name = "账单id", description = "账单唯一标识",example = "1")
    private Integer id;  //账单id

    @Schema(name = "用户id", description = "用户id", example = "1")
    private Integer userId; //用户id

    @Schema(name = "充电站", description = "关联充电站", example = "1")
    private Integer chargingStationId; //充电站

    @Schema(name = "充电桩", description = "关联充电桩id", example = "1")
    private Integer chargingPieId;  //充电桩id

    @Schema(name = "账单号", description = "账单号", example = "4598415641489456")
    private String serialNo;  //账单号

    @Schema(name = "支付方式", description = "支付方式", example = "微信支付")
    private String payWay;  //支付方式

    @Schema(name = "充电时间", description = "充电时间", example = "1h36m")
    private String chargingTime; //充电时间

    @Schema(name = "订单id", description = "关联预定订单id",example = "1")
    private Integer orderId; //订单id

    @Schema(name = "账单日期", description = "账单日期", example = "2025-06-10")
    private Date date; //账单日期

    @Schema(name = "订单金额订单金额", description = "充电账单应支付金额", example = "256.15")
    private double amount; //订单金额

    @Schema(name = "开始充电的时间", description = "开始充电的时间", example = "16:06:36")
    private String time; //开始充电的时间


}

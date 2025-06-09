package org.example.imfutures.pojo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import java.util.Date;

//充电预定订单实体类
@Data
@Schema(name = "充电预定订单实体类")
public class Order {

    @Schema(name = "订单id", description = "预定订单唯一标识", example = "1")
    private Integer id;

    @Schema(name = "用户id", description = "用户关联id", example = "1")
    private Integer userId; //用户id

    @Schema(name = "预定日期", description = "订单的预定日期", example = "2025-06-10")
    private Date date; //预定日期

    @Schema(name = "预定时间", description = "预定时间", example = "16:05:36")
    private String time; //预定时间

    @Schema(name = "充电桩", description = "关联充电桩id", example = "1")
    private Integer chargingPiesId; //充电桩

    @Schema(name = "充电站", description = "关联充电站", example = "1")
    private Integer chargingStationsId; //充电站

    @Schema(name = "状态", description = "预定订单状态", example = "1")
    private Integer status; //状态

    @Schema(name = "订单号", description = "订单号", example = "4598415641489456")
    private String serialNo; //订单号

    @Schema(name = "评论id", description = "评论id", example = "1")
    private Integer commentId;  //评论id

    @Schema(name = "使用状态", description = "使用状态", example = "1")
    private int useStatus;  //使用状态

    @Schema(name = "支付状态", description = "支付状态", example = "1")
    private int payStatus;  //支付状态

}

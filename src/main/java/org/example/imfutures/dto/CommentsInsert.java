package org.example.imfutures.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;


@Data
@Schema(name = "添加评论实体")
public class CommentsInsert {

    @Schema(name = "评论id", description = "评论唯一标识符", example = "1")
    private Integer id;

    @Schema(name = "订单id", description = "关联订单id", example = "1")
    private Integer orderId; //订单id

    @Schema(name = "评论内容", description = "评论内容", example = "充电速度非常快")
    private String content;

    @Schema(name = "评论日期", description = "评论日期", example = "2025-06-04")
    private Date date;

    @Schema(name = "评分", description = "评分", example = "2.6")
    private Double score;

    @Schema(name = "用户id", description = "关联用户id", example = "1")
    private Integer userId;

    @Schema(name = "充电站id", description = "评论的关联充电站", example = "1")
    private Integer chargingStationId;


}

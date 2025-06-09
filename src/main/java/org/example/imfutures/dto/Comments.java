package org.example.imfutures.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(name = "评论实体类")
//评论实体类
public class Comments {

    @Schema(name = "评论id", description = "评论唯一标识符", example = "1")
    private Integer id;

    @Schema(name = "评论内容", description = "评论内容", example = "充电速度非常快")
    private String content; //评论内容

    @Schema(name = "评论日期", description = "评论日期", example = "2025-06-04")
    private Date date; //评论日期

    @Schema(name = "评分", description = "评分", example = "2.6")
    private double score; //评分

    @Schema(name = "用户id", description = "关联用户id", example = "1")
    private Integer userId; //用户id

    @Schema(name = "充电站id", description = "评论的关联充电站", example = "1")
    private Integer chargingStationId; //充电站id

    @Schema(name = "用户名", description = "用户名", example = "天天开心")
    private String userName;

    @Schema(name = "用户头像", description = "用户头像", example = "https://aliyun.com/15156151/4156156")
    private String avatar;


}

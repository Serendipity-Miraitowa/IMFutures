package org.example.imfutures.pojo;

import lombok.Data;

import java.util.Date;

@Data
//评论实体类
public class Comments {
    private Integer id;
    private String content; //评论内容
    private Date date; //评论日期
    private double score; //评分
    private Integer userId; //用户id
    private Integer chargingStationId; //充电站id

}

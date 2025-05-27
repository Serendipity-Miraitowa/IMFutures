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

    public Comments() {
    }

    public Comments(Integer id, String content, Date date, double score, Integer userId, Integer chargingStationId) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.score = score;
        this.userId = userId;
        this.chargingStationId = chargingStationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(Integer chargingStationId) {
        this.chargingStationId = chargingStationId;
    }
}

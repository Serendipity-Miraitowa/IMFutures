package org.example.imfutures.dto;

import java.util.Date;

public class CommentsInsert {
    private Integer id;
    private Integer orderId; //订单id
    private String content;
    private Date date;
    private Double score;
    private Integer userId;
    private Integer chargingStationId;

    public CommentsInsert() {
    }

    public CommentsInsert(Integer id, Integer orderId, String content, Date date, Double score, Integer userId, Integer chargingStationId) {
        this.id = id;
        this.orderId = orderId;
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
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

    @Override
    public String toString() {
        return "CommentsInsert{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", score=" + score +
                ", userId=" + userId +
                ", chargingStationId=" + chargingStationId +
                '}';
    }
}

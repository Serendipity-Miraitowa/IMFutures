package org.example.imfutures.pojo;


import lombok.Data;

import java.util.Date;

@Data
//消息实体类
public class Message {
    private Integer id;
    private String content; //消息内容
    private Date date; //消息日期
    private String title; //消息标题
    private Integer userId; //用户id
    private Integer status; //消息状态

    public Message() {
    }

    public Message(Integer id, String content, Date date, String title, Integer userId, Integer status) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.title = title;
        this.userId = userId;
        this.status = status;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

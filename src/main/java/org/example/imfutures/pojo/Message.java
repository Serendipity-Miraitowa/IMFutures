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

}

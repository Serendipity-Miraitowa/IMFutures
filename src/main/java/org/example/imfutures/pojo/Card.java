package org.example.imfutures.pojo;

import lombok.Data;

import java.util.Date;

@Data
//身份证信息实体类
public class Card {
    private Integer id;
    private String name; //姓名
    private String number; //身份证号码
    private Date startDay; //身份证有效期开始日期
    private Date endDay; //身份证有效期结束日期
    private String sex; //性别
    private String type; //身份证类型
    private String nationality;  //国籍
    private Date birthday;  //出生日期

}

package org.example.imfutures.dto;

import lombok.Data;

import java.util.Date;

@Data
//身份证信息实体类
public class Cards {
    private Integer id;
    private String name; //姓名
    private String number; //身份证号码
    private Date startDay; //身份证有效期开始日期
    private Date endDay; //身份证有效期结束日期
    private String sex; //性别
    private String type; //身份证类型
    private String nationality;  //国籍
    private Date birthday;  //出生日期
    private Integer uid; //用户id


    public Cards() {
    }

    public Cards(Integer id, String name, String number, Date startDay, Date endDay, String sex, String type, String nationality, Date birthday, Integer uid) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.startDay = startDay;
        this.endDay = endDay;
        this.sex = sex;
        this.type = type;
        this.nationality = nationality;
        this.birthday = birthday;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}

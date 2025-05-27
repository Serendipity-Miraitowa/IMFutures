package org.example.imfutures.pojo;

import lombok.Data;

import java.util.Date;

/*导航历史实体类*/
@Data
public class Nav {
    private Integer id;
    private Integer userId; //用户id
    private String address; //地址
    private Date date; //导航日期

    public Nav() {
    }

    public Nav(Integer id, Integer userId, String address, Date date) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

package org.example.imfutures.dto;

import lombok.Data;

import java.sql.Time;

@Data
//充电站实体类
public class ChargingStations {
    private Integer id;
    private String name; //充电站名称
    private String type; //充电站充电类型
    private double price; //价格
    private double distance; //距离
    private String address; //位置
    private String brief; //简介
    private String parking; //停车位
    private String parkingPrice; //停车费
    private Time jobStartTime; //开始工作时间
    private Time jobENdTime; //结束工作时间
    private String phone; //联系电话
    private String img; //图片地址
    private String discount; //优惠
    private double score; //评分
    private String company; //公司

    public ChargingStations() {
    }

    public ChargingStations(Integer id, String name, String type, double price, double distance, String address, String brief, String parking, String parkingPrice, Time jobStartTime, Time jobENdTime, String phone, String img, String discount, double score, String company) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.distance = distance;
        this.address = address;
        this.brief = brief;
        this.parking = parking;
        this.parkingPrice = parkingPrice;
        this.jobStartTime = jobStartTime;
        this.jobENdTime = jobENdTime;
        this.phone = phone;
        this.img = img;
        this.discount = discount;
        this.score = score;
        this.company = company;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getParkingPrice() {
        return parkingPrice;
    }

    public void setParkingPrice(String parkingPrice) {
        this.parkingPrice = parkingPrice;
    }

    public Time getJobStartTime() {
        return jobStartTime;
    }

    public void setJobStartTime(Time jobStartTime) {
        this.jobStartTime = jobStartTime;
    }

    public Time getJobENdTime() {
        return jobENdTime;
    }

    public void setJobENdTime(Time jobENdTime) {
        this.jobENdTime = jobENdTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

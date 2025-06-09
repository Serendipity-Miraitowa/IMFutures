package org.example.imfutures.pojo;

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
    private String company; //充电站公司
    private Double score;  //评分
    private String account;  //商户端账号
}

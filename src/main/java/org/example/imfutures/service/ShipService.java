package org.example.imfutures.service;



import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.example.imfutures.pojo.ChargingPies;
import org.example.imfutures.dto.ChargingStations;
import org.example.imfutures.dto.Comments;
import org.example.imfutures.pojo.Order;

import java.util.List;

public interface ShipService {

    /**
     * 查询所有充电站
     * @return
     */
    List<ChargingStations> selectShip(String name);

    /**
     * 查询所有充电桩
     * @param id
     * @return
     */
    List<ChargingPies> selectPies(Integer id);

    /**
     * 按价格排序
     * @return
     */
    List<ChargingStations> selectShipByPrice();


    /**
     * 按距离排序
     * @return
     */
    List<ChargingStations> selectShipByDistance();

    /**
     * 按评分排序
     * @return
     */
    List<ChargingStations> selectShipByScore();


    /**
     * 综合排序
     * @return
     */
    List<ChargingStations> selectShipBySynthesis();

    /**
     * 查询所有评论
     * @param id
     * @return
     */
    List<Comments> comments(Integer id);


    /**
     * 添加预定订单
     * @param order
     */
    void insertOrder(Order order);

    /**
     * 改变使用状态为使用中
     * @param id
     */
    void updateUseStatus(Integer id);

    /**
     * 查询预定订单
     * @param id
     * @return
     */
    List<Order> selectOrder(Integer id);

    /**
     * 查询已取消订单
     * @param id
     * @return
     */
    List<Order> selectCancelOrder(Integer id);


    /**
     * 查询已完成订单
     * @param id
     * @return
     */
    List<Order> selectCompleteOrder(Integer id);

    /**
     * 取消预约订单
     * @param id
     */
    void updateOrder(Integer id);

    /**
     * 根据id查询充电站信息
     * @param id
     * @return
     */
    ChargingStations selectChargingById(Integer id);

    /**
     * 根据id查询充电桩信息
     * @param id
     * @return
     */
    ChargingPies selectPie(Integer id);

    /**
     * 修改使用状态和预约状态为已完成
     * @param uid
     */
    void updateOrderStatus(Integer uid);
}

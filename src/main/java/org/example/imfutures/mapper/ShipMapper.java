package org.example.imfutures.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.imfutures.pojo.ChargingPies;
import org.example.imfutures.dto.ChargingStations;
import org.example.imfutures.dto.Comments;
import org.example.imfutures.pojo.Order;
import org.example.imfutures.pojo.Users;

import java.util.List;

@Mapper
public interface ShipMapper {

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
    @Select("select * from charging_stations order by price")
    List<ChargingStations> selectShipByPrice();


    /**
     * 按距离排序
     * @return
     */
    @Select("select * from charging_stations order by distance")
    List<ChargingStations> selectShipByDistance();

    /**
     * 查询所有评论
     * @param id
     * @return
     */
    @Select("select * from comments where charging_station_id = #{id}")
    List<Comments> comments(Integer id);

    /**
     * 根据id查询评论用户名称, 头像
     * @param id
     * @return
     */
    @Select("select user_name, avatar from users where uid = #{id}")
    Users selectUserName(Integer id);

    /**
     * 添加预定订单
     * @param order
     */
    @Insert("insert into `order`(user_id, date, time, charging_pies_id, charging_stations_id, status, serial_no, comment_id, use_status, pay_status) values(#{userId}, #{date}, #{time}, #{chargingPiesId}, #{chargingStationsId}, #{status}, #{serialNo}, #{commentId}, #{useStatus}, #{payStatus})")
    void insertOrder(Order order);

    /**
     * 改变使用状态为使用中
     * @param id
     */
    @Update("update `order` set use_status = 1 where id = #{id}")
    void updateUseStatus(Integer id);

    /**
     * 查询预定订单
     * @param id
     * @return
     */
    @Select("select * from `order` where user_id = #{id} and status = 0 order by id desc")
    List<Order> selectOrder(Integer id);

    /**
     * 查询已取消订单
     * @param id
     * @return
     */
    @Select("select * from `order` where user_id = #{id} and status = 1 and pay_status = 2 order by id desc")
    List<Order> selectCancelOrder(Integer id);


    /**
     * 查询已完成订单
     * @param id
     * @return
     */
    @Select("select * from `order` where user_id = #{id} and status = 2 and use_status = 2 and pay_status = 1 order by id desc")
    List<Order> selectCompleteOrder(Integer id);

    /**
     * 取消预约订单
     * @param id
     */
    @Update("update `order` set status = 1, pay_status = 2 where id= #{id}")
    void updateOrder(Integer id);

    /**
     * 根据id查询充电站信息
     * @param id
     * @return
     */
    @Select("select * from charging_stations where id = #{id}")
    ChargingStations selectChargingById(Integer id);

    /**
     * 根据id查询充电桩信息
     * @param id
     * @return
     */
    @Select("select * from charging_pies where id = #{id}")
    ChargingPies selectPie(Integer id);

    /**
     * 修改使用状态和预约状态为已完成
     * @param id
     */
    @Update("update `order` set status = 2, use_status = 2 where id = #{id}")
    void updateOrderStatus(Integer id);
}

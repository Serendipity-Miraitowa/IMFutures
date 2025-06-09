package org.example.imfutures.service.Impl;

import org.example.imfutures.mapper.ShipMapper;
import org.example.imfutures.pojo.ChargingPies;
import org.example.imfutures.dto.Comments;
import org.example.imfutures.pojo.ChargingStations;
import org.example.imfutures.pojo.Order;
import org.example.imfutures.pojo.Users;
import org.example.imfutures.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;


@Service
public class ShipServiceImpl implements ShipService {

    @Autowired
    ShipMapper mapper;

    /**
     * 查询所有充电站
     * @return
     */
    @Override
    public List<ChargingStations> selectShip(String name) {
        List<ChargingStations> list = mapper.selectShip(name);
        return list;
    }

    /**
     * 查询所有充电桩
     * @param id
     * @return
     */
    @Override
    public List<ChargingPies> selectPies(Integer id) {
        return mapper.selectPies(id);
    }

    /**
     * 查询可用充电桩
     * @param id
     * @return
     */
    @Override
    public List<ChargingPies> selectChargingPies(Integer id) {
        return mapper.selectChargingPies(id);
    }

    /**
     * 按价格排序
     * @return
     */
    @Override
    public List<ChargingStations> selectShipByPrice() {
        List<ChargingStations> list = mapper.selectShipByPrice();
        //按价格升序排序，价格相同，按评分排序
        list.sort(Comparator.comparing(ChargingStations::getPrice).thenComparing(ChargingStations::getScore));
        return list;
    }

    /**
     * 按距离排序
     * @return
     */
    @Override
    public List<ChargingStations> selectShipByDistance() {
        List<ChargingStations> list = mapper.selectShipByDistance();
        //按距离升序排序，距离相同，按评分排序
        list.sort(Comparator.comparing(ChargingStations::getDistance).thenComparing(ChargingStations::getScore));
        return list;
    }

    /**
     * 按评分排序
     * @return
     */
    @Override
    public List<ChargingStations> selectShipByScore() {
        List<ChargingStations> list = mapper.selectShip("");
        //按评分降序排序，评分相同，按距离排序
        list.sort(Comparator.comparing(ChargingStations::getScore).reversed().thenComparing(ChargingStations::getDistance));
        return list;
    }

    /**
     * 综合排序
     * @return
     */
    @Override
    public List<ChargingStations> selectShipBySynthesis() {
        List<ChargingStations> list = mapper.selectShip("");
        //先按距离排序，后按价格排序,再按评分排序
        list.sort(Comparator.comparing(ChargingStations::getDistance).thenComparing(ChargingStations::getPrice)
                .thenComparing(ChargingStations::getScore).reversed());
        return list;
    }

    /**
     * 查询所有评论
     * @param id
     * @return
     */
    @Override
    public List<Comments> comments(Integer id) {
        List<Comments> list = mapper.comments(id);
        for (Comments comments: list){
            Integer userId = comments.getUserId();
            Users users = mapper.selectUserName(userId);
            if (users != null){
                comments.setUserName(users.getUserName());
                comments.setAvatar(users.getAvatar());
            }
        }
        return list;
    }

    /**
     * 添加预定订单
     * @param order
     */
    @Override
    public void insertOrder(Order order) {
        mapper.insertOrder(order);
        mapper.updateStatus(order.getChargingPiesId(), 1);
    }

    /**
     * 改变使用状态为使用中
     * @param id
     */
    @Override
    public void updateUseStatus(Integer id) {
        mapper.updateUseStatus(id);
    }

    /**
     * 查询预约订单
     * @param id
     * @return
     */
    @Override
    public List<Order> selectOrder(Integer id) {
        return mapper.selectOrder(id);
    }

    /**
     * 查询已取消订单
     * @param id
     * @return
     */
    @Override
    public List<Order> selectCancelOrder(Integer id) {
        return mapper.selectCancelOrder(id);
    }

    /**
     * 查询已完成订单
     * @param id
     * @return
     */
    @Override
    public Order selectCompleteOrder(Integer id) {
        return mapper.selectCompleteOrder(id);
    }

    /**
     * 取消预约订单
     * @param id
     */
    @Override
    public void updateOrder(Integer id) {
        mapper.updateOrder(id);
        Order order = mapper.selectOrderById(id);
        mapper.updateStatus(order.getChargingPiesId(), 0);
    }

    /**
     * 根据id查询充电站信息
     * @param id
     * @return
     */
    @Override
    public ChargingStations selectChargingById(Integer id) {
        return  mapper.selectChargingById(id);
    }

    /**
     * 根据id查询充电桩信息
     * @param id
     * @return
     */
    @Override
    public ChargingPies selectPie(Integer id) {
        return mapper.selectPie(id);
    }

    /**
     * 修改使用状态和预约状态为已完成
     * @param id
     */
    @Override
    public void updateOrderStatus(Integer id) {
        mapper.updateOrderStatus(id);
        Order order = mapper.selectOrderById(id);
        mapper.updateStatus(order.getChargingPiesId(), 0);
    }

}

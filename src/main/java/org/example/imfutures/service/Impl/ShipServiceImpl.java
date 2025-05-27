package org.example.imfutures.service.Impl;

import org.example.imfutures.mapper.ShipMapper;
import org.example.imfutures.pojo.ChargingPies;
import org.example.imfutures.dto.Comments;
import org.example.imfutures.dto.ChargingStations;
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
        list = averageScore(list);
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
     * 按价格排序
     * @return
     */
    @Override
    public List<ChargingStations> selectShipByPrice() {
        List<ChargingStations> list = mapper.selectShipByPrice();
        list = averageScore(list);
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
        list = averageScore(list);
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
        list = averageScore(list);
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
        list = averageScore(list);
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
    public List<Order> selectCompleteOrder(Integer id) {
        return mapper.selectCompleteOrder(id);
    }

    /**
     * 取消预约订单
     * @param id
     */
    @Override
    public void updateOrder(Integer id) {
        mapper.updateOrder(id);
    }

    /**
     * 根据id查询充电站信息
     * @param id
     * @return
     */
    @Override
    public ChargingStations selectChargingById(Integer id) {
        ChargingStations charging = mapper.selectChargingById(id);
        charging = averageScore(charging);
        return charging;
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
     * @param uid
     */
    @Override
    public void updateOrderStatus(Integer uid) {
        mapper.updateOrderStatus(uid);
    }

    /**
     * 计算平均分
     * @param list
     * @return
     */
    private List<ChargingStations> averageScore(List<ChargingStations> list) {
        DecimalFormat df = new DecimalFormat("#.0");
        for (ChargingStations chargingStation : list) {
            Integer id = chargingStation.getId();
            List<Comments> comments = mapper.comments(id);
            double totalScore = 0;
            int commentCount = 0;

            for (Comments comment : comments) {
                totalScore += comment.getScore();
                commentCount++;
            }

            if (commentCount > 0) {
                double averageScore = totalScore / commentCount;
                averageScore = Double.parseDouble(df.format(averageScore));
                chargingStation.setScore(averageScore);
            } else {
                // 如果没有评论，设置默认值， 0
                chargingStation.setScore(0.0);
            }
        }
        return list;
    }

    /**
     * 计算单个充电站的平均分
     * @param chargingStation
     * @return
     */
    private ChargingStations averageScore(ChargingStations chargingStation){
        DecimalFormat df = new DecimalFormat("#.0");
        Integer id = chargingStation.getId();
        List<Comments> comments = mapper.comments(id);
        double totalScore = 0;
        int commentCount = 0;

        for (Comments comment : comments) {
            totalScore += comment.getScore();
            commentCount++;
        }

        if (commentCount > 0) {
            double averageScore = totalScore / commentCount;
            averageScore = Double.parseDouble(df.format(averageScore));
            chargingStation.setScore(averageScore);
        } else {
            // 如果没有评论，设置默认值， 0
            chargingStation.setScore(0.0);
        }
        return chargingStation;
    }
}

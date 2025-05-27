package org.example.imfutures.controller;


import org.example.imfutures.pojo.ChargingPies;
import org.example.imfutures.dto.ChargingStations;
import org.example.imfutures.dto.Comments;
import org.example.imfutures.pojo.Order;
import org.example.imfutures.pojo.Pay;
import org.example.imfutures.service.ShipService;
import org.example.imfutures.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/IMFuture/ship")
public class ShipController {

    @Autowired
    ShipService service;

    /**
     * 查询所有充电站
     * @return
     */
    @GetMapping("/selectShip")
    public Result selectShips(@RequestParam("name") String name){
        List<ChargingStations> list;
        try {
            list = service.selectShip(name);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 查询充电桩信息
     * @param id
     * @return
     */
    @GetMapping("/selectPies")
    public Result select(@RequestParam("id") Integer id){
        List<ChargingPies> list;
        try {
            list = service.selectPies(id);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 价格排序
     * @return
     */
    @GetMapping("/price")
    public Result sortPrice(){
        List<ChargingStations> list;
        try {
            list = service.selectShipByPrice();
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 距离排序
     * @return
     */
    @GetMapping("/distance")
    public Result sortDistance(){
        List<ChargingStations> list;
        try {
            list = service.selectShipByDistance();
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 评分排序
     * @return
     */
    @GetMapping("/score")
    public Result sortScore(){
        List<ChargingStations> list;
        try {
            list = service.selectShipByScore();
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 综合排序
     * @return
     */
    @GetMapping("/synthesis")
    public Result sortSynthesis(){
        List<ChargingStations> list;
        try {
            list = service.selectShipBySynthesis();
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 查询所有评论
     * @param id
     * @return
     */
    @GetMapping("/comments")
    public Result comments(@RequestParam("id") Integer id){
        List<Comments> list;
        try {
            list = service.comments(id);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 添加预约订单
     * @param order
     * @return
     */
    @PostMapping("/insertOrder")
    public Result insertOrder(@RequestBody Order order){
        try {
            service.insertOrder(order);
            return new Result(true, "预约成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(false, "预约失败", e.getMessage());
        }
    }

    /**
     * 改变使用状态为使用中
     * @param id
     * @return
     */
    @PutMapping("/modifyUse")
    public Result modify(@RequestParam("id") Integer id){
        try {
            service.updateUseStatus(id);
            return new Result(true, "充电桩开启成功");
        } catch (Exception e) {
            return new Result(false, "使用失败，请稍后再试", e.getMessage());
        }
    }

    /**
     * 查询预约订单
     * @param id
     * @return
     */
    @GetMapping("/selectScheduledOrder")
    public Result selectScheduledOrder(@RequestParam("id") Integer id){
        List<Order> list;
        try {
            list = service.selectOrder(id);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "预约失败", e.getMessage());
        }
    }

    /**
     * 查询已取消订单
     * @param id
     * @return
     */
    @GetMapping("/cancelOrder")
    public Result cancelOrder(@RequestParam("id") Integer id){
        List<Order> list;
        try {
            list = service.selectCancelOrder(id);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 查询已完成订单
     * @param id
     * @return
     */
    @GetMapping("/completeOrder")
    public Result completeOrder(@RequestParam("id") Integer id){
        List<Order> list;
        try {
            list = service.selectCompleteOrder(id);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 取消预约订单
     * @param id
     * @return
     */
    @GetMapping("/cancel")
    public Result cancel(@RequestParam("id") Integer id){
        try {
            service.updateOrder(id);
            return new Result(true, "取消成功");
        } catch (Exception e) {
            return new Result(false, "取消失败", e.getMessage());
        }
    }

    /**
     * 根据id查询充电站信息
     * @param id
     * @return
     */
    @GetMapping("/selectChargingById")
    public Result selectChargingById(@RequestParam("id") Integer id){
        try {
            ChargingStations chargingStations = service.selectChargingById(id);
            return new Result(true, "查询成功", chargingStations);
        } catch (Exception e) {
            return new Result(false, "取消失败", e.getMessage());
        }
    }

    /**
     * 查询单个充电桩信息
     * @param id
     * @return
     */
    @GetMapping("/selectPie")
    public Result selectPie(@RequestParam("id") Integer id){
        ChargingPies chargingPies = new ChargingPies();
        try {
            chargingPies = service.selectPie(id);
            return new Result(true, "查询成功", chargingPies);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 修改使用状态和预约状态为已完成
     * @param id
     * @return
     */
    @PutMapping("/modifyOrder")
    public Result modifyOrder(@RequestParam("id") Integer id){
        try {
            service.updateOrderStatus(id);
            return new Result(true, "订单已结束");
        } catch (Exception e) {
            return new Result(false, "订单结束失败，请稍后再试", e.getMessage());
        }
    }

}

package org.example.imfutures.controller;


import org.apache.catalina.User;
import org.example.imfutures.dto.OrderPay;
import org.example.imfutures.dto.PayDetail;
import org.example.imfutures.dto.PayList;
import org.example.imfutures.pojo.Pay;
import org.example.imfutures.pojo.Users;
import org.example.imfutures.service.PayService;
import org.example.imfutures.service.UserService;
import org.example.imfutures.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CrossOrigin("*")
@RestController
@RequestMapping("/IMFuture/pay")
public class PayController {

    @Autowired
    PayService payService;
    @Autowired
    UserService userService;

    /**
     * 查询支付账单
     * @param uid
     * @return
     */
    @GetMapping("/selectPay")
    public Result selectPay(@RequestParam("uid") Integer uid) {
        List<Pay> pays = new ArrayList<>();
        try {
            pays = payService.selectPay(uid);
            return new Result(true, "查询成功", pays);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 查询支付账单根据预定订单
     * @param id
     * @return
     */
    @GetMapping("/select")
    public Result select(@RequestParam("id") Integer id) {
        List<Pay> list = new ArrayList<>();
        try {
            list = payService.select(id);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 删除支付账单
     * @param uid
     * @return
     */
    @DeleteMapping("/delete/{uid}")
    public Result delete(@PathVariable("uid") Integer uid) {
        try {
            payService.delete(uid);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            return new Result(false, "删除失败，请稍后再试", e.getMessage());
        }
    }

    /**
     * 查询支付账单详情
     * @param id
     * @return
     */
    @GetMapping("/selectDetail/{id}")
    public Result selectDetail(@PathVariable("id") Integer id) {
        Pay pay = new Pay();
        try {
            pay = payService.selectDetail(id);
            return new Result(true, "查询成功", pay);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 验证支付密码
     * @param payPassword
     * @return
     */
    @GetMapping("/password")
    public Result password(@RequestParam("payPassword") String payPassword, @RequestParam("uid") Integer uid){
        Users users;
        try{
            users = userService.select(uid);
            if(!(users.getPayPassword() == null)){
                if (Objects.equals(payPassword, users.getPayPassword())){
                    return new Result(true, "支付成功");
                }else {
                    return new Result(false, "密码错误，请重试");
                }
            }else {
                return new Result(false, "没有设置支付密码，请先去支付设置功能设置支付密码");
            }
        } catch (Exception e) {
            return new Result(false, "支付失败，请稍后再试", e.getMessage());
        }
    }

    /**
     * 添加支付订单
     * @param pay
     * @return
     */
    @PostMapping("/addPay")
    public Result addPay(@RequestBody Pay pay){
        boolean isSuccess;
        try{
            isSuccess = payService.addPay(pay);
            if (isSuccess){
                return new Result(true, "支付成功");
            }else {
                return new Result(false, "支付失败，请稍后再试");
            }
        } catch (Exception e) {
            return new Result(false, "支付失败，请稍后再试", e.getMessage());
        }
    }

    /**
     * 查询支付方式
     * @param uid
     * @return
     */
    @GetMapping("/payWayList")
    public Result payWayList(@RequestParam("uid") Integer uid){
        List<String> list = new ArrayList<>();
        try {
            list = payService.payWayList(uid);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败，请稍后再试", e.getMessage());
        }
    }


    /**
     * 根据用户id和充电站id查询充电订单
     * @param payList
     * @return
     */
    @PostMapping("/payList")
    public Result payList(@RequestBody PayList payList){
        List<Pay> list = new ArrayList<>();
        try {
            list = payService.payList(payList);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败，请稍后再试", e.getMessage());
        }
    }
}

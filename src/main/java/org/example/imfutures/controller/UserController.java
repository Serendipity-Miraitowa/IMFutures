package org.example.imfutures.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.imfutures.dto.Cards;
import org.example.imfutures.dto.UpdateUser;
import org.example.imfutures.mapper.UserMapper;
import org.example.imfutures.pojo.*;
import org.example.imfutures.service.UserService;
import org.example.imfutures.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Tag(name = "用户管理")
@CrossOrigin("*")
@RestController
@RequestMapping("/IMFuture/user")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    UserMapper mapper;

    /**
     * 修改用户信息，并获取最新信息
     * @param user
     * @return
     */
    @Operation(summary = "修改用户信息，并获取最新信息")
    @PostMapping("/update")
    public Result update(@RequestBody UpdateUser user){
        Users users = new Users();
        try {
            users = service.updateUser(user);
            System.out.println(users.getUserName());
            return new Result(true, "修改成功", users);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(false, "修改失败", e.getMessage());
        }
    }

    /**
     * 添加实名认证
     * @param cards
     * @return
     */
    @Operation(summary = "添加实名认证")
    @PostMapping("/addCard")
    public Result addCard(@RequestBody Cards cards){
        System.out.println(cards.getUid());
        try {
            service.addCard(cards);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(false, "添加失败", e.getMessage());
        }
    }

    /**
     * 更新实名认证信息
     * @param cards
     * @return
     */
    @Operation(summary = "更新实名认证信息")
    @PostMapping("/updateCard")
    public Result updateCard(@RequestBody Cards cards){
        try {
            service.updateCard(cards);
            return new Result(true, "更新成功");
        } catch (Exception e) {
            return new Result(false, "更新失败", e.getMessage());
        }
    }

    /**
     * 查询身份信息
     * @param id
     * @return
     */
    @Operation(summary = "查询身份信息")
    @GetMapping("/selectCard")
    public Result selectCard(@RequestParam("id") Integer id){
        Card card = new Card();
        try {
            card = service.selectCard(id);
            return new Result(true, "查询成功", card);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    @Operation(summary = "查询用户信息")
    @GetMapping("/selectUserInfo")
    public Result selectUserInfo(@RequestParam("id") Integer id){
        Users users = new Users();
        try {
            users = service.selectUserInfo(id);
            return new Result(true, "查询成功", users);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 历史导航
     * @param uid
     * @return
     */
    @Operation(summary = "历史导航")
    @GetMapping("/navgation")
    public Result navgation(@RequestParam("uid") Integer uid){
        List<Nav> list = new ArrayList<>();
        try {
            list = service.selectNav(uid);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 删除历史导航
     * @param uid
     * @return
     */
    @Operation(summary = "删除历史导航")
    @GetMapping("/deleteNav")
    public Result deleteNav(@RequestParam("uid") Integer uid){
        try {
            service.deleteNav(uid);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            return new Result(false, "删除失败", e.getMessage());
        }
    }

    /**
     * 修改支付密码
     * @param users
     * @return
     */
    @Operation(summary = "修改支付密码")
    @PostMapping("/updatePayPassword")
    public Result updatePayPassword(@RequestBody Users users ){
        try {
            service.updatePayPassword(users);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            return new Result(false, "修改失败", e.getMessage());
        }
    }

    /**
     * 查询免密支付详情
     * @param id
     * @return
     */
    @Operation(summary = "查询免密支付详情")
    @GetMapping("/noPayDetail")
    public Result noPayDetail(@RequestParam("id") Integer id){
        FreePay freePay = new FreePay();
        try {
            freePay = service.selectNoPayDetail(id);
            return new Result(true, "查询成功", freePay);
        } catch (Exception e) {
            return new Result(false, "查询失败，请稍后再试", e.getMessage());
        }
    }

    /**
     * 查询免密支付列表
     * @param uid
     * @return
     */
    @Operation(summary = "查询免密支付列表")
    @GetMapping("/noPayList")
    public Result noPayList(@RequestParam("uid") Integer uid){
        List<FreePay> list = new ArrayList<>();
        try {
            list = service.selectNoPayList(uid);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败，请稍后再试", e.getMessage());
        }
    }

    /**
     * 取消免密支付
     * @param id
     * @return
     */
    @Operation(summary = "取消免密支付")
    @DeleteMapping("/deleteFreePay")
    public Result deleteFreePay(@RequestParam("id") Integer id){
        try {
            service.deleteFreePay(id);
            return new Result(true, "取消成功");
        } catch (Exception e) {
            return new Result(false, "取消失败，请稍后再试", e.getMessage());
        }
    }

    /**
     * 添加免密支付
     * @param freePay
     * @return
     */
    @Operation(summary = "添加免密支付")
    @PostMapping("/addFreePay")
    public Result addFreePay(@RequestBody FreePay freePay){
        try {
            boolean isHaving = service.hasFreePay(freePay.getChargingStationId(), freePay.getUserId());
            if (isHaving) {
                return new Result(true, "该商家已开通免密支付");
            }else {
                service.addFreePay(freePay);
                return new Result(true, "添加成功");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(false, "添加失败，请稍后再试", e.getMessage());
        }
    }

    /**
     * 免密支付(如果查询到该商家已开通免密支付则直接添加支付账单，不用验证密码等)
     * @param id
     * @param uid
     * @return
     */
    @Operation(summary = "免密支付(如果查询到该商家已开通免密支付则直接添加支付账单，不用验证密码等)")
    @GetMapping("/selectFreePay")
    public Result selectFreePay(@RequestParam("id") Integer id, @RequestParam("uid") Integer uid){
        try {
            boolean isHaving = service.hasFreePay(id, uid);
            return new Result(true, "免密支付成功", isHaving);
        } catch (Exception e) {
            return new Result(false, "查询失败，请稍后再试", e.getMessage());
        }
    }

    /**
     * 查询支付方式列表
     * @param uid
     * @return
     */
    @Operation(summary = "查询支付方式列表")
    @GetMapping("/selectPayWay")
    public Result selectPayWay(@RequestParam("uid") Integer uid){
        List<UserPayWay> list = new ArrayList<>();
        try {
            list = service.selectUserPayWay(uid);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败，请稍后再试", e.getMessage());
        }
    }

    /**
     * 删除支付方式
     * @param ids
     * @return
     */
    @Operation(summary = "删除支付方式")
    @DeleteMapping("/deletePayWay")
    public Result deletePayWay(@RequestParam("ids") List<Integer> ids){
        try {
            service.deleteUserPayWay(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            return new Result(false, "删除失败，请稍后再试", e.getMessage());
        }
    }

    /**
     * 添加支付方式
     * @param userPayWay
     * @return
     */
    @Operation(summary = "添加支付方式")
    @PostMapping("/addPayWay")
    public Result addPayWay(@RequestBody UserPayWay userPayWay){
        try {
            service.insertPayWay(userPayWay);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            return new Result(false, "添加失败，请稍后再试", e.getMessage());
        }
    }

    /**
     * 查询支付方式列表，按支付顺序排序
     * @param uid
     * @return
     */
    @Operation(summary = "查询支付方式列表，按支付顺序排序")
    @GetMapping("/selectPayWayBySequence")
    public Result selectPayWayBySequence(@RequestParam("uid") Integer uid){
        List<UserPayWay> list = new ArrayList<>();
        try {
            list = service.selectUserPayWayList(uid);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败，请稍后再试", e.getMessage());
        }
    }

    /**
     * 更新支付顺序
     * @param id
     * @param sequence
     * @return
     */
    @Operation(summary = "更新支付顺序")
   @PutMapping("/updatePayWaySequence")
    public Result updatePayWaySequence(@RequestParam("id") Integer id, @RequestParam("sequence") Integer sequence){
       try {
           service.updateUserPayWay(id, sequence);
           return new Result(true, "更改成功");
       } catch (Exception e) {
           return new Result(false, "更改失败，请稍后再试", e.getMessage());
       }
   }

}

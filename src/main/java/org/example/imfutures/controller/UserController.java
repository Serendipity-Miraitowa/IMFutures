package org.example.imfutures.controller;

import org.apache.catalina.User;
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


}

package org.example.imfutures.controller;

import org.example.imfutures.dto.loginAndRegister.Login;
import org.example.imfutures.pojo.Users;
import org.example.imfutures.service.LoginService;
import org.example.imfutures.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/IMFuture")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    LoginService service;

    /**
     * 用户登录
     * @param login
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Login login){
        if (service.isHaveAccount(login)){
            if (service.isTrue(login) != null){
                Users users = service.login(login);
               return new Result(true, "登录成功", users);
            }else {
                return new Result(false, "密码错误请重试");
            }
        }else {
            return new Result(false, "账号不存在，请先注册");
        }
    }


    /**
     * 注册
     * @param login
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody Login login){
        try {
            if (service.isHaveAccount(login)){
                return new Result(false, "该手机号已有账号，请登录");
            }else {
                service.register(login);
                return new Result(true, "注册成功");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(false, "注册失败" + e.getMessage());
        }
    }


    /**
     * 修改密码
     * @param login
     * @return
     */
    @PostMapping("/updatePassword")
    public Result updatePassword(@RequestBody Login login){
        try {
            service.updatePassword(login);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            return new Result(false, "修改失败");
        }
    }
}

package org.example.imfutures.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.imfutures.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


/**
 * 获取验证码
 */

@Tag(name = "获取验证码")
@RestController
@RequestMapping("/IMFuture")
@CrossOrigin("*")
public class GetCode {

    /**
     * 获取手机号验证码
     * @param phone
     * @return
     */
    @Operation(summary = "获取手机号验证码")
    @GetMapping("/code")
    public Result code(@RequestParam("phone") String phone){
        try {
            Random random = new Random();
            Integer code = random.nextInt(9000) + 1000;
            return new Result(true, "验证码发送成功", code.toString());
        }catch (Exception e){
            return new Result(false, "验证码发送失败", e.getMessage());
        }
    }

    /**
     * 获取邮箱验证码
     * @param email
     * @return
     */
    @Operation(summary = "获取邮箱验证码")
    @GetMapping("/email")
    public Result email(@RequestParam("email") String email){
        try {
            Random random = new Random();
            Integer code = random.nextInt(9000) + 1000;
            return new Result(true, "验证码发送成功", code.toString());
        } catch (Exception e) {
            return new Result(false, "验证码发送失败", e.getMessage());
        }
    }
}

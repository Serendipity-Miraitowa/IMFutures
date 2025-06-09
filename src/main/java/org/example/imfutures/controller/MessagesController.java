package org.example.imfutures.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.imfutures.pojo.Message;
import org.example.imfutures.service.MessageService;
import org.example.imfutures.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Tag(name = "消息管理")
@CrossOrigin("*")
@RestController
@RequestMapping("/IMFuture/message")
public class MessagesController {

    @Autowired
    MessageService service;

    /**
     * 查询已阅读消息
     * @param uid
     * @return
     */
    @Operation(summary = "查询已阅读消息")
    @GetMapping("/messageList")
    public Result messageList(@RequestParam("uid") Integer uid) {
        List<Message> messages = new ArrayList<>();
        try {
            messages = service.messages(uid);
            return new Result(true, "查询成功", messages);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 查询未阅读消息
     * @param uid
     * @return
     */
    @Operation(summary = "查询未阅读消息")
    @GetMapping("/messageNoReadList")
    public Result messageNoReadList(@RequestParam("uid") Integer uid) {
        List<Message> messages = new ArrayList<>();
        try {
            messages = service.messagesNoRead(uid);
            return new Result(true, "查询成功", messages);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 更新状态
     * @param id
     * @param uid
     * @return
     */
    @Operation(summary = "更新状态")
    @PutMapping("/read")
    public Result read(@RequestParam("uid") Integer uid, @RequestParam("id") Integer id) {
        try {
            service.updateMessageStatus(uid, id);
            return new Result(true, "查询成功");
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 批量阅读
     * @param uid
     * @return
     */
    @Operation(summary = "批量阅读")
    @PutMapping("/readAll")
    public Result readAll(@RequestParam("uid") Integer uid) {
        try {
            service.updateMessageAll(uid);
            return new Result(true, "查询成功");
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }
}

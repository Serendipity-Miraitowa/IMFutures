package org.example.imfutures.controller;



import org.example.imfutures.dto.Comments;
import org.example.imfutures.dto.CommentsInsert;
import org.example.imfutures.service.CommentService;
import org.example.imfutures.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/IMFuture/comments")
public class CommentController {

    @Autowired
    CommentService service;

    /**
     * 查询用户所有评论
     * @param uid
     * @return
     */
    @GetMapping("/myComments")
    public Result commentList(@RequestParam("uid") Integer uid){
        List<Comments> list = new ArrayList<>();
        try {
            list = service.selectByUserId(uid);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @PostMapping("/addComment")
    public Result addComment(@RequestBody CommentsInsert comment){
        try {
            service.insert(comment);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            System.out.println("错误信息："+e.getMessage());
            return new Result(false, "添加失败", e.getMessage());
        }
    }

}

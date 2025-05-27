package org.example.imfutures.controller;


import org.example.imfutures.pojo.Nav;
import org.example.imfutures.service.NavigationService;
import org.example.imfutures.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/IMFuture/navgation")
public class NavigationController {

    @Autowired
    NavigationService service;

    /**
     * 查询历史导航
     * @param uid
     * @return
     */
    @GetMapping("/selectList")
    public Result selectList(@RequestParam("uid") Integer uid) {
        List<Nav> list = new ArrayList<>();
        try {
            list = service.findByUid(uid);
            return new Result(true, "查询成功", list);
        } catch (Exception e) {
            return new Result(false, "查询失败", e.getMessage());
        }
    }

    /**
     * 添加历史导航
     * @param nav
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Nav nav) {
        try {
            service.insert(nav);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            return new Result(false, "添加失败", e.getMessage());
        }
    }

    /**
     * 删除历史导航
     * @param uid
     * @return
     */
    @DeleteMapping("/{uid}")
    public Result delete(@PathVariable("uid") Integer uid) {
        try {
            service.delete(uid);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            return new Result(false, "删除失败，请稍后重试", e.getMessage());
        }
    }
}

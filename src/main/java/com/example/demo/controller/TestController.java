package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Result;
import com.example.demo.view.req.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class TestController {

    @Resource
    private UserService userService;

    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user) {
        try {
            log.info("User#{}", user);
            return userService.add(user);
        } catch (Exception e) {
            log.error("add user error#{}", e);
            return Result.builder().code(-1).msg("保存失败").build();
        }
    }

    @PostMapping("/users")
    public Result getUser(@RequestBody UserReq req) {
        try {
            log.info("UserReq#{}", req);
            return userService.select(req);
        } catch (Exception e) {
            log.error("search user error#{}", e);
            return Result.builder().code(-1).msg("查询出错").build();
        }
    }

    @PostMapping("/users/count")
    public Result countUser(@RequestBody UserReq req) {
        try {
            log.info("UserReq#{}", req);
            return userService.count(req);
        } catch (Exception e) {
            log.error("count user error#{}", e);
            return Result.builder().code(-1).msg("查询出错").build();
        }
    }
}

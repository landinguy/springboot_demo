package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            return Result.builder().code(-1).msg("保存用戶失敗").build();
        }
    }

    @PostMapping("/getUser")
    public Result getUser(@RequestParam String username) {
        try {
            log.info("username#{}", username);
            return userService.select(username);
        } catch (Exception e) {
            log.error("search user error#{}", e);
            return Result.builder().code(-1).msg("查詢用戶失敗").build();
        }
    }
}

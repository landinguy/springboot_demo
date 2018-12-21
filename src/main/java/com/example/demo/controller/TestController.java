package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Result;
import com.example.demo.view.req.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class TestController {

    @Resource
    private UserService userService;

    @PostMapping("/addUser")
    public Result addUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        try {
            log.info("User#{}", user);
            if (bindingResult.hasErrors()) {
                String errMsg = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.joining(","));
                log.info("@Valid not pass,errMsg#{}", errMsg);
                return Result.builder().code(-1).msg("参数校验未通过：" + errMsg).build();
            }
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

    /**
     * 前端为multipart/form-data post请求方式，后端参数获取及验证
     *
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping("/test")
    public Result test(@Valid User user, BindingResult bindingResult) {
        try {
            log.info("user#{}", user);
            if (bindingResult.hasErrors()) {
                String errMsg = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.joining(","));
                log.info("@Valid not pass,errMsg#{}", errMsg);
                return Result.builder().code(-1).msg("参数校验未通过：" + errMsg).build();
            }
            return userService.add(user);
        } catch (Exception e) {
            log.error("add user error#{}", e);
            return Result.builder().code(-1).msg("保存失败").build();
        }
    }
}

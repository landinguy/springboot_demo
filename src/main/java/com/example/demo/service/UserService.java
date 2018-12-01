package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.entity.UserExample;
import com.example.demo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by xxf on 2018/12/1 0001.
 */
@Slf4j
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public Result add(User user) {
        Date now = new Date();
        user.setCreateTs(now);
        user.setUpdateTs(now);
        userMapper.insertSelective(user);
        log.info("保存用戶成功,User#{}", user);
        return Result.builder().msg("success").build();
    }

    public Result select(String username) {
        UserExample example = new UserExample();
        if (!StringUtils.isEmpty(username)) {
            example.createCriteria().andUsernameEqualTo(username);
        }
        List<User> users = userMapper.selectByExample(example);
        log.info("users#{}", users);
        return Result.builder().msg("success").data(users).build();
    }
}

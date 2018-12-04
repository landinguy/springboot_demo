package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.entity.UserExample;
import com.example.demo.util.Result;
import com.example.demo.view.req.UserReq;
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
        log.info("保存用户成功,User#{}", user);
        return Result.builder().msg("保存成功").build();
    }

    public Result select(UserReq req) {
        UserExample example = new UserExample();
        example.setPageNo((req.getPageNo() - 1) * req.getPageSize());
        example.setPageSize(req.getPageSize());
        UserExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(req.getUsername())) {
            criteria.andUsernameLike(req.getUsername() + "%");
        }
        List<User> users = userMapper.selectByExample(example);
        log.info("users#{}", users);
        return Result.builder().msg("查询成功").data(users).build();
    }

    public Result count(UserReq req) {
        UserExample example = new UserExample();
        if (!StringUtils.isEmpty(req.getUsername())) {
            example.createCriteria().andUsernameLike(req.getUsername());
        }
        long count = userMapper.countByExample(example);
        log.info("查询出的用户数#{}", count);
        return Result.builder().msg("查询成功").data(count).build();
    }
}

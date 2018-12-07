package com.example.demo.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xxf on 2018/12/7 0007.
 */
@Configuration
public class MyBean {

    @Bean
    public JSONObject jsonObject() {
        return new JSONObject();
    }
}

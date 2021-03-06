package com.example.demo.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by xxf on 2018/12/7 0007.
 */
@Configuration
public class MyBean {

    @Bean
    public JSONObject jsonObject() {
        return new JSONObject();
    }

    /**
     * 线程池
     *
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor myExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(9999999);
        executor.setKeepAliveSeconds(60);
        return executor;
    }
}

package com.example.demo.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class JobTest {

    @Scheduled(cron = "2/10 * * * * ?")
    public void test() {
        LocalDateTime dateTime = LocalDateTime.now();
        log.info("北京时间#{}", dateTime);
    }

}

package com.example.demo.job;

import com.example.demo.config.MailConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

@Slf4j
@Component
public class JobTest {

    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private MailConfig mailConfig;

//    @Scheduled(cron = "2/10 * * * * ?")
//    public void test() {
//        String date = DateFormatUtils
//                .format(new Date(), "yyyy-MM-dd HH:mm:ss");
//        log.info("北京时间#{}", date);
//    }

    @Scheduled(cron = "0 10 23 * * ?")
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailConfig.getUsername());
        message.setTo("1029573528@qq.com");
        message.setSubject("主题：睡觉提醒");
        message.setText("亲爱的小飞，已经 22:30 啦！早点休息哦~~");

        javaMailSender.send(message);
    }


    @Scheduled(cron = "0/5 * * * * ?")
    public void test() {
        log.info("start..........");
        int n = 0;
        try {
            while (true) {
                n++;
                if (n > 10000) {
                    log.info("quite........");
                    Thread.sleep(5000);
                    break;
                }
                if (n % 1000 != 0) {
                    log.info("n{}", n);
                } else {
                    log.info("....n#{}", n);
                    Thread.sleep(2000);
                    continue;
                }
            }
        } catch (Exception e) {
            log.info("e#{}", e);
        }
    }


}

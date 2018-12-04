package com.example.demo.job;

import com.example.demo.config.MailConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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


}

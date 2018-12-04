package com.example.demo.job;

import com.example.demo.config.MailConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JobTest {

    @Resource
    private JavaMailSender JavaMailSender;
    @Resource
    private MailConfig MailConfig;

    @Test
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MailConfig.getUsername());
        message.setTo("1029573528@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        JavaMailSender.send(message);
    }
}
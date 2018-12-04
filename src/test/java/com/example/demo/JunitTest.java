package com.example.demo;

import com.example.demo.config.MailConfig;
import com.example.demo.junit_test.UserService;
import com.example.demo.util.Result;
import com.example.demo.view.req.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by xxf on 2018/12/2 0002.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTest {

    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private MailConfig mailConfig;
    @Resource
    private UserService userService;

    @Test
    public void count() {
        Result result = userService.count(new UserReq("", null, null));
        log.info("result#{}", result);
    }

    @Test
    public void sendMail1() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailConfig.getUsername());
        message.setTo("1029573528@qq.com");
        message.setSubject("主题：邮件测试");
        message.setText("这是一封测试邮件。");

        javaMailSender.send(message);
    }

}
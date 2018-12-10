package com.example.demo;

import com.example.demo.config.MailConfig;
import com.example.demo.entity.User;
import com.example.demo.rabbit.Sender;
import com.example.demo.service.RedisService;
import com.example.demo.service.UserService;
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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

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
    @Resource
    private Sender sender;
    @Resource
    private RedisService redisService;

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

    @Test
    public void rabbitTest() {
        Result result = userService.select(new UserReq("", 1, 10));
        List<User> users = (List<User>) result.getData();
//        users.forEach(item -> sender.sendToFanoutExchange(item));
//        users.forEach(item -> sender.sendToQuene("queueA", item));

        //A,B队列都将收到消息
//        users.forEach(item -> sender.sendToTopicExchange(item, "topic.a"));
        //只有B收到消息
        users.forEach(item -> sender.sendToTopicExchange(item, "topic.random"));
    }

    @Test
    public void redisTest() {
        Result result = userService.select(new UserReq("", 1, 10));
        List<User> users = (List<User>) result.getData();
//        users.forEach(item -> redisService.set("cache:user:" + item.getId(), item));

        users.forEach(item -> redisService.lSet("user:list", item));
        log.info("user:list#llen#{}", redisService.lGetListSize("user:list"));
    }

    /**
     * Files类的使用
     */
    @Test
    public void filesTest() {
        try {
//            BufferedReader br = Files.newBufferedReader(Paths.get("d:\\province.sql"), StandardCharsets.UTF_8);
//            BufferedWriter bw = Files.newBufferedWriter(Paths.get("d:\\province_copy.sql"), StandardCharsets.UTF_8);
//            String str;
//            while ((str = br.readLine()) != null) {
//                bw.write(str);
//                bw.newLine();
////                log.info(str);
//            }
//            bw.flush();
//            bw.close();
//            br.close();

            Files.copy(Paths.get("d:\\province.sql"), Paths.get("d:\\province_copy.sql"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.error("do file error#{}", e);
        }

    }

}
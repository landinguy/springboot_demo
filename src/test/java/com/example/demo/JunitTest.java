package com.example.demo;

import com.example.demo.config.MailConfig;
import com.example.demo.entity.User;
import com.example.demo.others.strategy.demo1.Flower;
import com.example.demo.others.strategy.demo1.Red;
import com.example.demo.rabbit.Sender;
import com.example.demo.service.RedisService;
import com.example.demo.service.UserService;
import com.example.demo.util.Result;
import com.example.demo.view.req.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Test
    public void xTest() {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.fluentPut("key1", "value1").fluentPut("key2", "value2");
//        log.info("size#{},jsonObject#{}", jsonObject.size(), jsonObject);

//        String s1 = "ab";
//        String s2 = s1.intern();
//        String s3 = new String("ab");
//        log.info("s1 == s2 ?#{}", s1 == s2);
//        log.info("s1 == s3 ?#{}", s1 == s3);

//        log.info("3 * 0.1 == 0.3 ?#{}", 3 * 0.1 == 0.3);

//        short s = 1;
//        s = s + 1;//错误
//        s = (short) (s + 1);//正确
//        s += 1;//正确


    }

//    @Reference(check = false)
//    private DemoService demoService;
//
//    @Test
//    public void dubboTest() {
//        log.info("sum#{}", demoService.add(520, 1314));
//    }

    /**
     * 策略模式测试
     */
    @Test
    public void test1() {

        /** 不使用策略模式 **/
//        Flower flower = new Flower();
//        flower.setColor(Color.PINK);
//        if (flower.getColor().equals(Color.PINK)) {
//            log.info("I have a pink flower");
//        } else if (flower.getColor().equals(Color.RED)) {
//            log.info("I have a red flower");
//        } else if (flower.getColor().equals(Color.WHITE)) {
//            log.info("I have a white flower");
//        }

        /** 使用策略模式 **/
        Flower f = new Flower();
        f.setColorInterface(new Red());
        log.info("msg#{}", f.getMsg());

    }

    @Test
    public void testOptional() {
        String str = "optional";
        Optional<String> op1 = Optional.of(str);
        Optional<Object> op2 = Optional.empty();

        /** orElse 存在即返回, 无则提供默认值 **/
//        log.info("value#{}", op1.orElse("default"));//optional
//        log.info("value#{}", op2.orElse("default"));//default

        /** orElseGet 存在即返回, 无则由函数来产生 **/
//        log.info("value#{}", op1.orElseGet(this::getString));//optional
//        log.info("value#{}", op2.orElseGet(this::getString));//default

        /** ifPresent 存在才对它做点什么 **/
//        op1.ifPresent(item -> log.info("item1#{}", item));//optional
//        op2.ifPresent(item -> log.info("item2#{}", item));

        /** map username存在,反转,否则输出default **/
        User user = new User();
        user.setUsername("jack");
        Optional<User> u = Optional.of(user);
        String result = u.map(User::getUsername).map(StringUtils::reverse).orElse("default");
        log.info("result#{}", result);

    }

    private String getString() {
        return "default";
    }

    @Test
    public void generateSql() {
        try {
            StringBuilder sb = new StringBuilder("INSERT INTO \"FLOW_SSP\".\"SP_NUMBER_APPLY_INFO\" (");
            sb.append("CHANNEL_NUMBER,")
                    .append("SP_NUMBER,")
                    .append("LOCAL_IP,")
                    .append("LOCAL_PORT,")
                    .append("UPSTREAM_ACCOUNT,")
                    .append("UPSTREAM_PASSWORD,")
                    .append("DOWNSTREAM_ACCOUNT,")
                    .append("DOWNSTREAM_PASSWORD,")
                    .append("COMPANY_CODE,")
                    /** 额外字段 **/
                    .append("BUID,")
                    .append("SUPPORT_BUSINESS_TYPE,")
                    .append("IP_PORT,")
                    .append("APPLY_STATUS,")
                    .append("STATUS,")
                    .append("TOMCAT_PORT) VALUES (");
            String extraValues = ",\'91023860\',\'0,1,2\',\'10.95.98.42:8881\',\'1\',\'1\',\'9090\');";//额外字段的值
            BufferedReader br = Files.newBufferedReader(Paths.get("d:\\data.csv"), StandardCharsets.UTF_8);
            BufferedWriter bw = Files.newBufferedWriter(Paths.get("d:\\data.sql"), StandardCharsets.UTF_8);
            String str;
            while ((str = br.readLine()) != null) {
                StringBuilder builder = new StringBuilder(sb);
                builder.append(addMH(str)).append(extraValues);
                bw.write(builder.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            log.info("e#{}", e);
        }
    }

    public String addMH(String str) {
        String[] arr = str.split(",");
        String result = Arrays.stream(arr).map(item -> "\'" + item + "\'").collect(Collectors.joining(","));
        return result;
    }

    @Test
    public void testUrl() throws Exception {
//        URL url = new URL("http://27.115.67.198:10001/smsfile/resource/62BA967F83954AE190C55D8D838E36CC.jpg?name=xxf#index");
//        log.info("###{}",url.getProtocol());
//        log.info("###{}",url.getHost());
//        log.info("###{}",url.getPort());
//        log.info("###{}",url.getFile());
//        log.info("###{}",url.getPath());
//        log.info("###{}",url.getQuery());
//        log.info("###{}",url.getRef());

    }

//    @Resource
//    private HelloService helloService;
//
//    @Test
//    public void testHelloService() {
//        log.info(helloService.sayHello());
//    }


}
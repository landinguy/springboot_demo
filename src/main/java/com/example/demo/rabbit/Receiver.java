package com.example.demo.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver {

    @RabbitHandler
    @RabbitListener(queues = "queueA")
    public void process1(String msg) {
        log.info("ReceiverA:msg#{}", msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "queueB")
    public void process2(String msg) {
        log.info("ReceiverB:msg#{}", msg);
    }

}

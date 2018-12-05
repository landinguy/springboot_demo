package com.example.demo.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class Sender {

    @Resource
    private AmqpTemplate AmqpTemplate;

    /**
     * 往指定队列发消息
     *
     * @param queue
     * @param msg
     */
    public void sendToQuene(String queue, Object msg) {
        AmqpTemplate.convertAndSend(queue, msg.toString());
        log.info("sender1:queue#{},msg#{}", queue, msg);
    }

    /**
     * 往fanoutExchange交换机上发消息，两个队列都将收到消息
     *
     * @param msg
     */
    public void sendToFanoutExchange(Object msg) {
        AmqpTemplate.convertAndSend("fanoutExchange", "", msg.toString());
        log.info("sender1:msg#{}", msg);
    }

    /**
     * 根据routingKey往匹配上的队列发消息
     *
     * @param msg
     * @param routingKey
     */
    public void sendToTopicExchange(Object msg, String routingKey) {
        AmqpTemplate.convertAndSend("topicExchange", routingKey, msg.toString());
        log.info("sender1:routingKey#{},msg#{}", routingKey, msg);
    }
}

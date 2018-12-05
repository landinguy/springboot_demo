package com.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue queueA() {
        return new Queue("queueA");
    }

    @Bean
    public Queue queueB() {
        return new Queue("queueB");
    }

    /**
     * 定义一个TopicExchange
     *
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 定义一个FanoutExchange
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    /* 将两个个队列都绑定到FanoutExchange交换机上 */
    @Bean
    public Binding bindingA() {
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingB() {
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }

    /* 将两个队列都绑定到TopicExchange交换机上 */
    @Bean
    public Binding bindingTopicExchangeA() {
        return BindingBuilder.bind(queueA()).to(topicExchange()).with("topic.a");
    }

    @Bean
    public Binding bindingTopicExchangeB() {
        return BindingBuilder.bind(queueB()).to(topicExchange()).with("topic.#");
    }

}

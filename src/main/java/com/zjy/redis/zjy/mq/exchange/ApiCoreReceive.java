package com.zjy.redis.zjy.mq.exchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ApiCoreReceive {
    @RabbitHandler
    @RabbitListener(queues = "api.core")
    public void user(String msg) {
        System.out.println("api.core receive message: " + msg);
    }
}
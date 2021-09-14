package com.zjy.redis.zjy.mq.exchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiCoreSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void user(String msg){
        System.out.println("api.core.user send message: "+msg);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user", msg);
    }

    public void userQuery(String msg){
        System.out.println("api.core.user.query send message: "+msg);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user.query", msg);
    }
}
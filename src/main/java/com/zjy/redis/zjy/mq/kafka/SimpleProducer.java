package com.zjy.redis.zjy.mq.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jose
 * date 2019
 */
@RestController
public class SimpleProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping("send")
    public String send(String msg){
        kafkaTemplate.send("test", "wtrfegbelkrg");
        return "succed add";
    }
}

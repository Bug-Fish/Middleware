package com.zjy.redis.zjy.mq.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.apache.kafka.clients.consumer.ConsumerRecord;


/**
 * @Author jose
 * date 2019
 */
@Component
public class SimpleConsumer {
    @KafkaListener(topics = "test")
    public void listen (ConsumerRecord<?, ?> record) throws Exception {
        //控制台打印send进来的信息
        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
    }
}


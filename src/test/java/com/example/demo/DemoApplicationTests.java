package com.example.demo;

import com.zjy.redis.zjy.DemoApplication;
import com.zjy.redis.zjy.mq.PaymentNotifySender;
import com.zjy.redis.zjy.mq.exchange.ApiCoreSender;
import com.zjy.redis.zjy.mq.exchange.ApiPaymentSender;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {

    @Test
    void contextLoads() {

    }

    @Autowired
    private PaymentNotifySender sender;

    @Test
    public void test_sender() {
        sender.sender("支付订单号："+System.currentTimeMillis());
    }


    @Autowired
    private ApiCoreSender coreSender;

    @Test
    public void test_user() {
        coreSender.user("用户管理！");
    }

    @Test
    public void test_userQuery() {
        coreSender.userQuery("查询用户信息！");
    }


    @Autowired
    private ApiPaymentSender paymentSender;

    @Test
    public void test_order() {
        paymentSender.order("订单管理！");
    }

    @Test
    public void test_orderQuery() {
        paymentSender.orderQuery("查询订单信息！");
    }

    @Test
    public void test_orderDetailQuery() {
        paymentSender.orderDetailQuery("查询订单详情信息！");
    }
}

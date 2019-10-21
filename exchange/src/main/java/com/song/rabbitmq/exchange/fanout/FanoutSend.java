package com.song.rabbitmq.exchange.fanout;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/fanout")
public class FanoutSend {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    private AtomicInteger count = new AtomicInteger(0);

    @GetMapping("/send")
    @ResponseBody
    public String send() {
        int num = count.addAndGet(1);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("spring-boot-FanoutExchange", // 交换机
                "", // routing-key
                "fanout:" + num, // 消息体内容
                correlationData); // 消息唯一ID
        return "success";
    }
}

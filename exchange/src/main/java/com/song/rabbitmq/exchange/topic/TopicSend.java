package com.song.rabbitmq.exchange.topic;

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
@RequestMapping("/topic")
public class TopicSend {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    private AtomicInteger count = new AtomicInteger(0);

    @GetMapping("/send")
    @ResponseBody
    public String send() {
        int num = count.addAndGet(1);
        String routingKey;
        if (num % 2 == 0) {
            routingKey = "song.mq.queueA";
        } else {
            routingKey = "song.mq.queueC";
        }

        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("spring-boot-TopicExchange", // 交换机
                routingKey, // routing-key
                "Topic:" + num, // 消息体内容
                correlationData); // 消息唯一ID
        return "success";
    }
}

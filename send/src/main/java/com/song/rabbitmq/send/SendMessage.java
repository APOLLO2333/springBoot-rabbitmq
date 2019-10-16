package com.song.rabbitmq.send;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SendMessage {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("spring-boot-exchange", // exchange：交换机
                "foo.bar.baz", // routing-key
                msg, // 消息体内容
                correlationData); // 消息唯一ID
    }
}

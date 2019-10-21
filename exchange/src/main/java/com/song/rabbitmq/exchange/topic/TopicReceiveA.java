package com.song.rabbitmq.exchange.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "Topic_A")
@Component
public class TopicReceiveA {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("TopicReceiveA -> Topic_A receive:" + msg);
    }
}

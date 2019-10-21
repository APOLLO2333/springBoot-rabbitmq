package com.song.rabbitmq.exchange.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "Topic_B")
@Component
public class TopicReceiveB {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("TopicReceiveB -> Topic_B receive:" + msg);
    }
}

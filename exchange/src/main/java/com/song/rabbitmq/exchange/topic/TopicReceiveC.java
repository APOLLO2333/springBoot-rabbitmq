package com.song.rabbitmq.exchange.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "Topic_C")
@Component
public class TopicReceiveC {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("TopicReceiveC -> Topic_C receive:" + msg);
    }
}

package com.song.rabbitmq.exchange.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "Direct_A")
@Component
public class DirectReceiveB {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("DirectReceiveB -> Direct_A receive:" + msg);
    }
}

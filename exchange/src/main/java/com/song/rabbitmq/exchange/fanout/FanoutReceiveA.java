package com.song.rabbitmq.exchange.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "Fanout_A")
@Component
public class FanoutReceiveA {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiveA -> Fanout_A receive:" + msg);
    }
}

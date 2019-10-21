package com.song.rabbitmq.exchange.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "Fanout_B")
@Component
public class FanoutReceiveB {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiveB -> Fanout_B receive:" + msg);
    }
}

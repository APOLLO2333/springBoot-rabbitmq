package com.song.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class Producer {


    @Autowired
    private RabbitTemplate template;

    @GetMapping("/send")
    public void sendMessage(String msg) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        template.convertAndSend("message", msg);
    }

}

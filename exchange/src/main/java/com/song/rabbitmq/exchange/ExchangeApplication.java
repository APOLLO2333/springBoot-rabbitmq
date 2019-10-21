package com.song.rabbitmq.exchange;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExchangeApplication {

    //    public static final String DirectExchangeName = "spring-boot-DirectExchange";
//    public static final String ExchangeName = "spring-boot-FanoutExchange";
    public static final String ExchangeName = "spring-boot-TopicExchange";
    //    public static final String queueNameA = "Direct_A";
//    public static final String queueNameA = "Fanout_A";
//    public static final String queueNameB = "Fanout_B";
    public static final String queueNameA = "Topic_A";
    public static final String queueNameB = "Topic_B";
    public static final String queueNameC = "Topic_C";

    @Bean
    Queue queueA() {
        return new Queue(queueNameA, false);
    }

    @Bean
    Queue queueB() {
        return new Queue(queueNameB, false);
    }

    @Bean
    Queue queueC() {
        return new Queue(queueNameC, false);
    }

//    @Bean
//    DirectExchange exchange() {
//        return new DirectExchange(ExchangeName);
//    }

//    @Bean
//    FanoutExchange exchange() {
//        return new FanoutExchange(ExchangeName);
//    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(ExchangeName);
    }
//
//    @Bean
////    Binding bindingA(@Qualifier("queueA") Queue queue, FanoutExchange exchange) {
////        return BindingBuilder.bind(queue).to(exchange);
////    }
////
////    @Bean
////    Binding bindingB(@Qualifier("queueB") Queue queue, FanoutExchange exchange) {
////        return BindingBuilder.bind(queue).to(exchange);
////    }


    @Bean
    Binding bindingA(@Qualifier("queueA") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("song.mq.queueA");
    }

    @Bean
    Binding bindingB(@Qualifier("queueB") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("song.mq.#");
    }

    @Bean
    Binding bindingC(@Qualifier("queueC") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("song.mq.queueC");
    }

    public static void main(String[] args) {
        SpringApplication.run(ExchangeApplication.class, args);
    }

}

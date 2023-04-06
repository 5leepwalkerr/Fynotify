package com.example.fynotify.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitConfig {
    @Bean
    public Queue myQueue1(){
        return new Queue("myQueue1");
    }
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("common-exchange");
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct-exchange");
    }
    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(myQueue1()).to(directExchange()).with("warning");
    }
}

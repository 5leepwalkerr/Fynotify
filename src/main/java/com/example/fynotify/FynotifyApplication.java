package com.example.fynotify;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.RabbitConnectionFactoryBean;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import static org.springframework.amqp.core.ExchangeBuilder.directExchange;

@SpringBootApplication
public class FynotifyApplication {
    public static void main(String[] args) {
        SpringApplication.run(FynotifyApplication.class, args);
    }

    @Bean
    public Queue myQueue1(){
        return new Queue("myQueue1");
    }
    @Bean
    public Queue myQueue2(){
        return new Queue("myQueue2");
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
        return BindingBuilder.bind(myQueue1()).to(directExchange()).with("error");
    }
    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(myQueue2()).to(directExchange()).with("info");
    }
    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(myQueue2()).to(directExchange()).with("warning");
    }
}

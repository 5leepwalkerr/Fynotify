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
}

package com.example.fynotify.config;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
@Log4j
@RequiredArgsConstructor
@Configuration
@EnableWebSocketMessageBroker
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

    @Value("${spring.rabbitmq.host}")
    @NonFinal String host;

    @Value("${spring.rabbitmq.username}")
    @NonFinal String username;

    @Value("${spring.rabbitmq.password}")
    @NonFinal String password;
}

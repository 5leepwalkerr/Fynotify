package com.example.fynotify.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class Listener {
Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @RabbitListener(queues = "myQueue1")
    public void processMyQueue(String message){
        LOGGER.info("Received first message from myQueue1 : {}",message);
    }
    @RabbitListener(queues = "myQueue2")
    public void handleExchange(String message){
        LOGGER.info("Received message from exchange using rabbitHandler : {}",message);
        //TODO: прописать тесты для вебсокетов нагуглить sendTo, messageMapping, rabbitTemplate, схему отправки сообщений по сокетам(для понимания)
    }
}

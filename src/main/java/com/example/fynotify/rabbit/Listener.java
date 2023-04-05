package com.example.fynotify.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class Listener {
    Logger logger = LoggerFactory.getLogger(Listener.class);

    @RabbitListener(queues = "myQueue1")
    public void processMyQueue(String message){
        logger.info("Recieved first message from myQueue1 : {}",message);
    }
    @RabbitListener(queues = "myQueue2")
    public void processMyQueue2(String message){
        logger.info("Recieved second message from myQueue2 : {}",message);
    }
}

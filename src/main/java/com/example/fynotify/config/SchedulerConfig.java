package com.example.fynotify.config;

import com.example.fynotify.models.UserResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedulerConfig {

    @Autowired
    private RabbitTemplate template;
    @Scheduled(fixedDelay = 3000)
    public void sendMessages(){
        template.convertAndSend("topic/user",new UserResponse("Message from Scheduler!"));
    }
}

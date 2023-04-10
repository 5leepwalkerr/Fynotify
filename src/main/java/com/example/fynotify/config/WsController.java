package com.example.fynotify.config;

import com.example.fynotify.models.User;
import com.example.fynotify.models.UserResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {

    @Autowired
    //private RabbitTemplate rabbitTemplate;

    @MessageMapping("/user")
    @SendTo("/topic/user")
    public UserResponse getUser(User user){
        return new UserResponse(user.getName());
    }

    //TODO: видос на ютубе, разобраться с сокетами и как посылать нотифай из ws контроллера
}

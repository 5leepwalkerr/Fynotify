package com.example.fynotify.config;

import com.example.fynotify.models.Notification;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {

    @MessageMapping("/notify.sendMessage")
    @SendTo("topic/messages")
    public Notification sendMessage(@Payload Notification notification){
        return notification;
    }

    @MessageMapping("/notify.newUser")
    public Notification newUser(@Payload Notification notification, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username",notification.getSender());
        return notification;
    }
}

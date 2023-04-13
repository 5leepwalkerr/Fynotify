package com.example.fynotify.rabbit;

import com.example.fynotify.models.Notification;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@EnableRabbit
@Component
@Slf4j
public class Listener {
    Logger LOGGER = LoggerFactory.getLogger(Listener.class);
    @Autowired
    private SimpMessageSendingOperations messageTemplate;

    @EventListener
    public void handleWebSocketConnectionListener(SessionConnectedEvent event){
        LOGGER.info("WebSocket connection successful!");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String)headerAccessor.getSessionAttributes().get("username");
        if(username!=null){
            Notification notification = new Notification();
            notification.setType("Leave");
            notification.setSender(username);

            messageTemplate.convertAndSend("/topic/public",notification);
        }
    }

}

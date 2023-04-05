package com.example.fynotify.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/fynotify")
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/test")
    public ResponseEntity<?> sendMessage(@RequestBody HashMap<String,String> map){
        logger.info("Init my queue");
        template.setExchange("direct-exchange");
        template.convertAndSend(map.get("key"),map.get("message"));
        return ResponseEntity.ok("Success emit to queue");
    }
}

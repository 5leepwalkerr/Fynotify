package com.example.fynotify.controllers;

import com.example.fynotify.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.support.serializer.JsonSerializer;

@RestController
@RequestMapping("/fynotify")
public class TestController {
    @Autowired
    private Producer producer;

    @GetMapping("/test")
    public ResponseEntity<String> message(@RequestParam("message")String message){
         producer.sendMessage(message);
         return ResponseEntity.ok("Message sent!");
    }
}

package com.example.fynotify.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Notification implements Serializable {
    private String notification;
    private String sender;
    private String type;
}

package com.example.fynotify.models;

import java.io.Serializable;

public class UserResponse implements Serializable {
    private String content;
    public UserResponse(){}
    public UserResponse(String content){
        this.content = content;
    }
}

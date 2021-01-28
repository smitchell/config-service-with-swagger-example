package com.example.sampleclient.controllers;

import com.example.sampleclient.models.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Value("${message:Hello default}")
    private String message;

    @GetMapping("/{id}")
    public Message getMessage(@PathVariable final int id) {
        return new Message(id, this.message);
    }

}

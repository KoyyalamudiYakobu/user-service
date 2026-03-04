package com.example.demo.cotroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MessageProducer;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

	
	@Autowired
    private final MessageProducer producer;

    public MessageController(MessageProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/sendMsg/{msg}")
    public String sendMessage(@PathVariable String msg) {
        producer.sendMessage(msg);
        return "Message sent: " + msg;
    }
    
    @GetMapping("/sendseccondMsg/{msg}")
    public String sendMessageTwo(@PathVariable String msg) {
        producer.sendMessageTwo(msg);
        return "Message sent: " + msg;
    }
    
}

package com.example.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.example.demo.config.RabbitMQConfig;

@Service
public class MessageConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumeMessage(String message) {
        System.out.println("Received Message: " + message);
    }
    
    @RabbitListener(queues=RabbitMQConfig.QUEUE_TWO)
    public void consumeMessageTwo(String message)
    {
    	System.out.println("Received Message Two: " + message);
    }
}

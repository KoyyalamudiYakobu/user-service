package com.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "my_queue";
    public static final String QUEUE_TWO = "my_queue_Tow";
    public static final String EXCHANGE = "my_exchange";
    public static final String ROUTING_KEY = "my_routing_key";
    public static final String ROUTING_KEY_TWO = "my_routing_key_Two";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, false);
    }
    
    @Bean
    public Queue queueTwo() {
        return new Queue(QUEUE_TWO, false);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
    
    @Bean
    public Binding bindingTwo(Queue queueTwo, DirectExchange exchange) {
        return BindingBuilder.bind(queueTwo).to(exchange).with(ROUTING_KEY_TWO);
    }
}

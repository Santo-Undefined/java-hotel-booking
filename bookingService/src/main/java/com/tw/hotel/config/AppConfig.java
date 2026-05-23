package com.tw.hotel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${hotel.redis.receipt-queue-name:task-queue}")
    private String queueName;

    @Bean(name = "receiptQueueName")
    public String receiptQueueName() {
        return this.queueName;
    }
}


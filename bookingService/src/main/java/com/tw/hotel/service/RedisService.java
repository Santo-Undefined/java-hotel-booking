package com.tw.hotel.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.hotel.responseDto.BookingResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RedisService {
    private final String queueName;
    ObjectMapper mapper = new ObjectMapper();
    private final ReactiveStringRedisTemplate redisTemplate;

    @Autowired
    public RedisService(
            ReactiveStringRedisTemplate redisTemplate,
            @Qualifier("receiptQueueName") String queueName) {
        this.redisTemplate = redisTemplate;
        this.queueName = queueName;
    }

    public Mono<Long> pushTask(BookingResponseDto bookingResponseDto) throws JsonProcessingException {
        System.out.println("queue name "  + queueName);
        String responseString = mapper.writeValueAsString(bookingResponseDto);
        return redisTemplate.opsForList()
                .leftPush(queueName, responseString)
                .doOnSuccess(len -> System.out.println("Successfully pushed. New size: {}".formatted(len)) )
                .doOnError(e -> System.out.println("Redis push failed!".formatted(e)));
    }
}
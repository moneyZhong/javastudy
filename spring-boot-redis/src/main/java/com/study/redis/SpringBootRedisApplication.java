package com.study.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringBootRedisApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootRedisApplication.class, args);
    }
}

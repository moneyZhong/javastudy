package com.study.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ProviderApplication.class, args);

    }
}

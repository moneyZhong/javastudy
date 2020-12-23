package com.study.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@MapperScan("com.study.mybatisplus.dao")
@SpringBootApplication
public class MybatisPlusApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MybatisPlusApplication.class, args);

    }

}

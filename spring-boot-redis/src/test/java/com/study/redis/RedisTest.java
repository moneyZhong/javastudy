package com.study.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// 获取启动类，加载配置，确定装载 Spring 程序的装载方法，它回去寻找 主配置启动类（被 @SpringBootApplication 注解的）
@SpringBootTest
// 让 JUnit 运行 Spring 的测试环境， 获得 Spring 环境的上下文的支持
@RunWith(SpringRunner.class)

public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate ;

    @Test
    public void test1(){
        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("key11111", "value", 10, TimeUnit.SECONDS);
        System.out.println(aBoolean);

        redisTemplate.opsForValue().set("userName",new User("zhongqian",30,new Date()));


        Object userName = redisTemplate.opsForValue().get("userName");
        System.out.println(userName);
        User user = (User)userName;
        System.out.println(user.getAge()+"======"+user.getUserName());
    }
}
@NoArgsConstructor
@AllArgsConstructor
@Data
class User{
    private String userName;
    private int age;
    private Date birthDay;
}

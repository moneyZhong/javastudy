package com.springboot.study;

import com.springboot.study.controller.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStudyApp.class)
public class GetTest {

    @Autowired
    private RestTemplate restTemplate;
    @Test
    public  void test01(){
        String forObject = restTemplate.getForObject(URI.create("http://localhost:8888/get/paramOnUrl/1/2"), String.class);
        System.out.println(forObject);
    }



    @Test
    public void test02(){
        String forObject = restTemplate.getForObject("http://localhost:8888/get/paramOnUrl/{1}/{2}", String.class, 1, "钟钱");
        System.out.println(forObject);
    }

    @Test
    public void test03(){
        String forObject = restTemplate.getForObject("http://localhost:8888/get/getParam?name=钟钱&age=38", String.class);
        System.out.println(forObject);
    }
    @Test
    public void test03_1(){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("name","zhongqian");
        paramMap.put("age",800);
        String forObject = restTemplate.getForObject("http://localhost:8888/get/getParam?name={name}&age={age}", String.class,paramMap);
        System.out.println(forObject);
    }
    @Test
    public void test04() throws Exception{
        String forObject = restTemplate.getForObject("http://localhost:8888/get/getParamBase64?name="+ URLEncoder.encode("钟钱","utf8"), String.class);
        System.out.println(forObject);
    }


    @Test
    public void test05(){
        User forObject = restTemplate.getForObject("http://localhost:8888/get/getForObject", User.class);
        System.out.println(forObject);
    }

    @Test
    public void test05_1(){
        ResponseEntity<User> forEntity = restTemplate.getForEntity("http://localhost:8888/get/getForObject", User.class);
        System.out.println(forEntity.getStatusCode() == HttpStatus.OK);
        System.out.println(forEntity.getBody());
    }







}

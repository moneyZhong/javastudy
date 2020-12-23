package com.springboot.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootStudyApp.class)
public class PostTest {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test01(){
        LinkedMultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.set("name","zhangsan");

        String s = restTemplate.postForObject("http://localhost:8888/post/postForm", request, String.class);
        System.out.println(s);
    }
    @Test
    public void test02(){
        LinkedMultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.set("name","zhangsan");

        String s = restTemplate.postForObject("http://localhost:8888/post/postBody", request, String.class);
        System.out.println(s);
    }


}

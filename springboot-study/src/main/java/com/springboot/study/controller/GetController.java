package com.springboot.study.controller;


import com.springboot.study.controller.vo.User;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.base64.Base64Decoder;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

@RestController
@RequestMapping("get")
public class GetController {

    //http://localhost:8888/get/paramOnUrl/5/7
    @RequestMapping("paramOnUrl/{age}/{name}")
    public String paramOnUrl(@PathVariable(name="name") String name,@PathVariable(name = "age") int age){
        return "age:"+age+"===name:"+name;
    }

    //http://localhost:8888/get/getParam?name=zhongqian&age=38
    @RequestMapping("getParam")
    public String getParam(@RequestParam(name="name") String name, @RequestParam(name="age") int age){
        return "age:"+age+"===name:"+name;
    }

    @RequestMapping("getParamBase64")
    public String getParam(@RequestParam(name="name") String name) throws Exception{
        return "name:"+ URLDecoder.decode(name,"utf8");
    }

    //http://localhost:8888/get/getForObject
    @GetMapping("getForObject")
    public User getForObject(){
        User user = new User();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("zhongqian");
        return user;
    }



}

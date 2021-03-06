package com.study.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping(value = "login-success",produces = "text/plan;charset=UTF-8")
    public String loginSuccess(){
        return "登录成功";
    }

    @GetMapping(value = "r/r1",produces = "text/plan;charset=UTF-8")
    public String r1(){
        return "访问资源r1";
    }

    @GetMapping(value = "r/r2",produces = "text/plan;charset=UTF-8")
    public String r2(){
        return "访问资源r2";
    }
}

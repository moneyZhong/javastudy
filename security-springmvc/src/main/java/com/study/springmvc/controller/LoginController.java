package com.study.springmvc.controller;

import com.study.springmvc.model.AuthVo;
import com.study.springmvc.model.UserDto;
import com.study.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping(value = "login",produces = "text/plain;charset=utf-8")
    public String  login(AuthVo authVo, HttpSession session){
        UserDto auth = authenticationService.auth(authVo);
        session.setAttribute(UserDto.USER_SESSION_KEY,auth);
        return auth.getUsername()+"登录成功!";
    }

    @GetMapping(value="logout",produces = "text/plain;charset=utf-8")
    public String logout(HttpSession session){
        session.invalidate();
        return "退出成功";
    }

    @GetMapping(value="r/r1",produces = "text/plain;charset=utf-8")
    public String r1(HttpSession session){
        UserDto attribute = (UserDto) session.getAttribute(UserDto.USER_SESSION_KEY);
        if(attribute == null){
            return "匿名访问资源r1";
        }
        return attribute.getUsername()+"访问r1";
    }

    @GetMapping(value="r/r2",produces = {"text/plain;charset=utf-8"})
    public String r2(HttpSession session){
        UserDto attribute = (UserDto) session.getAttribute(UserDto.USER_SESSION_KEY);
        if(attribute == null){
            return "匿名访问资源r2";
        }
        return attribute.getUsername()+"访问r2";
    }
}

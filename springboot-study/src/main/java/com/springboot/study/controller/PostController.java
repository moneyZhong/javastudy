package com.springboot.study.controller;

import com.springboot.study.controller.vo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
public class PostController {

    @PostMapping("postForm")
    public String postForm(String name){
        return name;
    }

    @PostMapping("postBody")
    public  User postBody(@RequestBody User user){
        return user;
    }

}

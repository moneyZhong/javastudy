package com.springboot.study.controller.vo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String name;
    private Date birthday;
    private int age;
}

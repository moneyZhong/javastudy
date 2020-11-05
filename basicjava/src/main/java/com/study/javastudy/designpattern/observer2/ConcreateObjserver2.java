package com.study.javastudy.designpattern.observer2;

public class ConcreateObjserver2 implements  Observer2{
    @Override
    public void update() {
        System.out.println("接收到了通知");
    }
}

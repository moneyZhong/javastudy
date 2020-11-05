package com.study.javastudy.designpattern.observer1;

public class ConcreateObserver implements  Observer{
    @Override
    public void update() {
        System.out.println(this+"...接收到通知了");
    }
}

package com.study.javastudy.designpattern.observer2;

public class ConcreateSubject2 extends Subject2{
    private String state;
    @Override
    public void doUpdate(String state) {
        this.state = state;
        System.out.println(state);
        notifyAllObServer();
    }
}

package com.study.javastudy.designpattern.observer2;

public class Test {
    public static void main(String[] args) {
        Observer2 observer2 = new ConcreateObjserver2();
        Observer2 observer21 = new ConcreateObjserver2();
        Subject2 subject2 = new ConcreateSubject2();
        subject2.add(observer2);
        subject2.add(observer21);
        subject2.doUpdate("状态发生变化");
    }
}

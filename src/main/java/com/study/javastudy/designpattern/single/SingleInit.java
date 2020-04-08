package com.study.javastudy.designpattern.single;

public class SingleInit {
    private static SingleInit singleInit = new SingleInit();
    private SingleInit(){}

    public static SingleInit getInstance(){
        return singleInit;
    }
}

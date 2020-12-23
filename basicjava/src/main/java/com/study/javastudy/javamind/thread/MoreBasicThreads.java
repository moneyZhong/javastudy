package com.study.javastudy.javamind.thread;

public class MoreBasicThreads {
    public static void main(String[] args) {
        for(int i = 0 ; i< 10; i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting for liftOff");
    }
}

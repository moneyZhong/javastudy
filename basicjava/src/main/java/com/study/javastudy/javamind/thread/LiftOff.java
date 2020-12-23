package com.study.javastudy.javamind.thread;

public class LiftOff implements  Runnable{
    private  Integer countDown = 10; //default value

    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(){}
    public LiftOff(Integer countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#"+id+"("+ (countDown>0?countDown:"LiftOff!") +")";
    }

    @Override
    public void run() {
        while(countDown-- >0){
            System.out.println(status());
            Thread.yield();//将cpu从一个线程转移给另一个线程。
        }
    }

}

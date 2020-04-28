package com.study.javastudy.designpattern.single;

public class SingleSync {
    private SingleSync(){}

    private static SingleSync singleSync = null;

    public static SingleSync getInstance(){
        if(singleSync == null){
            synchronized (SingleSync.class){
                if(singleSync == null){
                    singleSync = new SingleSync();
                }
            }
        }
        return singleSync;
    }
}

package com.study.javastudy.designpattern.factory.simple;

public abstract class LoggerFactory {
    abstract  Logger createLoger();

    public void writeLog(){
        this.createLoger().addLog();
    }

}

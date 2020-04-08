package com.study.javastudy.designpattern.factory.simple;

public class DbLoggerFactory extends  LoggerFactory{
    @Override
    Logger createLoger() {
        return new DbLog();
    }
}

package com.study.javastudy.designpattern.factory.simple;

public class FileLoggerFactory extends  LoggerFactory {
    @Override
    Logger createLoger() {
        return new FileLog();
    }
}

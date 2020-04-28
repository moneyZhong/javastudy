package com.study.javastudy.designpattern.factory.simple;

public class FileLog implements  Logger{
    @Override
    public void addLog() {
        System.out.println("FileLog >> addLog()");
    }
}

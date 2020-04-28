package com.study.javastudy.designpattern.factory.simple;

import lombok.extern.java.Log;

public class DbLog implements Logger {
    @Override
    public void addLog() {
        System.out.println("Dblog addLog");
    }
}

package com.study.javastudy.designpattern.observer1;

public interface Subject {
    void add(Observer observer);
    void sub(Observer observer);
    void notifyObservers();
}

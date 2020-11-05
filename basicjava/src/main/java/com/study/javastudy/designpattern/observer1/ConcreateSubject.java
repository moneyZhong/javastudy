package com.study.javastudy.designpattern.observer1;

import java.util.Iterator;
import java.util.Vector;

public class ConcreateSubject implements  Subject{
    private Vector<Observer> vector = new Vector<>();

    @Override
    public void add(Observer observer) {

        this.vector.add(observer);
    }

    @Override
    public void sub(Observer observer) {
        this.vector.remove(observer);
    }


    @Override
    public void notifyObservers() {
        System.out.println("通知所有观察者");
        Iterator<Observer> iterator = vector.iterator();
        while (iterator.hasNext()){
            iterator.next().update();
        }
    }
}

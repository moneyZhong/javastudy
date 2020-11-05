package com.study.javastudy.designpattern.observer2;

import java.util.Iterator;
import java.util.Vector;

public abstract class Subject2 {
    Vector<Observer2> vector = new Vector<>();
    public void add(Observer2 observer2){
        vector.add(observer2);
    }
    public void sub(Observer2 observer2){
        vector.remove(observer2);
    }
    protected void notifyAllObServer(){
        Iterator<Observer2> iterator = vector.iterator();
        while(iterator.hasNext()){

            iterator.next().update();
        }
    }
    public abstract void doUpdate(String state);
}

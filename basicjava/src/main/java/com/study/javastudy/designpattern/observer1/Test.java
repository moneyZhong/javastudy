package com.study.javastudy.designpattern.observer1;


public class Test {
    public static void main(String[] args) {
        Observer observer1 = new ConcreateObserver();
        Observer observer2 = new ConcreateObserver();

        Subject subject = new ConcreateSubject();
        subject.add(observer1);
        subject.add(observer2);
        subject.notifyObservers();
    }

    /**
     * 存在问题
     * 上面的【抽象主题角色】，其中管理集合的方法，都是由子类来实现的，
     * 而实际情况则是这些管理集合的方法是所有实现子类共用的，
     * 所以可以把这些转移到抽象主题中去。
     */
}

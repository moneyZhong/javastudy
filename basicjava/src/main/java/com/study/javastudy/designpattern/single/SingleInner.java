package com.study.javastudy.designpattern.single;

public class SingleInner {
    private SingleInner(){}

    private static class SingleInnerTemp{
        private static SingleInner singleInner = new SingleInner();
    }
    private static SingleInner getInstance(){
        return SingleInnerTemp.singleInner;
    }

}

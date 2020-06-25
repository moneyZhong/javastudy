package com.study.javastudy.designpattern.proxy.dynamic;



public class WangTeacher implements ITeacher{
    @Override
    public String teach(String str) {
        System.out.println("wang 老师上课");
        return str+"hell";
    }

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new WangTeacher());
        ITeacher instance = (ITeacher) proxyFactory.getInstance();
        String wanghhh = instance.teach("wanghhh");
        System.out.println(wanghhh);
    }
}

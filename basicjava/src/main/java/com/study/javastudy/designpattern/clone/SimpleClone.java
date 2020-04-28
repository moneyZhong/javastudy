package com.study.javastudy.designpattern.clone;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class SimpleClone implements Cloneable{
    private String name;
    private int age;

    private SimpleObject simpleObject;


    @Override
    public SimpleClone clone() throws CloneNotSupportedException {
        return (SimpleClone) super.clone();
    }


}

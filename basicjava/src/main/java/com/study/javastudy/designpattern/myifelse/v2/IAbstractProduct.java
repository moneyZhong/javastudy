package com.study.javastudy.designpattern.myifelse.v2;

import javax.annotation.PostConstruct;

public abstract class IAbstractProduct implements  IProduct{
    @PostConstruct
    public void addToList() {
        ProductService.addProduct(this);
    }
}

package com.study.javastudy.designpattern.myifelse.v1;

public class Test {
    public static void main(String[] args) {
        IProduct product = ProductFactory.getProduct("B");
        product.createProduct();
    }
}

package com.study.javastudy.obpool.simple;

import org.apache.commons.pool2.impl.GenericObjectPool;

public class Test {
    public static void main(String[] args) {
        ReaderWithPoolUtil readerWithPoolUtil = new ReaderWithPoolUtil(new GenericObjectPool(new StringBufferFactory()));

    }
}

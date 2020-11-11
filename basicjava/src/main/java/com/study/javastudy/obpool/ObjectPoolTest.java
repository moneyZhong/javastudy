package com.study.javastudy.obpool;

import com.study.javastudy.obpool.simple.ReaderUtil;
import com.study.javastudy.obpool.simple.ReaderWithPoolUtil;
import com.study.javastudy.obpool.simple.StringBufferFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * <dependency>
 *
 *    <groupId>org.apache.commons</groupId>
 *
 *    <artifactId>commons-pool2</artifactId>
 *
 *    <version>2.4.2</version>
 *
 * </dependency>
 * 对象池
 */
public class ObjectPoolTest {
    public static void main(String[] args) {
        ReaderWithPoolUtil readerUtil = new ReaderWithPoolUtil(new GenericObjectPool<StringBuffer>(new StringBufferFactory()));
    }
}

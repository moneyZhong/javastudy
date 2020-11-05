package com.study.javastudy.strings;

import cn.hutool.core.io.resource.ClassPathResource;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class StringTest {
    @Test
    public void test01(){
        String format = String.format("%0" + 5 + "d", 2);
        System.out.println(format);//00002

        String format2 = String.format("%0" + 5 + "d", 100);
        System.out.println(format2);//00100

        String format3 = String.format("%0" + 5 + "d", 989898989);
        System.out.println(format3);//989898989

    }

    @Test
    public void test02(){
        ClassPathResource classPathResource = new ClassPathResource("com/study/javastudy/claszz");
        System.out.println(classPathResource.getAbsolutePath());


    }

    @Test
    public void test03(){
        ClassLoader classLoader = null;
        classLoader = Thread.currentThread().getContextClassLoader();
        URL dir = classLoader.getResource("dir");
        String path = dir.getPath();
        System.out.println(path);
    }
}

package com.study.javastudy.stream;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;

public class StreamTest {

    @Test
    public void joinTest01(){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        String join = Joiner.on(",").join(list);
        System.out.println(join);

    }
    @Test
    public void joinTest02(){
        String[] split = "aaa,bbb".split(",");
        List<String> strings = Arrays.asList(split);
        System.out.println(strings);

        List<String> strings1 = Arrays.asList("aaa,bbb".split(","));
        System.out.println(strings1);
    }

}

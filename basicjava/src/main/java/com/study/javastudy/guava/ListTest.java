package com.study.javastudy.guava;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class ListTest {
    @Test
    public void test01(){
        List<Integer> numList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

        List<List<Integer>> lists=Lists.partition(numList,3);
        System.out.println(lists);
    }
}

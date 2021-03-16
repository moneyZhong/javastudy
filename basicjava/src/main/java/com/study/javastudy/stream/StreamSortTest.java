package com.study.javastudy.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("2019-12","2020-01","2019-11","2020-12");
        List<String> collect = list.stream().sorted((m1, m2) -> {
            if (Integer.parseInt(m1.replace("-", "")) > Integer.parseInt(m2.replace("-", ""))) {
                return -1;
            } else if (Integer.parseInt(m1.replace("-", "")) < Integer.parseInt(m2.replace("-", ""))) {
                return 1;
            }
            return 0;
        }).limit(3).collect(Collectors.toList());
        System.out.println(collect);
    }
    @Test
    public void test1(){
        List<String> list = Arrays.asList("2019-12","2020-01","2019-11","2020-12");
        List<String> collect = list.stream().sorted(Comparator.comparing(String::toString).reversed()).limit(3).collect(Collectors.toList());
        System.out.println(collect);
    }


}

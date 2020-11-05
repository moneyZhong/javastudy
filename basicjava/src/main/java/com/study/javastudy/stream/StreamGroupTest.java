package com.study.javastudy.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupTest {
    List<User> list = Arrays.asList(new User(19, "张三", 60),
            new User(19, "张三", 60),
            new User(19, "张三", 60),
            new User(19, "张三", 60),
            new User(19, "张三", 60),
            new User(20, "张三1", 60),
            new User(20, "张三2", 60),
            new User(20, "张三3", 60)


    );

    @Test
    public void test01() {
        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(User::getAge, Collectors.counting()));
        System.out.println(collect);
        Map<Integer, List<User>> collect2 = list.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(collect2);
        List<Map.Entry<Integer, Long>> collect1 = list.stream().collect(Collectors.groupingBy(User::getAge, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 10).collect(Collectors.toList());
        System.out.println(collect1);


        Map<Integer, User> collect3 = list.stream().collect(Collectors.toMap(User::getAge, v -> v, (v1, v2) -> v1));
        System.out.println(collect3);
    }
}

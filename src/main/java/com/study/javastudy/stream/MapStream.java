package com.study.javastudy.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MapStream {
    public static void main(String[] args) {
        test06();

    }

    public static void test06(){
        List<User> userList = Arrays.asList(new User(20,"张三",50),new User(30,"钟钱",100));
        Optional<Integer> reduce = userList.stream().map(e -> e.getAge()).reduce((a, b) -> a + b);
        System.out.println(reduce.get());


    }

    public static void test05(){
        List<Integer> inList = Arrays.asList(3,9,1,10,5,2);
        Integer integer = inList.stream().reduce((a, b) -> {
            System.out.println("a="+a+",b="+b); return a + b;}).get();
        System.out.println(integer);

        Integer integer2 = inList.stream().reduce(0,(a, b) -> {
            System.out.println("a="+a+",b="+b); return a + b;});
        System.out.println(integer2);
    }


    public static void test04(){
        List<Integer> inList = Arrays.asList(3,9,1,10,5,2);
        List<Integer> collect = inList.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList());
        IntSummaryStatistics intSummaryStatistics = collect.stream().mapToInt((e) -> e).summaryStatistics();
        System.out.println(collect);
        System.out.println(intSummaryStatistics.getCount());
    }

    public static void test03(){
        List<Integer> inList = Arrays.asList(1,3,8,5,9,10);
        List<Integer> collect = inList.stream().map(e -> e * e).limit(3).collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void test02(){
        List<String> stringList = Arrays.asList("1","","2323","ff");
        List<String> collect = stringList.stream().filter(e -> !e.isEmpty()).collect(Collectors.toList());
        String collect1 = stringList.stream().filter(e -> !e.isEmpty()).collect(Collectors.joining());
        System.out.println(collect);
        System.out.println(collect1);
    }

    public static void test01(){
        String[] strings = {"abc","aaaaa","a"};
        Arrays.stream(strings).map(e -> e.length()).forEach(System.out::println);

        String[] abarray = {"a-b-c","bbb-bbaa"};
        Arrays.stream(abarray).flatMap(e -> Arrays.stream(e.split("-"))).map(e -> e.length()).forEach(System.out::println);

        Integer integer = Integer.valueOf("123");
        Integer integer2 = Integer.valueOf("123");
        System.out.println(integer == integer2);
        integer = Integer.valueOf("1234");
        System.out.println(integer2);
    }
}
@Data
@AllArgsConstructor
@ToString
class User{
    private int age;
    private String name;
    private int score;
}

package com.study.javastudy.guava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class OptionalTest {

    @Test
    public void test01(){
        String a = "";
        String b= "b";
        User user = new User();

        Integer or = com.google.common.base.Optional.fromNullable(user.getAge()).or(0);
        System.out.println(or);

        Integer integer = Optional.ofNullable(user.getAge()).orElse(0);
        System.out.println(integer);
//        String s = Optional.ofNullable(user.getAddress().getCity()).orElse(b);


//        System.out.println(s);
    }


    @Test
    public void test1(){
        Optional<Integer> integer = Optional.of(5);
        System.out.println(integer.get());
        System.out.println(integer.isPresent());

        Optional<Object> o1 = Optional.ofNullable(null);
        System.out.println(o1.isPresent());

        System.out.println(o1.get());

        Optional<Object> o = Optional.of(null);

    }






    /**
     * 将name 重复的年龄换成50
     */
    @Test
    public void test02(){
        List<User> users = Arrays.asList(
                new User("zhongqian", 31, "hubei"),
                new User("zhongqian2", 31, "hubei"),
                new User("zhongqian", 31, "hubei"),
                new User("zhongqian4", 31, "hubei"),
                new User("zhongqian3", 31, "hubei"),
                new User("zhongqian3", 31, "hubei"),
                new User("zhongqian3", 31, "hubei")
        );

        Map<String,User>  map = new HashMap<>();
        Collection<User> collect = users.stream().map(e -> {
            if (map.containsKey(e.getName())) {
                e.setAge(50);
                map.get(e.getName()).setAge(50);
            }
            map.put(e.getName(), e);
            return e;
        }).collect(Collectors.toList());
        System.out.println(collect);

    }
}
@NoArgsConstructor
@AllArgsConstructor
@Data
class User{
    private String name;
    private Integer age;
    private String address;
}

@Data
class Address{
    private String city;
    private String county;
}

package com.study.javastudy.stream;

import org.junit.Test;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunTest {


    @Test
    public void CalcuTest(){
        ICalculate calculate = (e)-> e*e;
        int sqrt = calculate.sqrt(5);
        System.out.println(sqrt);
    }


    @Test
    public void cusumerTest(){
        Consumer consumer1 = (e)->{
            System.out.println(e);
        };
        Consumer consumer2 = e-> System.out.println(e);

        Consumer consumer3 = System.out::println;
        consumer1.accept(5);
        consumer1.accept("aaaa");
        consumer1.accept(new Date());

        consumer1.andThen(consumer1).accept("hahaha");
    }

    @Test
    public void FunTest(){
        Function<Integer,Integer> fun1 = e -> e*e;
        Integer apply = fun1.apply(5);
        System.out.println(apply);
        Integer apply2 = fun1.andThen(fun1).apply(2);
        System.out.println(apply2);

        Function<Object, Object> identity = Function.identity();
        Object ahahha = identity.apply("ahahha");
        System.out.println(ahahha);
    }




}

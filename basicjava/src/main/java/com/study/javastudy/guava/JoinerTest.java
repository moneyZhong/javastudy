package com.study.javastudy.guava;

import cn.hutool.db.sql.SqlBuilder;
import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinerTest {

    private List<String> notNullStrings = Arrays.asList("张三","李四","王五");
    private List<String> withNullValueStrings = Arrays.asList("张三",null,"李四","王五",null);

    @Test
    public void test01(){
        System.out.println(Joiner.on(",").join(notNullStrings));
        System.out.println(notNullStrings.stream().collect(Collectors.joining(",")));
        System.out.println(String.join(",", notNullStrings));
    }

    @Test
    public void test02(){
        //空指针
//        System.out.println(Joiner.on(",").join(withNullValueStrings));
        //张三,null,李四,王五,null
        System.out.println(String.join(",", withNullValueStrings));

        //张三,李四,王五
        System.out.println(Joiner.on(",").skipNulls().join(withNullValueStrings));
        //张三,defualt,李四,王五,defualt
        System.out.println(Joiner.on(",").useForNull("defualt").join(withNullValueStrings));
        //张三,defualt,李四,王五,defualt
        System.out.println(withNullValueStrings.stream().map(this::defalut).collect(Collectors.joining(",")));
    }

    public String defalut(String s){
        return StringUtils.isEmpty(s)?"defualt":s;
    }

    @Test
    public void test03() throws IOException {
        StringBuffer sb = new StringBuffer("start:");
        System.out.println(Joiner.on(",").skipNulls().appendTo(sb, withNullValueStrings));

    }
}

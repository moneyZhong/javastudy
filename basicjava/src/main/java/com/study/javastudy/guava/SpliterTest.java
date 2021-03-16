package com.study.javastudy.guava;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.regex.Pattern;

public class SpliterTest {

    @Test
    public void test01(){
        List<String> strings = Splitter.on(",").splitToList("a,b,c");
        System.out.println(strings);

        List<String> strings1 = Splitter.on("|").splitToList("a|b|c");
        System.out.println(strings1);
        System.out.println(Splitter.on(Pattern.compile("\\|")).splitToList("a|b|c"));
    }

    @Test
    public void test02(){
        List<String> strings = Splitter.on(",").splitToList("a,,b,c,");
        System.out.println(strings);
        List<String> strings1 = Splitter.on(",").omitEmptyStrings().splitToList("a  ,,b,c,");
        System.out.println(strings1);

        List<String> strings2 = Splitter.on(",").omitEmptyStrings().trimResults().splitToList("a  ,,b,c,");
        System.out.println(strings2);

        List<String> strings3 = Splitter.on(",").omitEmptyStrings().trimResults().limit(2).splitToList("a  ,,b,c,");
        System.out.println(strings3);
    }
}

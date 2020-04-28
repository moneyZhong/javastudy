package com.study.javastudy.commonlang3;

import org.apache.commons.lang3.ArrayUtils;

import java.io.Serializable;

public class DoArrayUtils {
    public static void main(String[] args) {
        boolean[] bArray = ArrayUtils.add(ArrayUtils.EMPTY_BOOLEAN_ARRAY, true);
        System.out.println(ArrayUtils.toString(bArray));

        String[] strings = ArrayUtils.toArray("abc", "aaa", "123");
        String[] strings2 = {"abc,","hahaha"};

    }
}

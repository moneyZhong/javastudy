package com.study.javastudy.claszz;

import cn.hutool.core.util.ClassUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class ClassLoaderTest {
    Logger LOGGER = LoggerFactory.getLogger(ClassLoaderTest.class);
    @Test
    public void test01(){
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = null;
        String fileName = "abc.txt";
        Properties props = null;
        try {
            is = ClassUtil.getClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException(fileName + " file is not found");
            }
            props = new Properties();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            props.load(bf);

        } catch (IOException e) {
            LOGGER.error("load properties file failure", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close input stream failure", e);
                }
            }
        }
        System.out.println(props);
    }

    @Test
    public void test02() throws Exception{
        Class<?> aClass = Class.forName("com.study.javastudy.claszz.ClassTest");
        System.out.println(aClass.getSimpleName());
        System.out.println(toLowerFirstCase(aClass.getSimpleName()));
        System.out.println(aClass.getName());
    }

    private static String toLowerFirstCase(String simpleName) {
        char [] chars = simpleName.toCharArray();
        //之所以加，是因为大小写字母的ASCII码相差32，
        // 而且大写字母的ASCII码要小于小写字母的ASCII码
        //在Java中，对char做算学运算，实际上就是对ASCII码做算学运算
        chars[0] += 32;
        return String.valueOf(chars);
    }
}

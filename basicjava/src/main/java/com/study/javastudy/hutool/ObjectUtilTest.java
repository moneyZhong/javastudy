package com.study.javastudy.hutool;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ObjectUtilTest {
    public static void main(String[] args) {
        Clazz clazz = new Clazz();
        clazz.setClassName("一班");
        List<Student> list = new ArrayList<>();
        Student stu = new Student();
        stu.setName("张三");
        list.add(stu);
        clazz.setList(list);
        Clazz clazz2 = ObjectUtil.cloneByStream(clazz);
        System.out.println(clazz == clazz2);

        System.out.println(clazz2.getList().get(0).getName());

        clazz2.setClassName("二班");
        System.out.println(clazz.getClassName());

        System.out.println("232323".hashCode());

    }
}

@Data
class Clazz implements Serializable {
    private String className;
    private List<Student> list;
}
@Data
class Student implements  Serializable{
    private String name;
    private String address;
}



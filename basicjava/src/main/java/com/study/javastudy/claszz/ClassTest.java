package com.study.javastudy.claszz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ClassTest {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student = new Student();

        Class c1 = student1.getClass();
        Class c2 = student.getClass();
        System.out.println(student.getClass().hashCode());
        System.out.println(student1.getClass().hashCode());
        System.out.println(c1 == c2);

    }
}

class Student{}
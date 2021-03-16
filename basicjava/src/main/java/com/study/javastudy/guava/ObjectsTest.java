package com.study.javastudy.guava;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import lombok.Data;
import org.junit.Test;

public class ObjectsTest {
    @Test
    public void test01(){
        String a = new String("a");
        System.out.println(Objects.equal(null, null));
        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.equal("a", a));
    }

    @Test
    public void test02(){
        UserObjects userObjects = new UserObjects();
        UserObjects userObjects1 = new UserObjects();
        userObjects.equals(userObjects1);
        System.out.println(Objects.equal(userObjects, userObjects1));

        System.out.println(Objects.hashCode(userObjects));
        System.out.println(Objects.hashCode(userObjects1));
        System.out.println(userObjects.hashCode());
    }
}

@Data
class UserObjects implements Comparable<UserObjects>{
    private String name;
    private int age;

    @Override
    public int compareTo(UserObjects o) {
        return ComparisonChain.start().compare(this.getAge(),o.getAge())
                .compare(this.getName(),o.getAge())
                .result();
    }
}

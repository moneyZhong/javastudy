package com.study.javastudy.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
public class BasicTest {
    @Test
    public void baseTest01(){
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        group.addUser(new User());

        String jsonString = JSON.toJSONString(group, SerializerFeature.NotWriteDefaultValue);

        System.out.println(jsonString);
    }

}

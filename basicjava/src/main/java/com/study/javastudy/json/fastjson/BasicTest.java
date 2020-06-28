package com.study.javastudy.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.Date;

public class BasicTest {

    @Test
    public void baseTest02(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","zhongqian");
        jsonObject.put("birthday",new Date());
        String jsonStr = jsonObject.toJSONString();
        System.out.println(jsonObject.toJSONString());

        JSONObject.parseObject(jsonStr);
    }

    @Test
    public void baseTest01(){
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");


        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");
        guestUser.setDate(new Date());

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        group.addUser(new User());

        String jsonString = JSON.toJSONString(group);
        String jsonString1 = JSON.toJSONString(group, SerializerFeature.WriteMapNullValue);
        String jsonString11 = JSON.toJSONString(group, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
        String jsonString2 = JSON.toJSONString(group,SerializerFeature.WriteNullStringAsEmpty);
        String jsonString3 = JSON.toJSONString(group,  SerializerFeature.DisableCircularReferenceDetect);
        String jsonString4 = JSON.toJSONString(group,SerializerFeature.WriteNullListAsEmpty);
        String jsonString5 = JSON.toJSONString(group,SerializerFeature.WriteNonStringValueAsString);
        String jsonString6 = JSON.toJSONString(group,SerializerFeature.WriteNonStringKeyAsString);

        System.out.println(jsonString);
        System.out.println(jsonString1);
        System.out.println(jsonString11);
        System.out.println(jsonString2);
        System.out.println(jsonString3);
        System.out.println(jsonString4);
        System.out.println(jsonString5);
        System.out.println(jsonString6);
    }

}

package com.study.javastudy.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

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

    /**
     * 对象转json字符串
     */
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

    @Test
    public void test02(){
        JSONObject jsonObject = new JSONObject().fluentPut("sign", "123").fluentPut("data", "dataaaaa");
        System.out.println(jsonObject.toJSONString());
        Map<String,Object> map = Maps.newHashMap();
        map.put("busiObject",jsonObject);
        map.put("channel",null);
        System.out.println(JSON.toJSONString(map));
        Map<String,Object> map2 = Maps.newHashMap();
        map2.put("JsonParam",map);
        System.out.println(JSON.toJSONString(map2));

        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map2));
        JSONObject data = jsonObject1.getJSONObject("JsonParam");
        System.out.println(data.getJSONObject("busiObject").getString("data"));
    }

    /**
     * json字符串转对象
     */
    @Test
    public void test03(){
        String jsonStr = "{\"result\":{\"total\":1,\"items\":[{\"capital\":[{\"amomon\":\"1800万\",\"paymet\":\"\",\"time\":\"\",\"percent\":\"90.00%\"}],\"name\":\"迟文平\",\"capitalActl\":[],\"logo\":null,\"alias\":null,\"id\":2200654984,\"type\":2},{\"capital\":[{\"amomon\":\"200万\",\"paymet\":\"\",\"time\":\"\",\"percent\":\"10.00%\"}],\"name\":\"迟文华\",\"capitalActl\":[],\"logo\":null,\"alias\":null,\"id\":2200654984,\"type\":2}]},\"reason\":\"ok\",\"error_code\":0}";
        Map map = JSONObject.parseObject(jsonStr, Map.class, Feature.IgnoreNotMatch);
        System.out.println(map.get("reason"));
        System.out.println(map.get("result"));
    }

}

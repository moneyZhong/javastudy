package com.study.mybatisplus;

import com.google.common.collect.Maps;
import com.study.mybatisplus.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisXml {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        Map map =  Maps.newHashMap();
        map.put("name","1");
        map.put("id",10);
        List list = userMapper.selectByMaps(map);
        System.out.println(list);
    }
}

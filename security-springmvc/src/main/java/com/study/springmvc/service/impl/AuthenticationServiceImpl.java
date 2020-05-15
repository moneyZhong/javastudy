package com.study.springmvc.service.impl;

import com.study.springmvc.model.AuthVo;
import com.study.springmvc.model.UserDto;
import com.study.springmvc.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static Map<String,UserDto> cacheUser;

    static {
        cacheUser = new HashMap<>();

        Set<String> set1 = new HashSet<>();
        set1.add("p1");

        Set<String> set2 = new HashSet<>();
        set1.add("p2");

        cacheUser.put("zhangsan",new UserDto("zhangsan","123",set1));
        cacheUser.put("lisi",new UserDto("lisi","456",set2));
    }


    @Override
    public UserDto auth(AuthVo authVo) {
        if(StringUtils.isEmpty(authVo.getPassword()) || StringUtils.isEmpty(authVo.getUsername())){
            throw new RuntimeException("用户名或密码为空");
        }
        UserDto userDto = cacheUser.get(authVo.getUsername());
        if(userDto == null){
            throw new RuntimeException("用户名不存在");
        }
        if(!userDto.getPassword().equals(authVo.getPassword())){
            throw new RuntimeException("用户密码不正确!");
        }
        return userDto;
    }
}

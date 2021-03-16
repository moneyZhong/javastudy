package com.study.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.mybatisplus.dao.dataobject.User;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {
    List<User> selectByMaps(Map<String,Object> map);
}

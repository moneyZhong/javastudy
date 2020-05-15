package com.study.springmvc.service;

import com.study.springmvc.model.AuthVo;
import com.study.springmvc.model.UserDto;

public interface AuthenticationService {

    UserDto auth(AuthVo authVo);
}

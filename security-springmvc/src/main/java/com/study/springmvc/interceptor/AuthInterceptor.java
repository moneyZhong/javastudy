package com.study.springmvc.interceptor;

import com.study.springmvc.model.UserDto;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object attribute = request.getSession().getAttribute(UserDto.USER_SESSION_KEY);
        if(attribute == null){
            writeContent(response,"请登录");
            return false;
        }
        UserDto userDto = (UserDto) attribute;

        if(request.getRequestURI().contains("/r/r1") && userDto.getAuthories().contains("p1")){
            return true;
        }
        if(request.getRequestURI().contains("/r/r2") && userDto.getAuthories().contains("p2")){
            return true;
        }

        writeContent(response,"你没有权限");

        return false;
    }

    private void writeContent(HttpServletResponse response, String msg) throws  Exception{
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(msg);
        writer.close();
    }
}

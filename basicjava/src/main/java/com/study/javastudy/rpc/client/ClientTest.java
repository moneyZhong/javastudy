package com.study.javastudy.rpc.client;

import com.study.javastudy.rpc.server.User;
import com.study.javastudy.rpc.server.UserApi;

public class ClientTest {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(UserApi.class);
        UserApi instance = (UserApi)proxyFactory.getInstance();
        User user = instance.selectById(1);
        System.out.println(user);
    }
}

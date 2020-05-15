package com.study.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestBCrypt {

    @Test
    public void test(){
        String encode = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123");
        System.out.println(PasswordEncoderFactories.createDelegatingPasswordEncoder().matches("123",encode));
    }
}

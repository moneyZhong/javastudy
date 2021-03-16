package com.study.javastudy.guava;

import com.google.common.base.Preconditions;
import org.junit.Test;

public class PrecondtionTest {
    @Test
    public void test01(){
        //没理解这样做有和意义。 不加这个代码异常同样会往外跑异常
        Preconditions.checkArgument(false);

    }
}

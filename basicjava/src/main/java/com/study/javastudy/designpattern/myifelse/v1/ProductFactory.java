package com.study.javastudy.designpattern.myifelse.v1;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {
    private static Map<String,IProduct> map;
    static{
        map = new HashMap<>();
        map.put("A",new CreateAProduct());
        map.put("B",new CreateBProduct());
        map.put("C",new CreateCProduct());
    }

    public static IProduct getProduct(String type){
       return map.get(type);
    }
}

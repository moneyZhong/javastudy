package com.study.javastudy.designpattern.myifelse.v2;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ProductService {
    private static final List<IProduct> productList = new ArrayList<>();
    public static void addProduct(IProduct product){
        productList.add(product);
    }

    static {
        new CreateAProduct().addToList();
        new CreateBProduct().addToList();
        new CreateCProduct().addToList();
    }


    /**
     * 统一的执行入口
     * @param param
     */
    public static void createProduct(Param param){
        System.out.println("before invoke");
        List<IProduct> collect = productList.stream().filter(e -> e.chooseProduct(param)).collect(Collectors.toList());
        if(CollectionUtil.isEmpty(collect)){
            log.error("未匹配到对应产品");
            return ;
        }else{
            for(IProduct product : collect){
                product.createProduct(param);
            }
        }
        System.out.println("after invoke");

    }

    public static void main(String[] args) {
        Param param = new Param();
        param.setRuleEnum(RuleEnum.RULE_C);
        createProduct(param);
    }

}

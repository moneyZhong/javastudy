package com.study.javastudy.designpattern.myifelse.v2;


public class CreateCProduct extends IAbstractProduct {


    @Override
    public void createProduct(Param param) {
        System.out.println("create C product");
    }

    @Override
    public Boolean  chooseProduct(Param param) {
        return param.getRuleEnum().getCode().equals(RuleEnum.RULE_C.getCode());
    }
}

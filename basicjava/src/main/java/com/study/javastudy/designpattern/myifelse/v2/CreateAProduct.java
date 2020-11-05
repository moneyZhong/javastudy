package com.study.javastudy.designpattern.myifelse.v2;


public class CreateAProduct extends IAbstractProduct {

    @Override
    public void createProduct(Param param) {
        System.out.println("create a product");
    }

    @Override
    public Boolean chooseProduct(Param param) {
        return param.getRuleEnum().getCode().equals(RuleEnum.RULE_A.getCode());
    }
}

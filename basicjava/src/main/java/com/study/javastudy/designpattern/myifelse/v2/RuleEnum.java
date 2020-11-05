package com.study.javastudy.designpattern.myifelse.v2;

import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.C;

public enum RuleEnum {

    RULE_A("A","规则"),
    RULE_B("B","规则"),

    RULE_C("C","规则");


    private String code;
    private String msg;
    public String getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }

    RuleEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public static  RuleEnum getInstance(String code){
        if(StringUtils.isNoneEmpty(code)){
            for(RuleEnum ruleEnum : RuleEnum.values()){
                if(ruleEnum.getCode().equals(code)){
                    return ruleEnum;
                }
            }
        }
        return null;
    }

}

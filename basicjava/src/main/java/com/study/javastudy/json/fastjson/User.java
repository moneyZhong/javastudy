package com.study.javastudy.json.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
@Data
public class User {

    private Long   id;
    private String name;
    @JSONField(format="yyyy-MM-dd")
    private Date date;

}
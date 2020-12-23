package com.study.mybatisplus.dao.dataobject;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName(value = "user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String email;

    //@TableField(fill = FieldFill.INSERT)
   // private Date createTime;
    //@TableField(fill = FieldFill.UPDATE)
    //@TableField(fill = FieldFill.INSERT_UPDATE)
    //private Date updateTime;

    @Version
    private int version;

    /**
     * 逻辑删除
     */
    @TableLogic
    private String deleted;
}

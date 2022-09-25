package com.njust.var1.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("manager")
public class Manager {
    private String id;
    @TableField(select = false)
    private String password;
    private String workplace;
    private String phone;
    private String name;
    private String email;
    private String liveplace;
    private int workid;

}

package com.njust.var1.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("nurse")
public class Nurse {
    private String name;
    private String id;
    @TableField(select = false)
    private String password;
    private String workplace;
    @TableLogic
    private int deleted;
    private int workid;
    private int age;
    private String phone;

}

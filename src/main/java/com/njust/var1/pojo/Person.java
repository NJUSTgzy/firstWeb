package com.njust.var1.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Data
@TableName("person")
public class Person {
    private String job;
    private String id;
    private String name;
    private float tem;
    @TableField(select = false)
    private String password;
    private String phone;
    private String place;
    private int deleted;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp time;
    private int age;
    private String geliplace;

}
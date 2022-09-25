package com.njust.var1.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
@Data
@TableName("report")
public class Report {
    private String id;
    private String result;
    private float tem;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp time;
    private String health;
    private int deleted;
    private String collectplace;
    private String name;
    private String phone;
}
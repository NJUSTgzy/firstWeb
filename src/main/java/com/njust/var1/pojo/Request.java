package com.njust.var1.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@TableName("request")
public class Request {
    private String id;
    private Timestamp time;
    private String msg;
    private String title;
    @TableLogic
    private int deleted;
}

package com.njust.var1.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("workpalce")
public class Workplace {
    private String address;
    private float maxPeople;
    private float nowPeople;
    @TableLogic
    private int deleted;
}

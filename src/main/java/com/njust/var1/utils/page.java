package com.njust.var1.utils;

import lombok.Data;

import java.util.List;


@Data
public class page<T> {
    private int pagNum;// 当前的页数
    private int pageSize;// 每页显示数量，limit函数第二个参数
    private int totalRecord;// 总记录数
    private int totalPage;// 总页数
    private int startIndex;// 开始位置，limit函数第一个参数
    private List<T> dateList;
    private int start;
    private int end;

}

package com.njust.var1.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ReportTime {
    private String id;
    private String result;
    private float tem;
    private String time;
    private String health;
    private int deleted;

    public ReportTime(Report report){
        id=report.getId();
        result=report.getResult();
        tem=report.getTem();
        time=report.getTime().toString();
        health=report.getHealth();
        deleted=report.getDeleted();
    }

}
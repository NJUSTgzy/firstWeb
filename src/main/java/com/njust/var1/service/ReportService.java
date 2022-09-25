package com.njust.var1.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njust.var1.mapper.ReportMapper;
import com.njust.var1.pojo.Report;
import com.njust.var1.utils.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportService {

    @Autowired
    private ReportMapper reportDao;

    public Report findOne(String id){
        return reportDao.selectById(id);
    }


    public page<Report> findAll(int num, int pageCount){
        Page<Report> page = new Page<>(num,pageCount);
        IPage<Report> iPage = reportDao.selectPage(page,null);
        page<Report> res = new page<>();
        res.setDateList(iPage.getRecords());
        res.setTotalPage((int) iPage.getTotal()/5);
         return res;
    }

    @Transactional
    public boolean addReport(Report report){
        return reportDao.insert(report)==0 ?false:true;
    }

    public page<Report> findTodayReport(int num) {
        Page<Report> page = new Page<>(num,5);
        QueryWrapper<Report> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply(true, "TO_DAYS(NOW())-TO_DAYS(time) = 0");
        IPage<Report> iPage = reportDao.selectPage(page,queryWrapper);
        page<Report> res = new page<>();
        res.setDateList(iPage.getRecords());
        res.setTotalPage((int) iPage.getTotal()/5);
        return res;
    }

    public page<Report> findByid(String id){
        Page<Report> page = new Page<>(1,5);
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("id",id);
        IPage<Report> iPage = reportDao.selectPage(page,qw);
        page<Report> res = new page<>();
        res.setDateList(iPage.getRecords());
        res.setTotalPage((int) iPage.getTotal()/5);
        return res;
    }
}

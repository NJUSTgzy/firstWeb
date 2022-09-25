package com.njust.var1.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njust.var1.mapper.NurseMapper;
import com.njust.var1.mapper.RequestMapper;
import com.njust.var1.pojo.*;
import com.njust.var1.utils.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NurseService {

    @Autowired
    private NurseMapper nurseDao;

    @Autowired
    private ReportService reportService;

    @Autowired
    private RequestMapper requestDao;

    public boolean isUser(String id){
        return nurseDao.selectById(id)!=null ? true:false;
    }

    public boolean isRight(String id,String password){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("id",id);
        qw.eq("password",password);
        return nurseDao.selectOne(qw)!= null ? true:false;
        
    }

    public page<Report> findAllReport(int num){
        int PageCount=5;
        return reportService.findAll(num,PageCount);
    }


    public page<Request> findRequest(int num){
        int PageCount =5;
        Page<Request> page = new Page<>(num,PageCount);
        IPage<Request> iPage = requestDao.selectPage(page,null);
        page<Request> res = new page<>();
        res.setTotalPage((int) iPage.getTotal()/5);
        res.setDateList(iPage.getRecords());
        return res;
    }

    public page<Nurse> findAllNurse(int num){
        int PageCount=5;
        Page<Nurse> page = new Page<>(num,PageCount);
        IPage<Nurse> iPage = nurseDao.selectPage(page,null);
        page<Nurse> res = new page<>();
        res.setDateList(iPage.getRecords());
        res.setTotalPage((int) iPage.getTotal()/5);
        return res;
    }

    public page<Nurse> findEnrollNurse(int num){
        int PageCount = 5;
        IPage<Nurse> Page = new Page<>(num,PageCount);
        IPage<Nurse> iPage = nurseDao.getEnrollNurse(Page);
        page<Nurse> res = new page<>();
        res.setDateList(iPage.getRecords());
        res.setTotalPage((int) iPage.getTotal()/5);
        return res;
    }

    @Transactional
    public boolean enroll(Nurse nurse) {
        nurse.setDeleted(1);
        return nurseDao.insert(nurse) == 0 ?false:true;
    }

    public int addNurse(List<String> ids) {
        int count=0;
        for (String id: ids) {
            Nurse nurse = new Nurse();
            nurse.setId(id);
            nurse.setDeleted(0);
            nurseDao.updateById(nurse);
            count++;
        }
        return count;
    }



    public int delNurse(List<String> ids){
        return nurseDao.deleteBatchIds(ids);
    }


    public Nurse findNurse(String id) {
        return nurseDao.selectById(id);
    }

    public boolean updateNurse(Nurse nurse) {
        Nurse old = nurseDao.selectById(nurse.getId());
        old.setPhone(nurse.getPhone());
        old.setWorkplace(nurse.getWorkplace());
        return nurseDao.updateById(old)==1 ? true:false;
    }

    public page<Report> findTodayReport(int num) {
        return reportService.findTodayReport(num);
    }
    public page<Report> findReport(String id) {
        return reportService.findByid(id);
    }
}

package com.njust.var1.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njust.var1.mapper.ManagerMapper;
import com.njust.var1.pojo.*;
import com.njust.var1.utils.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerMapper managerDao;
    @Autowired
    private ReportService reportService;
    @Autowired
    private PersonService personService;
    @Autowired
    private NurseService nurseService;




    public boolean isUser(String id){
        return managerDao.selectById(id)==null ? false:true;
    }
    public boolean isRight(String id,String password){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("id",id);
        qw.eq("password",password);
        return managerDao.selectOne(qw)!= null ? true:false;
    }

    public page<Report> findAllReport(int num){
        int PageCount=5;
        return reportService.findAll(num,PageCount);
    }

    public boolean enroll(Manager manager){
        return managerDao.insert(manager)==0 ? false:true;
    }

    public page<Nurse> findAllNurse(int num){return nurseService.findAllNurse(num);}
    public page<Nurse> findEnrollNurse(int num){return nurseService.findEnrollNurse(num);}
    public page<Person> findAllPerson(int num){return personService.findAllPerson(num);}
    public page<Person> findEnrollPerson(int num){return personService.findEnrollPerson(num);}

    public int addNurse(List<String> ids) {
        return nurseService.addNurse(ids);
    }
    public int addPerson(List<String> ids) {
        return personService.addPerson(ids);
    }
    public int delNurse(List<String> ids){
        return nurseService.delNurse(ids);
    }

    public int delPerson(List<String> ids){
        return personService.delPerson(ids);
    }

    public Manager findManager(String id) {
        return managerDao.selectById(id);
    }

    public page<Person> findYang(int num,String y,String m,String d) {
        if((Integer.parseInt(m)<10)){
            m="0"+m;
        }
        if((Integer.parseInt(d)<10)){
            d="0"+d;
        }
        String date =y+"-"+m+"-"+d;
        return personService.findYang(num,date);
    }

    public boolean updateManager(Manager manager) {
        Manager old = managerDao.selectById(manager.getId());
        old.setPhone(manager.getPhone());
        old.setWorkplace(manager.getWorkplace());
        old.setEmail(manager.getEmail());
        old.setLiveplace(manager.getLiveplace());
        return managerDao.updateById(old)==1 ? true:false;
    }
}

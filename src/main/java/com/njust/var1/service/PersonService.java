package com.njust.var1.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njust.var1.mapper.PersonMapper;
import com.njust.var1.mapper.RequestMapper;
import com.njust.var1.pojo.*;
import com.njust.var1.utils.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonMapper personDao;
    @Autowired
    private ReportService reportService;

    @Autowired
    private RequestMapper requestDao;

    public boolean isUser(String id){
        return personDao.selectById(id)!=null ? true:false;
    }

    public boolean isRight(String id,String password){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("id",id);
        qw.eq("password",password);
        return personDao.selectOne(qw)!= null ? true:false;

    }

    public Report findOne(String id){
        return reportService.findOne(id);
    }

    public page<Person> findAllPerson(int num){
        int PageCount=5;
        Page<Person> page = new Page<>(num,PageCount);
        IPage<Person> iPage = personDao.selectPage(page,null);
        page<Person> res = new page<>();
        res.setTotalPage((int) iPage.getTotal()/5);
        res.setDateList(iPage.getRecords());
        return res;
    }

    public page<Person> findEnrollPerson(int num){
        int PageCount = 5;
        IPage<Person> Page = new Page<>(num,PageCount);
        IPage<Person> iPage = personDao.getEnrollPerson(Page);
        page<Person> res = new page<>();
        res.setDateList(iPage.getRecords());
        res.setTotalPage((int) iPage.getTotal()/5);
        return res;
    }

    public page<Person> findYang(int num,String date){
        int PageCount = 25;
        IPage<Person> Page = new Page<>(num,PageCount);
        IPage<Person> iPage = personDao.getYang(Page,date);
        System.out.println(iPage);
        page<Person> res = new page<>();
        res.setDateList(iPage.getRecords());
        res.setTotalPage((int) iPage.getTotal());
        return res;
    }

    @Transactional
    public boolean enroll(Person person) {
        person.setDeleted(1);
        return personDao.insert(person) == 0 ?false:true;
    }

    public int addPerson(List<String> ids) {
        int count=0;
        for (String id: ids) {
            Person person = new Person();
            person.setId(id);
            person.setDeleted(0);
            personDao.updateById(person);
            count++;
        }
        return count;
    }

    public int delPerson(List<String> ids){
        return personDao.deleteBatchIds(ids);
    }

    public boolean addRequest(String rq,String name){
        Request request = new Request();
        request.setMsg(rq);
        return  requestDao.insert(request)==1 ? true:false;

    }

    public Person findPerson(String id) {
        return personDao.selectById(id);
    }

    @Transactional
    public boolean addReport(Report report) {
        Timestamp createTime = new Timestamp(new Date().getTime());
        report.setTime(createTime);

        return reportService.addReport(report);
    }

    public boolean update(Person person) {
        Person old = personDao.selectById(person.getId());
        old.setPhone(person.getPhone());
        old.setJob(person.getJob());
        old.setPlace(person.getPlace());

        return personDao.updateById(old)==1 ? true:false;
    }
}

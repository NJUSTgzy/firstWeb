package com.njust.var1.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njust.var1.pojo.*;
import com.njust.var1.service.ManagerService;
import com.njust.var1.service.NoticeService;
import com.njust.var1.utils.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/login")
    public String Login(String username,String pwd){
        if (username == null  || pwd ==null){
            return "please input username and pwd";
        } else if (!managerService.isUser(username)){
            return "not user";
        }else if(managerService.isRight(username,pwd)){
            return "login succ";
        }else {
            return "pwd wrong!";
        }
    }


    @GetMapping("/find/allReport")
    public page<Report> findAllReport(int num){
        return managerService.findAllReport(num);
    }



    @PostMapping("/enroll")
    public boolean enroll(@RequestBody Manager manager){
        return managerService.enroll(manager);
    }


    @GetMapping("/delete/notice")
    public boolean deleteNotice(int id){
        return noticeService.deleteNotice(id);
    }

    @PostMapping("/add/notice")
    public boolean uploadNotice(@RequestBody Notice notice){
        return noticeService.uploadNotice(notice);
    }

    @GetMapping("/enroll/nurse")
    public page<Nurse> showEnrollNurse(int num){
        return managerService.findEnrollNurse(num);
    }

    @GetMapping("/enroll/person")
    public page<Person> showEnrollPerson(int num){

        return managerService.findEnrollPerson(num);
    }

    @GetMapping("/find/allNurse")
    public page<Nurse> showAllNurse(int num){
        return managerService.findAllNurse(num);
    }

    @GetMapping("/find/allPerson")
    public page<Person> showAllPerson(int num){
        return managerService.findAllPerson(num);
    }

    @PostMapping("/add/nurse")
    public int addNurse(@RequestBody List<String> ids){

        return managerService.addNurse(ids);
    }

    @PostMapping("/add/person")
    public int addPerson(@RequestBody List<String> ids){
        return managerService.addPerson(ids);
    }

    @PostMapping("/delete/nurse")
    public int delNurse(@RequestBody List<String> ids){
        return managerService.delNurse(ids);
    }
    @PostMapping("/delete/person")
    public int delPerson(@RequestBody List<String> ids){
        return managerService.delPerson(ids);
    }


    @GetMapping("/find/self")
    public Manager findSelf(String id){
        return managerService.findManager(id);
    }

    @GetMapping("/find/yang")
    public page<Person> findYang(String y,String m,String d){return managerService.findYang(1,y,m,d);}

    @PostMapping("/update")
    public boolean update(@RequestBody Manager manager){
        return managerService.updateManager(manager);
    }
}

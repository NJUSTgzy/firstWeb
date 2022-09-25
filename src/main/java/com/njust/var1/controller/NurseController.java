package com.njust.var1.controller;

import com.njust.var1.pojo.Notice;
import com.njust.var1.pojo.Nurse;
import com.njust.var1.pojo.Report;
import com.njust.var1.pojo.Request;
import com.njust.var1.service.NoticeService;
import com.njust.var1.utils.page;
import com.njust.var1.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/nurse")
public class NurseController {
    @Autowired
    private NurseService nurseService;

    @GetMapping("/login")
    public String Login(String username,String pwd){
        if (!nurseService.isUser(username)){
            return "not user";
        }else if(nurseService.isRight(username,pwd)){
            return "login succ";
        }else {
            return "pwd wrong!";
        }
    }

    @Autowired
    private NoticeService noticeService;


    @GetMapping("/find/notice")
    public page<Notice> findNotice(int num){
        return noticeService.showNotice(num);
    }

    @GetMapping("/find/allReport")
    public page<Report> findAllReport(int num){
        return nurseService.findAllReport(num);
    }


    @PostMapping("/enroll")
    public boolean enroll(@RequestBody Nurse nurse){
        return nurseService.enroll(nurse);
    }

    @GetMapping("/find/request")
    public page<Request> findRequest(int num){
        return nurseService.findRequest(num);
    }

    @GetMapping("/find/self")
    public Nurse findSelf(String id){
        return nurseService.findNurse(id);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Nurse nurse){
        return nurseService.updateNurse(nurse);
    }

    @GetMapping("/find/todayReport")
    public page<Report> findTodayReport(int num){
        return nurseService.findTodayReport(num);
    }

    @GetMapping("/find/report")
    public page<Report> find(String id){
        return nurseService.findReport(id);
    }
}

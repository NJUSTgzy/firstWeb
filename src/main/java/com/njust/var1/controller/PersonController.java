package com.njust.var1.controller;

import com.njust.var1.pojo.Notice;
import com.njust.var1.pojo.Nurse;
import com.njust.var1.pojo.Person;
import com.njust.var1.pojo.Report;
import com.njust.var1.service.NoticeService;
import com.njust.var1.service.PersonService;
import com.njust.var1.utils.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {


    @Autowired
    private PersonService personService;

    @Autowired
    private NoticeService noticeService;


    @GetMapping("/find/notice")
    public page<Notice> findNotice(int num){
        return noticeService.showNotice(num);
    }

    @GetMapping("/login")
    public String Login(String username,String pwd){
        if (!personService.isUser(username)){
            return "not user";
        }else if(personService.isRight(username,pwd)){
            return "login succ";
        }else {
            return "pwd wrong!";
        }
    }


    @GetMapping("/find/allReport")
    public Report findOne(String id){
        return personService.findOne(id);
    }


    @PostMapping("/enroll")
    public boolean enroll(@RequestBody Person person){
        return personService.enroll(person);
    }


    @PostMapping("/add/request")
    public boolean addRequest(String text, HttpSession session){
        return personService.addRequest(text,session.getId());
    }

    @GetMapping("/find/self")
    public Person findSelf(String id){
        return personService.findPerson(id);
    }

    @PostMapping("/add/msg")
    public boolean addReport(@RequestBody  Report report){
        return personService.addReport(report);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Person person){
        return personService.update(person);
    }

}

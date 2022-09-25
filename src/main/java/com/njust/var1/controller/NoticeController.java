package com.njust.var1.controller;

import com.njust.var1.pojo.Notice;
import com.njust.var1.service.NoticeService;
import com.njust.var1.utils.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/showNotice")
    public page<Notice> showNotice(@RequestBody int num){
        return noticeService.showNotice(num);
    }


}

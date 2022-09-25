package com.njust.var1.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njust.var1.mapper.NoticeMapper;
import com.njust.var1.pojo.Notice;
import com.njust.var1.pojo.Nurse;
import com.njust.var1.utils.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeDao;

    @Transactional
    public boolean uploadNotice(Notice notice){
        Timestamp createTime = new Timestamp(new Date().getTime());
        notice.setTime(createTime);

        return noticeDao.insert(notice)==0 ? false:true;
    }


    public boolean deleteNotice(int id){

        return noticeDao.deleteById(id) ==0 ? false:true;
    }

    public page<Notice> showNotice(int num) {
        int PageCount=5;
        Page<Notice> page = new Page<>(num,PageCount);
        IPage<Notice> iPage = noticeDao.selectPage(page,null);
        page<Notice> res = new page<>();
        res.setDateList(iPage.getRecords());
        res.setTotalPage((int) iPage.getTotal()/5);
        return res;
    }
}

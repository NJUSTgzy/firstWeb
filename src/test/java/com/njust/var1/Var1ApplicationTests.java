package com.njust.var1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.njust.var1.mapper.NurseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Var1ApplicationTests {

    @Autowired
    private NurseMapper nurseDao;

    @Test
    void contextLoads() {
        IPage page = new Page(1,5);
        nurseDao.selectPage(page,null);
        System.out.println("total"+page.getTotal());
        System.out.println("data"+page.getRecords());
    }

}

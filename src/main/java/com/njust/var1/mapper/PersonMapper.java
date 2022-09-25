package com.njust.var1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.njust.var1.pojo.Nurse;
import com.njust.var1.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {

    @Select("select * from person "
            +   "WHERE deleted=1")
    public IPage<Person> getEnrollPerson(IPage<Person> notes);

    @Select("select * from person where id in (select id from report where DATE_FORMAT(time,'%Y-%m-%d')=#{date} and result = '阳')")
    public IPage<Person> getYang(IPage<Person> notes,String date);
}

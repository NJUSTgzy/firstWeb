package com.njust.var1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.njust.var1.pojo.Nurse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NurseMapper extends BaseMapper<Nurse> {

    @Select("select * from nurse "
        +   "WHERE deleted=1")
    public IPage<Nurse> getEnrollNurse(IPage<Nurse> notes);

}

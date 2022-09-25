package com.njust.var1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.njust.var1.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerDao extends BaseMapper<Manager> {
}

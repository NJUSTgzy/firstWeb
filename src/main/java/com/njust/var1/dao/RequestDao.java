package com.njust.var1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.njust.var1.pojo.Request;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequestDao extends BaseMapper<Request> {
}

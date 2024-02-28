package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Bustatus;

public interface BustatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bustatus record);

    int insertSelective(Bustatus record);

    Bustatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bustatus record);

    int updateByPrimaryKey(Bustatus record);
}
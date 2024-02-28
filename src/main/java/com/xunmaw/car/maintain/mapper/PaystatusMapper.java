package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Paystatus;

public interface PaystatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Paystatus record);

    int insertSelective(Paystatus record);

    Paystatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Paystatus record);

    int updateByPrimaryKey(Paystatus record);
}
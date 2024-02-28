package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Consumsettle;

public interface ConsumsettleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Consumsettle record);

    int insertSelective(Consumsettle record);

    Consumsettle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Consumsettle record);

    int updateByPrimaryKey(Consumsettle record);
}
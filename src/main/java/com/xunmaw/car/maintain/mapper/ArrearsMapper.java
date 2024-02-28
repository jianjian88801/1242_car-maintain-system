package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Arrears;

public interface ArrearsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Arrears record);

    int insertSelective(Arrears record);

    Arrears selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Arrears record);

    int updateByPrimaryKey(Arrears record);
}
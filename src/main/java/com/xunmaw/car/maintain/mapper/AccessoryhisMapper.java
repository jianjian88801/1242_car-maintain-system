package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Accessoryhis;

public interface AccessoryhisMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Accessoryhis record);

    int insertSelective(Accessoryhis record);

    Accessoryhis selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Accessoryhis record);

    int updateByPrimaryKey(Accessoryhis record);
}
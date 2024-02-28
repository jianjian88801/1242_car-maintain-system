package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Projcategory;

import java.util.List;

public interface ProjcategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Projcategory record);

    int insertSelective(Projcategory record);

    Projcategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Projcategory record);

    int updateByPrimaryKey(Projcategory record);
    
    List<Projcategory> selectAll();
    
    List<Projcategory> selectAllCategory();
}
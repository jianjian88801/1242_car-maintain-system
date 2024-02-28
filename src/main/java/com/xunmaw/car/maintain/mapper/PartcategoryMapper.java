package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Partcategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartcategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Partcategory record);

    int insertSelective(Partcategory record);

    Partcategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Partcategory record);

    int updateByPrimaryKey(Partcategory record);
    
    /**
     * 查询所有的零件的类别
     * @param status
     * @return
     */
    List<Partcategory> selectAllPartCategory(@Param("status") String status);
}
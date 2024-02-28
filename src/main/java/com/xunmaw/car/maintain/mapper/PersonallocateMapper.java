package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Personallocate;

public interface PersonallocateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Personallocate record);

    int insertSelective(Personallocate record);

    Personallocate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Personallocate record);

    int updateByPrimaryKey(Personallocate record);
}
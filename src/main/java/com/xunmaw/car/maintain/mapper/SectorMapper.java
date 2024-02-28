package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Sector;

import java.util.List;

public interface SectorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sector record);

    int insertSelective(Sector record);

    Sector selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sector record);

    int updateByPrimaryKey(Sector record);
    
    /**
     * 查询所有的部门
     * @return
     */
    List<Sector> selectAllSector();
}
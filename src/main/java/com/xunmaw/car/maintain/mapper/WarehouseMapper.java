package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Warehouse;
import com.xunmaw.car.maintain.views.PartStorageView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);
    
    /**
     * 查询
     * @param keyword
     * @return
     */
    List<PartStorageView> selectPartStorage(@Param("key") String keyword);
    
    /**
     * 查询所有的仓库信息
     * @param status
     * @return
     */
    List<Warehouse> selectAllWarehouse(@Param("status") String status);
}
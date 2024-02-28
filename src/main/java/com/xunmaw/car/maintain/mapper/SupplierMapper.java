package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
    
    
    List<Supplier> selectAllSupplier(
    		@Param("key") String key,
    		@Param("sort") String sort,
    		@Param("order") String order,
    		@Param("flag") String flag);
}
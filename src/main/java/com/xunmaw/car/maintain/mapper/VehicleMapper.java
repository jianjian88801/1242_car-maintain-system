package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Vehicle;
import com.xunmaw.car.maintain.views.CustomerVehicle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VehicleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Vehicle record);

    int insertSelective(Vehicle record);

    Vehicle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Vehicle record);

    int updateByPrimaryKey(Vehicle record);
    
    List<CustomerVehicle> selectVehicleByKey(@Param("keyworld") String keyworld);
    
}
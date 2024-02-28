package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Customer;
import com.xunmaw.car.maintain.views.CustomerView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    List<Customer> selectCustomerByKey(@Param("keyworld") String keyworld);
    
    List<CustomerView> selectCustomer(
    		@Param("key") String key,
    		@Param("sort") String sort,
    		@Param("order") String order);
}
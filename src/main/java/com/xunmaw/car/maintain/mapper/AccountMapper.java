package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Account;
import com.xunmaw.car.maintain.views.LoginBean;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
    LoginBean selectcount(Account account);
    
    Account selectByAccountNum(@Param("accountnumber") String accountnumber);
}
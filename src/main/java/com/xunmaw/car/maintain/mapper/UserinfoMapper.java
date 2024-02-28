package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Userinfo;
import com.xunmaw.car.maintain.views.UserSector;
import com.xunmaw.car.maintain.views.UserView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
    
    List<UserSector> selectAllUserByDep();
    
    /**
     * 查询所有的用户
     * @param status
     * @return
     */
    List<UserView> selectAllUsers(@Param("status") String status, @Param("key") String key);
    
    /**
     * 删除用户
     * @param userinfoid
     * @return
     */
    int modifyUser(@Param("userinfoid") String userinfoid, @Param("userflag") String userflag);
    
    /**
     * 删除所有用户的权限
     * @param accountid
     * @return
     */
    int delUserRights(@Param("accountid") String accountid);
}
package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Permission;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    /**
     * 获取所有的大类
     */
    List<String> getAllPermissonCategory();
    
    /**
     * 获取用户所有的权限
     */
    List<Permission> getAllUserPermission(String accountnumber);
    
    /**
     * 查询
     * @param permission
     * @return
     */
    List<Permission> selectAllPermission();
    
    /**
     * 查询所有有效的权限
     * @return
     */
    List<Permission> selectAllPermissions();
    
}
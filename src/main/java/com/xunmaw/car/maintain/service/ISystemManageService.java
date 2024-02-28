package com.xunmaw.car.maintain.service;

import com.xunmaw.car.maintain.entity.Permission;
import com.xunmaw.car.maintain.entity.Sector;
import com.xunmaw.car.maintain.utils.PagedResult;
import com.xunmaw.car.maintain.views.UserView;

import java.util.List;

/**
 * 系统管理
 *
 * @author desenyang tz
 *
 */
public interface ISystemManageService {

	/**
	 * 查询所有的用户
	 *
	 * @param pageNo
	 * @param pageSize
	 * @param status
	 * @return
	 */
	PagedResult<UserView> queryAllUser(Integer pageNo, Integer pageSize, String status, String key);
	
	/**
	 * 修改用户信息(添加，修改，删除)
	 * @param userinfo		用户的信息
	 * @param type			用户的类型
	 * @return				返回用户的信息
	 */
	boolean modifyUser(UserView userView, int[] privileges, String type);
	
	/**
	 * 查询系统中所有的权限（有效权限）
	 * @return
	 */
	List<Permission> queryAllPermission();

	List<Permission> queryAllComment();

	/**
	 * 查询所有的部门
	 * @return
	 */
	List<Sector> queryAllSectors();
	
	
	/**
	 * 查询所有用户的权限
	 * @param accountnumber
	 * @return
	 */
	List<Permission> queryAllUserPer(String accountnumber);
	
	
	/**
	 * 修改密码
	 * @param password
	 * @return
	 */
	boolean modifyPass(String password, String accountnumber);
}



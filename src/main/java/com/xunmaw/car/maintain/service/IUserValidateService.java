package com.xunmaw.car.maintain.service;


import com.xunmaw.car.maintain.entity.Account;
import com.xunmaw.car.maintain.views.LoginBean;
import com.xunmaw.car.maintain.views.AccrodingPanel;

/**
 * 用户的验证接口
 * @author cp
 *
 */
public interface IUserValidateService {
	
	/**
	 * 用户消息是否合法
	 * @param account
	 * @return
	 */
	LoginBean userislawable(Account account);
	
	/**
	 * 查询用户所有的权限
	 * @param account
	 * @return
	 */
	AccrodingPanel queryUserPrivleges(Account account);
}

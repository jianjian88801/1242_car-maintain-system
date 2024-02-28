package com.xunmaw.car.maintain.utils;

import com.xunmaw.car.maintain.views.LoginBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * web的工具类
 * @author cp
 *
 */
public class MyWebUtils {
	private static final Logger logger = LoggerFactory.getLogger(MyWebUtils.class);
	
	/**
	 * 获取用户的对象
	 * @param request		request对象
	 * @return				返回用户的实例
	 */
	public static LoginBean getCurrentUser(HttpServletRequest request){
		LoginBean loginBean = null;
		try {
			loginBean = (LoginBean) request.getSession().getAttribute("user");
		} catch (Exception e) {
			logger.error(MyErrorPrinter.getErrorStack(e));
		}
		return loginBean;
	}
}

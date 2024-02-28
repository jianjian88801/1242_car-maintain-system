package com.xunmaw.car.maintain.controller;

import com.xunmaw.car.maintain.entity.Account;
import com.xunmaw.car.maintain.service.impl.ServiceFactory;
import com.xunmaw.car.maintain.utils.HttpConstants;
import com.xunmaw.car.maintain.utils.JsonDateValueProcessor;
import com.xunmaw.car.maintain.views.LoginBean;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@Controller
@Scope("prototype")
@RequestMapping("index")
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Resource
	private ServiceFactory serviceFactory;
	
	@RequestMapping("/main")
	public String index(HttpServletRequest request){
		LoginBean loginBean = (LoginBean) request.getSession().getAttribute("user");
		request.setAttribute("loginbean", loginBean);

		if(loginBean == null) {
			return "login";
		}
		// 下面是返回用户的权限：
		Account account = new Account();
		account.setAccountnumber(loginBean.getAccountnumber());
		request.setAttribute("allprivilege", serviceFactory.getUserValidateService().queryUserPrivleges(account));
		return "main";
	}

	@RequestMapping("/allprivilege")
	@ResponseBody
	public String allprivilege(HttpServletRequest request) {
		LoginBean loginBean = (LoginBean) request.getSession().getAttribute("user");
		request.setAttribute("loginbean", loginBean);

		if(loginBean == null) {
			return "login";
		}
		Account account = new Account();
		account.setAccountnumber(loginBean.getAccountnumber());
//		request.setAttribute("allprivilege", serviceFactory.getUserValidateService().queryUserPrivleges(account));

		return responseSuccess( serviceFactory.getUserValidateService().queryUserPrivleges(account));
	}

	@RequestMapping("/dis")
	public void dispatcher(HttpServletRequest request,HttpServletResponse response,@RequestParam("url") String url){
		try {
			logger.info("dispatcher:"+url);
			request.getRequestDispatcher("/WEB-INF/views"+url).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询所有的用户
	 *
	 * @return
	 */
	@RequestMapping("/queryUser")
	@ResponseBody
	public String queryUser() {
		return responseSuccess(serviceFactory.getBaseDataManageService().queryAllUser());
	}

	public String responseSuccess(Object obj){
		JSONObject jsonObj = new JSONObject();
		if(obj != null){
			logger.info("后端返回对象：{}", obj);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			jsonObj = JSONObject.fromObject(obj, jsonConfig);
			logger.info("后端返回数据：" + jsonObj);
			jsonObj.element(HttpConstants.RESPONSE_RESULT_FLAG_ISERROR, false);
			jsonObj.element(HttpConstants.SERVICE_RESPONSE_RESULT_MSG, "");
		}
		logger.info("输出结果：{}", jsonObj.toString());
		return jsonObj.toString();
	}

}

package com.xunmaw.car.maintain.service.impl;

import com.github.pagehelper.PageHelper;
import com.xunmaw.car.maintain.mapper.DaoFactory;
import com.xunmaw.car.maintain.entity.Partproc;
import com.xunmaw.car.maintain.service.IFinancialManagementService;
import com.xunmaw.car.maintain.utils.BeanUtil;
import com.xunmaw.car.maintain.utils.PagedResult;
import com.xunmaw.car.maintain.views.SettleOrderView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 财务管理的接口
 * @author desenyang tz
 *
 */
@Service
public class FinancialManagementService implements IFinancialManagementService{
	
	private static final Logger logger = LoggerFactory.getLogger(FinancialManagementService.class);
	
	@Resource
	private DaoFactory daoFactory;

	/**
	 * 分页查询所有的已经支付过的订单
	 */
	@Override
	public PagedResult<SettleOrderView> queryallSettled(String starttime, String endtime, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 0 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.topagedResult(daoFactory.getOrdersMapper().selectSettledOrders(starttime, endtime));
	}

	/**
	 * 查询所有的采购的订单
	 */
	@Override
	public PagedResult<Partproc> queryAllPartProc(String starttime, String endtime, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 0 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.topagedResult(daoFactory.getPartprocMapper().selectProced(starttime, endtime));
	}

	
	/**
	 * 接单统计
	 */
	@Override
	public Map<String, String> jiedantongji(String year) {
		return daoFactory.getOrdersMapper().jiedantongji(year);
	}

	/**
	 * 销售统计
	 */
	@Override
	public Map<String, String> xiaoshouetongji(String year) {
		return daoFactory.getOrdersMapper().xiaoshouetongji(year);
	}

	/**
	 * 采购金额统计
	 */
	@Override
	public Map<String, String> caigoujinetongji(String year) {
		return daoFactory.getOrdersMapper().caigoujinetongji(year);
	}

	/**
	 * 占比统计
	 */
	@Override
	public String[] zhanbitongji(String year) {
		return daoFactory.getOrdersMapper().zhanbitongji(year);
	}
	
}

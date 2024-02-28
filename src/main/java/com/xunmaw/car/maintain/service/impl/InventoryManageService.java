package com.xunmaw.car.maintain.service.impl;

import com.github.pagehelper.PageHelper;
import com.xunmaw.car.maintain.mapper.DaoFactory;
import com.xunmaw.car.maintain.entity.Part;
import com.xunmaw.car.maintain.entity.Partproc;
import com.xunmaw.car.maintain.service.IInventoryManageService;
import com.xunmaw.car.maintain.utils.BeanUtil;
import com.xunmaw.car.maintain.utils.MyErrorPrinter;
import com.xunmaw.car.maintain.utils.PagedResult;
import com.xunmaw.car.maintain.utils.StringUtils;
import com.xunmaw.car.maintain.views.LoginBean;
import com.xunmaw.car.maintain.views.PartProcView;
import com.xunmaw.car.maintain.views.PartStorageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 库存管理
 * @author cp
 *
 */
@Service
public class InventoryManageService implements IInventoryManageService {

	private static final Logger logger = LoggerFactory.getLogger(InventoryManageService.class);

	@Resource
	private DaoFactory daoFactory;
	
	/**
	 * 分页查采购的分页信息
	 */
	@Override
	public PagedResult<PartProcView> queryPagedPartProc(String keyworld, String purchstatus, String starttime,
                                                        String endtime, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.topagedResult(daoFactory.getPartprocMapper().selectPartProc(keyworld, purchstatus, starttime, endtime));
	 
	}

	/**
	 * 查询所有的采购的信息
	 */
	@Override
	public List<PartProcView> queryAllPartProc(String purchstatus, String starttime, String endtime) {
		List<PartProcView> partProcViews = null;
		partProcViews = daoFactory.getPartprocMapper().selectPartProc(null, purchstatus, starttime, endtime);
		return partProcViews;
	}

	
	/**
	 * 采购零件
	 * 1.更新零件表
	 * 2.更新存储
	 * 3.添加购买记录
	 */
	@Transactional
	@Override
	public boolean partProcing(String partid, String partprocid, LoginBean user, double price, double num) {
		boolean flag = false;
		Part part = daoFactory.getPartMapper().selectByPrimaryKey(StringUtils.getIntegerValue(partid, -1));
		if(part!=null){
			try {
				// 设置价格
				part.setPurchaseprice(price);
				daoFactory.getPartMapper().updateByPrimaryKeySelective(part);
				// 更新存储
				daoFactory.getPartstorageMapper().updateStorage(num, partid);
				// 添加使用记录
				Partproc partproc = daoFactory.getPartprocMapper().selectByPrimaryKey(StringUtils.getIntegerValue(partprocid, -1));
				if(partproc!=null){
					partproc.setPrucher(user.getUsername());
					partproc.setPruchdemand(num);
					partproc.setPruchernum(user.getUserinfoid());
					partproc.setPruchprice(price);
					partproc.setTotalpurchase(num*price);
					partproc.setPurchstatus("1");
					daoFactory.getPartprocMapper().updateByPrimaryKeySelective(partproc);
					flag = true;
				}
			} catch (Exception e) {
				logger.info(MyErrorPrinter.getErrorStack(e));
			}
		}
		return flag;
	}

	
	/**
	 * 查询所有的存储的表
	 */
	@Override
	public PagedResult<PartStorageView> queryAllPartStorage(String keyworld, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.topagedResult(daoFactory.getWarehouseMapper().selectPartStorage(keyworld));
	}

	/**
	 * 修改销售价格
	 */
	@Override
	public boolean modifyPrice(Integer partid, double price) {
		boolean flag = false;
		Part part = daoFactory.getPartMapper().selectByPrimaryKey(partid);
		if(part!=null){
			part.setSalesprice(price);
			flag = daoFactory.getPartMapper().updateByPrimaryKeySelective(part)>0;
		}
		return flag;
	}

}

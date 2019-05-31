package cn.dingd.dd.management.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.dao.ManageStockDao;
import cn.dingd.dd.management.service.ManageStockService;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年11月27日 下午3:56:44 类说明
 * 管理端车辆管理
 */
@Service
public class ManageStockServiceImpl implements ManageStockService {
	@Resource
	private ManageStockDao manageStockDao;
	@Resource
	private CommonService commonService;
	/** 管理端-拍卖管理-库存车辆查询 */
	@Override
	public Map<String, Object> FindStock(CheckQueryEntity checkQueryEntity, PageObject pageObject) {
		// 2017年12月11日TODO 
		Map<String, Object> map =new HashMap<>();
		//查询条目数
		int i=manageStockDao.getFindStockRowCount(checkQueryEntity);
		//更新条目数
		pageObject.setRowCount(i);
		//添加流拍次数
		List<Map> listMap=manageStockDao.FindStock(checkQueryEntity, pageObject);
		//查询流拍次数
		Map<Object,Object> sunCar=commonService.statisticalCars();
		for(Map myMap:listMap) {
			myMap.put("sunCars", sunCar.get(myMap.get("tid")));
		}
		//添加库存车辆
		map.put("list",listMap);
		//添加分页信息
		map.put("pageObject", pageObject);
		return map;
	}
}

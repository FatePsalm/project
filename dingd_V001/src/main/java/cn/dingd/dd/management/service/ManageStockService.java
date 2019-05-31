package cn.dingd.dd.management.service;

import java.util.Map;

import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.web.PageObject;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 下午12:21:36
* 类说明
* 管理端车辆管理
*/
public interface ManageStockService {
	/** 管理端-拍卖管理-库存车辆查询 */
	public Map<String, Object> FindStock(CheckQueryEntity checkQueryEntity, PageObject pageObject);
}

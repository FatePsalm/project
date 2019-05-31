package cn.dingd.dd.management.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.web.PageObject;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年10月17日 上午11:04:50 类说明 
 * 管理端车辆管理
 */
public interface ManageStockDao {
	/** 管理端-拍卖管理-库存车辆查询 */
	public List<Map> FindStock(@Param("checkQueryEntity")CheckQueryEntity checkQueryEntity,@Param("pageObject") PageObject pageObject);
	/** 管理端-拍卖管理-库存车辆查询-查询条目数*/
	public int getFindStockRowCount(@Param("checkQueryEntity")CheckQueryEntity checkQueryEntity);
}

package cn.dingd.dd.management.service;

import java.util.List;
import java.util.Map;

import cn.dingd.dd.common.entity.SecondKillBill;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;

/**
 * @author zoucong
 * 2018年1月16日上午11:23:33
 * 管理端-秒杀接口
 */
public interface ManageSeckillingService {

	/**拍卖-发布管理-秒杀-查询当日所有秒杀车辆*/
	List<Map> getAllSeckillCars();
	
	/**拍卖-发布管理-秒杀-添加秒杀车辆*/
	void addSeckillCars(List<SecondKillBill> slist);

	/**拍卖-发布管理-秒杀-查询库存车辆列表*/
	List<Map> FindCars();
	
	/**修改服务费*/
	String updateServerMoney(Integer carId,Integer serverMoney);
	
	/**修改车价*/
	String updateCarMoney(Integer carId, Float carMoney);

	/**根据车牌号搜索车辆*/
	List<Map> findCarByCarNum(String carNum);
	
	/**获取库存中最后一辆车的开拍时间*/
	Long getLastCarStartTime();

}

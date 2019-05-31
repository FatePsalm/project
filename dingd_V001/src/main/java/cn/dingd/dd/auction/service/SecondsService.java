package cn.dingd.dd.auction.service;

import java.util.List;
import java.util.Map;

import cn.dingd.dd.common.entity.SecondKillBill;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年1月16日 上午10:49:31 类说明 拍卖-秒杀
 */
public interface SecondsService {
	/** 拍卖-秒杀-获取当前系统时间 */
	public Long getCurrentTime();
	/** 拍卖-秒杀-根据车辆id查找详细 */
	public SecondKillBill findCarId(Integer carId) ;
	/** 拍卖-秒杀-秒杀开始修改车辆状态 
	 * @return */
	public void updateCarState(Integer carId,Integer carState);
	/** 拍卖-秒杀-秒杀中 */
	public int carSeconds(Integer carId,Integer userId)throws Exception;
	/** 拍卖-秒杀-查询车辆详细 */
	public Map<String, Object> findCarInfo(Integer carId)throws Exception;
	/** 拍卖-秒杀-获取车辆列表 */
	public List<Map<String, Object>> SecondsList();
}

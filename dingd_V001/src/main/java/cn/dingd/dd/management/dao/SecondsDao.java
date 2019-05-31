package cn.dingd.dd.management.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.SecondKillBill;
import cn.dingd.dd.common.view.TCarBasisInfoEntity;


/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年1月16日 上午10:54:50
* 类说明
* 拍卖-秒杀
*/
public interface SecondsDao {
	/** 拍卖-秒杀-根据车辆id查找详细 */
	public SecondKillBill findCarId(Integer carId);
	/** 拍卖-秒杀-获取车辆状态 */
	public int findCarState(Integer carId);
	/** 拍卖-秒杀-查询秒杀信息 */
	public SecondKillBill findCarSeconds(@Param("carId")Integer carId);
	/** 拍卖-秒杀-查询车辆详细 */
	public TCarBasisInfoEntity findCarInfo(@Param("carId")Integer carId);
	/** 拍卖-秒杀-获取车辆列表 */
	public List<Map<String, Object>> SecondsList();
}

package cn.dingd.dd.management.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.SecondKillBill;

/**
 * @author zoucong
 * 2018年1月16日上午11:31:02
 * 管理端-秒杀模块dao层接口
 */
public interface ManageSeckillingDao {
	
	/**查询当日所有秒杀车辆*/
	List<Map> getAllSeckillCars();
	/**添加秒杀车辆*/
	int addSeckillCar(SecondKillBill secondKillBill);
	/**查询库存车辆*/
	List<Map> FindCars();
	/**修改服务费*/
	int updateServerMoney(@Param("carId")int carId, @Param("serverMoney")float serverMoney);
	/**根据车牌号查找车辆*/
	List<Map> findCarByCarNum(String carNum);
	/**获取数据库中最后一辆车的开始时间*/
	Map getLastCarStartTime();
	/**修改车辆价格*/
	int updateCarMoney(@Param("carId")Integer carId, @Param("carMoney")Float carMoney);

}

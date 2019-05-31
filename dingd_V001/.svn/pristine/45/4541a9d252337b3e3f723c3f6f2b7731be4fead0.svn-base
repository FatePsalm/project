package cn.dingd.dd.management.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dingd.dd.common.entity.SecondKillBill;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.quartz.QuartzTime;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.management.dao.ManageSeckillingDao;
import cn.dingd.dd.management.service.ManageSeckillingService;

/**
 * @author zoucong
 * 2018年1月16日上午11:29:31
 * 后台管理-秒杀模块接口实现
 */
@Service
public class ManageSeckillingServiceImpl implements ManageSeckillingService{

	@Autowired
	private ManageSeckillingDao seckillingDao;
	@Autowired
	private CommonService commonService;
	
	/**
	 * 获取当日秒杀车辆
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Map> getAllSeckillCars() {
		List<Map> listMap = seckillingDao.getAllSeckillCars();
		//查询流拍次数
		Map<Object,Object> sunCar=commonService.statisticalCars();
		for(Map map:listMap) {
			//carState=7,表示生成拍卖订单
			if ((int)map.get("carState")==7) {
				map.put("result", "成功");
			}else{
				map.put("result","进行中");
			}
			//tid为车辆id,注意与查询结果中的字段匹配
			map.put("sunCars", sunCar.get(map.get("tid")));
		}
		return listMap;
	}

	/**
	 * 添加秒杀车辆
	 */
	@SuppressWarnings("static-access")
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addSeckillCars(List<SecondKillBill> secondList) {	
		TCarBasisInfoEntity car=new TCarBasisInfoEntity();
		// 将车辆插入秒杀表中
		for (SecondKillBill secondKillBill : secondList) {
			int resultsNum = seckillingDao.addSeckillCar(secondKillBill);
			//修改车辆状态
			car.setId(secondKillBill.getCarId());
			//状态为6,待拍卖
			car.setCarState(6);
			commonService.UpdateCarState(car);
			if(resultsNum==1) {
				//定时器名称为secKill+carId
				String quartzName = "secKill"+secondKillBill.getCarId();
				//开启定时器
				QuartzTime quartzTime = new QuartzTime();			
				try {
					//type=3为秒杀定时器
					quartzTime.getQuartz(secondKillBill.getStartTime(), quartzName, 3);
				} catch (SchedulerException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 查询库存车辆
	 */
	@SuppressWarnings({"unchecked", "rawtypes" })
	@Override
	public List<Map> FindCars() {
		List<Map> listMap=seckillingDao.FindCars();
		//查询流拍次数
		Map<Object,Object> sunCar=commonService.statisticalCars();
		for(Map map:listMap) {
			map.put("sunCars", sunCar.get(map.get("tid")));
		}
		return listMap;
	}

	/**
	 * 修改服务费
	 */
	@Override
	public String updateServerMoney(Integer carId,Integer serverMoney) {
		int resultNum = seckillingDao.updateServerMoney(carId,serverMoney);
		if (resultNum==1) {
			return "修改成功";
		}
		return "修改失败";
	}
	
	/**
	 * 根据车牌搜索车辆
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Map> findCarByCarNum(String carNum) {
		List<Map> listMap =  seckillingDao.findCarByCarNum(carNum);
		//查询流拍次数
		Map<Object,Object> sunCar=commonService.statisticalCars();
		for(Map map:listMap) {
			map.put("sunCars", sunCar.get(map.get("tid")));
		}
		return listMap;
	}

	/**
	 * 获取库存中最后一辆车的开拍时间
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Long getLastCarStartTime() {
		Map map = seckillingDao.getLastCarStartTime();
		if (map==null) {
			return null;
		}
		Timestamp timestamp = (Timestamp) map.get("startTime");
		if (timestamp==null) {
			return null;
		}
		return timestamp.getTime();
	}

	/**
	 * 修改车价
	 * @param carId 车辆id
	 * @param carMoney 车价
	 * @return
	 */
	@Override
	public String updateCarMoney(Integer carId, Float carMoney) {
		int resultNum = seckillingDao.updateCarMoney(carId,carMoney);
		if (resultNum==1) {
			return "修改成功";
		}
		return "修改失败";
	}

}

package cn.dingd.dd.auction.service.impl;

import cn.dingd.dd.auction.dao.TCarBasisInfoDao;
import cn.dingd.dd.auction.service.AuctionSessionService;
import cn.dingd.dd.auction.service.SecondsService;
import cn.dingd.dd.common.entity.AuctionOrderEntity;
import cn.dingd.dd.common.entity.SecondKillBill;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.util.*;
import cn.dingd.dd.management.dao.SecondsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年1月16日 上午10:51:26 类说明 拍卖-秒杀
 */
@Service
@Component  //import org.springframework.stereotype.Component;  
public class SecondsServiceImpl implements SecondsService {
	@Resource
	private SecondsDao secondsDao;
	@Resource
	private CommonService commonService;
	@Resource
	private AuctionSessionService auctionSessionService;
	@Autowired
	private TCarBasisInfoDao tCarBasisInfoDa;

	/** 拍卖-秒杀-清除redis中过期的车辆 */
	 @Scheduled(cron="59 59 23 * * ? ")   //每天执行一次
	public void removeRedisCar() {
		//获取所有的车辆
		Set<String> set = RedisClient.getkeys("Seconds");
		for (String string : set) {
			int carId = StringUtils.getStringNum(string);
			//修改车辆状态
			updateCarState(carId, 1);
			System.out.println("车辆ID:"+carId+"放回车库!");
			//删除redis车辆信息
			RedisClient.deleteData("Seconds"+carId);
			System.out.println("车辆ID:"+carId+"已从redis移除!");
		}
	}
	/** 拍卖-秒杀-获取当前系统时间 */
	public Long getCurrentTime() {
		// 当前系统时间
		return System.currentTimeMillis();
	}

	/** 拍卖-秒杀-根据车辆id查找详细 */
	public SecondKillBill findCarId(Integer carId) {
		return secondsDao.findCarId(carId);
	}

	/** 拍卖-秒杀-秒杀开始修改车辆状态 */
	public void updateCarState(Integer carId, Integer carState) {
		TCarBasisInfoEntity tCarBasisInfoEntity = new TCarBasisInfoEntity();
		tCarBasisInfoEntity.setId(carId);
		tCarBasisInfoEntity.setCarState(carState);
		commonService.UpdateCarState(tCarBasisInfoEntity);
	}

	/** 拍卖-秒杀-秒杀中 */
	public int carSeconds(Integer carId, Integer userId)throws Exception {
		String redisCarIdStr = RedisClient.getLpop("Seconds"+carId);
		// 如果返回为null,秒杀失败!
		if (redisCarIdStr == null) {
			throw new Exception("redis里不存在.");			
		}
		Integer redisCarId = Integer.parseInt(redisCarIdStr);
		// 如果传入carId和redis数据不一致失败!
		if (redisCarId != carId) {
			return 2;
		}
		// 成功以后生成订单!
		AuctionOrderEntity auctionOrderEntity = new AuctionOrderEntity();
		SecondKillBill secondKillBill = findCarId(redisCarId);
		auctionOrderEntity.setCarId(redisCarId);
		auctionOrderEntity.setOrderState(1);
		auctionOrderEntity.setAchieveMoney(secondKillBill.getCarMoney());
		auctionOrderEntity.setInvoice(0);
		auctionOrderEntity.setInvoiceMoney(0);
		auctionOrderEntity.setAuserId(userId);
		auctionOrderEntity.setAuctionId(0);
		auctionOrderEntity.setTotalMoney(secondKillBill.getCarMoney() + secondKillBill.getServerMoney() + Constant.registFee);
		auctionOrderEntity.setOrderTime(new Date());
		auctionOrderEntity.setServerMoney(secondKillBill.getServerMoney());
		auctionOrderEntity.setRegistFee(Constant.registFee);
		Boolean results = null;
		try {
			results = auctionSessionService.addAuctionOrder(auctionOrderEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 如果返回值是空或者flase的时候失败!
		if (results == null || !results) {
			return 3;
		}
		return 1;                                            
	}

	/** 拍卖-秒杀-查询车辆详细 */
	public Map<String, Object> findCarInfo(Integer carId)throws Exception {
		try {
			Map<String, Object> map = new HashMap<>();
			// 获取车辆秒杀价
			SecondKillBill secondKillBill = findCarId(carId);
			if (secondKillBill == null) {
				throw new NullPointerException("获取车辆信息失败!");
			}
			// 倒计时
			Long longTime = secondKillBill.getStartTime().getTime() - getCurrentTime();
			map.put("countdown", longTime / 1000);
			// 获取车辆详细
			cn.dingd.dd.common.view.TCarBasisInfoEntity findCarInfo = secondsDao.findCarInfo(carId);
			if (findCarInfo!=null){
				float div = NumberUtil.div(findCarInfo.getMileage(), Variable.Mileage);
				findCarInfo.setMileage(div);
			}
			//注入显性损伤统计数
			findCarInfo.setDcount(tCarBasisInfoDa.getCountDominant(carId));
			map.put("carInfo", findCarInfo);
			List<Integer> ls = new ArrayList<>();
			ls.add(7);
			ls.add(1);
			// 车辆损伤图片
			map.put("dicts", commonService.GetImgInfo(ls));
			map.put("seconds", secondKillBill);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询车辆详情失败！");
		}
	}

	/** 拍卖-秒杀-获取车辆列表 */
	public List<Map<String, Object>> SecondsList() {
		List<Map<String, Object>> list = secondsDao.SecondsList();
		for (Map<String, Object> eMap : list) {
			float div = NumberUtil.div(Float.parseFloat(eMap.get("mileage") + ""), Variable.Mileage);
			eMap.put("mileage", div);
			Date date = (Date) eMap.get("startTime");
			Long longTime = date.getTime() - getCurrentTime();
			eMap.put("countdown", longTime / 1000);
		}
		return list;
	}

}

package cn.dingd.dd.management.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dingd.dd.common.entity.AuctionCarEntity;
import cn.dingd.dd.common.entity.AuctionSessionEntity;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.quartz.QuartzTime;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.dao.ManageAuctionsDao;
import cn.dingd.dd.management.service.ManageAuctionsService;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年11月27日 下午3:56:44 类说明
 */
@Service
public class ManageAuctionsServiceImpl implements ManageAuctionsService {
	@Resource
	private ManageAuctionsDao manageAuctionsDao;
	@Resource
	private CommonService commonService;

	/**拍卖-发布管理-场次ID-查询场次开始时间*/
	public Date FindFieldTime(int field) {
		return manageAuctionsDao.FindFieldTime(field);
	}
	/**拍卖-发布管理-场次ID-查询场次当前车辆分页条数*/
	public int FindFieldCarsIdRowCount(AuctionCarEntity auctionCarEntity) {
		return manageAuctionsDao.FindFieldCarsIdRowCount(auctionCarEntity,manageAuctionsDao.State(auctionCarEntity.getAuctionId()));
	}
	/**拍卖-发布管理-场次ID-查询场次当前车辆*/
	public Map<String, Object> FindFieldCarsId(AuctionCarEntity auctionCarEntity,PageObject pageObject) {
		//查询信息
		List<Map> listMap=manageAuctionsDao.FindFieldCarsId(auctionCarEntity,manageAuctionsDao.State(auctionCarEntity.getAuctionId()), pageObject);
		//查询流拍次数
		Map<Object,Object> sunCar=commonService.statisticalCars();
		Map<String, Object> rMap=new HashedMap();
		//加入流拍次数和预报价对比
		for(Map<Object,Object> e:listMap) {
			e.put("sunCars", Integer.parseInt(String.valueOf(sunCar.get(e.get("tid"))))-1);
			//e.put("sunCars", ((int)(sunCar.get(e.get("tid"))))-1);
			if(e.get("auctionMoneyMAX")==null&&e.get("moneyMAX")==null) {
				//预拍金额和竞拍金额==null
				e.put("Max", 0);
				e.put("MaxState", 1);
			}else if(e.get("auctionMoneyMAX")!=null&&e.get("moneyMAX")!=null) {
				//预拍金额和竞拍金额!=null
				if((float)(e.get("auctionMoneyMAX"))>(float)(e.get("moneyMAX"))) {
					e.put("Max", (float)(e.get("auctionMoneyMAX")));
					e.put("MaxState", 1);
				}else {
					e.put("Max", (float)(e.get("moneyMAX")));
					e.put("MaxState", 2);
				}
			}else if(e.get("auctionMoneyMAX")==null||e.get("moneyMAX")==null) {
				//预拍金额或者竞拍金额==null
				if(e.get("auctionMoneyMAX")!=null) {
					e.put("Max", (float)(e.get("auctionMoneyMAX")));
					e.put("MaxState", 1);
				}else if(e.get("moneyMAX")!=null){
					e.put("Max", (float)(e.get("moneyMAX")));
					e.put("MaxState", 2);
				}
			}
		}
		//添加总条数
		pageObject.setRowCount(FindFieldCarsIdRowCount(auctionCarEntity));
		//添加返回数据
		rMap.put("list", listMap);
		rMap.put("pageObject", pageObject);
		return rMap;
	}
	/**拍卖-发布管理-添加车辆-查询场次当前车辆*/
	public List<Map> FindFieldCars(AuctionCarEntity auctionCarEntity){
		List<Map> listMap=manageAuctionsDao.FindFieldCars(auctionCarEntity);
		//查询流拍次数
				Map<Object,Object> sunCar=commonService.statisticalCars();
				for(Map map:listMap) {
					map.put("sunCars", sunCar.get(map.get("tid")));
				}
		return listMap;
	}
	/** 拍卖-发布管理-添加车辆-修改场次车辆 */
	@Transactional(rollbackFor = Exception.class) // 事物控制
	public String UpdateFieldCars(List<TCarBasisInfoEntity> tCarBasisInfoEntities,
			List<AuctionCarEntity> auctionCarEntity) {
		for (TCarBasisInfoEntity t : tCarBasisInfoEntities) {
			// 修改车辆起拍价
			if (UpdatePrice(t) != 1 ) {
				throw new NullPointerException("更新车辆起拍价失败!");
			}
			// 删除场次与车辆关系
			TCarBasisInfoEntity car=new TCarBasisInfoEntity();
			for (AuctionCarEntity d : auctionCarEntity) {
				DeleteFieldCars(d);
			}
			// 插入场次与车辆关系
			for (AuctionCarEntity a : auctionCarEntity) {
				AddFieldCars(a);
				//修改车辆状态
				car.setId(a.getCarId());
				car.setCarState(6);
				commonService.UpdateCarState(car);
			}
		}
		return "更新成功!";
	}

	/** 拍卖-发布管理-添加车辆-删除场次的对应车辆 */
	public int DeleteFieldCars(AuctionCarEntity auctionCarEntity) {
		return manageAuctionsDao.DeleteFieldCars(auctionCarEntity);
	}

	/** 拍卖-发布管理-添加车辆-添加场次的对应车辆 */
	public int AddFieldCars(AuctionCarEntity auctionCarEntity) {
		return manageAuctionsDao.AddFieldCars(auctionCarEntity);
	}

	/** 拍卖-发布管理-添加车辆-修改起拍价 */
	public int UpdatePrice(TCarBasisInfoEntity tCarBasisInfoEntity) {
		return manageAuctionsDao.UpdatePrice(tCarBasisInfoEntity);
	}

	/** 拍卖-发布管理-添加车辆-查询车辆列表 */
	public List<Map> FindCars() {
		List<Map> listMap=manageAuctionsDao.FindCars();
		//查询流拍次数
		Map<Object,Object> sunCar=commonService.statisticalCars();
		for(Map map:listMap) {
			map.put("sunCars", sunCar.get(map.get("tid")));
		}
		return listMap;
	}

	/** 查询拍卖纪录 */
	public Map<String, Object> FindAuctions(AuctionCarEntity auctionCarEntity,PageObject pageObject) {
		Map<String, Object> map=new HashMap<>();
		List<Map> listMap=manageAuctionsDao.FindAuctions(auctionCarEntity,pageObject);
		pageObject.setRowCount(manageAuctionsDao.FindAuctionsRowCount(auctionCarEntity));
		map.put("list", listMap);
		map.put("pageObject", pageObject);
		return map;
	}

	/** 查询拍卖场次 */
	public List<Map> FindField(AuctionSessionEntity auctionSessionEntity) {
		Date date = auctionSessionEntity.getAuctionDate();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String str = simpleDateFormat.format(date);
		return manageAuctionsDao.FindField(str);
	}

	/** 新建拍卖场次 */
	public int NewField(AuctionSessionEntity auctionSessionEntity) {
		//获取开始时间
		Date date = auctionSessionEntity.getAuctionStart();
		//转化时间为场次号
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
		//转换为String
		String dateStr = simpleDateFormat.format(date);
		//写入场次号
		auctionSessionEntity.setAuctionNum(dateStr.trim());
		//初始化场次状态
		auctionSessionEntity.setAuctionState(1);
		//如果插入数据成功,则执行定时器
		int resultsNum=manageAuctionsDao.NewField(auctionSessionEntity);
		if(resultsNum==1) {
			//获取项目id为job
			String id=auctionSessionEntity.getId()+"";
			//场次号为group
			//String auctionNum=auctionSessionEntity.getAuctionNum();
		
			try {
				 QuartzTime.getQuartz(auctionSessionEntity.getAuctionStart(),"auction"+id,1);
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return resultsNum;
	}
}

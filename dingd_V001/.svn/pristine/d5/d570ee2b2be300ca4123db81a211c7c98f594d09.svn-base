package cn.dingd.dd.detection.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dingd.dd.common.entity.CarBrandsInfoEntity;
import cn.dingd.dd.common.entity.CarDamageEntity;
import cn.dingd.dd.common.entity.CarDominantEntity;
import cn.dingd.dd.common.entity.CarModelInfoEntity;
import cn.dingd.dd.common.entity.CarPictureEntity;
import cn.dingd.dd.common.entity.CarSeriesInfoEntity;
import cn.dingd.dd.common.entity.CheckBillEntity;
import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.detection.dao.DetectOrderDao;
import cn.dingd.dd.detection.service.DetectOrderService;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年10月17日 上午11:02:41 类说明
 */
@Service
public class DetectOrderServiceImpl implements DetectOrderService {
	@Resource
	private DetectOrderDao detectOrderDao;
	@Resource
	private CommonService commonService;
	
	/**根据检测订单查询是否重复提交信息*/
	public int findVIN(String carNumber,String VIN) {
		return detectOrderDao.findVIN(carNumber, VIN);
	}
	/**根据检测订单查询是否重复提交信息*/
	public int detectUpload(int checkBillId) {
		return detectOrderDao.detectUpload(checkBillId);
	}
	/** 上传车辆检测订单 */
	@Transactional(rollbackFor = Exception.class) // 事物控制
	public void CheckUpload(TCarBasisInfoEntity tCarBasisInfoEntity,List<CarDominantEntity> carDominantList,List<CarDamageEntity> carDamageList,
			List<CarPictureEntity> carPictureList) throws Exception{
		// 保存检测信息
		tCarBasisInfoEntity.setTitle(tCarBasisInfoEntity.getCarName()+"/"+tCarBasisInfoEntity.getCars()+"/"+tCarBasisInfoEntity.getCarModel());
		detectOrderDao.addTCarInfo(tCarBasisInfoEntity);
		int carId = tCarBasisInfoEntity.getId();
		// 显性损伤注入车辆ID
		for(CarDominantEntity domin:carDominantList) {
			domin.setCarId(carId);
		}
		//隐性损伤注入车辆ID
		for(CarDamageEntity dama:carDamageList) {
			dama.setCarId(carId);
		}
		//保存显性损伤
		if(carDominantList!=null&&carDominantList.size()>0) {
			detectOrderDao.carDominant(carDominantList);
		}
		//保存隐性损伤
		if(carDamageList!=null&&carDamageList.size()>0) {
			detectOrderDao.carDamage(carDamageList);
		}
		// 上传其他图片
		for (int i = 0; i < carPictureList.size(); i++) {
			carPictureList.get(i).setCarId(carId);
		}
		detectOrderDao.uploadImg(carPictureList);
		setCheckState(tCarBasisInfoEntity.getCheckBillId(),2);
	}

	/**
	 * 根据检测单号查询对应的carId
	 * 
	 * @param checkBillId
	 */
	public int getCarId(int checkBillId) {
		return detectOrderDao.getCarId(checkBillId);
	}

	/**
	 * 根据检测单号查询对应的检测单id
	 * 
	 * @param checkBillId
	 */
	@Override
	public int getcheckBillId(String checkBillId) {
		return detectOrderDao.getcheckBillId(checkBillId).getId();
	}
	

	/** 验证码授权检测车辆验证码匹配 
	 * @throws Exception */
	@Transactional(rollbackFor = Exception.class) // 事物控制
	public String FindAuthorizationCheck(CheckBillEntity checkBillEntity, String password) throws Exception {
		if (checkBillEntity == null || checkBillEntity.getTelephone() == null
				|| checkBillEntity.getTelephone().equals("") || password == null || password.equals("")) {
			throw new Exception("账号或验证码为空!");
		}
		String cacheNumber = commonService.GetCacheNumber(checkBillEntity.getTelephone());
		if (!cacheNumber.equals(password)) {
			throw new Exception("密码错误!");
		}
		return "验证通过!";
	}

	/** 更改检测单状态 */
	public int setCheckState(int id, int checkStatus) {
		int state = detectOrderDao.setCheckState(id, (checkStatus + 1));
		if (state != 1) {
			throw new NullPointerException("修改状态异常!");
		}
		return state;
	}

	/** 根据联系人信息发送验证码授权 */
	public String FindAuthorization(CheckBillEntity checkBillEntity) {
		if (checkBillEntity == null || checkBillEntity.getTelephone() == null
				|| checkBillEntity.getTelephone().equals("")) {
			throw new NullPointerException("未获取到联系人电话!");
		}
		return commonService.RandomCodeOut(checkBillEntity.getTelephone(), 1, 0);
	}

	/** 根据车辆ID获取配置 */
	public CarModelInfoEntity FindCarIDInfo(CarModelInfoEntity carModelInfoEntity) {
		return detectOrderDao.FindCarIDInfo(carModelInfoEntity);
	}

	/** 根据车辆ID查询车型款式信息 */
	public List<CarModelInfoEntity> FindCarModelInfo(CarSeriesInfoEntity carSeriesInfoEntity) {
		return detectOrderDao.FindCarModelInfo(carSeriesInfoEntity);
	}

	/** 根据品牌ID查询车系列信息 */
	public List<CarSeriesInfoEntity> FindCarSeriesInfo(CarBrandsInfoEntity carBrandsInfoEntity) {
		return detectOrderDao.FindCarSeriesInfo(carBrandsInfoEntity);
	}

	/** 返回所有的车辆品牌 */
	public List<CarBrandsInfoEntity> CarInfoAll(CarBrandsInfoEntity carBrandsInfoEntity) {
		return detectOrderDao.CarInfoAll(carBrandsInfoEntity);
	}

	/** 我的订单中心 */
	public List<CheckBillEntity> MyDetectOrder(StaffInfoEntity staffInfo, PageObject pageObject, Integer checkStatus) {
		return detectOrderDao.MyDetectOrder(staffInfo, pageObject, checkStatus);
	}

	/** 我的订单中心修改订单时间 */
	public Integer UpdateTime(CheckBillEntity checkBillEntity) {
		return detectOrderDao.UpdateTime(checkBillEntity);
	}
}

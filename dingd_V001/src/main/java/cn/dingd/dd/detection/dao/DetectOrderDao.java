package cn.dingd.dd.detection.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.CarBrandsInfoEntity;
import cn.dingd.dd.common.entity.CarDamageEntity;
import cn.dingd.dd.common.entity.CarDominantEntity;
import cn.dingd.dd.common.entity.CarModelInfoEntity;
import cn.dingd.dd.common.entity.CarPictureEntity;
import cn.dingd.dd.common.entity.CarSeriesInfoEntity;
import cn.dingd.dd.common.entity.CheckBillEntity;
import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.web.PageObject;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年10月17日 上午11:04:50 类说明 检测师订单
 */
public interface DetectOrderDao {

	/** 根据检测订单查询是否重复提交信息 */
	public int findVIN(@Param("carNumber") String carNumber, @Param("VIN") String VIN);

	/** 根据检测订单查询是否重复提交信息 */
	public int detectUpload(@Param("checkBillId") int checkBillId);

	/**
	 * 更改检测单状态
	 */
	public int setCheckState(@Param("id") int id, @Param("checkStatus") int checkStatus);

	/**
	 * 上传特写图片和其他证件图片
	 */
	public int uploadImg(@Param("list") List<CarPictureEntity> list);

	/** 根据检测单号查询对应的检测单id */
	public CheckBillEntity getcheckBillId(@Param("checkBillId") String checkBillId);

	/** 根据检测单号查询对应的carId */
	public int getCarId(@Param("checkBillId") int checkBillId);

	/** 上传检测端车辆损伤-显性损伤 */
	public int carDominant(@Param("list") List<CarDominantEntity> list);

	/** 上传检测端车辆损伤-隐性损伤 */
	public int carDamage(@Param("list") List<CarDamageEntity> list);

	/** 上传检测端车辆基本信息 */
	public int addTCarInfo(TCarBasisInfoEntity tCarBasisInfoEntity);

	/** 根据车辆ID获取配置 */
	public CarModelInfoEntity FindCarIDInfo(CarModelInfoEntity carModelInfoEntity);

	/** 根据车辆ID查询车型款式信息 */
	public List<CarModelInfoEntity> FindCarModelInfo(CarSeriesInfoEntity carSeriesInfoEntity);

	/** 根据品牌ID查询车系列信息 */
	public List<CarSeriesInfoEntity> FindCarSeriesInfo(CarBrandsInfoEntity carBrandsInfoEntity);

	/** 返回所有的车辆品牌 */
	public List<CarBrandsInfoEntity> CarInfoAll(@Param("carBrandsInfoEntity") CarBrandsInfoEntity carBrandsInfoEntity);

	/** 我的订单中心 */
	public List<CheckBillEntity> MyDetectOrder(@Param("staffInfo") StaffInfoEntity staffInfo,
			@Param("pageObject") PageObject pageObject, @Param("checkStatus") Integer checkStatus);

	/** 我的订单中心修改订单时间 */
	public Integer UpdateTime(CheckBillEntity checkBillEntity);

}

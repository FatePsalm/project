package cn.dingd.dd.detection.service;

import java.util.List;

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
* @version 创建时间：2017年10月17日 上午11:02:25
* 类说明
*/
public interface DetectOrderService {
	
	/**根据检测订单查询是否重复提交信息*/
	public int findVIN(String carNumber,String VIN);
	/**根据检测订单查询是否重复提交信息*/
	public int detectUpload(int checkBillId);
	/**更改检测单状态*/
	public int setCheckState(int id,int checkStatus);
	/**上传车辆检测订单
	 * @throws Exception */
	public void CheckUpload(TCarBasisInfoEntity carBasisInfoEntity, List<CarDominantEntity> carDominantList,List<CarDamageEntity> carDamageList ,List<CarPictureEntity> carPictureList) throws Exception ;
	/**验证码授权检测车辆验证码匹配*/
	public String  FindAuthorizationCheck(CheckBillEntity checkBillEntity,String password)throws Exception;
	/** 根据联系人信息发送验证码授权 */
	public String FindAuthorization(CheckBillEntity checkBillEntity);
	/** 根据车辆ID获取配置*/
	public CarModelInfoEntity FindCarIDInfo(CarModelInfoEntity carModelInfoEntity);
	/** 根据车辆ID查询车型款式信息 */
	public List<CarModelInfoEntity> FindCarModelInfo(CarSeriesInfoEntity carSeriesInfoEntity) ;
	/** 根据品牌ID查询车系列信息 */
	public List<CarSeriesInfoEntity> FindCarSeriesInfo(CarBrandsInfoEntity carBrandsInfoEntity);
	/** 返回所有的车辆品牌 */
	public List<CarBrandsInfoEntity> CarInfoAll(CarBrandsInfoEntity carBrandsInfoEntity);
	/** 我的订单中心 */
	public List<CheckBillEntity> MyDetectOrder(StaffInfoEntity staffInfo,PageObject pageObject,Integer check_status);
	/** 我的订单中心修改订单时间 */
	public Integer UpdateTime(CheckBillEntity checkBillEntity);
	/**根据检测单号查询对应的检测单id	 */
	public int getcheckBillId(String checkBillId) ;
	/** 根据检测单号查询对应的carId */
	public int getCarId(int checkBillId);
	
}

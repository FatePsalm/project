package cn.dingd.dd.temporary.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.temporary.entity.CarInfoDom;

/**
 * dom车辆信息接口
 * @author XCD
 *
 */
public interface CarInfoDomDao {
	
	/** 
	 * 
	 * 记录验证码登录信息
	 * 
	 */
	public int addCarInfo(CarInfoDom carInfoDom);

	/**
	 * 删除车辆信息
	 * @param id
	 * @return
	 */
	public int deleteCarInfo(int id);
	
	/**
	 * 更新车辆信息
	 * @param carInfoDomDao
	 */
	public void updCarInfo(CarInfoDom carInfoDom);
	
	/**
	 *获取车辆详情信息
	 */
	public CarInfoDom queryCarInfo(int id);
	/**
	 * 根据条件查询车辆信息
	 * @param money
	 * @param moneyEnd
	 * @param carCx
	 */
	public List<Map> queryCarInfoParam(@Param("money") float money,@Param("moneyEnd") float moneyEnd,@Param("carCx") String carCx,@Param("pageObject") PageObject pageObject);
	
	/**
	 *获取信息 
	 */
	public CarInfoDom getCarInfoId(int id);
	/**
	 * 获取总条数
	 * @return
	 */
	public int queryCarInfoPage();
	
	/**
	 * 查询车辆信息列表
	 * @param object
	 * @param cover
	 * @return
	 */
	public List<Map> queryCarList(@Param("pageObject") PageObject pageObject);
	
	/**
	 * 删除车辆信息
	 * @param id
	 * @return
	 */
	public int deleteCarInfoList(@Param("ids") List<Integer> ids);
	
}

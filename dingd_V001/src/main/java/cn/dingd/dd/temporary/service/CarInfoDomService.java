package cn.dingd.dd.temporary.service;


import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.temporary.entity.CarInfoDom;

/**
 * 车辆信息service
 * @author XCD
 *
 */
public interface CarInfoDomService {

	/**
	 * 添加车辆信息
	 * @param carInfoDomDao
	 * @return
	 */
	public boolean addCarInfoDom(CarInfoDom carInfoDom,MultipartFile[] files);
	
	
	/**
	 * 添加车辆信息
	 * @param carInfoDomDao
	 * @return
	 */
	public boolean updCarInfoDom(CarInfoDom carInfoDom);
	
	/**
	 * 删除车辆信息
	 * @param id
	 * @return
	 */
	public boolean deleteCarInfo(int id);
	/**
	 * 获取车辆信息
	 * @return
	 */
	public List<Map> queryCarInfoList(PageObject pageObject);
	
	/**
	 *获取车辆详情信息
	 */
	public CarInfoDom queryCarInfo(int id);
	
	
	/**
	 *设为封面
	 */
	public boolean updCover(int id,int carId);
	/**
	 * 根据条件查询车辆信息
	 * @param money
	 * @param moneyEnd
	 * @param carCx
	 * @return
	 */
	public List<Map> queryCarInfoParam(float money,float moneyEnd,String carCx,PageObject pageObject);
	/**
	 * 删除图片
	 * @param id
	 * @return
	 */
	public boolean delCarPictureDom(int id);
	/**
	 * 更新图片信息
	 * @param files
	 * @return
	 */
    public int updCarPictureDom(MultipartFile[] files,int id);
	
	/**
	 * 获取总页数
	 * @return
	 */
	public int queryCarInfoPage();
	
	/**
	 * 批量删除车辆信息
	 * @param ids
	 * @return
	 */
    public boolean delCarInfoList(List<Integer> ids );
		
	
  
	
	
}

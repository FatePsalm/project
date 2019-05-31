package cn.dingd.dd.temporary.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.temporary.entity.CarPictureDom;

/**
 * 车辆图片
 * @author XCD
 *
 */
public interface CarPictureDomDao {

	/**
	 * 添加车辆图片
	 * @param carPictureDom
	 * @return 
	 */
	public int addCarPicture(List<CarPictureDom> carPictureDoms);
	/**
	 * 添加车辆图片
	 * @param carPictureDom
	 */
	public int updCarPicture(CarPictureDom carPictureDoms);
	
	/**
	 * 删除图片信息
	 * @param id
	 * @return
	 */
	public int delCarPictureDom(int id); 
	
	/**
	 * 获取车辆图片
	 * @return
	 */
	public List<CarPictureDom> queryCarPictureDom();
	/**
	 * 设为封面
	 * @param id
	 */
	public void updCover(@Param("id") int id,@Param("carId") int carId);
	
	/**
	 * 根据车辆id删除图片信息
	 * @param carInfoId
	 * @return
	 */
	public int delCarPictureDomParam(int carInfoId); 
	
}

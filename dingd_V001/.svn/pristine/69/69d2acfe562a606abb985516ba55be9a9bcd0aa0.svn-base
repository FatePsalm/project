package cn.dingd.dd.auction.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.CarDamageEntity;
import cn.dingd.dd.common.entity.CarDominantEntity;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;

/**
 * 车辆信息dao
 * @author XCD
 *
 */
public interface TCarBasisInfoDao {

	/**
	 * 获取车辆显性损伤信息
	 * @param carId
	 * @return
	 */
	public List<CarDominantEntity> getCarDominant(int carId);
	   
	   /**
	    * 获取车辆其他图片
	    * @param carId
	    * @return
	    */
	   public List<Map> getRestsPicture(int carId);
	   
	   /**
	    * 获取车辆预报价数量
	    * @param carId
	    * @return
	    */
	   public Integer getCarInfoCount(@Param("userId")int userId,@Param("auctionId")int auctionId,@Param("carId")int carId);
	   
		/**
		 * 车辆状态
		 * @param carId
		 * @return
		 */
	   public Integer  getAuctionCarStatus(int carId);
	   
		/**
		 * 设置车辆状态
		 * @param carId
		 * @param status
		 * @return
		 */
		public Integer setCarStatus(@Param("status")int status,@Param("carId")int carId);
		
		/**
		 * 根据车辆id获取车辆信息
		 * @param carId
		 * @return
		 */
		public TCarBasisInfoEntity getTCarBasisInfoEntityId(int carId);
		/**
		 * 获取隐性损伤
		 * @param carid
		 * @return
		 */
		public List<CarDamageEntity> getCarDamage(int carId) ;
		/**
		 * 获取车辆显性损伤数量
		 * @return
		 */
		public Integer getCountDominant(int carId);
		
}

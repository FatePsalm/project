package cn.dingd.dd.auction.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.AuctionOrderEntity;
import cn.dingd.dd.common.entity.AuctionRecordEntity;
import cn.dingd.dd.common.entity.AuctionSessionEntity;
import cn.dingd.dd.common.entity.BiddingEntity;
import cn.dingd.dd.common.entity.CarDamageEntity;
import cn.dingd.dd.common.entity.CarDominantEntity;
import cn.dingd.dd.common.view.ShowAuctionDto;
import cn.dingd.dd.common.view.TCarBasisInfoEntity;
import cn.dingd.dd.common.web.PageObject;

/**
 * 拍卖场次service
 * @author XCD
 *
 */

public interface AuctionSessionService {

	/**
	 * 获取拍卖场次
	 * @return
	 */
	public List<AuctionSessionEntity> queryAuctionSession()throws Exception ;
	/**
	 * 根据场次id获取拍卖车辆
	 * @param asid
	 * @return
	 */
    public List<Map> queryAuctionCar(int asid,int userId,int status,Date dateStart,PageObject pageObject)throws Exception ;
    
    /**
	 * 添加竞价信息
	 * @param biddingEntity
	 */
	public boolean addBiddingEntity(BiddingEntity biddingEntity)throws Exception ;
	
	/**
	 * 添加拍卖纪录
	 * @param auctionRecordEntity
	 * @return
	 */
	public boolean addAuctionRecord(AuctionRecordEntity auctionRecordEntity)throws Exception ;
	/**
	 * 生成拍卖订单
	 * @param auctionOrderEntity
	 * @return
	 */
	public boolean addAuctionOrder(AuctionOrderEntity auctionOrderEntity)throws Exception ;
	
	/**
	 * 修改拍卖订单
	 * @param id 订单id 
	 * @return
	 */
	public boolean updAuctionOrder(int id)throws Exception ;

	/**
	 * 获取最大id的信息
	 * @return
	 */
	public String getIdentMax()throws Exception ;
	
	  /**
	   * 获取车辆详情
	   * @return
	   */
		public TCarBasisInfoEntity queryTCarinfo(int auctionId,int carId,int userId)throws Exception ;
		/**
		 * 获取图片信息
		 * @param carid
		 * @return
		 */
		public  List<CarDamageEntity> getCarDamage(int carid)throws Exception ;
		
		/**
		 * 获取订单
		 * @param userId
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		public List<Map> getAuctionOrderEntities(int userId,PageObject pageObject)throws Exception ;
		
		/**
		 * 获取场次开拍时间和车辆数
		 * @param userId
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		public Map getAuctionCarTime(int asid,int status)throws Exception;
	
		
		/**
		 * 设置车辆状态
		 * @param carId
		 * @param status
		 * @return
		 */
		public int setCarStatus(int carId,int status)throws Exception ;
		
		/**
		 * 获取车辆
		 * @param asid
		 * @throws Exception
		 */
		public boolean getAuctionCar(int asid)throws Exception ;
		/**
		 * 获取车辆状态
		 * @return
		 */
		public int getAuctionCarStatus(int carId);
		
		/**
		 * 获取车辆的其他图片
		 * @param carId
		 * @return
		 */
		public List<Map> getRestsPicture(int carId);
		
		   /**
		    * 获取场次状态
		    * @param asid
		    * @return
		    */
		   public Integer getAuctionStatus(int status);
		   
		   /**
		    * 获取车辆信息
		    * @param carId
		    * @return
		    */
		   public TCarBasisInfoEntity getTCarBasisInfoID(int carId);
		   /**
		    * 获取首页分页信息
		    * @param userId
		    * @param asid
		    * @param status
		    * @param dateStart
		    * @return
		    */
		   public Integer queryAuctionCarPage(@Param("userId")int userId,@Param("asid")int asid,@Param("status") int status,@Param("dateStart") Date dateStart);
		   /**
		    * 获取订单分页信息
		    * @param userId
		    * @return
		    */
		   public Integer getAuctionOrderPage(int userId);
		   
		   /**
		    * 获取车辆显性损伤
		    * @param carId
		    * @return
		    */
		   public List<CarDominantEntity> getCarDominant(int carId)throws Exception;
		   
		   /**
		    * 屏幕展示拍卖信息
		    * @return
		    */
		   public ShowAuctionDto getCarInfo();
}

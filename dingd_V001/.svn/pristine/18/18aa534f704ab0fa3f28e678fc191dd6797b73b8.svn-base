package cn.dingd.dd.auction.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.AuctionRecordEntity;
import cn.dingd.dd.common.entity.AuctionSessionEntity;
import cn.dingd.dd.common.entity.BiddingEntity;
import cn.dingd.dd.common.entity.CarDamageEntity;
import cn.dingd.dd.common.view.ShowAuctionDto;
import cn.dingd.dd.common.view.TCarBasisInfoEntity;
import cn.dingd.dd.common.web.PageObject;

/**
 * 拍卖场次
 * @author XCD
 *
 */
public interface AuctionSessionDao {
	
	/**
	 * 获取拍卖场次
	 * @return
	 */
	public List<AuctionSessionEntity> queryAuctionSession(Date date);
	
	/**
	 * 获取拍卖场次的车辆信息
	 * @param asid
	 * @return
	 */
	public List<Map> queryAuctionCar(@Param("userId")int userId,@Param("asid")int asid,@Param("status") int status,@Param("dateStart") Date dateStart,@Param("pageObject")PageObject pageObject);

	/**
	 * 添加竞价信息
	 * @param biddingEntity
	 */
	public void addBiddingEntity(BiddingEntity biddingEntity);
	
	/**
	 * 记录出价信息
	 * @param auctionRecord
	 * @return
	 */
	public int addAuctionRecord(AuctionRecordEntity auctionRecord);
	

  /***
   * 获取车辆详情
   * @param userId
   * @param auctionId 场次id
   * @param carId
   * @return
   */
	public TCarBasisInfoEntity queryTCarinfo(@Param("userId")int userId,@Param("auctionId")int auctionId,@Param("carId")int carId);
	
	
	
	/**
	 * 获取场次开拍时间和车辆数
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map getAuctionCarTime(@Param("asid")int asid,@Param("status")int status);
	
	/**
	 * 根据场次id获取车辆
	 * @param asid
	 * @return
	 */
	public  Map  getTCarBasisinfo(@Param("asid")int asid,@Param("status")int status);

	
	/**
	 * 获取场次id
	 * @param status
	 * @return
	 */
	public Integer getAuctionId(int status);
	
	/**
	 * 修改场次状态
	 * @param asid
	 * @param stuats
	 * @param date
	 * @return
	 */
	public int updAuctionOver(@Param("status")int status,@Param("date")Date date,@Param("asid")int asid);
   
   
   /**
    * 获取场次状态
    * @param asid
    * @return
    */
   public Integer getAuctionStatus(int status);
   
 
   /**
    *  获取总条数
    * @param userId
    * @param auctionId
    * @param status
    * @param dateStart
    * @param pageObject
    * @return
    */
   public Integer queryAuctionCarPage(@Param("userId")int userId,@Param("asid")int asid,@Param("status") int status,@Param("dateStart") Date dateStart);
   
   /**
    * 获取车辆信息
    * @param carId
    * @return
    */
   public TCarBasisInfoEntity getTCarBasisInfoID(int carId);

   /**
    * 屏幕拍卖展示
    * @return
    */
   public ShowAuctionDto showAuction();
  
   /**
    * 屏幕拍卖展示
    * @return
    */
   public ShowAuctionDto getCarInfo(); 
   
   
}

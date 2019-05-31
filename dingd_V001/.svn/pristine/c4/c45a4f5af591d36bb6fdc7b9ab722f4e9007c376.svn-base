package cn.dingd.dd.auction.dao;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Pattern;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.AuctionOrderEntity;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.web.PageObject;

/**
 * 拍卖订单
 * @author XCD
 *
 */
public interface AuctionOrderDao {

	/**
	 * 添加拍卖订单
	 * @param auctionOrder
	 */
	public int addAuctionOrder(AuctionOrderEntity auctionOrder);
	/**
	 * 修改拍卖订单
	 * @param auctionOrder
	 * @return
	 */
	public int updAuctionOrder(AuctionOrderEntity auctionOrder);
	
	
	/**
	 * 获取最大id的拍卖订单号
	 * @return
	 */
	public String getIdentMax();
	/**
	 * 查询拍卖订单
	 * @return
	 */
	public List<AuctionOrderEntity> getAuctionOrder(int status);
	
	
	/**
	 * 获取订单
	 * @param id
	 * @return
	 */
	public AuctionOrderEntity geAuctionOrderEntityId(int id);
	/**
	 * 查询拍卖订单
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> queryAuctionOrder(@Param("userId")int userId,@Param("pageObject")PageObject pageObject);
	/**
	 * 获取拍卖订单条数
	 * @return
	 */
	public Integer getAuctionOrderPage(int userId);
	/**
	 * 删除异常订单
	 * @param id
	 * @return
	 */
	public Integer delAuctionOrder(int id);
	
}

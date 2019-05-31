package cn.dingd.dd.management.service;

import cn.dingd.dd.common.entity.*;
import cn.dingd.dd.common.web.PageObject;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年12月13日 下午3:28:27
* 类说明
* 管理端-拍卖订单
*/
public interface MamageOrderService {
	/**
	 * 时间: 2018/5/7 11:14
	 * 功能描述:过户成功计算返利发送短信通知
	 * 根据建档车辆ID查询商家电话号码
	 */
	public void rebate_SMS(Integer carId) ;
	/**管理端-拍卖管理-查询订单扣款时间 状态1-截止付款时间 2-生成时间*/
	public Date FindAbortTime(int id,int state) ;
	/**管理端-拍卖管理-修改时间*/
	public int UpdateOrderTime(AuctionOrderEntity auctionOrderEntity);
	/** 管理端-拍卖管理-创建档案 */
	public int addRecord(Integer id,RecordEntity recordEntity,List<RecordPictureEntity> list);
	/** 管理端-拍卖管理-修改拍卖订单状态 */
	public int UPdateOrder(AuctionOrderEntity auctionOrderEntity,AuctionOrderTimeEntity auctionOrderTimeEntity);
	/** 管理端-拍卖管理-拍卖订单查询 */
	public Map<String, Object> FindOrder(CheckQueryEntity checkQueryEntity,PageObject pageObject);
}

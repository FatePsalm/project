package cn.dingd.dd.management.dao;

import cn.dingd.dd.common.entity.*;
import cn.dingd.dd.common.web.PageObject;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年12月13日 下午3:29:31
* 类说明
* 管理端-拍卖订单
*/
public interface MamageOrderDao {
	/**
	 * 时间: 2018/5/7 11:14
	 * 功能描述:过户成功计算返利发送短信通知
	 * 根据建档车辆ID查询商家电话号码
	 */
	public Map<String,Object> rebate_SMS(Integer carId) ;
	/** 管理端-拍卖管理-查找操作记录 */
	public AuctionOrderTimeEntity findOperating(AuctionOrderTimeEntity auctionOrderTimeEntity);
	/** 管理端-拍卖管理-更新写入操作记录 */
	public Integer upOperating(AuctionOrderTimeEntity auctionOrderTimeEntity);
	/** 管理端-拍卖管理-写入操作记录 */
	public Integer addOperating(AuctionOrderTimeEntity auctionOrderTimeEntity);
	/**管理端-拍卖管理-根据ID查询并返回对象*/
	public AuctionOrderEntity findAuctionOrderEntity(@Param("id")Integer id);
	/**管理端-拍卖管理-付款解除资金冻结 id-订单id,*/
	public Integer RemoveMoney(@Param("id")Integer id,@Param("money")Integer money );
	/**管理端-拍卖管理-查询订单扣款时间 状态1-截止付款时间 2-生成时间*/
	public Date FindAbortTime(@Param("id")int id,@Param("state")int state);
	/**管理端-拍卖管理-修改时间*/
	public int UpdateOrderTime(AuctionOrderEntity auctionOrderEntity);
	/** 管理端-拍卖管理-写入图片信息 */
	public int addRecordImg(@Param("list")List<RecordPictureEntity> list); 
	/** 管理端-拍卖管理-创建档案 */
	public int addRecord(RecordEntity recordEntity);
	/** 管理端-拍卖管理-拍卖订单查询 */
	public List<Map<String, Object>> FindOrder(@Param("checkQueryEntity")CheckQueryEntity checkQueryEntity,@Param("pageObject")PageObject pageObject);
	/** 管理端-拍卖管理-拍卖订单查询查询总条目数 */
	public int FindOrderRowCount(@Param("checkQueryEntity")CheckQueryEntity checkQueryEntity);
}

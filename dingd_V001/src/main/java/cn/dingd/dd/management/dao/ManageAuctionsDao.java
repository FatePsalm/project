package cn.dingd.dd.management.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.AuctionCarEntity;
import cn.dingd.dd.common.entity.AuctionSessionEntity;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.web.PageObject;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 下午4:00:54
* 类说明
* T管理端DAO
*/
public interface ManageAuctionsDao {
	/**拍卖-发布管理-根据场次ID查询状态*/
	public int State(int auctionId);
	/**拍卖-发布管理-场次ID-查询场次开始时间*/
	public Date FindFieldTime(int field);
	/**拍卖-发布管理-场次ID-查询场次当前车辆分页条数*/
	public int FindFieldCarsIdRowCount(AuctionCarEntity auctionCarEntity,@Param("auctionId")int auctionId);
	/**拍卖-发布管理-场次ID-查询场次当前车辆*/
	public List<Map> FindFieldCarsId(@Param("auctionCarEntity")AuctionCarEntity auctionCarEntity,@Param("auctionId")int auctionId,@Param("pageObject")PageObject pageObject) ;
	/**拍卖-发布管理-添加车辆-查询场次车辆*/
	public List<Map> FindFieldCars(AuctionCarEntity auctionCarEntity);
	/**拍卖-发布管理-添加车辆-添加场次的对应车辆*/
	public int AddFieldCars(AuctionCarEntity auctionCarEntity);
	/**拍卖-发布管理-添加车辆-删除场次的对应车辆*/
	public int DeleteFieldCars(AuctionCarEntity auctionCarEntity) ;
	/**拍卖-发布管理-添加车辆-修改起拍价*/
	public int  UpdatePrice(TCarBasisInfoEntity tCarBasisInfoEntity) ;
	/**拍卖-发布管理-添加车辆-查询车辆列表*/
	public List<Map> FindCars() ;
	/**查询拍卖纪录*/
	public int FindAuctionsRowCount(@Param("auctionCarEntity")AuctionCarEntity auctionCarEntity) ;
	/**查询拍卖纪录*/
	public List<Map> FindAuctions(@Param("auctionCarEntity")AuctionCarEntity auctionCarEntity,@Param("pageObject")PageObject pageObject) ;
	/**查询拍卖场次*/
	public List<Map> FindField(@Param("str")String str) ;
	/**新建拍卖场次*/
	public int NewField(AuctionSessionEntity auctionSessionEntity);
}

package cn.dingd.dd.management.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.dingd.dd.common.entity.AuctionCarEntity;
import cn.dingd.dd.common.entity.AuctionSessionEntity;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.web.PageObject;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 下午12:21:36
* 类说明
* 管理端拍卖接口
*/
public interface ManageAuctionsService {
	/**拍卖-发布管理-场次ID-查询场次开始时间*/
	public Date FindFieldTime(int field);
	/**拍卖-发布管理-场次ID-查询场次当前车辆*/
	public Map<String, Object> FindFieldCarsId(AuctionCarEntity auctionCarEntity,PageObject pageObject);
	/**拍卖-发布管理-添加车辆-查询场次车辆*/
	public List<Map> FindFieldCars(AuctionCarEntity auctionCarEntity);
	/**拍卖-发布管理-添加车辆-修改场次车辆*/
	public String UpdateFieldCars(List<TCarBasisInfoEntity> tCarBasisInfoEntities,List<AuctionCarEntity> auctionCarEntity);
	/**拍卖-发布管理-添加车辆-修改起拍价*/
	public int  UpdatePrice(TCarBasisInfoEntity tCarBasisInfoEntity) ;
	/**拍卖-发布管理-添加车辆-查询车辆列表*/
	public List<Map> FindCars() ;
	/**查询拍卖纪录*/
	public Map<String, Object> FindAuctions(AuctionCarEntity auctionCarEntity,PageObject pageObject) ;
	/**查询拍卖场次*/
	public List<Map> FindField(AuctionSessionEntity auctionSessionEntity) ;
	/**新建拍卖场次*/
	public int NewField(AuctionSessionEntity auctionSessionEntity);
}

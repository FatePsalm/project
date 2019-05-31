package cn.dingd.dd.management.controller;
/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 上午11:06:27
* 类说明
* T管理端接口
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.common.entity.AuctionCarEntity;
import cn.dingd.dd.common.entity.AuctionSessionEntity;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.service.ManageAuctionsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@CrossOrigin
@RequestMapping("/mgmtPm/")
public class ManageAuctionsController {
	@Resource
	private ManageAuctionsService manageAuctionsService;

	/** 拍卖-发布管理-场次ID-查询场次当前车辆 */
	@RequestMapping("doFindFieldCarsId")
	@ResponseBody
	public JsonResult doFindFieldCarsId(AuctionCarEntity auctionCarEntity, PageObject pageObject) {
		if (auctionCarEntity.getAuctionId() < 1) {
			// 场次信息
			throw new NullPointerException("场次信息为空!");
		}
		if (pageObject.getPageSize() < 1) {
			// 分页信息
			throw new NullPointerException("分页信息为空!");
		}
		return new JsonResult(manageAuctionsService.FindFieldCarsId(auctionCarEntity, pageObject));
	}

	/** 拍卖-发布管理-添加车辆-查询场次当前车辆 */
	@RequestMapping("doFindFieldCars")
	@ResponseBody
	public JsonResult doFindFieldCars(AuctionCarEntity auctionCarEntity) {
		return new JsonResult(manageAuctionsService.FindFieldCars(auctionCarEntity));
	}

	/** 拍卖-发布管理-添加车辆-修改场次车辆 */
	@RequestMapping("doUpdateFieldCars")
	@ResponseBody
	public JsonResult doUpdateFieldCars(HttpServletRequest request) {
		String string = request.getParameter("datas");
		if (string == null || string.equals("")) {
			throw new NullPointerException("未获取到数据!");
		}
		List<TCarBasisInfoEntity> tList = new ArrayList<TCarBasisInfoEntity>();
		List<AuctionCarEntity> aList = new ArrayList<AuctionCarEntity>();
		JSONArray jsonArray = JSONArray.fromObject(string);
		Iterator<Object> it = jsonArray.iterator();
		while (it.hasNext()) {
			TCarBasisInfoEntity tCarBasisInfoEntity = new TCarBasisInfoEntity();
			AuctionCarEntity auctionCarEntity = new AuctionCarEntity();
			JSONObject ob = (JSONObject) it.next();
			tCarBasisInfoEntity.setId(ob.getInt("carId"));
			tCarBasisInfoEntity.setAskingPrice((float) ob.getDouble("askingPrice"));
			auctionCarEntity.setAuctionId(ob.getInt("auctionId"));
			auctionCarEntity.setCarId(ob.getInt("carId"));
			auctionCarEntity.setSort(ob.getInt("sort"));
			tList.add(tCarBasisInfoEntity);
			aList.add(auctionCarEntity);
		}
		// Date
		// auctionTime=manageAuctionsService.FindFieldTime(aList.get(0).getAuctionId());
		// long time=System.currentTimeMillis()+(2*60*60*1000);
		// if(time>=auctionTime.getTime()) {
		// throw new NullPointerException("追加车辆需提前2小时更改!");
		// }

		for (TCarBasisInfoEntity t : tList) {
			if (t.getId() < 1) {
				throw new NullPointerException("车辆id为空!");
			}
			if ((t.getAskingPrice()*10000) < 1) {
				throw new NullPointerException("起拍价设置为空!");
			}
		}
		for (AuctionCarEntity a : aList) {
			if (a.getAuctionId() < 1) {
				throw new NullPointerException("场次ID为空!");
			}
			if (a.getCarId() < 1) {
				throw new NullPointerException("车辆ID为空!");
			}
		}
		// 修改车辆起拍价
		// 删除场次关系表中的车辆信息
		// 添加场次关系表中的车辆信息
		return new JsonResult(manageAuctionsService.UpdateFieldCars(tList, aList));
	}

	/** 拍卖-发布管理-添加车辆-修改起拍价 */
	@RequestMapping("doUpdatePrice")
	@ResponseBody
	public JsonResult doUpdatePrice(TCarBasisInfoEntity tCarBasisInfoEntity) {
		if (tCarBasisInfoEntity.getId() < 1) {
			throw new NullPointerException("车辆id为空!");
		}
		if (tCarBasisInfoEntity.getAskingPrice() < 1) {
			throw new NullPointerException("起拍价错误!");
		}
		int i = manageAuctionsService.UpdatePrice(tCarBasisInfoEntity);
		if (i != 1) {
			throw new NullPointerException("更新失败!");
		}
		return new JsonResult("更新成功!");
	}

	/** 拍卖-发布管理-添加车辆-查询车辆列表 */
	@RequestMapping("doFindCars")
	@ResponseBody
	public JsonResult doFindCars() {
		return new JsonResult(manageAuctionsService.FindCars());
	}

	/** 查询拍卖纪录 */
	@RequestMapping("doFindAuctions")
	@ResponseBody
	public JsonResult doFindAuctions(AuctionCarEntity auctionCarEntity, PageObject pageObject) {
		if (auctionCarEntity.getAuctionId() < 1) {
			throw new NullPointerException("场次id为空!");
		}
		if (auctionCarEntity.getCarId() < 1) {
			throw new NullPointerException("车辆id为空!");
		}
		if (pageObject.getPageSize() < 1) {
			// 分页信息
			throw new NullPointerException("分页信息为空!");
		}
		return new JsonResult(manageAuctionsService.FindAuctions(auctionCarEntity, pageObject));
	}

	/** 查询拍卖场次 */
	@RequestMapping("doFindField")
	@ResponseBody
	public JsonResult doFindField(AuctionSessionEntity auctionSessionEntity) {
		if (auctionSessionEntity.getAuctionDate() == null) {
			throw new NullPointerException("场次时间为空!");
		}
		List<Map> list = manageAuctionsService.FindField(auctionSessionEntity);
		return new JsonResult(list);
	}

	/** 新建拍卖场次 */
	@RequestMapping("doNewField")
	@ResponseBody
	public JsonResult doNewField(AuctionSessionEntity auctionSessionEntity) {
		// 场次创建时间
		if (auctionSessionEntity.getAuctionDate() == null) {
			throw new NullPointerException("场次创建时间为空!");
		}
		// 场次开始时间
		if (auctionSessionEntity.getAuctionStart() == null) {
			throw new NullPointerException("场次开始时间为空!");
		}
		// 场次开始时间必须大于当前时间
		if (auctionSessionEntity.getAuctionStart().getTime() < System.currentTimeMillis()) {
			throw new NullPointerException("场次开始时间必须大于当前服务器时间!");
		}
		if (manageAuctionsService.NewField(auctionSessionEntity) != 1) {
			throw new NullPointerException("新建场次失败,插入数据异常!");
		}

		return new JsonResult("新建场次完成!");
	}
}

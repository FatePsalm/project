package cn.dingd.dd.auction.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.auction.service.SecondsService;
import cn.dingd.dd.common.entity.SecondKillBill;
import cn.dingd.dd.common.web.JsonResult;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年1月16日 上午10:45:51 类说明 拍卖-秒杀
 */
@Controller
@CrossOrigin
@RequestMapping("/Seconds/")
public class SecondsController {
	@Resource
	private SecondsService secondsService;

	/** 拍卖-秒杀-秒杀中 */
	@RequestMapping("doCarSeconds")
	@ResponseBody
	public JsonResult doCarSeconds(Integer carId, Integer userId) {
		if (carId == null || carId < 1) {
			throw new NullPointerException("车辆ID为空!");
		}
		if (userId == null || userId < 1) {
			return new JsonResult(new Exception("用户ID为空!"),1404);
		}
		SecondKillBill secondKillBill = secondsService.findCarId(carId);
		// 当前时间
		Long date = secondsService.getCurrentTime();
		// 开始秒杀时间
		Long StartTime = secondKillBill.getStartTime().getTime();
		if (StartTime >= date) {
			throw new NullPointerException("秒杀未开始!");
		}
		Integer results;
		try {
			results = secondsService.carSeconds(carId, userId);
		} catch (Exception e) {			
			e.printStackTrace();
			return new JsonResult(new Exception("秒杀失败或已被其他用户购买！"),1003);
		}
		return new JsonResult(results);
	}

	/** 拍卖-秒杀-查询车辆详细 */
	@RequestMapping("doFindCarInfo")
	@ResponseBody
	public JsonResult doFindCarInfo(Integer carId) {
		if (carId == null || carId < 1) {
			throw new NullPointerException("车辆ID为空!");
		}
		try {
			return new JsonResult(secondsService.findCarInfo(carId));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(e,1003);
		}
	}

	/** 拍卖-秒杀-获取车辆列表 */
	@RequestMapping("doSecondsList")
	@ResponseBody
	public JsonResult doSecondsList() {
		return new JsonResult(secondsService.SecondsList());
	}
}

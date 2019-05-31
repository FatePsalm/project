package cn.dingd.dd.management.controller;
/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 上午11:06:27
* 类说明
* 管理端车辆管理
*/

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.service.ManageStockService;

@Controller
@CrossOrigin
@RequestMapping("/mgmtKc/")
public class ManageStockController {
	@Resource
	private ManageStockService manageStockService;
	@Resource
	private CommonService commonService;

	/** 管理端-拍卖管理-库存车辆查询 */
	@RequestMapping("doFindStock")
	@ResponseBody
	public JsonResult doFindStock(CheckQueryEntity checkQueryEntity, PageObject pageObject) {
		System.out.println(checkQueryEntity);
		if (checkQueryEntity.getCreateTimeStart() != null && checkQueryEntity.getCreateTimeOver() != null) {
			if (checkQueryEntity.getCreateTimeStart().getTime() > checkQueryEntity.getCreateTimeOver().getTime()) {
				// 查询开始时间必须小于结束时间
				throw new NullPointerException("查询开始时间必须小于结束时间!");
			}
		}
		if (checkQueryEntity.getCarState() < 1) {
			// 车辆状态判断
			throw new NullPointerException("车辆状态为空!");
		}
		if (pageObject.getPageSize() < 1) {
			// 请传入分页信息
			throw new NullPointerException("请传入分页信息!");
		}
		return new JsonResult(manageStockService.FindStock(checkQueryEntity, pageObject));
	}

	/** 管理端-拍卖管理-库存车辆查询 -修改车辆状态 */
	@RequestMapping("doUpdateCarState")
	@ResponseBody
	public JsonResult doUpdateCarState(TCarBasisInfoEntity tCarBasisInfoEntity) {
		if (tCarBasisInfoEntity.getId() < 1) {
			throw new NullPointerException("车辆id为空!");
		}
		if (tCarBasisInfoEntity.getCarState() < 1) {
			throw new NullPointerException("车辆状态为空!");
		}
		if (commonService.UpdateCarState(tCarBasisInfoEntity) != 1) {
			throw new NullPointerException("车辆状态修改失败!");
		}
		return new JsonResult("车辆状态修改成功!");
	}
}

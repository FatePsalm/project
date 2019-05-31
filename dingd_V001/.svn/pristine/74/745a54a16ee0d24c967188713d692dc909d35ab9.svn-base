package cn.dingd.dd.management.controller;
/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月27日 上午11:06:27
* 类说明
* 车辆详情
*/

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.common.entity.TCarBasisInfoEntity;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.management.service.ManageParticularsService;

@Controller
@CrossOrigin
@RequestMapping("/mgmtPa/")
public class ManageParticularsController {
	@Resource
	private ManageParticularsService manageParticularsService;

	/** 管理端-车辆详细-车辆详细 */
	@RequestMapping("doFindDetailed")
	@ResponseBody
	public JsonResult doFindDetailed(Integer id) {
		if (id == null || id < 1) {
			throw new NullPointerException("ID为空!");
		}
		return new JsonResult(manageParticularsService.FindDetailed(id));
	}

	/** 管理端-车辆详细-电器及附件 */
	@RequestMapping("doFindAttachment")
	@ResponseBody
	public JsonResult doFindAttachment(Integer id) {
		if (id == null || id < 1) {
			throw new NullPointerException("ID为空!");
		}
		return new JsonResult(manageParticularsService.FindAttachment(id));
	}

	/** 管理端-车辆详细-隐性损伤 */
	@RequestMapping("doFindRecessive")
	@ResponseBody
	public JsonResult doFindRecessive(Integer id) {
		if (id == null || id < 1) {
			throw new NullPointerException("ID为空!");
		}
		return new JsonResult(manageParticularsService.FindRecessive(id));
	}

	/** 管理端-车辆详细-显性损伤 */
	@RequestMapping("doFindDominant")
	@ResponseBody
	public JsonResult doFindDominant(Integer id) {
		if (id == null || id < 1) {
			throw new NullPointerException("ID为空!");
		}
		return new JsonResult(manageParticularsService.FindDominant(id));
	}

	/** 管理端-车辆详细-过户资料 */
	@RequestMapping("doFindRecord")
	@ResponseBody
	public JsonResult doFindRecord(Integer id) {
		if (id == null || id < 1) {
			throw new NullPointerException("ID为空!");
		}
		return new JsonResult(manageParticularsService.FindRecord(id));
	}

	/** 管理端-车辆详细-特写/证件及其他单据 */
	@RequestMapping("doFindPicture")
	@ResponseBody
	public JsonResult doFindPicture(Integer id, Integer imgType) {
		if (id == null || id < 1) {
			throw new NullPointerException("ID为空!");
		}
		return new JsonResult(manageParticularsService.FindPicture(id, imgType));
	}

	/** 管理端-车辆详细-流拍信息 */
	@RequestMapping("doFindAuction")
	@ResponseBody
	public JsonResult doFindAuction(Integer id) {
		if (id == null || id < 1) {
			throw new NullPointerException("ID为空!");
		}
		return new JsonResult(manageParticularsService.FindAuction(id));
	}

	/** 管理端-车辆详细-车主信息/联系人信息/检测师信息 */
	@RequestMapping("doFindCarPerson")
	@ResponseBody
	public JsonResult doFindCarPerson(Integer id) {
		if (id == null || id < 1) {
			throw new NullPointerException("ID为空!");
		}
		Map map = manageParticularsService.FindCarPerson(id);
		if (map == null) {
			throw new NullPointerException("车主信息/联系人信息/检测师信息不存在!");
		}
		return new JsonResult(map);
	}

	/** 管理端-车辆详细-车辆基本信息 */
	@RequestMapping("doCarInfo")
	@ResponseBody
	public JsonResult doCarInfo(TCarBasisInfoEntity tCarBasisInfoEntity) {
		// 判断id时候为空
		if (tCarBasisInfoEntity.getId() < 1) {
			throw new NullPointerException("ID为空!");
		}
		if (manageParticularsService.CarInfo(tCarBasisInfoEntity) == null) {
			throw new NullPointerException("获取车辆信息失败!");
		}
		return new JsonResult(manageParticularsService.CarInfo(tCarBasisInfoEntity));
	}
}

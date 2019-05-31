package cn.dingd.dd.management.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.service.ManageAuserService;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年1月6日 上午11:27:06 类说明 管理端-人员管理-A端用户
 */
@Controller
@CrossOrigin
@RequestMapping("/mgmtAuser/")
public class ManageAuserController {
	@Resource
	private ManageAuserService manageAuserService;

	/** 管理端-人员管理-A端用户 */
	@RequestMapping("doFindAuser")
	@ResponseBody
	public JsonResult doFindAuser(CheckQueryEntity checkQueryEntity, PageObject pageObject) {
		if (checkQueryEntity.getStartTime() != null && checkQueryEntity.getOverTime() != null) {
			if (checkQueryEntity.getStartTime().getTime() > checkQueryEntity.getOverTime().getTime()) {
				throw new NullPointerException("开始时间需要小于结束时间!");
			}
		}
		if (pageObject.getPageSize() < 1) {
			throw new NullPointerException("查询信息或分页信息为空!");
		}
		return new JsonResult(manageAuserService.FindAuser(checkQueryEntity, pageObject));
	}
}

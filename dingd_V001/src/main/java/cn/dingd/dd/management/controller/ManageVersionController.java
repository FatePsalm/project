package cn.dingd.dd.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.management.service.ManageVersionService;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年4月17日 上午9:37:19
* 类说明
* 版本控制,根据版本控制页面显示
*/
@RestController
@CrossOrigin
@RequestMapping("/version/")
public class ManageVersionController  {
	@Autowired
	private ManageVersionService manageVersionService;
	/**获取版本显示信息*/
	@RequestMapping("getVersion")
	public JsonResult getVersion(String version) {
		if (version==null) {
			throw new NullPointerException("传入参数未设置!");
		}
		return new JsonResult(manageVersionService.getVersion(version));
	}
	
}

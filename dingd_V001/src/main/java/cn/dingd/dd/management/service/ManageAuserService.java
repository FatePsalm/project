package cn.dingd.dd.management.service;

import java.util.Map;

import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.web.PageObject;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年1月6日 上午11:28:10
* 类说明
* 管理端-人员管理-A端用户
*/
public interface ManageAuserService {
	/** 管理端-人员管理-A端用户 */
	public Map<String, Object> FindAuser(CheckQueryEntity checkQueryEntity, PageObject pageObject);
}

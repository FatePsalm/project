package cn.dingd.dd.management.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.dao.ManageAuserDao;
import cn.dingd.dd.management.service.ManageAuserService;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年1月6日 上午11:28:30
* 类说明
* 管理端-人员管理-A端用户
*/
@Service
public class ManageAuserServiceImpl implements ManageAuserService{
	@Resource
	private ManageAuserDao manageAuserDao;
	/** 管理端-人员管理-A端用户 */
	public Map<String, Object> FindAuser(CheckQueryEntity checkQueryEntity, PageObject pageObject){
		List<Map<String, Object>>  list=manageAuserDao.FindAuser(checkQueryEntity, pageObject);
		pageObject.setRowCount(manageAuserDao.FindAuserPageCount(checkQueryEntity));
		Map<String, Object> map=new HashedMap();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
}

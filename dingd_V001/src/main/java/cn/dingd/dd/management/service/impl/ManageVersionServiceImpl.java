package cn.dingd.dd.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dingd.dd.common.entity.VersionEntity;
import cn.dingd.dd.management.dao.ManageVersionDao;
import cn.dingd.dd.management.service.ManageVersionService;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年12月13日 下午3:29:31 类说明 版本控制,根据版本控制页面显示
 */
@Service
public class ManageVersionServiceImpl implements ManageVersionService {
	@Autowired
	private ManageVersionDao manageVersionDao;
	/**获取版本显示信息*/
	@Override
	public VersionEntity getVersion(String version) {
		// 2018年4月17日TODO 
		VersionEntity value=null;
		try {
			value = manageVersionDao.getVersion(version);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NullPointerException("数据库查询异常!"); 
		}
		return value;
	}
	
}

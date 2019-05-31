package cn.dingd.dd.management.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.web.PageObject;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年1月6日 上午11:29:09
* 类说明
* 管理端-人员管理-A端用户
*/
public interface ManageAuserDao {
	/** 管理端-人员管理-A端用户总数 */
	public int FindAuserPageCount(@Param("checkQueryEntity")CheckQueryEntity checkQueryEntity);
	/** 管理端-人员管理-A端用户 */
	public List<Map<String, Object>> FindAuser(@Param("checkQueryEntity")CheckQueryEntity checkQueryEntity, @Param("pageObject")PageObject pageObject);
}

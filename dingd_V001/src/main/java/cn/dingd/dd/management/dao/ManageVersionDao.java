package cn.dingd.dd.management.dao;
/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年4月17日 上午9:47:32
* 类说明
* 版本控制,根据版本控制页面显示
*/

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.VersionEntity;

public interface ManageVersionDao {
	/**获取版本显示信息*/
	public VersionEntity getVersion(@Param("version")String version);
}

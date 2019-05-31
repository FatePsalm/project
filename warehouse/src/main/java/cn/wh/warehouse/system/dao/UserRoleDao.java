package cn.wh.warehouse.system.dao;

import org.apache.ibatis.annotations.Param;

import cn.wh.warehouse.common.dao.BaseDao;
import cn.wh.warehouse.system.entity.UserRole;


public interface UserRoleDao extends BaseDao<UserRole> {

	/**
	 * 判断用户角色表中是否存在用户占用此角�?
	 * @param roleId
	 */
	int isExist(@Param("roleId")Integer roleId);

}

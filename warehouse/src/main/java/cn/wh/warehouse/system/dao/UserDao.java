package cn.wh.warehouse.system.dao;

import java.util.List;
import java.util.Map;

import cn.wh.warehouse.common.dao.BaseDao;
import cn.wh.warehouse.system.entity.User;


public interface UserDao extends BaseDao<User> {

	int isExist(String username);

	/**
	 * 查询用户得权�?
	 * @param userId
	 */
	List<String> findPermission(Integer userId);

	/**
	 * 查询用户可见的菜�?
	 * @param id
	 * @return
	 */
	List<Map<String,Object>> menuList(Integer id);

	

}

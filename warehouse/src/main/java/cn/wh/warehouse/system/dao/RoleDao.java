package cn.wh.warehouse.system.dao;
import java.util.List;
import java.util.Map;

import cn.wh.warehouse.common.dao.BaseDao;
import cn.wh.warehouse.system.entity.Role;



public interface RoleDao extends BaseDao<Role> {

	List<Map<String, Object>> findRoleList();

	

}

package cn.wh.warehouse.system.service;

import java.util.List;
import java.util.Map;

import cn.wh.warehouse.common.web.PageObject;
import cn.wh.warehouse.system.entity.Role;



public interface RoleService {

	Map<String, Object> findObjects(Role role, PageObject pageObj);

	List<Map<String, Object>> loadMenuTree();

	void save(Role role,String menuIdList);

	Map<String, Object> findRoleById(Integer roleId);

	void updateRole(Role role,String menuIdList);

	void deleteRole(Integer roleId);

}

package cn.dingd.dd.biz.backgroud.service;

import java.util.List;

import cn.dingd.dd.biz.common.entity.MenuInfo;
import cn.dingd.dd.biz.common.entity.Role;
import cn.dingd.dd.biz.common.view.RoleView;

/**
* @author ZC
* @date 2018年4月20日下午2:42:33
* 角色管理
*/
public interface RoleManageService {

	/**
	 * 添加一个角色
	 * @param role 角色对象
	 * @param permissionList 权限集合
	 */
	void addRole(RoleView role);
	
	/**
	 * 获取所有角色
	 * @return
	 */
	List<Role> roles( String quaryParam);
	
	/**
	 * 跟新角色
	 * @param role
	 */
	void updateRole(RoleView role);
	
	/**
	 * 查询角色
	 * @param roleId
	 * @return
	 */
	Role getRoleById(Integer roleId);
	
	/**
	 * 检验是否存在该角色名
	 * @param roleName
	 * @return true 存在；false 不存在
	 */
	Boolean roleIsExist(String roleName);
	
	/**
	 * 启停角色
	 * @param roleId
	 */
	void disableorEnableRole(Integer roleId);
	
	/**
	 * 是否为内置角色
	 * @return
	 */
	Boolean isInlayRole(Integer roleId);
}

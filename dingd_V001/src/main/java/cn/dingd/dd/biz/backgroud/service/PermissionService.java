package cn.dingd.dd.biz.backgroud.service;
/**
* @author ZC
* @date 2018年4月24日上午10:17:46
*/

import java.util.List;

import cn.dingd.dd.biz.common.entity.MenuInfo;

public interface PermissionService {
	
	/**
	 * 权限列表
	 * @return
	 */
	List<MenuInfo> menuList();
	
	/**
	 * 用户权限
	 * @return
	 */
	List<MenuInfo>  userPermission(Integer accountId);
	
	/**
	 * 权限集合
	 */
	List<MenuInfo> permissionList();
	
	/**
	 * 根据用户id获取
	 * @param accountId
	 * @return
	 */
	List<MenuInfo> permissionListByUser(Integer accountId);
}

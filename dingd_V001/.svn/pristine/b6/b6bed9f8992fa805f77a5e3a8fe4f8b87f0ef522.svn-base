package cn.dingd.dd.biz.backgroud.controller;

import javax.enterprise.inject.New;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dingd.dd.biz.backgroud.service.RoleManageService;
import cn.dingd.dd.biz.common.entity.Role;
import cn.dingd.dd.biz.common.view.RoleView;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.JsonResult;

/**
* @author ZC
* @date 2018年4月23日上午11:27:20
* 角色管理控制器
*/
@RestController
@CrossOrigin
@RequestMapping("roleManage")
public class RoleManageController {
	
	@Autowired
	private RoleManageService roleManageService;
	
	/**
	 * 获取角色列表
	 * @param quaryParam
	 * @return
	 */
	@RequestMapping("roleList")
	public JsonResult roleList(String quaryParam) {
		try {
			return new JsonResult(roleManageService.roles(quaryParam));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("获取角色信息失败"));
		}
	}
	
	/**
	 * 新增角色
	 * @param quaryParam
	 * @return
	 */
	@RequestMapping("addRole")
	public JsonResult addRole(RoleView role) {
		try {
			try {
				checkRoleInfo(role);
			} catch (Exception e) {
				return new JsonResult(e);
			}
			roleManageService.addRole(role);
			return new JsonResult("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult("添加失败");
		}
	}
	
	/**
	 * 编辑角色
	 * @param quaryParam
	 * @return
	 */
	@RequestMapping("editRole")
	public JsonResult updateRole(RoleView role) {
		try {
			try {
				checkRoleInfo(role);
			} catch (Exception e) {
				return new JsonResult(e);
			}
			roleManageService.updateRole(role);
			return new JsonResult("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult("添加失败");
		}
	}	
	
	/**
	 * 角色信息
	 * @param roleId
	 * @return
	 */
	@RequestMapping("role")
	public JsonResult roleInfo(Integer roleId) {
		try {
			return new JsonResult(roleManageService.getRoleById(roleId));
		} catch (Exception e) {
			return new JsonResult(new Exception("获取信息失败"));
		}
		
	}
	
	/**
	 * 启停角色
	 * @param roleId
	 * @return
	 */
	@RequestMapping("overturnState")
	public JsonResult disableorEnableRole(Integer roleId) {
		try {
			if (roleManageService.isInlayRole(roleId)) {
				return new JsonResult(new Exception("该为内置角色"));
			}
			roleManageService.disableorEnableRole(roleId);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(new Exception("修改失败"));
		}
		return  new JsonResult("修改成功");
	}
	
	/**
	 * 校验角色信息
	 * @throws Exception 
	 */
	public void checkRoleInfo(RoleView role) throws Exception {
		if (!StringUtils.isNotNullApp(role.getRoleName())) {
			throw new Exception("角色名为空");
		}
		if (!StringUtils.isNotNullApp(role.getRoleDesc())) {
			throw new Exception("角色描述为空");
		}
		if (role.getId()!=null) {
			try {
				Role roleById = roleManageService.getRoleById(role.getId());
				if (roleById!=null && roleById.getRoleName().equals(role.getRoleName())) {
					return;
				}
			} catch (Exception e) {
				throw new Exception("获取数据失败");
			}
		}
		if (roleManageService.roleIsExist(role.getRoleName())) {	
			throw new Exception("该角色名已存在");
		}
	}
}

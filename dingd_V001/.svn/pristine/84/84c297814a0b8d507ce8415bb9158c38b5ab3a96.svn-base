package cn.dingd.dd.biz.backgroud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dingd.dd.biz.backgroud.dao.AccountRoleMapper;
import cn.dingd.dd.biz.backgroud.dao.MenuInfoMapper;
import cn.dingd.dd.biz.backgroud.dao.MenuRoleMapper;
import cn.dingd.dd.biz.backgroud.dao.RoleMapper;
import cn.dingd.dd.biz.backgroud.service.RoleManageService;
import cn.dingd.dd.biz.common.entity.AccountRole;
import cn.dingd.dd.biz.common.entity.AccountRoleExample;
import cn.dingd.dd.biz.common.entity.MenuInfo;
import cn.dingd.dd.biz.common.entity.MenuRole;
import cn.dingd.dd.biz.common.entity.MenuRoleExample;
import cn.dingd.dd.biz.common.entity.Role;
import cn.dingd.dd.biz.common.entity.RoleExample;
import cn.dingd.dd.biz.common.view.RoleView;

import cn.dingd.dd.common.shiro.realm.BizBackGroundRealm;


/**
* @author ZC
* @date 2018年4月23日上午11:31:15
*/
@Service
public class RoleManageServiceImpl implements RoleManageService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private MenuRoleMapper menuRoleMapper;
	
	@Autowired
	private MenuInfoMapper menuInfoMapper;
	
	@Autowired
	private AccountRoleMapper accountRoleMapper;
	
	@Autowired
	private BizBackGroundRealm realm;
	
	@Override
	public void addRole(RoleView role) {
		Integer integer = roleMapper.addNewRole(role);
		if (integer==1) {
			List<MenuRole> menuRoles = new ArrayList<>();
			String[] permissionList = role.getPermissionList().split(",");
			for (int i = 0; i < permissionList.length; i++) {
				MenuRole menuRole = new MenuRole();
				menuRole.setMenuId(Integer.valueOf(permissionList[i]));
				menuRole.setRoleId(role.getId());
				menuRoles.add(menuRole);
			}
			menuRoleMapper.addMenuRoleList(menuRoles);
		}
	}
	
	@Override
	public void updateRole(RoleView role) {
		Role record = new Role();
		record.setId(role.getId());
		record.setRoleName(role.getRoleName());
		record.setRoleDesc(role.getRoleDesc());
		int integer = roleMapper.updateByPrimaryKeySelective(record);
		if (integer==1) {
			List<MenuRole> menuRoles = new ArrayList<>();
			String[] permissionList = role.getPermissionList().split(",");
			for (int i = 0; i < permissionList.length; i++) {
				MenuRole menuRole = new MenuRole();
				menuRole.setMenuId(Integer.valueOf(permissionList[i]));
				menuRole.setRoleId(role.getId());
				menuRoles.add(menuRole);
			}
			AccountRoleExample accountRoleExample = new AccountRoleExample();
			accountRoleExample.createCriteria().andRoleIdEqualTo(role.getId());
			List<AccountRole> selectByExample = accountRoleMapper.selectByExample(accountRoleExample);
			List<Integer> collect = selectByExample.stream().map(AccountRole::getStaffId).collect(Collectors.toList());
			realm.clearUserAuthByUserId(collect);
			MenuRoleExample menuRoleExample = new MenuRoleExample();
			menuRoleExample.createCriteria().andRoleIdEqualTo(role.getId());
			menuRoleMapper.deleteByExample(menuRoleExample);
			menuRoleMapper.addMenuRoleList(menuRoles);
		}
		
	}
	
	@Override
	public List<Role> roles(String quaryParam) {
		if (quaryParam != null && "".equals(quaryParam.trim())) {
			quaryParam = null;
		}
		return roleMapper.getRolessByQuaryParam(quaryParam);
	}

	@Override
	public Boolean roleIsExist(String roleName) {
		RoleExample roleExample = new RoleExample();
		roleExample.createCriteria().andRoleNameEqualTo(roleName);
		List<Role> selectByExample = roleMapper.selectByExample(roleExample);
		if (selectByExample!=null&&selectByExample.size()>1) {
			return true;
		}
		return false;
	}

	@Override
	public Role getRoleById(Integer roleId) {
		List<Integer> permissionList = menuInfoMapper.selectPermissionByRole(roleId);
		Role role = roleMapper.selectByPrimaryKey(roleId);	
		role.setPermissionList(permissionList);
		return role;
	}

	@Override
	public void disableorEnableRole(Integer roleId) {
		roleMapper.disableorEnableRole(roleId);
	}

	@Override
	public Boolean isInlayRole(Integer roleId) {
		Integer inlay= roleMapper.selectInlayById(roleId);
		if (inlay==1) {
			return true;
		}
		return false;
	}

	
}

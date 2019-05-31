package cn.dingd.dd.biz.backgroud.service.impl;

import cn.dingd.dd.biz.backgroud.dao.MenuInfoMapper;
import cn.dingd.dd.biz.backgroud.service.PermissionService;
import cn.dingd.dd.biz.common.entity.MenuInfo;
import cn.dingd.dd.biz.common.entity.MenuInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ZC
 * @date 2018年4月24日上午10:19:50 系统权限service
 */
@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private MenuInfoMapper menuInfoMapper;

	@Override
	public List<MenuInfo> menuList() {
		MenuInfoExample menuInfoExample = new MenuInfoExample();
		List<MenuInfo> menuInfos = menuInfoMapper.selectByExample(menuInfoExample);
		return menuTree(menuInfos);
	}

	@Override
	public List<MenuInfo> userPermission(Integer accountId) {
		if (accountId == null) {
			throw new NullPointerException("用户id为空");
		}
		List<MenuInfo> menuInfos = menuInfoMapper.getMenuInfosByAccount(accountId);
		return menuTree(menuInfos);
	}

	@Override
	public List<MenuInfo> permissionList() {
		MenuInfoExample menuInfoExample = new MenuInfoExample();
		return menuInfoMapper.selectByExample(menuInfoExample);
	}

	@Override
	public List<MenuInfo> permissionListByUser(Integer accountId) {
		return menuInfoMapper.getMenuInfosByAccount(accountId);
	}

	public static void recursionSetChildren(
			List<MenuInfo> menuList, Set<Integer> keySet, Map<Integer, List<MenuInfo>> collect) {
		for (MenuInfo menuInfo : menuList) {
			if (keySet.contains(menuInfo.getId())) {
				menuInfo.setChildren(collect.get(menuInfo.getId()));
				menuInfo.getChildren().sort((o1, o2) -> o1.getSort() - o2.getSort());
				recursionSetChildren(menuInfo.getChildren(), keySet, collect);
			}
		}
	}

	private List<MenuInfo> menuTree(List<MenuInfo> menuInfos) {
		Map<Integer, List<MenuInfo>> collect =
				menuInfos.stream().collect(Collectors.groupingBy(MenuInfo::getParentId));
		List<MenuInfo> menus = collect.get(0);
		if (menuInfos.size() < 1) {
			return null;
		}
		menus.sort((o1, o2) -> o1.getSort() - o2.getSort());
		Set<Integer> keySet = collect.keySet();
		recursionSetChildren(menus, keySet, collect);
		return menus;
	}
}

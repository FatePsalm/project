package cn.wh.warehouse.system.service;

import java.util.List;
import java.util.Map;

import cn.wh.warehouse.system.entity.Menu;


public interface MenuService {

	List<Map<String, Object>> findObjects();

	List<Map<String, Object>> findTreeData();

	void save(Menu entity);

	Map<String, Object> findMenuById(Integer menuId);

	void updateMenu(Menu entity);

	void deleteMenu(Integer menuId);

}

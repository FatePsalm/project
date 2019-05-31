package cn.wh.warehouse.system.dao;

import java.util.List;
import java.util.Map;

import cn.wh.warehouse.common.dao.BaseDao;
import cn.wh.warehouse.system.entity.Menu;




public interface MenuDao extends BaseDao<Menu> {

	List<Map<String, Object>> findTreeData();

	int hasChild(Integer menuId);

}

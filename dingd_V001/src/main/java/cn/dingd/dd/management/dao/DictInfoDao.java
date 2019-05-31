package cn.dingd.dd.management.dao;

import cn.dingd.dd.common.entity.DictInfoEntity;
/**
 * 数据字典
 * @author XCD
 *
 */
public interface DictInfoDao {

	/**
	 *添加数据字典
	 * @param dictInfo
	 * @return
	 */
	public int addDictInfo(DictInfoEntity dictInfo);
	/**
	 * 修改数据字典
	 * @param dictInfo
	 * @return
	 */
	public int updDictInfo(DictInfoEntity dictInfo);
	/**
	 * 删除数据字典
	 * @param dictInfo
	 * @return
	 */
	public int delDictInfo(int id);
	
	
	
}

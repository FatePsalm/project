package cn.dingd.dd.search.service;

import cn.dingd.dd.common.entity.CheckQueryEntity;
import cn.dingd.dd.common.web.JsonResult;
import cn.dingd.dd.common.web.PageObject;

/**
* @author ZC
* @date 上午10:20:30
*/
public interface CarInfoSearchService {

	/**
	 * 导入车辆数据到solr索引库
	 * @return
	 */
	String importCarsToSolr();
	
	/**
	 *搜索车辆
	 * @param checkQueryEntity
	 * @param pageObject
	 * @return
	 */
	JsonResult searchCar(CheckQueryEntity checkQueryEntity, PageObject pageObject);
}

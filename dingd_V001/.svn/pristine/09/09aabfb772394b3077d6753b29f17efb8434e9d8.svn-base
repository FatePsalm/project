package cn.dingd.dd.biz.backgroud.service;

import java.util.List;

/**
* @author ZC
* @date 2018年4月28日上午10:31:53
* 商家公用service
*/
public interface BizCommonService {
	
	/**
	 * 数据范围中的员工id
	 * @param orgId 组织id
	 * @return
	 */
	List<Integer> staffIdsInDataRange(List<Integer> orgId);
	
	/**
	 * 是否为区域负责人
	 * @return
	 */
	Boolean isAreaManager(Integer orgId,Integer staffId);
	
	/**
	 * 员工对应的数据范围
	 * @param staffId
	 * @return
	 */
	List<Integer> orgIdsInStaff(Integer staffId);
}

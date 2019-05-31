package cn.dingd.dd.auction.dao;

import cn.dingd.dd.common.entity.AgentsEntity;
/**
 * 提车代理
 * @author XCD
 *
 */
public interface AgentsDao {

	/**
	 * 添加代理人信息
	 * @param agents
	 * @return
	 */
	public int addAgent(AgentsEntity agents);
	/**
	 * 修改代理人信息
	 * @param agents
	 * @return
	 */
	public int updAgent(AgentsEntity agents);
}

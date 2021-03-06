package cn.dingd.dd.biz.backgroud.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.biz.common.entity.ConfigurationInfoEntity;
import cn.dingd.dd.common.web.PageObject;

/**
 * 系统配置项设置
 * @author XCD
 *
 */
public interface ConfigurationInfoService {
	/**
	 * 添加配置项
	 * @param configurationInfoEntity
	 * @return
	 */
	public Integer addConfiguration(ConfigurationInfoEntity configurationInfoEntity)throws Exception;
	/**
	 * 修改配置项
	 * @param configurationInfoEntity
	 * @return
	 */
	public Integer updConfiguration(ConfigurationInfoEntity configurationInfoEntity)throws Exception;
	
	/**
	 * 获取配置项
	 * @param id
	 * @return
	 */
	public ConfigurationInfoEntity getConfiguration(int id)throws Exception;
	/**
	 * 更改配置项状态
	 * @param id
	 * @param status
	 * @return
	 */
    public Integer setConfiguration(@Param("id") int id,@Param("status") int status)throws Exception;
    /**
     * 获取配置项
     * @return
     */
    public List<ConfigurationInfoEntity>  queryConfigurationInfos(PageObject pageObject)throws Exception;
}

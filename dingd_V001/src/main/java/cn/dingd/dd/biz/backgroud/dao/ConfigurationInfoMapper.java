package cn.dingd.dd.biz.backgroud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.biz.common.entity.ConfigurationInfoEntity;
import cn.dingd.dd.common.web.PageObject;
/**
 * 配置项
 * @author XCD
 *
 */
public interface ConfigurationInfoMapper {

	/**
	 * 添加配置项
	 * @param configurationInfoEntity
	 * @return
	 */
	public Integer addConfiguration(ConfigurationInfoEntity configurationInfoEntity);
	/**
	 * 修改配置项
	 * @param configurationInfoEntity
	 * @return
	 */
	public Integer updConfiguration(ConfigurationInfoEntity configurationInfoEntity);
	
	/**
	 * 获取配置项
	 * @param id
	 * @return
	 */
	public ConfigurationInfoEntity getConfiguration(int id);
	/**
	 * 更改配置项状态
	 * @param id
	 * @param status
	 * @return
	 */
    public Integer setConfiguration(@Param("id") int id,@Param("status") int status);
    /**
     * 获取配置项
     * @return
     */
    public List<ConfigurationInfoEntity>  queryConfigurationInfos(@Param("pageObject")PageObject pageObject);
    
}

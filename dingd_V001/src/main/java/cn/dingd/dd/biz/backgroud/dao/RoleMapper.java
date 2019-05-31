package cn.dingd.dd.biz.backgroud.dao;

import cn.dingd.dd.biz.common.entity.Role;
import cn.dingd.dd.biz.common.entity.RoleExample;
import cn.dingd.dd.biz.common.view.RoleView;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    /**
     * 查询角色列表
     * @param quaryParam
     * @return
     */
    List<Role> getRolessByQuaryParam(@Param("quaryParam")String quaryParam);
    
    /**
     * 添加一个角色
     * @param role
     * @return
     */
	Integer addNewRole(RoleView role);
	
	/**
	 * 启停角色
	 * @param roleId
	 */
	void disableorEnableRole(Integer roleId);
	
	/**
	 * 查询角色内置状态
	 * @param roleId
	 * @return
	 */
	Integer selectInlayById(Integer roleId);
}
package cn.dingd.dd.biz.backgroud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.biz.common.entity.MenuRole;
import cn.dingd.dd.biz.common.entity.MenuRoleExample;

public interface MenuRoleMapper {
    int countByExample(MenuRoleExample example);

    int deleteByExample(MenuRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    List<MenuRole> selectByExample(MenuRoleExample example);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MenuRole record, @Param("example") MenuRoleExample example);

    int updateByExample(@Param("record") MenuRole record, @Param("example") MenuRoleExample example);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);
    
    /**
     * 添加角色菜单集合
     * @param menuRoles
     */
	void addMenuRoleList(List<MenuRole> menuRoles);
}
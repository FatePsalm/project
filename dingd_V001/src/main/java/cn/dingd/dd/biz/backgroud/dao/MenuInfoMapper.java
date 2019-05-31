package cn.dingd.dd.biz.backgroud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authc.AuthenticationToken;

import cn.dingd.dd.biz.common.entity.MenuInfo;
import cn.dingd.dd.biz.common.entity.MenuInfoExample;

public interface MenuInfoMapper {
    int countByExample(MenuInfoExample example);

    int deleteByExample(MenuInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MenuInfo record);

    int insertSelective(MenuInfo record);

    List<MenuInfo> selectByExample(MenuInfoExample example);

    MenuInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MenuInfo record, @Param("example") MenuInfoExample example);

    int updateByExample(@Param("record") MenuInfo record, @Param("example") MenuInfoExample example);

    int updateByPrimaryKeySelective(MenuInfo record);

    int updateByPrimaryKey(MenuInfo record);
    /**
     * 查询账号对应的权限列表
     * @param accountId
     * @return
     */
    List<MenuInfo> getMenuInfosByAccount(Integer accountId);
    
    /**
     * 获取加色对应的权限
     * @param roleId
     * @return
     */
    List<Integer> selectPermissionByRole(Integer roleId);
}
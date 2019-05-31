package cn.dingd.dd.biz.common.entity;

import java.io.Serializable;

/**
 * 菜单角色信息
 * @author ZC
 * @date 2018年4月25日 下午4:42:13
 */
public class MenuRole implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1769083713112688363L;

	private Integer id;

    private Integer roleId;

    private Integer menuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
package cn.dingd.dd.biz.common.entity;

import java.io.Serializable;

public class AccountRole implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1466619132411253781L;

	private Integer id;

    private Integer staffId;

    private Integer roleId;
    
    public AccountRole() {}
    
    public AccountRole(Integer staffId, Integer roleId) {
		super();
		this.staffId = staffId;
		this.roleId = roleId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
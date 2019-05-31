package cn.dingd.dd.biz.common.entity;

import java.util.Date;
import java.util.List;

/**
 * 组织架构
 * 
 * @author ZC
 * @date 2018年4月20日 下午1:49:17
 */
public class OrganizationInfo implements Cloneable {
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * 
	 */
	private Integer id;
	// 子节点
	private List<OrganizationInfo> TreeList;
	// 模糊查询
	private String find;

	/**
	 * 组织架构名称
	 */
	private String name;

	/**
	 * 组织架构备注
	 */
	private String orgDesc;

	/**
	 * 父id
	 */
	private Integer parentId;

	/**
	 * 创建人
	 */
	private Integer accountId;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 更改人
	 */
	private Integer updAccountId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 组织架构名称
	 * 
	 * @return name 组织架构名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 组织架构名称
	 * 
	 * @param name
	 *            组织架构名称
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 组织架构备注
	 * 
	 * @return org_desc 组织架构备注
	 */
	public String getOrgDesc() {
		return orgDesc;
	}

	/**
	 * 组织架构备注
	 * 
	 * @param orgDesc
	 *            组织架构备注
	 */
	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc == null ? null : orgDesc.trim();
	}

	/**
	 * 父id
	 * 
	 * @return parent_id 父id
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * 父id
	 * 
	 * @param parentId
	 *            父id
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * 创建人
	 * 
	 * @return account_id 创建人
	 */
	public Integer getAccountId() {
		return accountId;
	}

	/**
	 * 创建人
	 * 
	 * @param accountId
	 *            创建人
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	/**
	 * 更新时间
	 * 
	 * @return update_time 更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 更新时间
	 * 
	 * @param updateTime
	 *            更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 更改人
	 * 
	 * @return upd_account_id 更改人
	 */
	public Integer getUpdAccountId() {
		return updAccountId;
	}

	/**
	 * 更改人
	 * 
	 * @param updAccountId
	 *            更改人
	 */
	public void setUpdAccountId(Integer updAccountId) {
		this.updAccountId = updAccountId;
	}

	/**
	 * 创建时间
	 * 
	 * @return create_time 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 * 
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<OrganizationInfo> getTreeList() {
		return TreeList;
	}

	public void setTreeList(List<OrganizationInfo> treeList) {
		TreeList = treeList;
	}

	public String getFind() {
		return find;
	}

	public void setFind(String find) {
		this.find = find;
	}

	@Override
	public String toString() {
		return "OrganizationInfo [id=" + id + ", TreeList=" + TreeList + ", find=" + find + ", name=" + name
				+ ", orgDesc=" + orgDesc + ", parentId=" + parentId + ", accountId=" + accountId + ", updateTime="
				+ updateTime + ", updAccountId=" + updAccountId + ", createTime=" + createTime + "]";
	}

}
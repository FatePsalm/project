package cn.dingd.dd.biz.common.entity;

import java.util.Date;

/**
 * 配置项
 * @author XCD
 *
 */
public class ConfigurationInfoEntity {
	/** id*/
    private int id;
    /** key值  */
    private String confKey;
    /** value */
    private String confValue;
    /** 备注*/
    private String confDesc;
    /**创建时间*/
    private Date createTime;
    /**创建人*/
    private  int accountId;
    /**更新时间*/
    private Date updtTime;
    /**更新人*/
    private int updAccountId;
    /**
     * 是否启用
     */
    private int status;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConfKey() {
		return confKey;
	}
	public void setConfKey(String confKey) {
		this.confKey = confKey;
	}
	public String getConfValue() {
		return confValue;
	}
	public void setConfValue(String confValue) {
		this.confValue = confValue;
	}
	public String getConfDesc() {
		return confDesc;
	}
	public void setConfDesc(String confDesc) {
		this.confDesc = confDesc;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public Date getUpdtTime() {
		return updtTime;
	}
	public void setUpdtTime(Date updtTime) {
		this.updtTime = updtTime;
	}
	public int getUpdAccountId() {
		return updAccountId;
	}
	public void setUpdAccountId(int updAccountId) {
		this.updAccountId = updAccountId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ConfigurationInfoEntity [id=" + id + ", confKey=" + confKey + ", confValue=" + confValue + ", confDesc="
				+ confDesc + ", createTime=" + createTime + ", accountId=" + accountId + ", updtTime=" + updtTime
				+ ", updAccountId=" + updAccountId + ", status=" + status + "]";
	}
	
	
    
}

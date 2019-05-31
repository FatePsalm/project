package cn.dingd.dd.common.entity;

import java.io.Serializable;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年4月17日 上午9:37:19
* 类说明
* 版本控制,根据版本控制页面显示
*/
public class VersionEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1034189322052052721L;
	
	//主键ID
	private int id;
	//版本号
	private String versionControl;
	//打开1 关闭0 控制显示
	private Boolean valueControl;
	//是否强制更新 1更新 0不更新
	private Boolean updateControl;
	//备注
	private String notoControl;
	//启用1 禁用0
	private  Boolean enableControl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVersionControl() {
		return versionControl;
	}
	public void setVersionControl(String versionControl) {
		this.versionControl = versionControl;
	}
	public Boolean getValueControl() {
		return valueControl;
	}
	public void setValueControl(Boolean valueControl) {
		this.valueControl = valueControl;
	}
	public Boolean getUpdateControl() {
		return updateControl;
	}
	public void setUpdateControl(Boolean updateControl) {
		this.updateControl = updateControl;
	}
	public String getNotoControl() {
		return notoControl;
	}
	public void setNotoControl(String notoControl) {
		this.notoControl = notoControl;
	}
	public Boolean getEnableControl() {
		return enableControl;
	}
	public void setEnableControl(Boolean enableControl) {
		this.enableControl = enableControl;
	}
	@Override
	public String toString() {
		return "ManageVersionController [id=" + id + ", versionControl=" + versionControl + ", valueControl="
				+ valueControl + ", updateControl=" + updateControl + ", notoControl=" + notoControl
				+ ", enableControl=" + enableControl + "]";
	}
	
	

}

package cn.dingd.dd.common.entity;

import java.io.Serializable;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年10月18日 下午2:24:29
* 类说明 车辆品牌
*/
public class CarBrandsInfoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2489252276339843501L;
	/**汽车品牌ID*/
	private	Integer	id	;
	/**首字母*/
	private	String	brandsHead	;
	/**品牌ID*/
	private	String	brandsId	;
	/**品牌名*/
	private	String	brandsName	;
	/**Logo图片本地地址*/
	private	String	LogoImge	;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrandsHead() {
		return brandsHead;
	}
	public void setBrandsHead(String brandsHead) {
		this.brandsHead = brandsHead;
	}
	public String getBrandsId() {
		return brandsId;
	}
	public void setBrandsId(String brandsId) {
		this.brandsId = brandsId;
	}
	public String getBrandsName() {
		return brandsName;
	}
	public void setBrandsName(String brandsName) {
		this.brandsName = brandsName;
	}
	public String getLogoImge() {
		return LogoImge;
	}
	public void setLogoImge(String logoImge) {
		LogoImge = logoImge;
	}
	@Override
	public String toString() {
		return "CarBrandsInfo [id=" + id + ", brandsHead=" + brandsHead + ", brandsId=" + brandsId + ", brandsName="
				+ brandsName + ", LogoImge=" + LogoImge + "]";
	}
	
	

}

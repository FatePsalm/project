package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年11月21日 下午12:32:15 类说明
 */
public class CarPictureEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8491545249245994934L;
	// id
	private int id;
	// 图片信息
	private String priture;
	// 排序
	private int showSrot;
	// 链接地址
	private String url;
	// 车辆id
	private int carId;
	// 封面
	private int cover;
	// 生成时间
	private Date createTime;
	// 图片类型
	private int imgType;
	// 数据字典ID
	private int ddDictId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPriture() {
		return priture;
	}
	public void setPriture(String priture) {
		this.priture = priture;
	}
	public int getShowSrot() {
		return showSrot;
	}
	public void setShowSrot(int showSrot) {
		this.showSrot = showSrot;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getCover() {
		return cover;
	}
	public void setCover(int cover) {
		this.cover = cover;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getImgType() {
		return imgType;
	}
	public void setImgType(int imgType) {
		this.imgType = imgType;
	}
	public int getDdDictId() {
		return ddDictId;
	}
	public void setDdDictId(int ddDictId) {
		this.ddDictId = ddDictId;
	}
	@Override
	public String toString() {
		return "CarPicture [id=" + id + ", priture=" + priture + ", showSrot=" + showSrot + ", url=" + url + ", carId="
				+ carId + ", cover=" + cover + ", createTime=" + createTime + ", imgType=" + imgType + ", ddDictId="
				+ ddDictId + "]";
	}

	

}

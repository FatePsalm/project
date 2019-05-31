package cn.dingd.dd.common.entity;

import java.io.Serializable;

/**
 * 数据字典
 * @author XCD
 *
 */
public class DictInfoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5650229191029420756L;
	/**id*/
    private int id;
    /**文本*/
    private String dictName;
    /**文本code*/
    private int dictValue;
    /**排列顺序*/
    private int order;
    /**编码*/
    private String code;
    /**描述*/
    private String desc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	public int getDictValue() {
		return dictValue;
	}
	public void setDictValue(int dictValue) {
		this.dictValue = dictValue;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

    
}

package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.dingd.dd.common.util.StringUtils;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年10月10日 下午12:21:34 类说明
 * A端用户类
 */
public class AUserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1830814142035949669L;
	/**A端用户ID*/
	private int id;
	/**A端用户账号*/
	private String account;
	/**A端用户名*/
	private String nickname;
	/**A端用户姓名*/
	private String uName;
	/**A端用户年龄*/
	private int age;
	/**A端用户身份证号*/
	private String card;
	/**A端用户密码*/
	private String password;
	/**A端用户性别*/
	private int sex;
	/**A端用户手机号*/
	private String uPhone;
	/**A端用户注册时间*/
	private Date registerTime;
	/**A端用户信誉度*/
	private int credit;
	/**A端用户积分*/
	private int integration;
	/**A端用户用户签名100字以内*/
	private String sign;
	/**A端用户推荐人*/
	private String recommend;
	/**A端用户状态  0-禁用 1-启用 2-审核*/
	private int flag;
	/**A端用户-经销商ID*/
	private String dealersId;
	/**A端用户-经销商名称*/
	private String dealersName;
	/**A端用户-经销商营业执照编号*/
	private String businessNum;
	/**A端用户-经销商法人*/
	private String legalPerson;
	/**A端用户-经销商对公账号*/
	private String broughtAccount;
	/**A端用户-经销商开户行*/
	private String openingBank;
	/**A端用户-经销商执照照片*/
	private String lcenseImg;
	/**A端用户买家序号*/
	private String buyerNum;
	/**客户经理*/
	private int staffId;
	/**头像*/
	private String headImg;
	//用户类型
	private Integer type;
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		if(!StringUtils.isNotNullStr(recommend)){
		   this.account = account;
		}else{
			this.account=account.trim();
		}
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getIntegration() {
		return integration;
	}
	public void setIntegration(int integration) {
		this.integration = integration;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		if(!StringUtils.isNotNullStr(recommend)){
		    this.recommend = recommend;
		}else{
			this.recommend = recommend.trim();
		}
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getDealersId() {
		return dealersId;
	}
	public void setDealersId(String dealersId) {
		this.dealersId = dealersId;
	}
	public String getDealersName() {
		return dealersName;
	}
	public void setDealersName(String dealersName) {
		this.dealersName = dealersName;
	}
	public String getBusinessNum() {
		return businessNum;
	}
	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getBroughtAccount() {
		return broughtAccount;
	}
	public void setBroughtAccount(String broughtAccount) {
		this.broughtAccount = broughtAccount;
	}
	public String getOpeningBank() {
		return openingBank;
	}
	public void setOpeningBank(String openingBank) {
		this.openingBank = openingBank;
	}
	public String getLcenseImg() {
		return lcenseImg;
	}
	public void setLcenseImg(String lcenseImg) {
		this.lcenseImg = lcenseImg;
	}
	public String getBuyerNum() {
		return buyerNum;
	}
	public void setBuyerNum(String buyerNum) {
		this.buyerNum = buyerNum;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	@Override
	public String toString() {
		return "AUserEntity [id=" + id + ", account=" + account + ", nickname=" + nickname + ", uName=" + uName
				+ ", age=" + age + ", card=" + card + ", password=" + password + ", sex=" + sex + ", uPhone=" + uPhone
				+ ", registerTime=" + registerTime + ", credit=" + credit + ", integration=" + integration + ", sign="
				+ sign + ", recommend=" + recommend + ", flag=" + flag + ", dealersId=" + dealersId + ", dealersName="
				+ dealersName + ", businessNum=" + businessNum + ", legalPerson=" + legalPerson + ", broughtAccount="
				+ broughtAccount + ", openingBank=" + openingBank + ", lcenseImg=" + lcenseImg + ", buyerNum="
				+ buyerNum + ", staffId=" + staffId + ", headImg=" + headImg + "]";
	}

	
}

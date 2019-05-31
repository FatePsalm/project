package cn.dingd.dd.biz.common.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * @author ZC
 * @date 2018年4月25日 下午4:41:17
 * 账号信息
 */
public class AccountInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3236504702123301862L;

	private Integer id;
	//账号
    private String account;
    //昵称
    private String name;
    //密码
    @JsonIgnore
    private String password;
    //状态 
    private Integer flag;
    //邮箱
    private String mailbox;
    //电话
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox == null ? null : mailbox.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}
package cn.dingd.dd.common.shiro.token;
/**
 * @author zoucong
 * 2018年1月30日下午6:19:54
 * 用户登录类型
 */
public enum LoginType {
	
	AUSER("AUser"),//拍卖端
	STAFF("Staff"),//检测端
	BACKGround("BackGround"),//后台管理
	BIZBACKGroud("BizBackGround");//商家端后台管理系统
	
	private String type;

    private LoginType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}

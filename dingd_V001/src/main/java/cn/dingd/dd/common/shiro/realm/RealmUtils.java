package cn.dingd.dd.common.shiro.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;

import cn.dingd.dd.common.entity.StaffInfoEntity;
import cn.dingd.dd.common.service.CommonService;

/**
* @author ZC
* @date 2018年4月19日下午5:31:52
* realm工具类
*/
public class RealmUtils {

	@Value("#{configProperties['salt']}")
	private static String salt;
	@Resource
	private static CommonService commonService;
	
	/**
	 * shiro认证
	 * @param token
	 * @param realmName
	 * @return
	 */
	public static SimpleAuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token,String realmName) {
		//1. 把 AuthenticationToken 转换为 UsernamePasswordToken 
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//2. 从 UsernamePasswordToken 中来获取 username
		String username = upToken.getUsername();
		//判断用户名是否存在，若存在，返回user对象
		StaffInfoEntity user = commonService.isExist(username);
		//盐值. 
		ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
		//自动完成密码比对   - 密码的比对:
		//通过 AuthenticatingRealm 的 credentialsMatcher 属性来进行的密码的比对!
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, user.getuPassword(), credentialsSalt,realmName);
		SecurityUtils.getSubject().getSession().setAttribute("currentUser", username);
		//设置管理端的session过期时间为15分钟,覆盖配置文件中全局session过期时间
		SecurityUtils.getSubject().getSession().setTimeout(1000*60*15);
		return info;
	}
}

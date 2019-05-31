package cn.dingd.dd.common.shiro.realm;



import javax.annotation.Resource;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;

import cn.dingd.dd.common.service.CommonService;
/**
 * 通用短信认证reaml
 */
public class SMSRealm extends AuthorizingRealm {
	@Value("#{configProperties['salt']}")
	private String salt;
	@Resource
	private CommonService commonService;
	 
	/**
	 * 认证（短信密码验证）
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("==================>SMSRealm");
			//1. 把 AuthenticationToken 转换为 UsernamePasswordToken 
			UsernamePasswordToken upToken = (UsernamePasswordToken) token;
			 System.out.println("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
			//2. 从 UsernamePasswordToken 中来获取 username
			String username = upToken.getUsername();
			//判断用户名是否存在，若存在，返回user对象
			String password=commonService.GetCacheNumber(username);
			//盐值. 
			ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
			//自动完成密码比对   - 密码的比对:
			//通过 AuthenticatingRealm 的 credentialsMatcher 属性来进行的密码的比对!
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, credentialsSalt,getName());
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", username);
			return info;
		}


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

}

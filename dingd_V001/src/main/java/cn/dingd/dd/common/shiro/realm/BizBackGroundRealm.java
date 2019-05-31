package cn.dingd.dd.common.shiro.realm;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import cn.dingd.dd.biz.backgroud.service.PermissionService;
import cn.dingd.dd.biz.common.entity.AccountInfo;
import cn.dingd.dd.biz.common.entity.MenuInfo;
import cn.dingd.dd.biz.common.entity.StaffInfo;
import cn.dingd.dd.biz.common.view.StaffInfoView;
import cn.dingd.dd.common.shiro.token.CustomSessionManager;
import cn.dingd.dd.common.util.StringUtils;
/**
 * @author zoucong
 * 2018年1月30日下午6:27:43
 * 后台管理端认证reaml
 */
public class BizBackGroundRealm extends AuthorizingRealm {
	@Value("#{configProperties['salt']}")
	private String salt;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private CustomSessionManager customSessionManager;
		
	/**
	 * 认证(密码验证)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		StaffInfo user = null;
		try {
			//判断用户名是否存在，若存在，返回user对象
			user = (StaffInfo) SecurityUtils.getSubject().getSession().getAttribute("bizAccount");
		}catch (Exception e) {
			e.printStackTrace();
		}			
		//盐值. 
		ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
		//自动完成密码比对   - 密码的比对:
		//通过 AuthenticatingRealm 的 credentialsMatcher 属性来进行的密码的比对!
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getAccount(), user.getuPassword(), credentialsSalt,getName());
		//设置管理端的session过期时间为15分钟,覆盖配置文件中全局session过期时间
		SecurityUtils.getSubject().getSession().setTimeout(10000*60*15);
		return info;
	}


	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		StaffInfoView accountInfo = (StaffInfoView)SecurityUtils.getSubject().getSession().getAttribute("bizAccount");
		if (accountInfo==null) {
			return null;
		}
    	int userid = accountInfo.getId();
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		List<MenuInfo> permissions = permissionService.permissionListByUser(userid);
		if (permissions==null) {
			return null;
		}
		Set<String> permissionsStr = new HashSet<>();
		for (MenuInfo permission : permissions) {
			if (StringUtils.isNotNullApp(permission.getMenuCode())) {
			    permissionsStr.add(permission.getMenuCode());
			}
		}
		if (permissionsStr!=null) {
			info.setStringPermissions(permissionsStr);
		}
        return info; 
	}
	
	
	public void clearCachedAuthorizationInfo() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		super.clearCachedAuthorizationInfo(principalCollection);
	}
	
	
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		super.clearCachedAuthorizationInfo(principalCollection);
	}
	
	public void clearUserAuthByUserId(Integer...userIds){
		if(null == userIds || userIds.length == 0)	return ;
		List<SimplePrincipalCollection> result = customSessionManager.getSimplePrincipalCollectionByUserId(userIds);
		for (SimplePrincipalCollection simplePrincipalCollection : result) {
			clearCachedAuthorizationInfo(simplePrincipalCollection);
		}
	}
	
	public  void clearUserAuthByUserId(List<Integer> userIds) {
		if(null == userIds || userIds.size() == 0){
			return ;
		}
		clearUserAuthByUserId(userIds.toArray(new Integer[0]));
	}
	
}

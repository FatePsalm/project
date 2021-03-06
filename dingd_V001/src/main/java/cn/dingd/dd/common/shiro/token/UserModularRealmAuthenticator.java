package cn.dingd.dd.common.shiro.token;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

/**
 * @author zoucong
 * 2018年1月31日下午10:59:31
 * 自定义认证realm处理类,根据不同的登录类型走不同的reaml认证
 */
public class UserModularRealmAuthenticator extends ModularRealmAuthenticator {

	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		
		// 判断getRealms()是否返回为空
        assertRealmsConfigured();
        // 强制转换回自定义的CustomizedToken
        UserLoginToken customizedToken = (UserLoginToken) authenticationToken;
        // 登录类型
        String loginType = customizedToken.getLoginType();
        // 所有Realm
        Collection<Realm> realms = getRealms();
        // 登录类型对应的所有Realm
        Collection<Realm> typeRealms = new ArrayList<>();
        //将登录类型对应的reaml添加到集合中去
        for (Realm realm : realms) {
        	String name = realm.getName();
        	if (loginType.equals("BackGround") && name.equals(loginType)) {
        		typeRealms.add(realm);
        		continue;	 
			}
        	if (loginType.equals("BizBackGround")&&name.contains(loginType)) {
        		typeRealms.add(realm);
        		continue;
			}
            if (name.contains("SMS"))
            {
            	if (loginType .equals( "AUser" )) {
            		typeRealms.add(realm);
            		continue;
				}
            }
            if (name.contains(loginType)) {
            	typeRealms.add(realm);
			}
        }
        // 判断是单Realm还是多Realm
        if (typeRealms.size() == 1)
            return doSingleRealmAuthentication(typeRealms.iterator().next(), customizedToken);
        else
            return doMultiRealmAuthentication(typeRealms, customizedToken);
	}		
	
}

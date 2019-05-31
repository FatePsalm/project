package cn.dingd.dd.common.shiro.token;

import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.dingd.dd.biz.common.entity.AccountInfo;
import cn.dingd.dd.common.shiro.realm.BizBackGroundRealm;

/**
 * 自定义授权reaml处理类
 * @author ZC
 * @date 2018年4月25日 下午4:48:56
 */
public class UserModularRealmAuthorizer extends ModularRealmAuthorizer{
	@Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        assertRealmsConfigured();
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        for (Realm realm : getRealms()) {
            if (!(realm instanceof Authorizer)) continue;
            //if (primaryPrincipal instanceof AccountInfo) {
                if (realm instanceof BizBackGroundRealm) {
                    return ((BizBackGroundRealm) realm).isPermitted(principals, permission);
                }
            //}
        }
        return false;
    }

}

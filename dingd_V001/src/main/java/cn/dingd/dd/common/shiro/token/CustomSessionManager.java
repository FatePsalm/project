package cn.dingd.dd.common.shiro.token;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dingd.dd.biz.backgroud.service.StaffService;
import cn.dingd.dd.biz.common.entity.StaffInfo;
import cn.dingd.dd.common.shiro.session.CustomShiroSessionDao;


/**
 * 用户session管理类,用于自定义操作用户的session
 * @author zoucong
 * 2018年1月14日下午2:13:57
 */
public class CustomSessionManager {

	@Autowired
	private CustomShiroSessionDao customShiroSessionDao;
	@Autowired
	private StaffService accountInfoService;

	/**
	 * 获取所有的有效Session用户的用户信息
	 * @return
	 */
	public  List<String> getAllUser() {
		//获取所有session
		Collection<Session> sessions = customShiroSessionDao.getActiveSessions();
		List<String> list = new ArrayList<String>();		
		for (Session session : sessions) {
			String bo = getUserBySession(session);
			if(null != bo){
				list.add(bo);
			}
		}
		return list;
	}
	
	/**
	 * 根据session获取用户信息
	 * @param session
	 * @return
	 */
	private String getUserBySession(Session session){
		//获取session登录信息。
		Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
		if(null == obj){
			return null;
		}
		//确保是 SimplePrincipalCollection对象。
		if(obj instanceof SimplePrincipalCollection){
			SimplePrincipalCollection spc = (SimplePrincipalCollection)obj;
			/**
			 * 获取用户登录的，@link SampleRealm.doGetAuthenticationInfo(...)方法中
			 * return new SimpleAuthenticationInfo(user,user.getPswd(), getName());的user 对象。
			 */
			obj = spc.getPrimaryPrincipal();
			if(null != obj&&obj instanceof String ){
				return (String)obj;
			}
		}
		return null;
	}
	
	/**
	 * 根据ID查询 SimplePrincipalCollection,清楚缓存调用查找相应的对象
	 * @param userIds	用户ID
	 * @return
	 */
	public List<SimplePrincipalCollection> getSimplePrincipalCollectionByUserId(Integer...userIds){
		//把userIds 转成Set，好判断
		Set<Integer> idset = (Set<Integer>) array2Set(userIds);
		//获取所有session
		Collection<Session> sessions = customShiroSessionDao.getActiveSessions();
		//定义返回
		List<SimplePrincipalCollection> list = new ArrayList<SimplePrincipalCollection>();
		for (Session session : sessions) {
			//获取SimplePrincipalCollection
			Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
			if(null != obj && obj instanceof SimplePrincipalCollection){
				//强转
				SimplePrincipalCollection spc = (SimplePrincipalCollection)obj;
				//判断用户，匹配用户ID。
				Object primaryPrincipal = spc.getPrimaryPrincipal();
				if (primaryPrincipal instanceof String) {
					String account = (String)primaryPrincipal;
					StaffInfo info = accountInfoService.staffByAccount(account);
					if(null != info && idset.contains(info.getId())){
						//比较用户ID，符合即加入集合
						list.add(spc);
					}
				}
			}
		}
		return list;
	}
	
	/**
	 * 把数组转换成set
	 * @param array
	 * @return
	 */
	public static Set<Integer> array2Set(Integer[] array) {
		Set<Integer> set = new TreeSet<Integer>();
		for (Integer id : array) {
			if(null != id){
				set.add(id);
			}
		}
		return set;
	}						
}

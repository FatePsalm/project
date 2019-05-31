package cn.dingd.dd.common.shiro.session;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

/**
 * 自定义实现sessionDao接口的,实现与redis的整合
 * @author zoucong 
 * 2018年1月13日下午9:19:32
 */
public class CustomShiroSessionDao extends AbstractSessionDAO {

	private static Logger logger = LoggerFactory.getLogger(CustomShiroSessionDao.class);
	
	private ShiroSessionRepository shiroSessionRepository;
	
	@Resource
	private Cache cache;

	public ShiroSessionRepository getShiroSessionRepository() {
		return shiroSessionRepository;
	}

	public void setShiroSessionRepository(ShiroSessionRepository shiroSessionRepository) {
		this.shiroSessionRepository = shiroSessionRepository;
	}

	@Override
	public void delete(Session session) {
		if (session == null) {
			logger.error("session or session id is null");
			return;
		}
		Serializable id = session.getId();
		if (id != null)
			getShiroSessionRepository().deleteSession(id);
//			cache.remove(id);
	}

	@Override
	public Collection<Session> getActiveSessions() {
		return getShiroSessionRepository().getAllSessions();
	}

	/**
	 * 跟新
	 */
	@Override
	public void update(Session session) throws UnknownSessionException {
//		if (session instanceof ShiroSession) {    
         /* try{  // 如果没有主要字段(除lastAccessTime以外其他字段)发生改变    
//            ShiroSession ss = (ShiroSession) session;    
//            if (!ss.isChanged()) {    
//                return;    
//            }    
            long time1 = System.currentTimeMillis();
    		Serializable id = session.getId();
    		getShiroSessionRepository().saveSession(session);
    		cacheSession(id, session);
    		long time2 = System.currentTimeMillis();
    		System.out.println("远程更新session所需时间为："+(time2-time1));
	    } catch (Exception e) {    
	        logger.warn("更新Session失败", e); 
          }   */
          
//          Serializable id = session.getId();
  		 getShiroSessionRepository().saveSession(session);
//	    }     
		

	}

	/**
	 * 创建session
	 */
	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = this.generateSessionId(session);
		this.assignSessionId(session, sessionId);
		getShiroSessionRepository().saveSession(session);
//		cacheSession(sessionId,session);
		return sessionId;
	}

	/**
	 * 读取session
	 */
	@Override
	protected Session doReadSession(Serializable sessionId) {
//		return getShiroSessionRepository().getSession(sessionId);
		/*Element element = cache.get(sessionId);
		Session session = null;
		if (element!=null) {
			session = (Session) element.getValue();
		}
		else {
			long time1 = System.currentTimeMillis();
			session = getShiroSessionRepository().getSession(sessionId);
			long time2 = System.currentTimeMillis();
			System.out.println("远程读取session所需时间为："+(time2-time1));
			cacheSession(sessionId,session);
		}*/
		Session session = getShiroSessionRepository().getSession(sessionId);
		return session;
	}
	
	/**
	 * 在本地缓存session，解决频繁获取session远程连接性能问题
	 * @param sessionId
	 * @param session
	 */
	public void cacheSession(Serializable sessionId,Session session) {
		if (session==null) {
			return;
		}
		Element elementNew = new Element(sessionId, session);
		elementNew.setTimeToIdle((int)session.getTimeout() / 1000);
		cache.put(elementNew);
	}
	
	/**
	 * 允许更新的最小时间差
	 * @return
	 */
	public long timeSpan(Session session) {
		Session doReadSession = doReadSession(session.getId());
		long lastAccessTime = doReadSession.getLastAccessTime().getTime();
		long lastAccessTime2 = new Date().getTime();
		System.out.println(lastAccessTime2 - lastAccessTime);
		return lastAccessTime2 - lastAccessTime;
	}
}

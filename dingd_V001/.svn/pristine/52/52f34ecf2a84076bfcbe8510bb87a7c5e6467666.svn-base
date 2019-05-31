package cn.dingd.dd.common.shiro.session;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;

/**
 * session操作接口,为方便以后session底层存储的切换
 * @author zoucong 
 * 2018年1月13日下午9:22:21
 */
public interface ShiroSessionRepository {

	/** 保存session */
	void saveSession(Session session);

	/** 删除session */
	void deleteSession(Serializable sessionId);

	/** 获取session */
	Session getSession(Serializable sessionId);

	/** 获取所有的session */
	Collection<Session> getAllSessions();
}

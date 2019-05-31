package cn.dingd.dd.common.web;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dingd.dd.auction.dao.SchedulerJobDao;
import cn.dingd.dd.common.entity.SchedulerJob;
import cn.dingd.dd.common.quartz.QuartzTime;
import cn.dingd.dd.common.util.RedisClientPool;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author zoucong
 * 2018年1月30日下午3:35:35
 * 项目启动时做一些初始化操作
 */
public class ProjectInitialize {

	@Autowired
	private SchedulerJobDao schedulerJobDao;
	
	/**
	 * 保证服务器启动时redis正常
	 */
	@PostConstruct
	public void initRedis() {
		try {
			JedisPool instance = RedisClientPool.getInstance();
			Jedis resource = instance.getResource();
			instance.returnResource(resource);
			System.out.println("redis连接成功");
			//初始化job
//			intiSchedulerJob();
			System.out.println("初始化job任务");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("redis连接失败");
			System.exit(0);
		}
		
	}
	
	/**
	 * 注册quartz任务
	 */
	public void intiSchedulerJob() {
		List<SchedulerJob> jobs = schedulerJobDao.getAll();
		if (jobs==null) 
			return;
		for (int i = 0; i < jobs.size(); i++) {			
			SchedulerJob schedulerJob = jobs.get(i);
			if (!chectHost(schedulerJob.getHost())) {
				continue;
			}
			Date triggerTime = schedulerJob.getTriggerTime();
			triggerTime = chectTime(triggerTime)?triggerTime:new Date();
			if (schedulerJob.getType()==1) {
				registerJob(triggerTime,schedulerJob.getJobName(),1);
			}
			if (schedulerJob.getType()==2) {
				registerJob(triggerTime,schedulerJob.getJobName(),2);		
			}
			if (schedulerJob.getType()==3) {
				registerJob(triggerTime,schedulerJob.getJobName(),3);
			}
			if (schedulerJob.getType()==4) {
				registerJob(triggerTime,schedulerJob.getJobName(),4);
			}
		}	
	}
	
	public void registerJob(Date date,String jobName,Integer type) {
		try {
			QuartzTime.getQuartz(date , jobName , type);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public boolean chectTime(Date date) {
		if (date.getTime()>System.currentTimeMillis()) {
			return true;
		}
		return false;
	}
	
	public boolean chectHost(String host) {
		try {
			String string = InetAddress.getLocalHost().getHostAddress();
			return string.equals(host);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return false;
	}
}

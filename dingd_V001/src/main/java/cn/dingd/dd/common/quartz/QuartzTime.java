package cn.dingd.dd.common.quartz;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import cn.dingd.dd.common.util.RedisClientPool;
import redis.clients.jedis.Jedis;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年11月13日 上午10:58:19 类说明 结合redis执行超时任务
 */
public class QuartzTime {
	// redis key
	public static String orderOutTime = "orderOutTime";
	public static int jobStatus=-1;//启用状态
	
	
	
	/**
	 * 定时器
	 * @param date 执行时间
	 * @param name 定时器名称 order(订单)+id
	 * @param type 区分定时器执行那个任务
	 * @throws SchedulerException
	 */
	public static  void getQuartz(Date date,String name,int type) throws SchedulerException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//calendar.add(Calendar.SECOND, 5);
		// 格式: [秒] [分] [小时] [日] [月] [周] [年]
		String string = "" + calendar.get(Calendar.SECOND) + " " + calendar.get(Calendar.MINUTE) + " "
				+ calendar.get(Calendar.HOUR_OF_DAY) + " " + calendar.get(Calendar.DATE) + " "
				+ (calendar.get(Calendar.MONTH) + 1) + " ? " + calendar.get(Calendar.YEAR) + "";
		// 通过schedulerFactory获取一个调度器
		  SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
          Scheduler sche = gSchedulerFactory.getScheduler();
		try {
			 JobKey jobKey = new JobKey("job"+name, "jgroup"+name);
			 JobDetail jobDetail = null;
			 if(type==1){//修改场次
				 jobDetail= newJob(FieldJob.class).withIdentity(jobKey).build();  
			 }
			 else if(type==2){//订单处理
				 jobDetail= newJob(MyJobs.class).withIdentity(jobKey).build();  
			 }else if(type==3){//秒杀
				 jobDetail= newJob(SecondKillJobs.class).withIdentity(jobKey).build(); 
			 }
			
	         TriggerKey triggerKey = new TriggerKey("job"+name, "jgroup"+name);// 触发器  
	         Trigger trigger = newTrigger().withIdentity(triggerKey) .withSchedule(cronSchedule(string)).build();// 触发器时间设定  
	          sche.scheduleJob(jobDetail, trigger);  
            // 启动
            if (!sche.isShutdown()) {
            	sche.start();
            }
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}

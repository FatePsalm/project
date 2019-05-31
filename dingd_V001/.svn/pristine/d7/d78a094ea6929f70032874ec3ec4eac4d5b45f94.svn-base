package cn.dingd.dd.common.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

import cn.dingd.dd.auction.service.SecondsService;
import cn.dingd.dd.common.util.RedisClient;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.ApplicationContextRegister;

/**
 * @author 作者 xcd
 * @version 创建时间：2017年11月14日 上午10:23:31 类说明
 */
public class SecondKillJobs implements Job {
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ApplicationContext act = ApplicationContextRegister.getApplicationContext();
		SecondsService secondsService = act.getBean(SecondsService.class);
		try {
			String jobKey = context.getJobDetail().getKey().toString();
			String carIdStr = jobKey.substring(0, jobKey.indexOf("."));
			int carId = StringUtils.getStringNum(carIdStr);
		
			// 写入redis
			RedisClient.addRpush("Seconds" + carId, carId + "");
			secondsService.updateCarState(carId, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

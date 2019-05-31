package cn.dingd.dd.common.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.context.ApplicationContext;

import cn.dingd.dd.auction.service.AuctionSessionService;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.ApplicationContextRegister;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月14日 上午10:23:31
* 类说明
*/
public class MyJobs implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ApplicationContext act = ApplicationContextRegister.getApplicationContext();
		AuctionSessionService serv = act.getBean(AuctionSessionService.class);
		try {
			String jobKey=context.getJobDetail().getKey().getName().toString();
	        int id=StringUtils.getStringNum(jobKey);
			serv.updAuctionOrder(id);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}

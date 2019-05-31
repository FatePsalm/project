package cn.dingd.dd.common.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.context.ApplicationContext;

import cn.dingd.dd.auction.service.AuctionSessionService;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.ApplicationContextRegister;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年11月14日 上午10:23:31
* 类说明
*/
public class FieldJob implements Job{

	@Override
	public void execute(JobExecutionContext context) {
		ApplicationContext act = ApplicationContextRegister.getApplicationContext();
		AuctionSessionService auctionSessionService = act.getBean(AuctionSessionService.class);
		//查询数据库执行今天的第一个场次
		String jobKey=context.getJobDetail().getKey().getName().toString();
        int asid=StringUtils.getStringNum(jobKey);
		if(asid>0) {
			try {
				auctionSessionService.getAuctionCar(asid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

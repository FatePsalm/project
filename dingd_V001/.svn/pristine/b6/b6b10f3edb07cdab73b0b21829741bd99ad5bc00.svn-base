package cn.dingd.dd.common.quartz;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

import cn.dingd.dd.common.entity.AuctionOrderEntity;
import cn.dingd.dd.common.entity.AuctionSessionEntity;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.util.DateUtils;
import cn.dingd.dd.common.util.RedisClient;

public class QuartzJob {
	private static Logger logger = Logger.getLogger(QuartzJob.class);

	@Resource
	private CommonService commonService;

	/**
	 * @Description: 任务执行
	 * @param
	 */

	public void workRun() {

		try {
			// 查询大于当前时间的场次
			List<AuctionSessionEntity> list = commonService.firstFieldAll();
			if (list.size() != 0) {
				for (AuctionSessionEntity auctionSessionEntity : list) {
					try {
						String id = String.valueOf(auctionSessionEntity.getId());
						 QuartzTime.getQuartz(auctionSessionEntity.getAuctionStart(),"auction"+id,1);
					} catch (SchedulerException e) {
						throw new NullPointerException("定时器启动失败!");
					}
				}
			}
			//需要扣款的订单
			List<AuctionOrderEntity> auctionOrders=commonService.getAuctionOrders();
			if(auctionOrders!=null && auctionOrders.size()>0){
				Calendar calendar=Calendar.getInstance();  
				for(AuctionOrderEntity auctionOrderEntity : auctionOrders){
					// 设置时间
					calendar.setTime(auctionOrderEntity.getOrderTime());
					long difference=auctionOrderEntity.getAbortTime().getTime()-auctionOrderEntity.getOrderTime().getTime(); 
					long time=difference/(60*1000) ;
					// 时间规则/过期时间
					calendar.add(Calendar.MINUTE, (int)time);//分
					// 时间判定
					Date outDate = DateUtils.getTimeout(calendar);
					RedisClient.saveSetInfo(QuartzTime.orderOutTime, outDate.getTime(), String.valueOf(auctionOrderEntity.getId()));
					 QuartzTime.getQuartz(new Date(outDate.getTime()), "order"+auctionOrderEntity.getId(),2);
				}
			}
			
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
		}
	}
}

package cn.dingd.dd.common.quartz;

import java.util.TimerTask;

import org.springframework.context.ApplicationContext;

import cn.dingd.dd.auction.service.SecondsService;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.util.RedisClient;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.ApplicationContextRegister;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年1月16日 下午5:32:27 类说明
 */
public class SecondsTime extends TimerTask {
	private String jobName = "";

	public SecondsTime(String jobName) {
		this.jobName = jobName;
	}

	public void start(Long delay) {
		// 新建一个tesk
		TimerUtil.getInstance().schedule(new SecondsTime(jobName), delay);
	}

	@Override
	public void run() {
		Integer carId = StringUtils.getStringNum(jobName);
		ApplicationContext act = ApplicationContextRegister.getApplicationContext();
		CommonService commonService = act.getBean(CommonService.class);
		SecondsService secondsService = act.getBean(SecondsService.class);
		// 如果秒杀结束前状态还处于拍卖中视为流拍,车辆回到车库
		if (commonService.findCarState(carId) == 2) {
			secondsService.updateCarState(carId, 1);
			RedisClient.deleteData("Seconds");
			System.out.println("车辆流拍!");
		} else {
			System.out.println("车辆已被秒杀!");
		}
	}
}

package cn.dingd.dd.common.quartz;

import java.util.Timer;

/***
 * 
 * @author cancer 静态内部类生成时间定时器
 */
public class TimerUtil {
	private static class results {
		private static final Timer INSTANCE = new Timer();
	}
	//私有化构造方法
	private TimerUtil() {
	}
	//返回实咧
	public static final Timer getInstance() {
		return results.INSTANCE;
	}
}
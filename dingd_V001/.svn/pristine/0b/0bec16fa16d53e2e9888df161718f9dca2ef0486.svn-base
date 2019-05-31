package cn.dingd.dd.common.quartz;

import org.apache.commons.logging.Log;  
import org.apache.commons.logging.LogFactory;  
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
import org.quartz.JobListener;  

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年1月22日 下午3:26:25
* 类说明
*/
public class SimpleJobListener implements JobListener {

	Log logger = LogFactory.getLog(SimpleJobListener.class);  
	  
    public String getName() {  
         return getClass().getSimpleName();  
    }  
 
    public void jobToBeExecuted(JobExecutionContext context) {  
         String jobName = ((JobListener) context.getJobDetail()).getName();  
         logger.info(jobName + " is about to be executed");  
    }  
    public void jobExecutionVetoed(JobExecutionContext context) {  
         String jobName = ((JobListener) context.getJobDetail()).getName();  
         logger.info(jobName + " was vetoed and not executed()");  
    }  
    public void jobWasExecuted(JobExecutionContext context,  
              JobExecutionException jobException) {  
 
         String jobName = ((JobListener) context.getJobDetail()).getName();  
         logger.info(jobName + " was executed");  
    }  

}

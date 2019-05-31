package cn.dingd.dd.common.util;

import java.util.Timer;
/**
 * timer拍卖时间
 * @author XCD
 *
 */
public class DTimer extends Timer {

    
    public static Timer timer;  
    private DTimer(){};
    public static  Timer getSingletonInstance()  
    {  
    	 if (timer == null) {
    		 synchronized (Timer.class)
 			{
 				if(null == timer)
 				{
            	       timer=new Timer();
 				}
          }
    	 }
        return timer;
    } 
      
	
}

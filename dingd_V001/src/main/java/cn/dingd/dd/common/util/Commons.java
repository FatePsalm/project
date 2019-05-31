package cn.dingd.dd.common.util;

import java.text.NumberFormat;
import java.util.Random;
import java.util.UUID;

public class Commons {
	/**
	 * 生成随机数
	 * 36位的UUID
	 */
   public static  String   create_nonce_str(){
	       return UUID.randomUUID().toString();
   }
   /**
    * 获取起拍价格
    * @param f
    * @return
    */
   public static float getCarMoney(float f){
	   int rdm= (int)(60+Math.random()*(80-60+1));
       // 创建一个数值格式化对象  
       NumberFormat numberFormat = NumberFormat.getInstance();  
       // 设置精确到小数点后2位  
       numberFormat.setMaximumFractionDigits(2);  
       String result = numberFormat.format((float) rdm / (float) 10000 * 100); 
	   float  cm=f*Float.parseFloat(result);
	   float num=(float)(Math.round(cm*100))/100;
	   return num;
   }

   
   /**
    * 生成时间戳
    * @return
    */
   public  static String create_timestamp() {
       return Long.toString(System.currentTimeMillis() / 1000);
   }
   
   
   /**
    * 随机获取字符串
    * 包含数字和小写字母
    * @param length
    *        随机字符串长度
    * @return 随机字符串
    */
   public static String getRandomString(int length) {
       if ( length <= 0 ) {
           return "";
       }
       char[] randomChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a','b','c','d','e','f','g','h','i','j',
    		                  'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't','u','v','w','x','y','z'};
       Random random = new Random();
       StringBuffer stringBuffer = new StringBuffer();
       for (int i = 0; i < length; i++) {
           stringBuffer.append(randomChar[Math.abs(random.nextInt()) % randomChar.length]);
       }
       return stringBuffer.toString();
   }  
   
   public static String getRandom(int length) {
       if ( length <= 0 ) {
           return "";
       }
       char[] randomChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
       Random random = new Random();
       StringBuffer stringBuffer = new StringBuffer();
       for (int i = 0; i < length; i++) {
           stringBuffer.append(randomChar[Math.abs(random.nextInt()) % randomChar.length]);
       }
       return stringBuffer.toString();
   } 
} 
    

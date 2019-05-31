package cn.dingd.dd.common.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 判断数字的util类
 * 
 * @author lhj
 * 
 */
public class NumberUtil {

	/**
	 * 判断时间是否合法
	 * @param num
	 * @return
	 */
	public static boolean isNumber(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException  e) {
			return false;
		}
	}
	
	/**
    * 手机号验证 13.14.15.18开头
    * @param  mobileNumber 
    * @return 验证通过返回true 
    */  
	public static boolean isPhone(String mobileNumber){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^(0|86|17951)?(13[0-9]|15[0-9]|18[0-9]|19[0-9]|17[0-9]|14[0-9])[0-9]{8}$");
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }
	   
	/**
	 * 验证密码不等于null,length>=6&&length<=12
	 * @param password
	 * @return 通过true
	 */
	public static boolean isPassword(String password) {
		boolean flag = false;
		Pattern p = Pattern.compile("^[A-Za-z0-9]{6,12}$");
		Matcher m = p.matcher(password); 
		flag = m.matches();
		return flag;
	}
	
	 /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        boolean flag = false;
        try{
            String check = "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }
		
    public static void main(String[] args) {
    	boolean flag = false;
    	 Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(17[0,6,7,8])|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
         Matcher matcher = regex.matcher("17600102433");
         flag = matcher.matches();
         System.out.println(flag);
    }
    
    /**
     * 保存两位小数
     * @param f
     * @return
     */
    public static float getNum(float f,int n){
    	BigDecimal   b   =   new   BigDecimal(f);  
    	float   f1   =   b.setScale(n,   BigDecimal.ROUND_HALF_UP).floatValue(); 
    	return f1;
    }
  //相加
    public static float add(float d1,float d2){
        BigDecimal b1=new BigDecimal(d1+"");
        BigDecimal b2=new BigDecimal(d2+"");
        return b1.add(b2).floatValue();

    }
    //相减
    public static float sub(float d1,float d2){
        BigDecimal b1=new BigDecimal(d1+"");
        BigDecimal b2=new BigDecimal(d2+"");
        return b1.subtract(b2).floatValue();

    }
    //相乘
    public static float mul(float d1,float d2){
        BigDecimal b1=new BigDecimal(d1+"");
        BigDecimal b2=new BigDecimal(d2+"");
        return b1.multiply(b2).floatValue();

    }
    //相除
    public static float div(float d1,float d2){
        return div(d1,d2,10);

    }
    public static float div(float d1,float d2,int scale){
        if(scale<0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1=new BigDecimal(d1+"");
        BigDecimal b2=new BigDecimal(d2+"");
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).floatValue();

    }
}

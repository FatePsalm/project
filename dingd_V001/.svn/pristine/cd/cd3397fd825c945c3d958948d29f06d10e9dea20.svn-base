package cn.dingd.dd.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理类
 * 
 */
public class DateUtils {
	public static final String YMD = "yyyyMMdd";
	public static final String YMD_SLASH = "yyyy/MM/dd";
	public static final String YMD_DASH = "yyyy-MM-dd";
	public static final String YMD_DASH_WITH_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String YDM_SLASH = "yyyy/dd/MM";
	public static final String YDM_DASH = "yyyy-dd-MM";
	public static final String HMS = "HHmmss";
	public static final String HMS_COLON = "HH:mm:ss";
	public static final String YMDHMS = "yyyyMMddHHmmss";
	private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;
    private static final String ONE_SECOND_AGO = "秒前";  
    private static final String ONE_MINUTE_AGO = "分钟前";  
    private static final String ONE_HOUR_AGO = "小时前";  
    private static final String ONE_DAY_AGO = "天前";  
    private static final String ONE_MONTH_AGO = "月前";  
    private static final String ONE_YEAR_AGO = "年前";  
	// 上班时间..
	private static final Integer OFFICEHOURS = 9;
	// 下班时间
	private static final Integer TIMEFROMWORK = 18;
	// 超时时间
	public final static Integer OUTTIME = 4;
    /**
     * 时间转换成  ***前  如：2小时前，10分钟前，...
     * @param dat
     * @return
     */
    public static String getAgo(String dat){  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String time = "";
		try {
			Date date = format.parse(dat);
			time = format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return time;
    }  
  
    public static String format(Date date) {  
        long delta = new Date().getTime() - date.getTime();  
        if (delta < 1L * ONE_MINUTE) {  
            long seconds = toSeconds(delta);  
            return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;  
        }  
        if (delta < 45L * ONE_MINUTE) {  
            long minutes = toMinutes(delta);  
            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;  
        }  
        if (delta < 24L * ONE_HOUR) {  
            long hours = toHours(delta);  
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;  
        }  
        if (delta < 48L * ONE_HOUR) {  
            return "昨天";  
        }  
        if (delta < 30L * ONE_DAY) {  
            long days = toDays(delta);  
        //    return (days <= 0 ? 1 : days) + ONE_DAY_AGO;  
            return (days <= 0 ? 1 : days)+"";
        }  
        if (delta < 12L * 4L * ONE_WEEK) {  
            long months = toMonths(delta);  
            return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;  
        } else {  
            long years = toYears(delta);  
            return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;  
        }  
    }  
  
    
    
    private static long toSeconds(long date) {  
        return date / 1000L;  
    }  
  
    private static long toMinutes(long date) {  
        return toSeconds(date) / 60L;  
    }  
  
    private static long toHours(long date) {  
        return toMinutes(date) / 60L;  
    }  
  
    private static long toDays(long date) {  
        return toHours(date) / 24L;  
    }  
  
    private static long toMonths(long date) {  
        return toDays(date) / 30L;  
    }  
  
    private static long toYears(long date) {  
        return toMonths(date) / 365L;  
    }  

	/**
	 * 按指定的格式返回指定日期的字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDateString(Date date, String format) {
		String dateString = "";
		if(date == null){
			return dateString;
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			dateString = simpleDateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateString;
	}
	
	/**
	 * 按指定的格式返回指定日期的字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	@SuppressWarnings("unused")
	public static String getYMD() {
		Date date = new Date();
		String format = YMD_DASH;
		String dateString = "";
		if(date == null){
			return dateString;
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			dateString = simpleDateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateString;
	}

	/**
	 * 按指定的格式返回当前日期的字符串
	 * 
	 * @param farmat
	 * @return
	 */
	public static String getTodayString(String format) {
		String dateString = "";
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			dateString = simpleDateFormat.format(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateString;
	}

	/**
	 * 按指定的格式返回昨天的字符串
	 * 
	 * @param format
	 * @return
	 */
	public static String getYesterdayString(String format) {
		String dateString = "";
		try {
			Calendar calendar = Calendar.getInstance();// 此时打印它获取的是系统当前时间
			calendar.add(Calendar.DATE, -1);
			dateString = new SimpleDateFormat(format)
					.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateString;
	}

	/**
	 * 按指定的格式返回上个月今天的字符串
	 * 
	 * @param format
	 * @return
	 */
	public static String getLastMonthString(String format) {
		String dateString = "";
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, -1);
			Date date = calendar.getTime();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			dateString = simpleDateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateString;
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(String date) {
		String dateString = "";
		if (date != null && (date.length() == 8)) {
			dateString = date.substring(0, 4) + "-" + date.substring(4, 6)
					+ "-" + date.substring(6, 8);
		}
		return dateString;
	}

	/**
     * 创建一个"yyyyMM"日期的格式化对象
     * @return "yyyyMM"日期的格式化对象
     */
    private static SimpleDateFormat newShortYMFormat()
    {
        return new SimpleDateFormat("yyyyMM");
    }
    
    
    /**
     * 创建一个"yyyyMMdd"日期的格式化对象
     * @return "yyyyMMdd"日期的格式化对象
     */
    private static SimpleDateFormat newShortYMDFormat()
    {
        return new SimpleDateFormat("yyyyMMdd");
    }
    
    
    /**
     * 创建一个"HHmmss"日期的格式化对象
     * @return "HHmmss"日期的格式化对象
     */
    private static SimpleDateFormat newShortHMSFormat()
    {
        return new SimpleDateFormat("HHmmss");
    }
    
    
    /**
     * 创建一个"yyyyMMddHHmmss"日期的格式化对象
     * @return "yyyyMMddHHmmss"日期的格式化对象
     */
    private static SimpleDateFormat newShortYMDHMSFormat()
    {
        return new SimpleDateFormat("yyyyMMddHHmmss");
    }
    
    
    /**
     * 创建一个"yyyy-MM"日期的格式化对象
     * @return "yyyy-MM"日期的格式化对象
     */
    private static SimpleDateFormat newLongYMFormat()
    {
        return new SimpleDateFormat("yyyy-MM");
    }

    /**
     * 创建一个"yyyy-MM-dd"日期的格式化对象
     * @return "yyyy-MM-dd"日期的格式化对象
     */
    private static SimpleDateFormat newLongYMDFormat()
    {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    /**
     * 创建一个"HH:mm:ss"日期的格式化对象
     * @return "HH:mm:ss"日期的格式化对象
     */
    private static SimpleDateFormat newLongHMSFormat()
    {
        return new SimpleDateFormat("HH:mm:ss");
    }

    /**
     * 创建一个"yyyy-MM-dd HH:mm:ss"日期的格式化对象
     * @return "yyyy-MM-dd HH:mm:ss"日期的格式化对象
     */
    private static SimpleDateFormat newLongYMDHMSFormat()
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获得"yyyyMM"格式的当前日期
     * @return 返回"yyyyMM"格式的当前日期
     */
    public static String getShortYM()
    {
        return newShortYMFormat().format(new Date());
    }
    
    
    /**
     * 获得"yyyyMMdd"格式的当前日期
     * @return 返回"yyyyMMdd"格式的当前日期
     */
    public static String getShortYMD()
    {
        return newShortYMDFormat().format(new Date());
    }
    
    
    /**
     * 获得"HHmmss"格式的当前日期
     * @return 返回"HHmmss"格式的当前时间
     */
    public static String getShortHMS()
    {
        return newShortHMSFormat().format(new Date());
    }

    /**
     * 获得"yyyyMMddHHmmss"格式的当前日期
     * @return 返回"yyyyMMddHHmmss"格式的当前时间
     */
    public static String getShortYMDHMS()
    {
        return newShortYMDHMSFormat().format(new Date());
    }
    
    /**
     * 获得"yyyy-MM"格式的当前日期
     * @return 返回"yyyy-MM"格式的当前日期
     */
    public static String getLongYM()
    {
        return newLongYMFormat().format(new Date());
    }
    
    /**
     * 获得"yyyy-MM-dd"格式的当前日期
     * @return 返回"yyyy-MM-dd"格式的当前日期
     */
    public static String getLongYMD()
    {
        return newLongYMDFormat().format(new Date());
    }
    
    
    /**
     * 获得"HH:mm:ss"格式的当前日期
     * @return 返回"HH:mm:ss"格式的当前时间
     */
    public static String getLongHMS()
    {
        return newLongHMSFormat().format(new Date());
    }

    /**
     * 获得"yyyy-MM-dd HH:mm:ss"格式的当前日期
     * @return 返回"yyyy-MM-dd HH:mm:ss"格式的当前时间
     */
    public static String getLongYMDHMS()
    {
        return newLongYMDHMSFormat().format(new Date());
    }
    
    /**
     * "yyyy-MM"格式的日期转换为"yyyyMM"格式的日期
     * @param longYM "yyyy-MM"格式的日期
     * @return "yyyyMM"格式的日期
     * @throws ParseException
     */
    public static String toShortYM(String longYM) throws ParseException
    {
        return newShortYMFormat().format(newLongYMFormat().parse(longYM));
    }

    /**
     * "yyyy-MM-dd"格式的日期转换为"yyyyMMdd"格式的日期
     * @param longYMD "yyyy-MM-dd"格式的日期
     * @return "yyyyMMdd"格式的日期
     * @throws ParseException
     */
    public static String toShortYMD(String longYMD) throws ParseException
    {
        return newShortYMDFormat().format(newLongYMDFormat().parse(longYMD));
    }

    /**
     * "HH:mm:ss"格式的日期转换为"HHmmss"格式的日期
     * @param longHMS "HH:mm:ss"格式的日期
     * @return "HHmmss"格式的日期
     * @throws ParseException
     */
    public static String toShortHMS(String longHMS) throws ParseException
    {
        return newShortHMSFormat().format(newLongHMSFormat().parse(longHMS));
    }

    /**
     * "yyyy-MM-dd HH:mm:ss"格式的日期转换为"yyyyMMddHHmmss"格式的日期
     * @param longYMDHMS "yyyy-MM-dd HH:mm:ss"格式的日期
     * @return "yyyyMMddHHmmss"格式的日期
     * @throws ParseException
     */
    public static String toShortYMDHMS(String longYMDHMS) throws ParseException
    {
        return newShortYMDHMSFormat().format(newLongYMDHMSFormat().parse(longYMDHMS));
    }

    /**
     * "yyyyMM"格式的日期转换为"yyyy-MM"格式的日期
     * @param shortYM "yyyyMM"格式的日期
     * @return "yyyy-MM"格式的日期
     * @throws ParseException
     */
    public static String toLongYM(String shortYM) throws ParseException
    {
        return newLongYMFormat().format(newShortYMFormat().parse(shortYM));
    }

    /**
     * "yyyyMMdd"格式的日期转换为"yyyy-MM-dd"格式的日期
     * @param shortYMD "yyyyMMdd"格式的日期
     * @return "yyyy-MM-dd"格式的日期
     * @throws ParseException
     */
    public static String toLongYMD(String shortYMD) throws ParseException
    {
        return newLongYMDFormat().format(newShortYMDFormat().parse(shortYMD));
    }

    /**
     * "HHmmss"格式的日期转换为"HH:mm:ss"格式的日期
     * @param shortHMS "HHmmss"格式的日期
     * @return "HH:mm:ss"格式的日期
     * @throws ParseException
     */
    public static String toLongHMS(String shortHMS) throws ParseException
    {
        return newLongHMSFormat().format(newShortHMSFormat().parse(shortHMS));
    }

    /**
     * "yyyyMMddHHmmss"格式的日期转换为"yyyy-MM-dd HH:mm:ss"格式的日期
     * @param shortYMDHMS "yyyyMMddHHmmss"格式的日期
     * @return "yyyy-MM-dd HH:mm:ss"格式的日期
     * @throws ParseException
     */
    public static String toLongYMDHMS(String shortYMDHMS) throws ParseException
    {
        return newLongYMDHMSFormat().format(newShortYMDHMSFormat().parse(shortYMDHMS));
    }

    /**
     * 转化成 yyyy-MM-dd
     * @param date
     * @return
     */
	public static String toStringDate(Date date)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		String str=sdf.format(date);  
		return str;
	}
	
	public static String toStringDateMMdd(Date date,String  pattern)
	{
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);  
		String str=sdf.format(date);  
		return str;
	}
	
	/**
	 * 格式化时间
	 * 
	 * @param time
	 * @return
	 */
	public static String formatTime(String time) {
		String timeString = "";
		if (time != null && (time.length() == 6)) {
			timeString = time.substring(0, 2) + ":" + time.substring(2, 4)
					+ ":" + time.substring(4, 6);
		}
		return timeString;
	}
	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date stringToDate(String dateString , String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date;
		try {
			date = simpleDateFormat.parse( dateString );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			date =  new Date();
			e.printStackTrace();
		}
		return date;
	}
	
	public static String intToDate(String str)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(1900, 1, 1);
		cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(str));

		StringBuffer sb = new StringBuffer();
		sb.append(cal.get(Calendar.YEAR) + "-");
		sb.append(cal.get(Calendar.MONTH) + 1 + "-");
		sb.append(cal.get(Calendar.DAY_OF_MONTH));
		return sb.toString();
	}
	
	
    /** 
     * 根据日期获得星期 
     * @param date 
     * @return 
     */ 
	@SuppressWarnings("unused")
	public static String getWeekOfDate(Date date) { 
	  String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" }; 
	  String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" }; 
	  Calendar calendar = Calendar.getInstance(); 
	  calendar.setTime(date); 
	  int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1; 
	  return weekDaysCode[intWeek]; 
	} 
	
	  /** 
     *  当前星期是为5\6\7 返回  true
     * @param date 
     * @return 
     */ 
	public static boolean isUnWeekOfDate() { 
	  Date date = new Date();
	  String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" }; 
	  Calendar calendar = Calendar.getInstance(); 
	  calendar.setTime(date); 
	  int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1; 
	  String week = weekDaysCode[intWeek];
	  if("0".equals(week) || "5".equals(week) || "6".equals(week))
	  {
		  return  true;
	  }
	  return  false; 
	} 
	/**
	 * 时间计算
	 * @param date
	 * @param day 正数加时间，负数减时间
	 * @return
	 */
	public static String getDateOperation(Date date,int day){
	      Calendar cal = Calendar.getInstance();
	      cal.setTime(date);
	      if(day>0){
	      //加天
	      cal.add(Calendar.DATE, day);
	      }
	      else{
	      //减天
	      cal.add(Calendar.DATE, day);
	      }
	      return newLongYMDHMSFormat().format(cal.getTime());
	}
	
	
	
	/**
	 * 
	 * @param calendar
	 * @return 根据时间判断是否是节假日
	 */
	public static Date getTimeout(Calendar calendar) {
		// 获取时间
		if (calendar.get(Calendar.HOUR_OF_DAY) >= TIMEFROMWORK) {
			//下班时间,顺延到第二个工作日!");
			// 天
			calendar.add(Calendar.DATE, 1);
			// 如果是星期天在加一天
			if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
			//星期天不能过户哦!");
				calendar.add(Calendar.DATE, 1);
			}
			// 时
			calendar.set(Calendar.HOUR_OF_DAY, OFFICEHOURS + (calendar.get(Calendar.HOUR_OF_DAY) - TIMEFROMWORK));
			// 分
			calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
			// 秒
			calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
		}
		return calendar.getTime();
	}
	
	public static void main(String ars[])
	{
		System.out.println(getYMD());
		System.out.println(getWeekOfDate(new Date()));
	}
}
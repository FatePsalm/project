package cn.dingd.dd.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import cn.dingd.dd.common.quartz.QuartzTime;
import cn.dingd.dd.common.view.AuctionCarMoney;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;  


/**
 * 客户端
 * @author XCD
 *
 */

public class RedisClient {
	private static Logger logger = Logger.getLogger(RedisClient.class);
	/** 
     * 根据key和字段获取数据  
     * <一句话功能简述> 
     * <功能详细描述> 
     * @param flag 
     * @param field 
     * @return 
     * @see [类、类#方法、类#成员] 
     */  
    public static  Set<String>  getkeys(String flag)  
    {  
        Set<String> data = null;  
        Jedis redisClient = null;  
        try  
        {  
            redisClient = RedisClientPool.getInstance().getResource();  
            data = redisClient.keys(flag+"*");  
        }   
        catch (Exception e)  
        {  
            // 销毁对象  
        	RedisClientPool.getInstance().returnBrokenResource(redisClient);  
        }  
        finally  
        {  
            // 还原到连接池  
        	RedisClientPool.getInstance().returnResource(redisClient);  
        }  
          
        return data;  
    } 
	/** 
     * 根据key和字段获取数据  
     * <一句话功能简述> 
     * <功能详细描述> 
     * @param flag 
     * @param field 
     * @return 
     * @see [类、类#方法、类#成员] 
     */  
    public static Long EXPIRE(String flag,Integer field)  
    {  
        Long data = null;  
        Jedis redisClient = null;  
        try  
        {  
            redisClient = RedisClientPool.getInstance().getResource();  
            data = redisClient.expire(flag, field);  
        }   
        catch (Exception e)  
        {  
            // 销毁对象  
        	RedisClientPool.getInstance().returnBrokenResource(redisClient);  
        }  
        finally  
        {  
            // 还原到连接池  
        	RedisClientPool.getInstance().returnResource(redisClient);  
        }  
          
        return data;  
    } 
	 /** 
     * 根据key和字段获取数据  
     * <一句话功能简述> 
     * <功能详细描述> 
     * @param flag 
     * @param field 
     * @return 
     * @see [类、类#方法、类#成员] 
     */  
    public static Long addRpush(String flag,String field)  
    {  
        Long data = null;  
        Jedis redisClient = null;  
        try  
        {  
            redisClient = RedisClientPool.getInstance().getResource();  
            data = redisClient.rpush(flag, field);  
        }   
        catch (Exception e)  
        {  
            // 销毁对象  
        	RedisClientPool.getInstance().returnBrokenResource(redisClient);  
        }  
        finally  
        {  
            // 还原到连接池  
        	RedisClientPool.getInstance().returnResource(redisClient);  
        }  
          
        return data;  
    }  
	 /** 
     * 根据key和字段获取数据  
     * <一句话功能简述> 
     * <功能详细描述> 
     * @param flag 
     * @param field 
     * @return 
     * @see [类、类#方法、类#成员] 
     */  
    public static String getLpop(String flag)  
    {  
        String data = null;  
        Jedis redisClient = null;  
        try  
        {  
            redisClient = RedisClientPool.getInstance().getResource();  
            data = redisClient.lpop(flag);  
        }   
        catch (Exception e)  
        {  
            // 销毁对象  
        	RedisClientPool.getInstance().returnBrokenResource(redisClient);  
        }  
        finally  
        {  
            // 还原到连接池  
        	RedisClientPool.getInstance().returnResource(redisClient);  
        }  
          
        return data;  
    }  
	 /** 
     *  保存数据   类型为 Map 
     * <一句话功能简述> 
     * <功能详细描述> 
     * @param flag 
     * @param mapData 
     * @see [类、类#方法、类#成员] 
     */  
    public static void setMapDataToRedis(String flag,Map<String,String> mapData)  
    {         
        Jedis redisClient = null;  
        try  
        {  
            redisClient = RedisClientPool.getInstance().getResource();
            redisClient.hmset(flag,mapData);  
        }   
        catch (Exception e)  
        {  
            // 销毁对象  
        	RedisClientPool.getInstance().returnBrokenResource(redisClient);  
        }  
        finally  
        {  
            // 还原到连接池  
        	RedisClientPool.getInstance().returnResource(redisClient);  
        }  
    }  
      
    /** 
     *  保存数据   类型为 key-value 
     * <一句话功能简述> 
     * <功能详细描述> 
     * @param flag 
     * @param field 
     * @param value 
     * @see [类、类#方法、类#成员] 
     */  
    public static void setDataToRedis(String flag,String field,String value)  
    {  
        Jedis redisClient = null;  
        try  
        {  
            redisClient = RedisClientPool.getInstance().getResource();
            redisClient.hset(flag, field, value);  
        }   
        catch (Exception e)  
        {  
            // 销毁对象  
        	RedisClientPool.getInstance().returnBrokenResource(redisClient);  
        }  
        finally  
        {  
            // 还原到连接池  
        	RedisClientPool.getInstance().returnResource(redisClient);  
        }  
    }  
      
    /** 
     *  获取Map数据 
     * <一句话功能简述> 
     * <功能详细描述> 
     * @param flag 
     * @return 
     * @see [类、类#方法、类#成员] 
     */  
    public static Map<String,String> getMapData(String flag)  
    {  
        Map<String,String> dataMap = null;  
          
        Jedis redisClient = null;  
        try  
        {  
            redisClient = RedisClientPool.getInstance().getResource();  
            dataMap = redisClient.hgetAll(flag);  
        }   
        catch (Exception e)  
        {  
            // 销毁对象  
        	RedisClientPool.getInstance().returnBrokenResource(redisClient);  
        }  
        finally  
        {  
            // 还原到连接池  
        	RedisClientPool.getInstance().returnResource(redisClient);  
        }  
        return dataMap;  
    }  
      
    public static long deleteData(String flag)  
    {  
        long result = 0;  
        Jedis redisClient = null;  
        try  
        {  
            redisClient =RedisClientPool.getInstance().getResource();
            result = redisClient.del(flag);  
        }   
        catch (Exception e)  
        {  
            // 销毁对象  
        	RedisClientPool.getInstance().returnBrokenResource(redisClient);  
        }  
        finally  
        {  
            // 还原到连接池  
        	RedisClientPool.getInstance().returnResource(redisClient);  
        }  
          
        return result;  
    }  
      
    /** 
     * 根据key和字段获取数据  
     * <一句话功能简述> 
     * <功能详细描述> 
     * @param flag 
     * @param field 
     * @return 
     * @see [类、类#方法、类#成员] 
     */  
    public static String getData(String flag,String field)  
    {  
        String data = null;  
        Jedis redisClient = null;  
        try  
        {  
            redisClient = RedisClientPool.getInstance().getResource();  
            data = redisClient.hget(flag, field);  
        }   
        catch (Exception e)  
        {  
            // 销毁对象  
        	RedisClientPool.getInstance().returnBrokenResource(redisClient);  
        }  
        finally  
        {  
            // 还原到连接池  
        	RedisClientPool.getInstance().returnResource(redisClient);  
        }  
          
        return data;  
    }  
  
      
    @SuppressWarnings("rawtypes")
	public static void main(String[] args)  throws Exception  
    {           
    	//setRedisList(null, "AuctionCarMoney", AuctionCarMoney.class);
    	//restRedisList("AuctionCarMoney");
    	
    
    	
  	Jedis redis = RedisClientPool.getInstance().getResource();
    	try{
    		Map< String,String> map=new HashMap<>();
    	 Set<String> set=	redis.zrange(QuartzTime.orderOutTime, 0, 0);
    		 System.out.println(set+"==============是是是");
    		 
    		 List ls=getRedisList("AuctionCarMoney",AuctionCarMoney.class);
    		 System.out.println(ls+"========设置成功");
    		
    		Iterator it = map.keySet().iterator();
    		while (it.hasNext()) {
    		Object key = it.next();
    		 
    		
    		System.out.println("keyg = " + key + "; gvalue = " + map.get(key)+"=======Map");
    		}
  /*  		 String jst= redis.get("auctionMap");
    		  JSONObject jsonObj= JSONObject.fromObject(jst);

            Iterator it= jsonObj.keys();
          
    	        Map map1 = new HashMap<>();
    	      //  Iterator it = map.entrySet().iterator();
    	        while (it.hasNext()) {
    	        	
    	        String itg =it.next().toString();
    	    	// 获取Value
    	        JSONObject jt= JSONObject.fromObject(jsonObj.get(itg));
    	        System.out.println(jt+"=============");
				AuctionCarMoney value =(AuctionCarMoney) jsonObj.toBean(JSONObject.fromObject(jsonObj.get(itg)), AuctionCarMoney.class);
    	        	System.out.println("key = " + itg + "; value = " +value );
    	        	}*/
    	      
            
    		
    	 }catch (Exception e)  
         {  e.printStackTrace();
             // 销毁对象  
    		 RedisClientPool.getInstance().returnBrokenResource(redis); 
         }  
         finally  
         {  
             // 还原到连接池  
           	 RedisClientPool.getInstance().returnResource(redis); 
         }  
    
    //	lm.add(am);
    //	System.out.println(setAuctionCarMoney(am,"AuctionCarMoney"));
//    List ls=getRedisList("AuctionCarMoney",AuctionCarMoney.class);
//    	for(int i=0;i<ls.size();i++){
//    		System.out.println(((AuctionCarMoney)ls.get(i)).getMoney()+"========");
//    	}
//    	
    	
//	long s=System.currentTimeMillis();
//		Jedis redis = RedisClientPool.getInstance().getInstance().getResource();
//        for(int i=0;i<100;i++){
//        	redis.set(i+"D", "i");
//	    }    
//        redis.set("o","dgg");
//        // 还原到连接池  
//   	 RedisClientPool.getInstance().getInstance().returnResource(redis);  
//     System.out.println(System.currentTimeMillis()-s+"說過話");
    }

	private int expire;   
      
    public void testList()  
    {    
       Jedis redis = RedisClientPool.getInstance().getResource();  
        //hset key field value将哈希表key中的域field的值设为value。   
        redis.hset("table", "field1", "value1");   
        redis.hset("table", "field2", "value2");   
        redis.hset("table", "field3", "value3");   
        //返回哈希表key中，一个或多个给定域的值。   
        List<String> list = redis.hmget("table","field1","field2","field3");   
        for(String tmp : list)  
        {   
            System.out.println(tmp);   
        }   
    }  

    
    public static void testMap()  
    {  
        //同时将多个field - value(域-值)对设置到哈希表key中。   
        Map<String,String> map = new ConcurrentHashMap<String,String>();  
        for (int i = 0;i < 10;i++)  
        {  
            map.put("field"+i, "value"+i);   
        }  
        if (null != getData("table", "field1"))  
        {  
            deleteData("table");  
        }  
        //得到map下面的username的值   
        Map<String,String> maps = getMapData("table");  
        System.out.println(maps.size());  
          
        setMapDataToRedis("table",map);  
  
        //HGETALL key返回哈希表key中，所有的域和值。   
        maps = getMapData("table");   
         
        System.out.println(maps.size());  
    }  
    /**
     * 获取系列号
     * @return
     */
    @SuppressWarnings({ "deprecation", "finally" })
	public static String getSequence(String key){
    	Jedis redis =RedisClientPool.getInstance().getResource();
    	String sqno=null;
    	try{
	    	 if(redis.get(key)==null){
	    	    redis.set(key,"1");
	    	    redis.expire(key, 86400);
	    	 }
	    	 redis.incr(key);
	    	 sqno=redis.get(key);
    	 }catch (Exception e)  
         {  
             // 销毁对象  
    		 RedisClientPool.getInstance().returnBrokenResource(redis);  
         }  
         finally  
         {  
             // 还原到连接池  
        	 RedisClientPool.getInstance().returnResource(redis); 
         	return sqno;
         }  
    	
    }
    
    /**
     * 添加键值存储方法
     * @param key
     * @param val
     * @return
     */
    @SuppressWarnings({ "deprecation", "finally" })
	public static boolean setKeyVal(String key,String val){
    	Jedis redis = RedisClientPool.getInstance().getResource();
    	boolean b=false;
    	try{
	    	    redis.set(key,val);
	    	    b=true;
    	 }catch (Exception e)  
         {  
             // 销毁对象  
    		 RedisClientPool.getInstance().returnBrokenResource(redis); 
         }  
         finally  
         {  
             // 还原到连接池  
           	 RedisClientPool.getInstance().returnResource(redis); 
         	return b;
         }  
    	
    }
    
    /**
     * 根据key获取值
     * @param key
     * @return
     */
    @SuppressWarnings("deprecation")
	public static String getKeyString(String key){

    	Jedis redis = RedisClientPool.getInstance().getResource();
    	String val=null;
    	try{
    		 val=redis.get(key);
    		return val;
    	 }catch (Exception e)  
         {  
             // 销毁对象  
    		 RedisClientPool.getInstance().returnBrokenResource(redis); 
    		 return val;
         }  
         finally  
         {  
             // 还原到连接池  
           	 RedisClientPool.getInstance().returnResource(redis); 
         }  
    
    }
    
    /**
     * 添加list数据
     * @param jedis
     */
    @SuppressWarnings({ "deprecation", "finally" })
	public static List<String>  getList(String val,int index) {
		// list
    	Jedis jedis = RedisClientPool.getInstance().getResource();
    	List<String> list =null;
    	try{
    		jedis.lpush("mylist", val);
    		list = jedis.lrange("mylist", 0, index);
    		System.out.println(list);
    		for (String element : list) {
    			System.out.println(element);
    		}
    	 }catch (Exception e)  
         {  
             // 销毁对象  
    		 RedisClientPool.getInstance().returnBrokenResource(jedis); 
         }  
         finally  
         {  
             // 还原到连接池  
           	 RedisClientPool.getInstance().returnResource(jedis); 
         	return list;
         }  
		
	}
/**
 * 获取出价纪录 
 * @param AuctionCarMoney
 * @return
 */
    @SuppressWarnings("unchecked")
	public static List<Object> getRedisList(String AuctionCarMoney,Class cla){
    	
    	Jedis jedis = RedisClientPool.getInstance().getResource();
    	 List<Object> list=null;
    	try{
    		
    		 List<Object>   lt=jsonList2JavaList(jedis.get(AuctionCarMoney),cla);
    	     for(int i=lt.size();i>0;i--){
    	    	 
    	    	 if(lt.get(i-1)!=null){
    	    		 if(list==null){
    	    			 list=new ArrayList<>();
    	    		 }
    	    	    list.add(lt.get(i-1));
    	    	 }
    	    }
    	 }catch (Exception e)  
         {  
             // 销毁对象  
    		 RedisClientPool.getInstance().returnBrokenResource(jedis); 
         }  
         finally  
         {  
             // 还原到连接池  RedisClientPool.getInstance().getInstance().returnResource(redis);  
        	 RedisClientPool.getInstance().returnResource(jedis); 
         	return list;
         }  
      }
    
    /**
     * 设置list对象
     * @param am
     * @param AuctionCarMoney
     * @return
     */
    public static boolean setRedisList(Object obj,String key,Class cla){
    	
    	Jedis jedis = RedisClientPool.getInstance().getResource();
    	 List<Object> list=null;
    	try{
    	 
    	    list=jsonList2JavaList(jedis.get(key),cla);
    		if(list.size()>2){
    			list.remove(0);
    		}
    		
    		list.add(obj);
    	  	jedis.set(key,JSONArray.fromObject(list).toString()); 
    		
    	 }catch (Exception e)  
         {  
             // 销毁对象  
    		 RedisClientPool.getInstance().returnBrokenResource(jedis); 
    		 return false;
         }  
         finally  
         {  
             // 还原到连接池  RedisClientPool.getInstance().getInstance().returnResource(redis);  
           	 RedisClientPool.getInstance().returnResource(jedis); 
           	return true;
         }  
      }
    
    /**
     * 设置为空
     * @param obj
     * @param key
     * @param cla
     * @return
     */
    public static boolean restRedisList(String key){
    	Jedis jedis = RedisClientPool.getInstance().getResource();
	   	try{
	   	  	jedis.del(key);
	   	 }catch (Exception e)  
        {  
	   		 e.printStackTrace();
            // 销毁对象  
   		 RedisClientPool.getInstance().returnBrokenResource(jedis); 
   		 return false;
        }  
        finally  
        {  
            // 还原到连接池  RedisClientPool.getInstance().getInstance().returnResource(redis);  
          	 RedisClientPool.getInstance().returnResource(jedis); 
          	return true;
        }  
    }
    
    
    /**
     * 设置对象
     * @param obj
     * @param key
     * @return
     */
    public static boolean setRedisObject(Object obj,String key){
    	Jedis jedis = RedisClientPool.getInstance().getResource();
    	try {
		
			jedis.set(key.getBytes(), SerializeUtil.serialize(obj));
		} catch (Exception e) {
			   // 销毁对象  
   		 RedisClientPool.getInstance().returnBrokenResource(jedis); 
   		 return false;
		}  finally  
        {  
            // 还原到连接池  RedisClientPool.getInstance().getInstance().returnResource(redis);  
          	 RedisClientPool.getInstance().returnResource(jedis); 
          	return true;
        }  
    }
    
    /**
     * 获取对象
     * @param key
     * @return
     */
    public static Object getRedisObject(String key){
    	
    	Jedis jedis = RedisClientPool.getInstance().getResource();
		try {
			byte[] byt = jedis.get(key.getBytes());
			Object obj = SerializeUtil.unserialize(byt);
			return obj;
		} catch (Exception e) {
			 RedisClientPool.getInstance().returnBrokenResource(jedis); 
	   		 return false;
			}  finally  
	        {  
	            // 还原到连接池  RedisClientPool.getInstance().getInstance().returnResource(redis);  
	          	 RedisClientPool.getInstance().returnResource(jedis); 
	          	
	        }  

    }
    
    /**
     * 添加map
     * @param key
     * @param map
     * @return
     */
    @SuppressWarnings("finally")
	public static boolean setRedisMap(String key,Map<String,String> map){
    	
    	Jedis jedis = RedisClientPool.getInstance().getResource();
		try {
			jedis.set(key, JSONObject.fromObject(map).toString());
		} catch (Exception e) {
			 RedisClientPool.getInstance().returnBrokenResource(jedis); 
	   		 return false;
		}
		finally  
	        {  
	            // 还原到连接池  RedisClientPool.getInstance().getInstance().returnResource(redis);  
	          	 RedisClientPool.getInstance().returnResource(jedis); 
	          	return true;
	        } 
    }
    
    /**
     * 获取map
     * @param key
     * @param cla
     * @return
     */
    public static Map getRedisMap(String key,Class cla){
    	Jedis jedis = RedisClientPool.getInstance().getResource();
		try {
			return jsonMap2JavaMap(jedis.get(key),cla);
		} catch (Exception e) {
			 RedisClientPool.getInstance().returnBrokenResource(jedis); 
			 return null;
		}
		finally  
	        {  
	            // 还原到连接池  RedisClientPool.getInstance().getInstance().returnResource(redis);  
	          	 RedisClientPool.getInstance().returnResource(jedis); 
	        } 
    	
    }
    /**
     * 获取set信息
     * @param key
     * @param start 开始值 
     * @param end 结束值
     * @return
     */
    public static Set<String> getSetInfo(String key,int start,int end){
    	Jedis jedis = RedisClientPool.getInstance().getResource();
		try {
			// 获取redis里面的数据
			Set<String> set = jedis.zrange(key, start, end);
			return set;
		} catch (Exception e) {
			 RedisClientPool.getInstance().returnBrokenResource(jedis); 
			 return null;
		}
		finally  
	        {  
	            // 还原到连接池  RedisClientPool.getInstance().getInstance().returnResource(redis);  
	          	 RedisClientPool.getInstance().returnResource(jedis); 
	        } 
    }
    
    /**
     * 存储set信息
     * @param key
     * @param dob
     * @param valKey
     * @return
     */
    public static boolean saveSetInfo(String key,Long lg,String valKey){
    	
    	Jedis jedis = RedisClientPool.getInstance().getResource();
		try {
			jedis.zadd(QuartzTime.orderOutTime, lg,valKey);
			return true;
		} catch (Exception e) {
			 RedisClientPool.getInstance().returnBrokenResource(jedis); 
			 return false;
		}
		finally  
	        {  
	            // 还原到连接池  RedisClientPool.getInstance().getInstance().returnResource(redis);  
	          	 RedisClientPool.getInstance().returnResource(jedis); 
	        } 
    }
    /**
     * 删除信息
     * @param key
     * @param valKey
     * @return
     */
    public static boolean delSetInfo(String key,String valKey ){
       	Jedis jedis = RedisClientPool.getInstance().getResource();
    		try {
    			jedis.zrem(key, valKey);
    			return true;
    		} catch (Exception e) {
    			 RedisClientPool.getInstance().returnBrokenResource(jedis); 
    			 return false;
    		}
    		finally  
    	        {  
    	            // 还原到连接池  RedisClientPool.getInstance().getInstance().returnResource(redis);  
    	          	 RedisClientPool.getInstance().returnResource(jedis); 
    	        } 
    }
    	
    
    
    
    /**
     * 从json对象集合表达式中得到一个java对象列表
     * 
     * @param jsonString
     * @param pojoClass
     * @return
     */
    public static List jsonList2JavaList(String jsonString, Class pojoClass) {

        JSONArray jsonArray = JSONArray.fromObject(jsonString);

        JSONObject jsonObject;

        Object pojoValue;

        List list = new ArrayList<>();

        for (int i = 0; i < jsonArray.size(); i++) {

            jsonObject = jsonArray.getJSONObject(i);

            pojoValue = JSONObject.toBean(jsonObject, pojoClass);

            list.add(pojoValue);

        }

        return list;

    }
        
   /**
    * json转map
    * @param jsonString
    * @param pojoClass
    * @param obj
    * @return
    */
    @SuppressWarnings({ "rawtypes", "static-access", "unchecked" })
	public static Map  jsonMap2JavaMap(String jsonString, Class pojoClass) {

        JSONObject jsonObject=JSONObject.fromObject(jsonString);
        Iterator it= jsonObject.keys();
        Map map = new HashMap<>();
	    while (it.hasNext()) {
	        String key =it.next().toString();
	    	// 获取Value
	        Object value = jsonObject.toBean(JSONObject.fromObject(jsonObject.get(key)), pojoClass);
			map.put(key,value);
        	}
        return map;

    }
    
  
    /**
     * shiro缓存
     */
    public void returnResource(Jedis jedis) {
  	  RedisClientPool.getInstance().returnResource(jedis);
   }

    /**
     * 根据key从redis中获取值
     * @param key
     * @return
     */
    public byte[] get(byte[] key) {
      byte[] value = null;
      Jedis jedis = RedisClientPool.getInstance().getResource();
      try {
        value = jedis.get(key);
      } finally {
        returnResource(jedis);
      }
      return value;
    }

    /**
     * 保存
     * @param key
     * @param value
     * @return
     */
    public byte[] set(byte[] key, byte[] value) {
      Jedis jedis = RedisClientPool.getInstance().getResource();
      try {
        jedis.set(key, value);
        if (this.expire != 0 ) {
          jedis.expire(key, this.expire);
        }
      } finally {
        returnResource(jedis);
      }
      return value;
    }

    /**
     * set 带过期时间
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public byte[] set(byte[] key, byte[] value, int expire) {
      Jedis jedis = RedisClientPool.getInstance().getResource();
      try {
        jedis.set(key, value);
        if (expire != 0) {
          jedis.expire(key, expire);
        }
      } finally {
      	returnResource(jedis);
      }
      return value;
    }

    /**
     * 删除
     * @param key
     */
    public void del(byte[] key) {
      Jedis jedis = RedisClientPool.getInstance().getResource();
      try {
        jedis.del(key);
      } finally {
      	returnResource(jedis);
      }
    }

    /**
     * 清空
     */
    public void flushDB() {
      Jedis jedis = RedisClientPool.getInstance().getResource();
      try {
        jedis.flushDB();
      } finally {
        returnResource(jedis);
      }
    }

    /**
     * 缓存大小
     */
    public Long dbSize() {
      Long dbSize = 0L;
      Jedis jedis = RedisClientPool.getInstance().getResource();
      try {
        dbSize = jedis.dbSize();
      } finally {
        returnResource(jedis);
      }
      return dbSize;
    }

    /**
     * 所有key
     * @param pattern
     * @return
     */
    public Set<byte[]> keys(String pattern) {
      Set<byte[]> keys = null;
      Jedis jedis = RedisClientPool.getInstance().getResource();
      try {
        keys = jedis.keys(pattern.getBytes());
      } finally {
        returnResource(jedis);
      }
      return keys;
    }
}

package cn.dingd.dd.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cn.dingd.dd.common.util.StringUtils;


/**
 * Controller基类，所有Controller应该继承此类
 * 
 * @author Rocs
 *
 */
public class BaseController  {

	
	 @Autowired
	 protected HttpServletRequest request;
	 
	 @Autowired
	 protected HttpServletResponse response;
	

	 
	 /**
	  * 获取版本信息
	  * @return
	  */
	 public String getHeaderVersion(){
		 
	     String AppVersion = request.getHeader("AppVersion");
	     return AppVersion;
	 }
	 
	 /**
	  *获取用户id 
	  * @return
	  */
	 public int getUserId(){		 
	     int userId = Integer.parseInt(request.getHeader("userId"));
	     return userId;
	 }

	 
	 /**
	  * 获取token
	  * @param data	前端传来的参数
	  */
	 public boolean getToken(String data){
	     String token = request.getHeader("token");
	     boolean flag = false;
	     if(StringUtils.pwdEncryptUser("DINGDCOMTONGSX"+StringUtils.pwdEncryptUser(data)+"MOBILEAPP").equals(token)){
	    	 flag = true;
	     }
	     return flag;
	 }
	 
	 
	 /**
	  * 获取平台信息
	  * @return
	  */
	 public String getPlatform(){
	     String platform = request.getHeader("platform");	  
	     return platform;
	 }
}

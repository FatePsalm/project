package cn.dingd.dd.common.shiro.fileter;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import cn.dingd.dd.common.web.JsonResult;
import net.sf.json.JSONObject;
/**
 * 自定义登录认证过滤器
 * 对所有需要登录的接口进行认证
 * @author zoucong
 * 2018年1月26日下午3:21:33
 */
public class LoginFilter  extends AccessControlFilter {
	final static Class<LoginFilter> CLASS = LoginFilter.class;
	
	/**
	 * 访问控制，是否允许访问目标地址在这里控制
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest hrequest,
			ServletResponse response, Object mappedValue) throws Exception {
		HttpServletRequest request = (HttpServletRequest) hrequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		String domain = request.getHeader("Origin");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", domain);
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "accept,content-type");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST,DELETE,PUT");    
		Subject subject = SecurityUtils.getSubject();
		/**
		 * 展示页面允许匿名访问
		 */

		if(subject.isAuthenticated() || subject.isRemembered()){
            return Boolean.TRUE;
        }
		else{
        	out(httpServletResponse, new JsonResult(new Exception("未登录"),1404));
        	return false;      	
        }		
	}

	/**
	 * 上面方法返回false时执行该方法
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
			throws Exception {
		return false;
	}
	/**
	 * response 输出JSON
	 * @param hresponse
	 * @param resultMap
	 * @throws IOException
	 */
	public static void out(ServletResponse hresponse, Object resultMap){
		OutputStream out=null ;
		HttpServletResponse response = (HttpServletResponse) hresponse;
		try {
			response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"); 
			response.setHeader("Access-Control-Max-Age", "3600"); //设置过期时间 
			response.setHeader("Access-Control-Allow-Headers", "Origin,Access-Control-Allow-Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization"); 
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1. 
			response.setHeader("Pragma", "no-cache"); 
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			out = response.getOutputStream();
			out.write(JSONObject.fromObject(resultMap).toString().getBytes("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(null != out){
			  try {
				out.flush();
			    out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
			}
		}
	}
}

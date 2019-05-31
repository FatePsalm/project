package cn.dingd.dd.common.shiro.fileter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

/**
 * 
 * @author ZC
 * @date 2018年4月24日 下午1:36:10
 */
public class PermissionFilter extends PermissionsAuthorizationFilter{

	@Override
	public boolean isAccessAllowed(ServletRequest hrequest, ServletResponse hresponse, Object mappedValue)
			throws IOException {
		HttpServletRequest request = (HttpServletRequest) hrequest;
		HttpServletResponse response = (HttpServletResponse)hresponse;
		String domain = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", domain);
		response.setHeader("Access-Control-Allow-Headers", "accept,content-type");
		response.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST,DELETE,PUT");		
		return super.isAccessAllowed(request, response, mappedValue);
	}
}

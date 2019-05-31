package cn.dingd.dd.common.util;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class RequestHandler {
	private static Logger logeer = Logger.getLogger(RequestHandler.class);
	private HttpServletRequest request;
	private HttpServletResponse response;

	public RequestHandler(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	private Map parameters = new TreeMap();

	/**
	 * 获取参数值
	 * 
	 * @param parameter
	 *            参数名称
	 * @return String
	 */
	public String getParameter(String parameter) {

		String s = (String) this.parameters.get(parameter);

		return (null == s) ? "" : s;

	}

	/**
	 * 设置参数值
	 * 
	 * @param parameter
	 *            参数名称
	 * @param parameterValue
	 *            参数值
	 */

	public void setParameter(String parameter, String parameterValue) {

		String v = "";

		if (null != parameterValue) {

			v = parameterValue.trim();

		}
		this.parameters.put(parameter, v);

	}

	/**
	 * 将请求数据转为xml
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getXmlData() throws UnsupportedEncodingException {
		String sign = this.createSign(this.parameters);
		logeer.info("RequestHandler-->获得的sign：" + sign);
		this.setParameter("sign", sign);
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		Set es = this.parameters.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {

			Map.Entry entry = (Map.Entry) it.next();

			String k = (String) entry.getKey();

			String v = (String) entry.getValue();

			if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {

				sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");

			} else {
				sb.append("<" + k + ">" + v + "</" + k + ">");
			}

		}

		sb.append("</xml>");
		return sb.toString();

	}
	/**
	 * 签名算法
	 */
	public String createSign(Map<String, String> params) {

		StringBuffer sb = new StringBuffer();

		Set es = params.entrySet();

		Iterator it = es.iterator();

		while (it.hasNext()) {

			Map.Entry entry = (Map.Entry) it.next();

			String k = (String) entry.getKey();

			String v = (String) entry.getValue();

			if (null != v && !"".equals(v)

			&& !"sign".equals(k) && !"key".equals(k)) {

				sb.append(k + "=" + v + "&");

			}

		}
		sb.append("key=" + Constant.API);
		String sign = MD5Util.MD5Encode(sb.toString(), Constant.SIGN_ENCODE).toUpperCase();
		return sign;
	}

}

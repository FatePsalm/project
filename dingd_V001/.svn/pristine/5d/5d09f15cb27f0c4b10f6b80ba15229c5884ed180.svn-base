package cn.dingd.dd.common.util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * http网络请求
 * 
 * @author wcc
 *
 */
public class HttpGetOrPost {
	private   static  Logger logeer = Logger.getLogger(HttpGetOrPost.class);
	
	  /**
	  // 浏览器Agent 
      public static String USER_AGENT = "Mozilla/5.0 (Linux; U; Android 2.3.6; zh-cn; GT-S5660 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MicroMessenger/4.5.255";

      // 创建并配置HttpClient 
      private static final CloseableHttpClient httpClient = HttpClients 
            .custom() 
   
            .setDefaultRequestConfig( 
                    RequestConfig.custom() 
                            .setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY) 
                            .build()).build(); 
                            **/
    //连接超时时间，默认10秒
    private static int socketTimeout = 10000;

    //传输超时时间，默认30秒
    private  static int connectTimeout = 30000;
	
	/**
	 * get请求 返回一个  JSONObject 对象
	 * @param url
	 * @return  正常返回json对象 异常返回null
	 */
	public static JSONObject sendGet(String url) {
		CloseableHttpClient httpclient = null ;
		CloseableHttpResponse response = null;
		try {
		    httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url);
			response = httpclient.execute(httpget);
			logeer.info("HttpGetOrPost ----> response"+response);
			HttpEntity entity = response.getEntity();
			logeer.info("entity"+response);
			if (entity != null) {
				String s = EntityUtils.toString(entity);
				logeer.info("HttpGetOrPost ---> entity  s"+s);
				JSONObject jsonobj =  JSON.parseObject(s);
				return jsonobj;
			}
		} catch (Exception e) {
			logeer.error("HttpGetOrPost-->Exception "+e);
			e.printStackTrace();
		} finally {
			if(response != null){
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(httpclient != null){
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	
	/***
	 * https  post请求
	 * @param url
	 * @return 正常返回String字符串 异常返回null
	 * @throws UnsupportedEncodingException 
	 */
	public static  String sendPost(String  postDataXML) throws UnsupportedEncodingException{
		CloseableHttpClient httpClient = null ;
		logeer.info("HttpGetOrPost  sendPost--->start ");
        HttpPost httpPost = new HttpPost(Constant.GET_PREPAYID);
        //得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
        StringEntity postEntity = new StringEntity(postDataXML, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(postEntity);

        //设置请求器的配置
        httpPost.setConfig(RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build());
        try {
        	httpClient = HttpClients.createDefault();
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            logeer.info("HttpGetOrPost  sendPost---> entity："+result);
			return result;

        } catch (Exception e) {
        	 logeer.error("HttpGetOrPost  sendPost---> Exception ",e);
        } finally {
            httpPost.abort();
        }
        return null;
    }

	
	
	
	/***
	 * http post请求
	 * @param url
	 * @return 正常返回json对象 异常返回null
	 */
	public static JSONObject postHttpResult(String url) {
		CloseableHttpClient httpclient = null ;
		CloseableHttpResponse response = null;
		try {
		    httpclient = HttpClients.createDefault();
		    /***
			HttpPost httpPost = new HttpPost(url);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
	        nvps.add(new BasicNameValuePair("username", "vip"));  
	        nvps.add(new BasicNameValuePair("password", "secret"));  
	        httpPost.setEntity(new UrlEncodedFormEntity(nvps));  
			**/

            HttpUriRequest httpPost = RequestBuilder.post()
                    .setUri(new URI(url))
                    .addParameter("IDToken1", "username")
                    .addParameter("IDToken2", "password")
                    .build();
			response = httpclient.execute(httpPost);
			logeer.info("HttpGetOrPost ----> response"+response);
			HttpEntity entity = response.getEntity();
			logeer.info("entity"+response);
			if (entity != null) {
				String s = EntityUtils.toString(entity);
				logeer.info("HttpGetOrPost ---> entity  s"+s);
				JSONObject jsonobj =  JSON.parseObject(s);
				return jsonobj;
			}
		} catch (Exception e) {
			logeer.error("HttpGetOrPost-->Exception "+e);
			e.printStackTrace();
		} finally {
			if(response != null){
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(httpclient != null){
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	
	
	
	
	
	 /** 
     * 根据给定的链接获取所有的重定向位置 
     * @param link 给定的链接 
     * @return 
     * @throws ClientProtocolException 
     * @throws IOException 
    
    public  static List<URI> getAllRedirectLocations(String link) throws ClientProtocolException, IOException{ 
        List<URI> redirectLocations = null; 
        CloseableHttpResponse response = null; 
        try{ 
            HttpClientContext context = HttpClientContext.create(); 
            HttpGet httpGet = new HttpGet(link); 
            response = httpClient.execute(httpGet, context); 
           
            logeer.info("HttpGetOrPost-->getAllRedirectLocations  response"+EntityUtils.toString(response.getEntity())); 
            System.out.println("HttpGetOrPost-->getAllRedirectLocations  response"+EntityUtils.toString(response.getEntity()));
            // 获取所有的重定向位置 
            
            redirectLocations = context.getRedirectLocations();
            if(redirectLocations!=null){ 
            	logeer.info("HttpGetOrPost-->getAllRedirectLocations "+link);
                for(URI uri : redirectLocations){ 
                	logeer.info("HttpGetOrPost-->重定向 ：getAllRedirectLocations  "+link);
                } 
            } else{ 
                System.out.println("Not found!"); 
            } 
        }catch (Exception e){
        	logeer.info("HttpGetOrPost-->重定向 ：Exception  "+e);
        	e.printStackTrace();
        } finally{ 
            if(response!=null){ 
                response.close(); 
            } 
        } 
        return redirectLocations; 
    } 
    
     
    

    public static void main(String[] args) throws ClientProtocolException, IOException{ 
        // 输入URL 
    	StringBuffer getCodeUrl = new StringBuffer("https://open.weixin.qq.com/connect/oauth2/authorize");
		getCodeUrl.append("?appid=").append(Constant.APPID).append("&redirect_uri=").append(URLEncoder.encode(Constant.REDIRECT_URI,"utf-8"))
				.append("&response_type=code&scope=snsapi_userinfo&showwxpaytitle=1&state=").append(Constant.STATE)
				.append("#wechat_redirect");
        List<URI> allRedirectLocations = getAllRedirectLocations(getCodeUrl.toString()); 
        if(allRedirectLocations!=null){ 
            System.out.println(getCodeUrl.toString()); 
            for(URI uri : allRedirectLocations){ 
                System.out.println("|\nv\n" + uri.toASCIIString()); 
            } 
        } else{ 
            System.out.println("Not found!"); 
        } 
    } 
    */ 
   
      
}

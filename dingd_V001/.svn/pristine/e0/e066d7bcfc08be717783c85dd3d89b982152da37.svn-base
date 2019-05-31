package Common;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class SendRequest {
	
	public static final String UTF8 = "utf-8";
	public static int READ_TIMEOUT = 30000;
	public static int CONNECT_TIMEOUT = 30000;
	
	public static String doPost(String connectURL,String param ,String charset)  {
	    byte[] bytes = null;
	    ByteArrayOutputStream byteArrayOut = null;
	    URL url = null;
	    HttpURLConnection httpPost = null;
	    OutputStream out = null;
	    InputStream in = null;
	    String result = null;
	    try {
	        url = new URL(connectURL);
	        httpPost = (HttpURLConnection) url.openConnection();
	        httpPost.setRequestMethod("POST");
	        httpPost.setRequestProperty("AppVersion", "2.0.0");
	        httpPost.setRequestProperty("userId", "341");
	        httpPost.setRequestProperty("platform", "iOS");
	        httpPost.setDoInput(true);
	        httpPost.setDoOutput(true);
	        httpPost.setUseCaches(false);
	        httpPost.setConnectTimeout(CONNECT_TIMEOUT);
	        httpPost.setReadTimeout(READ_TIMEOUT);
	        httpPost.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;multipart/form-data");
	        
	        httpPost.connect();
	        out = httpPost.getOutputStream();
	        out.write(param.getBytes(charset));
	        out.flush();
	        in = httpPost.getInputStream();
	        byteArrayOut = new ByteArrayOutputStream();
	        byte[] buf = new byte[512];
	        int l = 0;
	        while ((l = in.read(buf)) != -1) {
	            byteArrayOut.write(buf, 0, l);
	        }
	        bytes = byteArrayOut.toByteArray();
	        result = new String(bytes, charset);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(byteArrayOut);
	        close(out); 
	        close(in);
	        close(httpPost);
	    }
	    return result;
 
	}  
	
	public static String formUpload(String urlStr, Map<String, String> textMap, Map<String, InputStream> fileMap) { 
	    String res = "";  

	    HttpURLConnection conn = null;  

	    String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符    

	    try {  

	        URL url = new URL(urlStr);  

	        conn = (HttpURLConnection) url.openConnection();  

	        conn.setConnectTimeout(5000);  

	        conn.setReadTimeout(30000);  

	        conn.setDoOutput(true);  

	        conn.setDoInput(true);  

	        conn.setUseCaches(false);  

	        conn.setRequestMethod("POST");  

	        conn.setRequestProperty("Connection", "Keep-Alive");  

	        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");  

	        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);  



	        OutputStream out = new DataOutputStream(conn.getOutputStream());  

	        // text    

	        if (textMap != null) {  

	            StringBuffer strBuf = new StringBuffer();  

	            Iterator<Map.Entry<String, String>> iter = textMap.entrySet().iterator();  

	            while (iter.hasNext()) {  

	                Map.Entry<String, String> entry = iter.next();  

	                String inputName = (String) entry.getKey();  

	                String inputValue = (String) entry.getValue();  

	                if (inputValue == null) {  

	                    continue;  

	                }  

	                strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");  

	                strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");  

	                strBuf.append(inputValue);  

	            }  

	            out.write(strBuf.toString().getBytes());  

	        }  



	        // file    

	        if (fileMap != null) {  

	            Iterator<Map.Entry<String, InputStream>> iter = fileMap.entrySet().iterator();  

	            while (iter.hasNext()) {  

	                Map.Entry<String, InputStream> entry = iter.next();  

	                String inputName = (String) entry.getKey();  

	               

	                FileInputStream inputValue =   (FileInputStream) entry.getValue();  

	                if (inputValue == null) {  

	                    continue;  

	                }  

	                

	                String filename = System.currentTimeMillis()+".png";  

	                String contentType = "image/png";  

	             

	                StringBuffer strBuf = new StringBuffer();  

	                strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");  

	                strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename + "\"\r\n");  

	                strBuf.append("Content-Type:" + contentType + "\r\n\r\n");  



	                out.write(strBuf.toString().getBytes());  



	                

	                DataInputStream in = new DataInputStream(inputValue);  

	                int bytes = 0;  

	                byte[] bufferOut = new byte[1024];  

	                while ((bytes = in.read(bufferOut)) != -1) {  

	                    out.write(bufferOut, 0, bytes);  

	                }  

	                in.close();  

	            }  

	        }  



	        byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();  

	        out.write(endData);  

	        out.flush();  

	        out.close();  



	        // 读取返回数据    

	        StringBuffer strBuf = new StringBuffer();  

	        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));  

	        String line = null;  

	        while ((line = reader.readLine()) != null) {  

	            strBuf.append(line).append("\n");  

	        }  

	        res = strBuf.toString();  

	        reader.close();  

	        reader = null;  

	    } catch (Exception e) {  

	        System.out.println("发送POST请求出错。" + urlStr);  

	        e.printStackTrace();  

	    } finally {  

	        if (conn != null) {  

	            conn.disconnect();  

	            conn = null;  

	        }  

	    }  

	    return res;  

	}  
	private static void close(Closeable stream) {
	    if (stream != null) {
	        try {
	            stream.close();
	            stream = null;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	private static void close(HttpURLConnection httpConn){
	    if(httpConn != null){
	        httpConn.disconnect();
	    }
	}

}

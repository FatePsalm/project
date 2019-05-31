package cn.dingd.dd.common.util;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * 上传图片到http服务器
 * @author xcd
 *
 */
public class HttpUpload {
	public static  String upload(String actionUrl, File file)
			throws IOException {
		
			String BOUNDARY = java.util.UUID.randomUUID().toString();
			String PREFFIX = "--", LINEND = "\r\n";
			String MULTIPART_FROM_DATA = "multipart/form-data";
			String CHARSET = "UTF-8";
			// 定义URL实例
			URL uri = new URL(actionUrl);
			HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
			// 设置从主机读取数据超时
			conn.setReadTimeout(10 * 1000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			// 维持长连接
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("Charset", "UTF-8");
			// 设置文件类型
			conn.setRequestProperty("Content-Type", MULTIPART_FROM_DATA
			+ ";boundary=" + BOUNDARY);
			// 创建一个新的数据输出流，将数据写入指定基础输出流
			DataOutputStream outStream = new DataOutputStream(
			conn.getOutputStream());
			// 发送文件数据
			if (file.getName() != null) {
			// 构建发送字符串数据
			StringBuilder sb1 = new StringBuilder();
			sb1.append(PREFFIX);
			sb1.append(BOUNDARY);
			sb1.append(LINEND);
			sb1.append("Content-Disposition: form-data; name=\"file\"; filename=\""
			+ file.getName() + "\"" + LINEND);
			sb1.append("Content-Type: application/octet-stream;chartset="
			+ CHARSET + LINEND);
			sb1.append(LINEND);
			// 写入到输出流中
			outStream.write(sb1.toString().getBytes());
			// 将文件读入输入流中
			InputStream is = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int len = 0;
			// 写入输出流
			while ((len = is.read(buffer)) != -1) {


			outStream.write(buffer, 0, len);
			}
			is.close();
			// 添加换行标志
			outStream.write(LINEND.getBytes());
			}
			// 请求结束标志
			byte[] end_data = (PREFFIX + BOUNDARY + PREFFIX + LINEND).getBytes();
			outStream.write(end_data);
			// 刷新发送数据
			outStream.flush();
			// 得到响应码
			int res = conn.getResponseCode();


			InputStream in = null;
			// 上传成功返回200
			if (res == 200) {
			in = conn.getInputStream();
			int ch;
			StringBuilder sb2 = new StringBuilder();
			// 保存数据
			while ((ch = in.read()) != -1) {
			sb2.append((char) ch);
			}
			file.delete();
			}
			// 如果数据不为空，则以字符串方式返回数据，否则返回null
			return in == null ? null : in.toString();
			}
	
	
	
	/**
	 * 下载文件
	 * @param  url
	 * @param  destFileName   xxx.jpg/xxx.png/xxx.txt
	 * @throws  ClientProtocolException
	 * @throws IOException
	 */
	public static void getFile(String url, String destFileName)  throws ClientProtocolException, IOException {
	    // 生成一个httpclient对象
	    CloseableHttpClient httpclient = HttpClients.createDefault();
	    HttpGet httpget =new HttpGet(url);
	    HttpResponse response = httpclient.execute(httpget);
	    HttpEntity entity = response.getEntity();
	    InputStream in = entity.getContent();
	    File file =new File(destFileName);
	    try{
	        FileOutputStream fout =new FileOutputStream(file);
	        int l = -1;
	        byte[] tmp =new byte[1024];
	        while((l = in.read(tmp)) != -1) {
	            fout.write(tmp,0, l);
	            // 注意这里如果用OutputStream.write(buff)的话，图片会失真，大家可以试试
	        }
	        fout.flush();
	        fout.close();
	    }finally{
	        // 关闭低层流。
	        in.close();
	    }
	    httpclient.close();
	}
	
	public static void downLoad(String remoteFileName, String localFileName) {
	          HttpClient client = new HttpClient();
	          GetMethod get = null;
	          FileOutputStream output = null;
	          
	          try {
	              get = new GetMethod("http://114.55.42.12:8085/speechmp3/");
//	              get.setRequestHeader("userName", userName);
//	              get.setRequestHeader("passwd", passwd);
	              get.setRequestHeader("fileName", remoteFileName);
	 
	             int i = client.executeMethod(get);
	 
	             if (200 == i) {
	                 System.out.println("The response value of token:" + get.getResponseHeader("token"));
	 
	                 File storeFile = new File(localFileName);
	                 output = new FileOutputStream(storeFile);
	                 
	                 // 得到网络资源的字节数组,并写入文件
	                output.write(get.getResponseBody());
             } else {
	                 System.out.println("DownLoad file occurs exception, the error code is :" + i);
	             }
	         } catch (Exception e) {
	             e.printStackTrace();
	         } finally {
	             try {
	                 if(output != null){
	                     output.close();
	                 }
	             } catch (IOException e) {
	                 e.printStackTrace();
	             }
	             
	             get.releaseConnection();
	             client.getHttpConnectionManager().closeIdleConnections(0);
	         }
	}
	
	/**
	 * 删除图片
	 */
	public static void delImg(List<String> ls){
		if(ls!=null){
			File file=null;
			String lastTag =null;
			String newPath =null;
			String url=null;
			for(int i=0;i<ls.size();i++){
				url=ls.get(i);
				file=new File(url);
				if(file!=null){
				 lastTag = url.substring(url.lastIndexOf("."),url.length());
			     newPath = url.substring(0, url.lastIndexOf("."));
				 File file2=new File(newPath+"_50x50"+lastTag);
				  if(file2!=null){
					  file2.delete();
				  }
				  file.delete();
				}
			}
		}
		
		
	}
	
}

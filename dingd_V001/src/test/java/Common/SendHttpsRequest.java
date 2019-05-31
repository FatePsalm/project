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
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class SendHttpsRequest {

	public static final String UTF8 = "utf-8";
	public static int READ_TIMEOUT = 30000;
	public static int CONNECT_TIMEOUT = 30000;

	public static String doPost(String connectURL, String param, String charset) {
		byte[] bytes = null;
		ByteArrayOutputStream byteArrayOut = null;
		URL url = null;
		HttpsURLConnection httpPost = null;
		OutputStream out = null;
		InputStream in = null;
		String result = null;
		try {

			HostnameVerifier hv = new HostnameVerifier() {
				public boolean verify(String urlHostName, SSLSession session) {
					System.out.println("Warning: URL Host: " + urlHostName
							+ " vs. " + session.getPeerHost());
					return true;
				}
			};

			trustAllHttpsCertificates();
			httpPost.setDefaultHostnameVerifier(hv);
			url = new URL(connectURL);
			httpPost = (HttpsURLConnection) url.openConnection();
			httpPost.setRequestMethod("POST");
			httpPost.setRequestProperty("AppVersion", "1.2.0");
			httpPost.setRequestProperty("userId", "333");
			httpPost.setDoInput(true);
			httpPost.setDoOutput(true);
			httpPost.setUseCaches(false);

			httpPost.setConnectTimeout(CONNECT_TIMEOUT);
			httpPost.setReadTimeout(READ_TIMEOUT);
			httpPost.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;multipart/form-data");

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

	private static void trustAllHttpsCertificates() throws Exception {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
				.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
				.getSocketFactory());
	}

	public static String formUpload(String urlStr, Map<String, String> textMap,
			Map<String, InputStream> fileMap) {
		String res = "";

		HttpsURLConnection conn = null;

		String BOUNDARY = "---------------------------123821742118716";
		// boundary就是request头和上传文件内容的分隔符

		try {

			URL url = new URL(urlStr);

			conn = (HttpsURLConnection) url.openConnection();

			conn.setConnectTimeout(5000);

			conn.setReadTimeout(30000);

			conn.setDoOutput(true);

			conn.setDoInput(true);

			conn.setUseCaches(false);

			conn.setRequestMethod("POST");

			conn.setRequestProperty("Connection", "Keep-Alive");

			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");

			conn.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=" + BOUNDARY);

			OutputStream out = new DataOutputStream(conn.getOutputStream());

			// text

			if (textMap != null) {

				StringBuffer strBuf = new StringBuffer();

				Iterator<Map.Entry<String, String>> iter = textMap.entrySet()
						.iterator();

				while (iter.hasNext()) {

					Map.Entry<String, String> entry = iter.next();

					String inputName = (String) entry.getKey();

					String inputValue = (String) entry.getValue();

					if (inputValue == null) {

						continue;

					}

					strBuf.append("\r\n").append("--").append(BOUNDARY)
							.append("\r\n");

					strBuf.append("Content-Disposition: form-data; name=\""
							+ inputName + "\"\r\n\r\n");

					strBuf.append(inputValue);

				}

				out.write(strBuf.toString().getBytes());

			}

			// file

			if (fileMap != null) {

				Iterator<Map.Entry<String, InputStream>> iter = fileMap
						.entrySet().iterator();

				while (iter.hasNext()) {

					Map.Entry<String, InputStream> entry = iter.next();

					String inputName = (String) entry.getKey();

					FileInputStream inputValue = (FileInputStream) entry
							.getValue();

					if (inputValue == null) {

						continue;

					}

					String filename = System.currentTimeMillis() + ".png";

					String contentType = "image/png";

					StringBuffer strBuf = new StringBuffer();

					strBuf.append("\r\n").append("--").append(BOUNDARY)
							.append("\r\n");

					strBuf.append("Content-Disposition: form-data; name=\""
							+ inputName + "\"; filename=\"" + filename
							+ "\"\r\n");

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

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));

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

	private static void close(HttpsURLConnection httpConn) {
		if (httpConn != null) {
			httpConn.disconnect();
		}
	}

	static class miTM implements javax.net.ssl.TrustManager,
			javax.net.ssl.X509TrustManager {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(
				java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(
				java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public void checkServerTrusted(
				java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}

		public void checkClientTrusted(
				java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}
	}
}

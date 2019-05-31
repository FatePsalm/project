/**
 * 
 */
package com.dingdang.biz.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Rocs
 * 
 */
public class StringUtils {

	protected final static Logger logger = Logger.getLogger(StringUtils.class);
	private static final String _pwdEncrypt_EXTRA_CODE = "share";
	private static final String CONFIG_SECRET = "0e9e61132f7dd02a4088e511c37e2838";
	private static final Key key;
	private static final String CHARS = "qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM0123456789";

	/**
	 * 静态块
	 */
	static {
		try {
			DESKeySpec objDesKeySpec = new DESKeySpec(
					CONFIG_SECRET.getBytes("UTF-8"));
			SecretKeyFactory objKeyFactory = SecretKeyFactory
					.getInstance("DES");
			key = objKeyFactory.generateSecret(objDesKeySpec);
		} catch (Exception e) {
			logger.error("", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 密码加密
	 *
	 * @param pwd
	 * @return
	 */
	public static String pwdEncrypt(String pwd) {
		return DigestUtils.md5Hex(DigestUtils.md5Hex(pwd
				+ _pwdEncrypt_EXTRA_CODE));
	}
/**
 * 用户id加密
 * @param id
 * @return
 */
	public static String pwdEncryptUser(String id) {
		return DigestUtils.md5Hex(id);
	}

	
	public static String decryptIosAndroid(String ciphertext) {
		try {
			byte[] res = DatatypeConverter.parseBase64Binary(ciphertext);
			return new String(res);
		} catch (Exception e) {
			logger.error("", e);
			return null;
		}
	}

	/**
	 * 判断string是否为null或者空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNullApp(String str) {
		if (str == null) {
			return false;
		} else if ("".equals(str.trim())) {
			return false;
		}
		return true;
	}

	/**
	 * 判断是否为null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		return null == str ? false : true;
	}

	/**
	 * 判断是否为空字符串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNullStr(String str) {
		return null != str && !str.trim().equals("") ? true : false;
	}

	/**
	 * 判断字符串是不是int类型
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInt(String str) {
		if (str == null || "".equals(str)) {
			return false;
		} else if (Pattern.compile("[0-9]*").matcher(str).matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断两字符串相同
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static boolean isEqual(String one, String two) {
		return one.equals(two) && isNotNullStr(one) && isNotNullStr(two);
	}

	/**
	 * 判断数组是否全非空
	 * 
	 * @param args
	 * @return true 不为空 false 为空
	 * 
	 */
	public static boolean isNotNullArgs(String[] args) {
		if (args == null) {
			return false;
		}
		for (String s : args) {
			if (StringUtils.isNotNullStr(s)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 八位随机数
	 * 
	 * @return
	 */
	public static int randomEight() {
		int j = 0;
		int number = 100000000;
		while (true) {
			boolean flag = true;
			int a = (int) (Math.random() * number);
			if (flag && String.valueOf(a).length() == 8 && a > 10000000
					&& a < 99999999) {
				j = a;
				break;
			}
		}
		return j;
	}

	/**
	 * int值转成2字节的byte数组
	 * 
	 * @param num
	 * @return
	 */
	public static byte[] int2byteArray(int num) {
		byte[] result = new byte[2];
		result[0] = (byte) (num >>> 8); // 取次低8位放到2下标
		result[1] = (byte) (num); // 取最低8位放到3下标
		return result;
	}

	/**
	 * 卡号隐藏********
	 * 
	 * @return
	 */
	public static String cardString() {
		String cardNo = "1234567891212";
		StringBuffer sb = new StringBuffer();
		String result = "";
		if (StringUtils.isNotNullStr(cardNo) && cardNo.length() > 6) {
			for (int i = 0; i < cardNo.length() - 6; i++) {
				sb.append("*");
			}
			result = cardNo.substring(0, 2) + sb.toString()
					+ cardNo.substring(cardNo.length() - 4);
		}
		return result;
	}

	/**
	 * 格式化
	 * 
	 * @return
	 */
	public static String strFormat(double d) {
		return new DecimalFormat("#0.##").format(d);
	}

	public static String mathRound(String s) {
		if (isNotNullStr(s)) {
			return String.valueOf(Math.round(Float.parseFloat(s)));
		} else {
			return "0";
		}

	}

	/**
	 * 格式化
	 * 
	 * @return
	 */
	public static String dateNoAdd(String no, int i) {
		return (Long.parseLong(no) + i) + "";
	}

	// 验证是否是数子
	@SuppressWarnings("unused")
	private static boolean isNumeric(String msg) {
		for (int i = 0; i < msg.length(); i++) {
			if (Character.isDigit(msg.charAt(i))) {
				continue;
			}
			return false;
		}
		return true;
	}

	/*public static void main(String[] args) {
		System.out.println(decryptIosAndroid("eydtb2RlbCc6J2lQaG9uZSBTaW11bGF0b3InLCAnZGV2aWNlTmFtZSc6J3g4Nl82NCcsICdzeXN0ZW1WZXJzaW9uJzonOC4xJywgJ2FwcFZlcnNpb24nOicxLjMuMCcsICdlcnJvckNvbnRlbnQnOic8P3htbCB2ZXJzaW9uPSIxLjAiIGVuY29kaW5nPSJVVEYtOCI/Pgo8IURPQ1RZUEUgcGxpc3QgUFVCTElDICItLy9BcHBsZS8vRFREIFBMSVNUIDEuMC8vRU4iICJodHRwOi8vd3d3LmFwcGxlLmNvbS9EVERzL1Byb3BlcnR5TGlzdC0xLjAuZHRkIj4KPHBsaXN0IHZlcnNpb249IjEuMCI+CjxkaWN0PgoJPGtleT5uYW1lPC9rZXk+Cgk8c3RyaW5nPk5TSW52YWxpZEFyZ3VtZW50RXhjZXB0aW9uPC9zdHJpbmc+Cgk8a2V5PnJlYXNvbjwva2V5PgoJPHN0cmluZz4qKiogLVtfX05TQXJyYXlNIGluc2VydE9iamVjdDphdEluZGV4Ol06IG9iamVjdCBjYW5ub3QgYmUgbmlsPC9zdHJpbmc+Cgk8a2V5PnN0YWNrQXJyYXk8L2tleT4KCTxhcnJheT4KCQk8c3RyaW5nPjAgICBDb3JlRm91bmRhdGlvbiAgICAgICAgICAgICAgICAgICAgICAweDAwMDAwMDAxMTJlYjBmMzUgX19leGNlcHRpb25QcmVwcm9jZXNzICsgMTY1PC9zdHJpbmc+CgkJPHN0cmluZz4xICAgbGlib2JqYy5BLmR5bGliICAgICAgICAgICAgICAgICAgICAgMHgwMDAwMDAwMTEyNzcyYmI3IG9iamNfZXhjZXB0aW9uX3Rocm93ICsgNDU8L3N0cmluZz4KCQk8c3RyaW5nPjIgICBDb3JlRm91bmRhdGlvbiAgICAgICAgICAgICAgICAgICAgICAweDAwMDAwMDAxMTJkN2Y3NmEgLVtfX05TQXJyYXlNIGluc2VydE9iamVjdDphdEluZGV4Ol0gKyA5NTQ8L3N0cmluZz4KCQk8c3RyaW5nPjMgICBQbGFuZUNpcmNsZSAgICAgICAgICAgICAgICAgICAgICAgICAweDAwMDAwMDAxMGU0ODZkYjQgLVtaVGFiQmFyVmlld0NvbnRyb2xsZXIgdGFiQmFyQ29udHJvbGxlcjpzaG91bGRTZWxlY3RWaWV3Q29udHJvbGxlcjpdICsgMTMyPC9zdHJpbmc+CgkJPHN0cmluZz40ICAgVUlLaXQgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgMHgwMDAwMDAwMTEzODEyNDVjIC1bVUlUYWJCYXJDb250cm9sbGVyIF90YWJCYXJJdGVtQ2xpY2tlZDpdICsgMTA0PC9zdHJpbmc+CgkJPHN0cmluZz41ICAgVUlLaXQgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgMHgwMDAwMDAwMTEzNmFiOGJlIC1bVUlBcHBsaWNhdGlvbiBzZW5kQWN0aW9uOnRvOmZyb206Zm9yRXZlbnQ6XSArIDc1PC9zdHJpbmc+CgkJPHN0cmluZz42ICAgVUlLaXQgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgMHgwMDAwMDAwMTEzOTdmYjc2IC1bVUlUYWJCYXIgX3NlbmRBY3Rpb246d2l0aEV2ZW50Ol0gKyA0NTE8L3N0cmluZz4KCQk8c3RyaW5nPjcgICBVSUtpdCAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAweDAwMDAwMDAxMTM2YWI4YmUgLVtVSUFwcGxpY2F0aW9uIHNlbmRBY3Rpb246dG86ZnJvbTpmb3JFdmVudDpdICsgNzU8L3N0cmluZz4KCQk8c3RyaW5nPjggICBVSUtpdCAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAweDAwMDAwMDAxMTM3YjI0MTAgLVtVSUNvbnRyb2wgX3NlbmRBY3Rpb25zRm9yRXZlbnRzOndpdGhFdmVudDpdICsgNDY3PC9zdHJpbmc+CgkJPHN0cmluZz45ICAgVUlLaXQgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgMHgwMDAwMDAwMTEzOTgzZmQxIC1bVUlUYWJCYXIoU3RhdGljKSBfYnV0dG9uVXA6XSArIDEwMzwvc3RyaW5nPgoJCTxzdHJpbmc+MTAgIFVJS2l0ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIDB4MDAwMDAwMDExMzZhYjhiZSAtW1VJQXBwbGljYXRpb24gc2VuZEFjdGlvbjp0bzpmcm9tOmZvckV2ZW50Ol0gKyA3NTwvc3RyaW5nPgoJCTxzdHJpbmc+MTEgIFVJS2l0ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIDB4MDAwMDAwMDExMzdiMjQxMCAtW1VJQ29udHJvbCBfc2VuZEFjdGlvbnNGb3JFdmVudHM6d2l0aEV2ZW50Ol0gKyA0Njc8L3N0cmluZz4KCQk8c3RyaW5nPjEyICBVSUtpdCAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAweDAwMDAwMDAxMTM3YjE3ZGYgLVtVSUNvbnRyb2wgdG91Y2hlc0VuZGVkOndpdGhFdmVudDpdICsgNTIyPC9zdHJpbmc+CgkJPHN0cmluZz4xMyAgVUlLaXQgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgMHgwMDAwMDAwMTEzNmYxMzA4IC1bVUlXaW5kb3cgX3NlbmRUb3VjaGVzRm9yRXZlbnQ6XSArIDczNTwvc3RyaW5nPgoJCTxzdHJpbmc+MTQgIFVJS2l0ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIDB4MDAwMDAwMDExMzZmMWMzMyAtW1VJV2luZG93IHNlbmRFdmVudDpdICsgNjgzPC9zdHJpbmc+CgkJPHN0cmluZz4xNSAgVUlLaXQgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgMHgwMDAwMDAwMTEzNmJlOWIxIC1bVUlBcHBsaWNhdGlvbiBzZW5kRXZlbnQ6XSArIDI0Njwvc3RyaW5nPgoJCTxzdHJpbmc+MTYgIFVJS2l0ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIDB4MDAwMDAwMDExMzZjYmE3ZCBfVUlBcHBsaWNhdGlvbkhhbmRsZUV2ZW50RnJvbVF1ZXVlRXZlbnQgKyAxNzM3MDwvc3RyaW5nPgoJCTxzdHJpbmc+MTcgIFVJS2l0ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIDB4MDAwMDAwMDExMzZhNzEwMyBfVUlBcHBsaWNhdGlvbkhhbmRsZUV2ZW50UXVldWUgKyAxOTYxPC9zdHJpbmc+CgkJPHN0cmluZz4xOCAgQ29yZUZvdW5kYXRpb24gICAgICAgICAgICAgICAgICAgICAgMHgwMDAwMDAwMTEyZGU2NTUxIF9fQ0ZSVU5MT09QX0lTX0NBTExJTkdfT1VUX1RPX0FfU09VUkNFMF9QRVJGT1JNX0ZVTkNUSU9OX18gKyAxNzwvc3RyaW5nPgoJCTxzdHJpbmc+MTkgIENvcmVGb3VuZGF0aW9uICAgICAgICAgICAgICAgICAgICAgIDB4MDAwMDAwMDExMmRkYzQxZCBfX0NGUnVuTG9vcERvU291cmNlczAgKyAyNjk8L3N0cmluZz4KCQk8c3RyaW5nPjIwICBDb3JlRm91bmRhdGlvbiAgICAgICAgICAgICAgICAgICAgICAweDAwMDAwMDAxMTJkZGJhNTQgX19DRlJ1bkxvb3BSdW4gKyA4Njg8L3N0cmluZz4KCQk8c3RyaW5nPjIxICBDb3JlRm91bmRhdGlvbiAgICAgICAgICAgICAgICAgICAgICAweDAwMDAwMDAxMTJkZGI0ODYgQ0ZSdW5Mb29wUnVuU3BlY2lmaWMgKyA0NzA8L3N0cmluZz4KCQk8c3RyaW5nPjIyICBHcmFwaGljc1NlcnZpY2VzICAgICAgICAgICAgICAgICAgICAweDAwMDAwMDAxMTUxNGQ5ZjAgR1NFdmVudFJ1bk1vZGFsICsgMTYxPC9zdHJpbmc+CgkJPHN0cmluZz4yMyAgVUlLaXQgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgMHgwMDAwMDAwMTEzNmFhNDIwIFVJQXBwbGljYXRpb25NYWluICsgMTI4Mjwvc3RyaW5nPgoJCTxzdHJpbmc+MjQgIFBsYW5lQ2lyY2xlICAgICAgICAgICAgICAgICAgICAgICAgIDB4MDAwMDAwMDEwZTQzYjVhZiBtYWluICsgMTExPC9zdHJpbmc+CgkJPHN0cmluZz4yNSAgbGliZHlsZC5keWxpYiAgICAgICAgICAgICAgICAgICAgICAgMHgwMDAwMDAwMTE0YWU3MTQ1IHN0YXJ0ICsgMTwvc3RyaW5nPgoJCTxzdHJpbmc+MjYgID8/PyAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIDB4MDAwMDAwMDAwMDAwMDAwMSAweDAgKyAxPC9zdHJpbmc+Cgk8L2FycmF5Pgo8L2RpY3Q+CjwvcGxpc3Q+Cid9"));
	}*/

	/**
	 * 防止注入
	 * 
	 * @param str
	 *            注入参数
	 * @return
	 */
	public static String TransactSQLInjection(String str) {
		return str.replaceAll("([';])+|(--)+", "");
	}


	
	/**
	* DES解密
	* @param src byte[]	待解密的byte[]
	* @param password 密钥
	* @return byte[] 解密之后的byte[]
	* @throws Exception
	*/
	public static byte[] decrypt(byte[] src, String password) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(password.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
		return cipher.doFinal(src);
	}
	
	 /**
	  * 获取token
	  * @param data	前端传来的参数
	  */
	 public boolean getToken(String data,HttpServletRequest request){
	
	     String token = request.getHeader("token");
	     boolean flag = false;
	     if(pwdEncryptUser("WUCOMTONGSX"+pwdEncryptUser(data)+"MOBILEAPP").equals(token)){
	    	 flag = true;
	     }
	     return flag;
	 }
	 /**
	     * 不够位数的在前面补0，保留num的长度位数字
	     * @param code
	     * @return
	     */
	    public static String autoGenericCode(String code, int num) {
	        String result = "";
	        // 保留num的位数
	        // 0 代表前面补充0     
	        // num 代表长度为4     
	        // d 代表参数为正数型 
	        result = String.format("%0" + num + "d", Integer.parseInt(code));

	        return result;
	    }
	    /**
	     * 获取字符串截取值
	     * @param sque
	     * @return
	     */
		public static String GetStringSub(String sque) {
			String order_no;
			int ind=sque.lastIndexOf("0");
			if(ind>0 && ind>=7){
				ind=ind+1;
				sque=sque.substring(ind,sque.length());
				int temp=Integer.getInteger(sque)+1;
				order_no=DateUtils.getShortYMD() +autoGenericCode((String.valueOf(temp)),4);
			}else{
				sque=sque.substring(8,sque.length());
				int temp=Integer.getInteger(sque)+1;
				order_no=DateUtils.getShortYMD() +temp;
			}
			return order_no;
		}
		/**
		 * 获取时间
		 * @param str
		 * @return
		 */
		public static int getStringNum(String str){
			String regEx="[^0-9]";   
			Pattern p = Pattern.compile(regEx);   
			Matcher m = p.matcher(str);
			if(m==null){
				return 0;
			}else{
			   return Integer.parseInt(m.replaceAll("").trim());
			}
		}
		
		/**
		 * 生成指定长度的随机验证码
		 * @param len
		 * @return
		 */
		public static String generateCode(int len) {
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < len; i++) {
				buffer.append(CHARS.charAt(new Random().nextInt(CHARS.length())));
			}
			return buffer.toString();
		}
		
		/**
		 * 判断字符串为数字或字母
		 * @param str
		 * @return
		 */
		public static Boolean isNumberOrLetter(String str) {
			String regex = "^[a-z|0-9|A-Z]+$";
			return str.matches(regex);
		}
		

		/**
		 * 是否为中文
		 * @param str
		 * @return
		 */
		public static Boolean isChinese(String str) {
			String regEx  = "[\\u4e00-\\u9fa5]+" ;
			return str.matches(regEx);
		}
		
		/**
		 * 判断字符串必须包含数字和字母
		 * @param str
		 * @return
		 */
		public static Boolean isNumberAndLetter(String str) {
			String letter = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]+$";
			return str.matches(letter);
		}
		
		/**
		 * 忽略大小写比较两个字符串
		 * @param str1
		 * @param str2
		 * @return
		 */
		public static boolean ignoreCaseEquals(String str1,String str2){  
		      return str1 == null ? str2 == null :str1.equalsIgnoreCase(str2);  
		}

}




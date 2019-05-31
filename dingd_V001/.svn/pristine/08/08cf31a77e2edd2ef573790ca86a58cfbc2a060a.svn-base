package cn.dingd.dd.common.util;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	// 合作者身份ID,以2088开头由16位纯数字组成的字符串
	public static String partner="2088821964936824";
	
	// 收款支付宝账号
	public static String seller_id=partner;
	
	public static String app_id = "2018010201520012";
	
	public static String notify_url = Constant.notify_url;
	
	public static String method = "alipay.trade.app.pay";
	
	// 交易安全检验码，由数字和字母组成的32位字符串
	// 如果签名方式设置为“MD5”时，请设置该参数
	public static String key = "i9pxkpe7m57k6n3669xtfmtneaovmypn";
	// 商户的私钥
	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANcBOS0DjJtT7xZM"+
			"Q+7i5saSr8eCUHfM0+2n8hbrEwL3RIZ1BjjT91d+cd3JVI6Gnx4gvs5Kyk1eRY1E"+
			"fKMI6w8D3sWdUQSRyEp07sdWwrLy2GXKvXuFzPOrwX2nZbj9VzVNrqxpiRg0BTp7"+
			"d07PyZHQCv2YigZ4egBHzKGM+Rz3AgMBAAECgYEAnkq+R4/HY0xGSApaMXRIJ4Yz"+
			"eBVPHQRmOyBcsdbcJmDZyIw7ynb0MSxctMbXRB+E4m+FSufxTUjMuBbmFDoqo4ak"+
			"axclDHODvvJaXG/N8iRsuH/UtPUEzqjWRquENwvP6uOJ4uaO39iv+2/C30yBn/aj"+
			"qoeyyW4sJuzrfUsZjPECQQD/iUibGU1k/ZS6vQZl1kwrpVO149bNWipXAwGmMk64"+
			"XZjCOJdYJGbEu5Cyunvcsgje3wQ5t6nT64rgOKT6ZBCNAkEA12UcFiJuY23LRJeF"+
			"/nC51OI09UvL88ngO3kvGCjCHv3iWXTLxcyGA+QEFqfMFllFIkMXEzgZFeYn74or"+
			"gPEMkwJAIYxId/ROcN/J0upWGLCVt3UxFEQhQzx/KoU+hi88nn/LOlRrqiq9Qz7M"+
			"tGo/MK4+8+ObjmhKZ4QY628EWcshUQJATwoyWUj/OwtCKQR1Th4tgxoTFuRejjJJ"+
			"T2mzx2jFezvtAKikUgwwLWNRwMKIWLcfcGgwIoRWaDvR8cvBFQrfcwJAVh3+sDPO"+
			"H6DZUVZog659a93VxMPUqCJ0ZxUOs4ZqjW+7H9PrE/I9dJzeWPnxOG/6QHzREUbL"+
			"i3QidzgI11lEmQ==";
	
	// 支付宝的公钥，无需修改该值
	public static String ali_public_key ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";

	
	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "/home/";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "RSA";

}

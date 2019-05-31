package controllerTest;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Common.SendRequest;

public class ControllerTest {
	
	@BeforeClass // 注意,这里必须是static...因为方法将在类被装载的时候就被调用(那时候还没创建实例)  
    public static void before()  
    {  
        System.out.println("global");  
    }  
  
    @AfterClass  
    public static void after() {  
        System.out.println("global destroy");  
    }  
  
    @Before  
    public void setUp() throws Exception {  
        System.out.println("一个测试开始。。");  
    }  
  
    @After  
    public void tearDown() throws Exception {  
        System.out.println("一个测试结束");  
    }
    
    
    
    
    @Test  
    //DetectOrder
    /** 我的订单中心修改订单时间 */
    public void dd() {
    	System.out.println(System.currentTimeMillis());
    }
    @Test  
    //DetectOrder
    /** 我的订单中心修改订单时间 */
    public void DoUpdateTime() {
    	String url="http://localhost:8080/ROOT/DetectOrder/DoUpdateTime.do";
    	String param ="id=5&appointmentTime="+new Date();
    	System.out.println(param);
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    //DetectOrder
    /** 我的订单中心完成订单 */
    public void DoMyDetectOrderOver() {
    	String url="http://localhost:8080/ROOT/DetectOrder/DoMyDetectOrderOver.do";
    	String param = "uPhone=17313178513&checkStatus=3";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    //DetectOrder
    /** 我的订单中心待上传订单 */
    public void DoMyDetectOrderWait() {
    	String url="http://localhost:8080/ROOT/DetectOrder/DoMyDetectOrderWait.do";
    	String param = "uPhone=17313178513&checkStatus=2";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    //DetectOrder
    /** 我的订单中心 */
    public void DoMyDetectOrder() {
    	String url="http://localhost:8080/DetectOrder/DoMyDetectOrder.do";
    	String param = "uPhone=17313178513&checkStatus=1";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    //DetectOrder
    /** 返回所有的车辆品牌 */
    public void DoCarInfoAll() {
    	String url="http://localhost:8080/DetectOrder/DoCarInfoAll.do";
    	String param = "brandsName=迪";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    //DetectOrder
    /** 根据品牌ID查询车系列信息 */
    public void DoFindCarSeriesInfo() {
    	String url="http://localhost:8080/ROOT/DetectOrder/DoFindCarSeriesInfo.do";
    	String param = "brandsId=33";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    //DetectOrder
    /** 根据车辆ID查询车型款式信息 */
    public void DoFindCarModelInfo() {
    	String url="http://localhost:8080/ROOT/DetectOrder/DoFindCarModelInfo.do";
    	String param = "seriesId=3170";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    //DetectOrder
    /** 根据车辆ID获取配置*/
    public void DoFindCarIDInfo() {
    	String url="http://localhost:8080/ROOT/DetectOrder/DoFindCarIDInfo.do";
    	String param = "C1=30307";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    //DetectOrder
    /**根据联系人信息发送验证码授权*/
    public void DoFindAuthorization() {
    	String url="http://localhost:8080/DetectOrder/DoFindAuthorization.do";
    	String param = "telephone=17313178512";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    //DetectOrder
    /**验证码授权检测车辆验证码匹配*/
    public void DoFindAuthorizationCheck() {
    	String url="http://localhost:8080/ROOT/DetectOrder/DoFindAuthorizationCheck.do";
    	String param = "telephone=17313178512&password=266391";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    //DetectOrder
    /**城市ID查询下属地区*/
    public void DoGetAreaId() {
    	String url="http://localhost:8080/DetectOrder/DoGetAreaId.do";
    	String param = "cityId=0";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
  
    @Test  
    //DetectOrder
    /**城市ID查询下属地区*/
    public void DoGetImgInfo() {
    	String url="http://localhost:8080/DetectOrder/DoGetImgInfo.do";
    	String param = "code=1";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    

    
}

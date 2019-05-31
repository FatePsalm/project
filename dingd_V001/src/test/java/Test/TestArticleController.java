package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Common.SendRequest;

public class TestArticleController {
	
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
    
//    @Test  
//    public void testQueryArticle() {
//    	String url="http://192.168.3.66:8080/share/article/queryArticle";
//    	String param = "pageNum=1&pageSize=10&userId=18";
//    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
//    }
//    
//    @Test  
//    public void testQueryArticleAll() {
//    	String url="http://192.168.3.66:8080/share/article/queryArticleAll";
//    	String param = "pageNum=2&pageSize=10&userId=18&type=1";
//    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
//    }
//    @Test  
//    public void testGetArticleSpeech() {
//    	String url="http://192.168.3.66:8080/share/article/getArticleSpeech";
//    	String param = "pageNum=1&pageSize=10&id=14&userId=350";
//    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
//    }
    @Test  
    public void testDoFindAuthorization() {
    	String url="http://localhost:8080/ROOT/DetectOrder/DoFindAuthorization.do";
    	String param = "telephone=17313178512";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    public void testDoCarInfoAll() {
    	String url="http://localhost:8080/ROOT/DetectOrder/DoCarInfoAll.do";
    	String param = "";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    public void testDoFindCarSeriesInfo() {
    	String url="http://localhost:8080/ROOT/DetectOrder/DoFindCarSeriesInfo.do";
    	String param = "brandsId=82";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    public void testDoFindCarModelInfo() {
    	String url="http://localhost:8080/ROOT/DetectOrder/DoFindCarModelInfo.do";
    	String param = "seriesId=3170";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    public void testDoFindCarIDInfo() {
    	String url="http://localhost:8080/ROOT/DetectOrder/DoFindCarIDInfo.do";
    	String param = "C1=27689";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    public void testDoMyDetectOrderOver() {
    	String url="http://localhost:8080/dingd_V001/DetectOrder/DoMyDetectOrderOver.do";
    	String param = "u_phone=17313178513";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    public void testDoMyDetectOrderWait() {
    	String url="http://localhost:8080/dingd_V001/DetectOrder/DoMyDetectOrderWait.do";
    	String param = "u_phone=17313178513";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    public void testGetArticleSpeech() {
    	String url="http://localhost:8080/dingd_V001/LoginDom/loginUserDom.do";
    	String param = "password=123456&account=admin";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    
    @Test  
    public void addCarInfo() {
    	String url="http://localhost:8080/dingd_V001/CarInfoDom/addCarInfoDom.do";
    	String param = "carCx=日系Polo&upTime="+new Date()+"&ghNum=1&xslc=60000&syxz=家庭&carColor=白色&money=3.6";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    
    @Test  
    public void addCarInfoParam() {
    	String url="http://120.78.64.188/CarInfoDom/queryCarList.do";
    	String param = "money=55&moneyEnd=0&page=1&pageSize=10";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    
    @Test  
    public void delCarInfoParam() {
    	String url="http://localhost:8080/dingd_V001/CarInfoDom/addCarInfoDom.do";
    	String param = "money=1&moneyEnd=88888&page=1&pageSize=10&carCx=跑车";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    
    @Test  
    public void delCarInfoParam1() {
    	String url="http://localhost:8080/dingd_V001/CarInfoDom/queryCarInfoDom.do";
    	String param = "id=1";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }

    @Test  
    public void testAddAnswer() {
    	//String url="http://120.79.30.34/CarInfoDom/delCarInfoList.do";
    	List ls=new ArrayList<>();
    String url="http://39.108.70.214/CarInfoDom/addCarInfoDom.do";
   	Map<String,String> param=new HashMap<>();
//    	param.put("imgCount", "3");
//    	param.put("questionId", "1");
//    	param.put("content", "三张图片一样？");
    	//CarInfoDom param=new CarInfoDom();
    	//param.setCarColor("红色");
   	param.put("carColor", "红色");
    param.put("carCx", "丰田");
    param.put("syxz", "家庭");
    param.put("money", "20");
    param.put("carNum", "1");
   param.put("upTime", "2017-01-10");
   	//param.put("ids",ls.toString());
		try {
			Map<String, InputStream> files = new HashMap<String, InputStream>();  
			files.put("files", new FileInputStream(new File("/Users/cancer/Pictures/3d_abstract_wallpaper_by_cs9_fx_design_2-wallpaper-1920x1080.jpg")) );  
			System.out.println(SendRequest.formUpload(url, param,files));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test  
    public void addAuctionSession() {
    	String url="http://localhost:8080/dingd_V001/AuctionSession/addBidding.do";
    	String param = "bidingTime="+new Date()+"&auserId=2&money=1.5&entrustId=2";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    public void queryAuctionSession() {
    	String url="http://localhost:8080/dingd_V001/AuctionSession/queryAuctionSession.do";
    	String param = "";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    @Test  
    public void queryEntrustEntity() {
    	String url="http://localhost:8080/dingd_V001/AuctionSession/queryEntrustEntity.do";
    	String param = "asid=1";
    	System.out.println(SendRequest.doPost(url, param, SendRequest.UTF8));
    }
    
    
}

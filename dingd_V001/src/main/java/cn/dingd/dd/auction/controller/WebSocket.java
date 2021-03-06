package cn.dingd.dd.auction.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.context.ApplicationContext;

import cn.dingd.dd.auction.service.AuctionSessionService;
import cn.dingd.dd.common.entity.AuctionRecordEntity;
import cn.dingd.dd.common.util.Constant;
import cn.dingd.dd.common.util.DateUtils;
import cn.dingd.dd.common.util.NumberUtil;
import cn.dingd.dd.common.util.RedisClient;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.view.AuctionCarMoney;
import cn.dingd.dd.common.web.ApplicationContextRegister;
import net.sf.json.JSONObject;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年10月25日 下午5:10:17
* 类说明
*/

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 *                 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/websocket/{param}")
public class WebSocket {

	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;
	// concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
	// 若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	public static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();
	
	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	public Session session;

	
	/**
	 * 连接建立成功调用的方法
	 * 
	 * @param session
	 *            可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	@OnOpen
	public void onOpen(@PathParam(value="param") String param,Session session, EndpointConfig config) {
		this.session = session;
		webSocketSet.add(this); // 加入set中
		addOnlineCount(); // 在线数加1
		//System.out.println(Constant.map.containsKey("auserId") +"==============仄仄仄"+Constant.map.get("session")+"仄仄仄============"+ Constant.map.get("auserId")+"多久的"+session);
	   if(Constant.map.containsKey("auserId")  && param.equals(Constant.map.get("auserId").toString())){
		   Constant.map.put("session",session);
	   }
		//System.out.println("有新连接加入"+param+"！当前在线人数为" + getOnlineCount()+"新的session"+Constant.map.get("session"));
	}

	
 

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		webSocketSet.remove(this); // 从set中删除
		subOnlineCount(); // 在线数减1
	}

	/**
	 * 收到客户端消息后调用的方法
	 * 
	 * @param message
	 *            客户端发送过来的消息
	 * @param session
	 *            可选的参数
	 * @throws Exception 
	 */
	@OnMessage
	public void onMessage(String message, Session sessiong) throws Exception {
		int userId = 0;// 用户
		int auctionMoney = 0;// 加价后总价
		int carId = 0;// 车辆id
		int auctionRange = 0;// 加价幅度
		int  carMoney=0;//车价
		int asid=0;//场次id
		int restTime=10;
		int type=1;
		
		String msg=message;
		
		if(!StringUtils.isNotNullStr(msg)){
			throw new Exception("信息不能为空！");
		}
		JSONObject jsonObject=JSONObject.fromObject(msg);
		
	  	if(!jsonObject.containsKey("type") || jsonObject.get("type")==null){
	  		throw new Exception("信息来源不正确！");
	  	}else{
	  		type=(int) jsonObject.get("type");
	  	}
	  	if(!jsonObject.containsKey("asid") || jsonObject.getInt("asid")<0){
			throw new Exception("场次信息不能为空！");
		}
		else{
			asid=jsonObject.getInt("asid");
		}
		if(!jsonObject.containsKey("carId") || jsonObject.getInt("carId")<0){
			throw new Exception("车辆信息不能为空！");
		}else{
			carId=jsonObject.getInt("carId");
		}
	 	if(((int)Constant.map.get("asid"))!=asid || ((int)Constant.map.get("carId"))!=carId  || !Constant.end){
	  		  messgeStop();
	  		return;
	  	}
	  	 if(type==2){//管理员人工达到保留价
	  		 if(!Constant.map.containsKey("auserId")){
	  			throw new Exception("没人出价不允许人工干预！");
	  		 }
	  		Constant.light=1;
	 		// 群发消息
				for (WebSocket item :webSocketSet) {
					try {
						if(Constant.map.get("session")==item.session){
							  Constant.result_Map.put("bidding", 1);
						}else{
							 Constant.result_Map.put("bidding", 0);
						}
						Constant.result_Map.put("moneyTime", 10);
						Constant.result_Map.put("pmTime",Constant.pm);
		              	Constant.result_Map.put("light",Constant.light);//是否过保留价
		              	Constant.map.put("light",Constant.light);
		              	Constant.result_Map.put("status", 0);//正常
		              	item.sendMessage(JSONObject.fromObject(Constant.result_Map).toString());
					} catch (IOException e) {
						e.printStackTrace();
						continue;
					}
				}
				return;
	  	 }
	  	
	   if(!jsonObject.containsKey("auserId") || jsonObject.getInt("auserId")<0){
				throw new Exception("用户信息不能为空！");
		}else{
				userId=jsonObject.getInt("auserId");
		}
		
		if(!jsonObject.containsKey("auctionRange") || jsonObject.getInt("auctionRange")<0){
			throw new Exception("加价信息不能为空！");
		}
		else{
			auctionRange=jsonObject.getInt("auctionRange");
		}
	
		if(!jsonObject.containsKey("carMoney") || jsonObject.get("carMoney")==null){
			throw new Exception("车价信息不能为空！");
		}
		if(!NumberUtil.isNumber(jsonObject.get("carMoney").toString())){
			throw new Exception("车价不是数字！");
		}
		else{
			carMoney=jsonObject.getInt("carMoney");
		}
	  	Constant.pm=restTime;
		Constant.tempTime=restTime;
		
		ApplicationContext act = ApplicationContextRegister.getApplicationContext();
		AuctionSessionService serv = act.getBean(AuctionSessionService.class);
	
		 try {
		                    carMoney=(carMoney+auctionRange);
							float price = Float.parseFloat(Constant.map.get("carMoney").toString());//获取价格
							if(((float) carMoney)>price){//判断是否大于上一个人的价格
								Constant.result_Map.put("carMoney", carMoney);
								Constant.map.put("carMoney", carMoney+"");//存储当前价格
								AuctionCarMoney am=new AuctionCarMoney();
								am.setMoney(auctionRange);
								am.setTime(DateUtils.getLongHMS());
								RedisClient.setRedisList(am, "AuctionCarMoney",AuctionCarMoney.class);//添加出价纪录
								Constant.result_Map.put("list",RedisClient.getRedisList("AuctionCarMoney",AuctionCarMoney.class));	//获取出价记录		
								if(Constant.retentionMoney<((float)carMoney) && Constant.light==0){
									Constant.result_Map.put("light",1);//是否过保留价
									Constant.light=1;
								}
								int serviceCharge=Constant.SERVICEMONEY;//服务费
								if(carMoney>Constant.STANDARD){
									serviceCharge=(int)(carMoney*Constant.RATE);
									Constant.result_Map.put("serviceCharge",serviceCharge);
								}else{
									Constant.result_Map.put("serviceCharge",serviceCharge);
								}
								auctionMoney= (serviceCharge+carMoney+Constant.registFee);
								Constant.map.put("auctionMoney",auctionMoney);
								Constant.result_Map.put("auctionMoney",auctionMoney);
								Constant.result_Map.put("moneyTime", restTime);
								Constant.result_Map.put("pmTime",restTime);
								// 群发消息
								for (WebSocket item :webSocketSet) {
									try {
						              	if(session==item.session){
											  Constant.result_Map.put("bidding", 1);
										}else{
											 Constant.result_Map.put("bidding", 0);
										}
						              	Constant.result_Map.put("status", 0);
						              	Constant.result_Map.put("auserId", 0);
						              	item.sendMessage(JSONObject.fromObject(Constant.result_Map).toString());
									} catch (IOException e) {
										e.printStackTrace();
										continue;
									}
								}
							}
							if(auctionRange>0){
								AuctionRecordEntity auctionRecordEntity = new AuctionRecordEntity();
								auctionRecordEntity.setAuctionMoney( auctionMoney);
								auctionRecordEntity.setAuctionRange( auctionRange);
								auctionRecordEntity.setCarId(carId);
								auctionRecordEntity.setAuserId(userId);
								auctionRecordEntity.setAuctionTime(new Date());
								auctionRecordEntity.setAuctionId(asid);
								serv.addAuctionRecord(auctionRecordEntity);	
						  }
				} catch (Exception e) {
				  e.printStackTrace();
					Constant.result_Map=new HashMap<>();
					Constant.result_Map.put("status", 3);
					for (WebSocket item :WebSocket.webSocketSet) {
						  item.sendMessage(JSONObject.fromObject(Constant.result_Map).toString());
					}
				}
		
			Constant.map.put("auserId", userId);
			Constant.map.put("carId", carId);
			Constant.map.put("auctionRange", auctionRange);
			Constant.map.put("carMoney", carMoney);
			Constant.map.put("light", Constant.light);
			Constant.map.put("asid", asid);
			Constant.map.put("session",session );
	}



/**
 * 推送信息
 */
	private void messgeStop() {
		for (WebSocket item :webSocketSet) {
			try {
		      	if(session==item.session){
		      		Constant.result_Map.put("status",4);//拍过了
		           	item.sendMessage(JSONObject.fromObject(Constant.result_Map).toString());
				}
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
	}
	

	/**
	 * 发生错误时调用
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		error.printStackTrace();
	}

	/**
	 * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
		// this.session.getAsyncRemote().sendText(message);
	}

	public static synchronized int getOnlineCount() {
		return onlineCount; 
	}

	public static synchronized void addOnlineCount() {
		WebSocket.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocket.onlineCount--;
	}

}

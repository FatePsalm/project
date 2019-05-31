package cn.dingd.dd.auction.service.impl;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dingd.dd.auction.controller.WebSocket;
import cn.dingd.dd.auction.dao.AuctionOrderDao;
import cn.dingd.dd.auction.dao.AuctionSessionDao;
import cn.dingd.dd.auction.dao.PayOrderDao;
import cn.dingd.dd.auction.dao.TCarBasisInfoDao;
import cn.dingd.dd.auction.service.AuctionSessionService;
import cn.dingd.dd.common.dao.CommonDao;
import cn.dingd.dd.common.entity.AuctionOrderEntity;
import cn.dingd.dd.common.entity.AuctionRecordEntity;
import cn.dingd.dd.common.entity.AuctionSessionEntity;
import cn.dingd.dd.common.entity.BiddingEntity;
import cn.dingd.dd.common.entity.CapitalAccountEntity;
import cn.dingd.dd.common.entity.CarDamageEntity;
import cn.dingd.dd.common.entity.CarDominantEntity;
import cn.dingd.dd.common.entity.PayOrderEntity;
import cn.dingd.dd.common.entity.PaymentInfoEntity;
import cn.dingd.dd.common.quartz.QuartzTime;
import cn.dingd.dd.common.util.Constant;
import cn.dingd.dd.common.util.DTimer;
import cn.dingd.dd.common.util.DateUtils;
import cn.dingd.dd.common.util.NumberUtil;
import cn.dingd.dd.common.util.RedisClient;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.view.ShowAuctionDto;
import cn.dingd.dd.common.view.TCarBasisInfoEntity;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.dao.DictInfoDao;
import net.sf.json.JSONObject;

/**
 * 拍卖场次实现类
 * 
 * @author XCD
 *
 */
@Service
public class AuctionSessionServiceImpl implements AuctionSessionService {

   
	
	@Resource
	private AuctionSessionDao auctionSessionDao;
	@Resource
	private AuctionOrderDao auctionOrderDao;
	@Resource
	private PayOrderDao payOrderDao;
    @Resource
    private TCarBasisInfoDao tCarBasisInfoDao;
    @Resource
    private CommonDao commonDao;
    @Resource
    private DictInfoDao dictInfoDao;
    
	/**
	 * 获取拍卖场次
	 * @throws Exception 
	 */
	@Override
	public List<AuctionSessionEntity> queryAuctionSession() throws Exception {

		try {
			Date date = new Date();
			return auctionSessionDao.queryAuctionSession(date);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询失败！");
		}
	}

	/**
	 * 查询拍卖场次的车辆信息
	 * @throws Exception 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Map> queryAuctionCar(int auctionId,int userId,int status,Date dateStart,PageObject  pageObject) throws Exception {

		try {
		  List<Map> ls=auctionSessionDao.queryAuctionCar(userId,auctionId,status,dateStart,pageObject);
		return ls;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取失败！");
		}
	}

	/**
	 * 添加竞价信息
	 * @throws Exception 
	 */
	@Override
	public boolean addBiddingEntity(BiddingEntity biddingEntity) throws Exception {

		try {
			auctionSessionDao.addBiddingEntity(biddingEntity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("添加失败!");
		}

	}

	/**
	 * 添加出价记录
	 * 
	 * @param auctionRecordEntity
	 * @return
	 * @throws Exception 
	 */
	@Override
	public boolean addAuctionRecord(AuctionRecordEntity auctionRecordEntity) throws Exception {

		try {
			auctionSessionDao.addAuctionRecord(auctionRecordEntity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("出价失败！");
		}

	}

	/**
	 * 添加订单
	 * 
	 * @param auctionOrderEntity
	 * @return
	 * @throws Exception 
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean addAuctionOrder(AuctionOrderEntity auctionOrderEntity) throws Exception {
		try {
			Calendar calendar = Calendar.getInstance();
			// 设置时间
			calendar.setTime(auctionOrderEntity.getOrderTime());
			// 时间规则/过期时间
			calendar.add(Calendar.HOUR_OF_DAY, DateUtils.OUTTIME);
			//calendar.add(Calendar.MINUTE, 60);//分
			// 时间判定
			Date outDate = DateUtils.getTimeout(calendar);
			auctionOrderEntity.setAbortTime(outDate);
			String order_no = DateUtils.getShortYMD()
					+ StringUtils.autoGenericCode(RedisClient.getSequence("AuctionOrder"), 4);
			if (!StringUtils.isNotNullStr(order_no)) {
				String sque;
				sque = getIdentMax();
				order_no = StringUtils.GetStringSub(sque);
			}
			auctionOrderEntity.setOrderNum(order_no);
			// 生成拍卖订单
			int oid = auctionOrderDao.addAuctionOrder(auctionOrderEntity);
			if (oid <= 0) {
				throw new Exception("拍卖订单生成失败！");
			}
	    	int rul=	tCarBasisInfoDao.setCarStatus(7,auctionOrderEntity.getCarId());
			if(rul==0){
				throw new RuntimeException("车辆状态修改失败！");
			}
			
				if(!RedisClient.saveSetInfo(QuartzTime.orderOutTime, outDate.getTime(), String.valueOf(auctionOrderEntity.getId()))){
					throw new RuntimeException("添加定时器失败！");
				}
			  QuartzTime.getQuartz(new Date(outDate.getTime()), "order"+auctionOrderEntity.getId(),2);
		
			// 生成保证金支付订单
			PayOrderEntity orderEntity = new PayOrderEntity();
			orderEntity.setAuserId(auctionOrderEntity.getAuserId());
			orderEntity.setTitle("拍中车辆");
			orderEntity.setMchannel(3);
			orderEntity.setCarId(auctionOrderEntity.getCarId());
		
			try {
				order_no = DateUtils.getShortYMD() + StringUtils.autoGenericCode(RedisClient.getSequence("orderno"), 4);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			orderEntity.setMnumber(order_no);
			orderEntity.setMoney(Constant.PLEDGE);
			orderEntity.setMstate(1);
			orderEntity.setPayTime(DateUtils.getShortYMDHMS());
			orderEntity.setMtime(new Date());
			orderEntity.setMtype(1);
			orderEntity.setThreeNo(String.valueOf(auctionOrderEntity.getId()));
			int id = payOrderDao.addPayOrder(orderEntity);
			if (id <= 0) {
				throw new RuntimeException("支付订单生成失败！");
			}
			// 修改资金账户
			CapitalAccountEntity accountEntity = payOrderDao.getUserCapitalAccount(auctionOrderEntity.getAuserId());
			if (accountEntity == null) {
				throw new Exception("没有资金账户!");
			}
			float balance = accountEntity.getBalance();
			
			if (balance < Constant.PLEDGE) {
				throw new Exception("资金账户余额不足!");
			}
			accountEntity.setBalance(balance - Constant.PLEDGE);
			accountEntity.setFreeze(accountEntity.getFreeze()+Constant.PLEDGE);
			// 生成支付订单
			if(payOrderDao.updCapitalAccountEntity(accountEntity)<=0){
				throw new RuntimeException("账户资金修改失败！");
			}
			// 添加消费记录
			PaymentInfoEntity entity = new PaymentInfoEntity();
			entity.setAuserId(auctionOrderEntity.getAuserId());
			entity.setMoney(Constant.PLEDGE);
			entity.setPayOrderId(orderEntity.getId());
			entity.setCreateTime(new Date());
			entity.setCurrentBalance(accountEntity.getBalance());
			entity.setComments("拍中车辆冻结");
			if(payOrderDao.addPaymentInfo(entity)<=0){
				throw new RuntimeException("消费信息生成失败！");
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("添加失败！");
		}

	}

	/**
	 * 修改拍卖订单
	 * 
	 * @param auctionOrderEntity
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updAuctionOrder(int id) {
		try {
						// 生成扣款支付订单
						PayOrderEntity payOrderEntity = payOrderDao.getPayOrderWithhold(null, id+"", 0, 1,1,new Date());
                        if(payOrderEntity==null){
                        	throw new Exception("没有需要扣款的订单！");
                        }
						String order_no = null;
						try {
							// 获取订单号
							order_no = DateUtils.getShortYMD()
									+ StringUtils.autoGenericCode(RedisClient.getSequence("orderno"), 4);
						} catch (Exception e1) {
							e1.printStackTrace();
							throw new Exception("订单号生成失败！");
						}
						payOrderEntity.setMnumber(order_no);
						payOrderEntity.setTitle("订单规定时间没交易。");
						payOrderEntity.setMtype(4);
						payOrderEntity.setMchannel(3);
						payOrderEntity.setMtime(new Date());
						payOrderEntity.setPayTime(DateUtils.getLongYMDHMS());
						payOrderEntity.setMstate(1);
						payOrderEntity.setId(0);
						int oid = payOrderDao.addPayOrder(payOrderEntity);
						// 生成订单
						if (oid <= 0) {
							throw new Exception("扣款订单生成失败！");
						}
						// 修改资金账户
						CapitalAccountEntity accountEntity = payOrderDao.getUserCapitalAccount(payOrderEntity.getAuserId());
						if (accountEntity == null) {
							throw new Exception("账号不存在！");
						}
						accountEntity.setFreeze(NumberUtil.sub(accountEntity.getFreeze(), payOrderEntity.getMoney()));
						// 修改资金账户
						if (payOrderDao.updCapitalAccountEntity(accountEntity) != 1) {
							throw new Exception("资金账户修改失败！");
						}
							PaymentInfoEntity paymentInfoEntity = new PaymentInfoEntity();
							paymentInfoEntity.setAuserId(payOrderEntity.getAuserId());
							paymentInfoEntity.setComments("订单规定时间没交易");
							paymentInfoEntity.setCreateTime(new Date());
							paymentInfoEntity.setMoney(payOrderEntity.getMoney());
							paymentInfoEntity.setCurrentBalance(accountEntity.getBalance());
							paymentInfoEntity.setPayOrderId(payOrderEntity.getId());
							if (payOrderDao.addPaymentInfo(paymentInfoEntity) != 1) {
								throw new Exception("消费信息生成失败！");
							}
							AuctionOrderEntity auctionOrderEntity=auctionOrderDao.geAuctionOrderEntityId(id);
							if(auctionOrderEntity==null){
								return true;
							}
							auctionOrderEntity.setOrderState(5);
							if(auctionOrderDao.updAuctionOrder(auctionOrderEntity)!=1){
								throw new Exception("拍卖订单更新失败！");
							}
							cn.dingd.dd.common.entity.TCarBasisInfoEntity basisInfoEntity=tCarBasisInfoDao.getTCarBasisInfoEntityId(payOrderEntity.getCarId());
							if(basisInfoEntity==null){
								throw new Exception("车辆信息不存在！");
							}
							basisInfoEntity.setCarState(1);
							if(tCarBasisInfoDao.setCarStatus(1, basisInfoEntity.getId())!=1){
								throw new Exception("车辆状态更新失败！");
							}
							// 删除redis里面的数据
							RedisClient.delSetInfo(QuartzTime.orderOutTime, id+"");
	
		} catch (Exception e) {
			//删除redis里面的数据
			RedisClient.delSetInfo(QuartzTime.orderOutTime, id+"");
			e.printStackTrace();
		}
		return true;
	}


	/**
	 * 获取最大id的订单号
	 * 
	 * @return
	 */
	@Override
	public String getIdentMax() {
		return auctionOrderDao.getIdentMax();
	}



   /**
    * 获取车辆详情
 * @throws Exception 
    */
	@Override
	public TCarBasisInfoEntity queryTCarinfo(int auctionId,int carId,int userId) throws Exception {
		try {
			TCarBasisInfoEntity basisInfoEntity=auctionSessionDao.queryTCarinfo(userId,auctionId,carId);
			 basisInfoEntity.setDcount(tCarBasisInfoDao.getCountDominant(carId));
			if(basisInfoEntity!=null){
				basisInfoEntity.setPcount(tCarBasisInfoDao.getCarInfoCount(userId,auctionId,carId));
			}
			return basisInfoEntity ;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取失败！");
		}
	}
	/**
	 * 获取车辆隐性损伤信息
	 * @param carid
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<CarDamageEntity> getCarDamage(int carid) throws Exception {
		 try {
			return tCarBasisInfoDao.getCarDamage(carid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取车辆图片信息失败！");
		}
	}


  /**
   * 获取订单
   * @param userId
   * @return
 * @throws Exception 
   */
	@SuppressWarnings("rawtypes")
	@Override
	public  List<Map> getAuctionOrderEntities(int userId,PageObject pageObject) throws Exception {
		
		try {
			List<Map> ls= auctionOrderDao.queryAuctionOrder(userId,pageObject);
			return ls ;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取订单失败！");
		}
	}
	/**
	 * 获取场次下面的车辆数和开拍时间
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Map getAuctionCarTime(int asid,int status) throws Exception {
		
		try {
			return auctionSessionDao.getAuctionCarTime(asid,status);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取失败！");
		}
	}
	/**
	 * 设置车辆状态
	 */
	@Override
	public int setCarStatus(int carId, int status) throws Exception {
		 int rl= tCarBasisInfoDao.setCarStatus( status,carId);
		return rl;
	}
  /**
   * 拍卖车辆设置车辆状态
   */
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean getAuctionCar(int asid)throws Exception {
		           System.out.println("开启拍卖场次");
		            try {
						Integer status = auctionSessionDao.getAuctionStatus(2);
						if (status != null) {
							throw new Exception("场次没完成不能开始下一场！");
						}
						if (commonDao.UpdateFirstField(asid, 2) <= 0) {
							throw new Exception("定时器场次启动失败！");
						}
						Constant.map.put("asid", asid);
						Map resultMap = null;
						resultMap = auctionSessionDao.getTCarBasisinfo(asid, 6);//根据场次获取车辆id
						if (resultMap == null) {
							if (auctionSessionDao.updAuctionOver(3, new Date(), asid) <= 0) {//更改场次拍卖时间和状态
								throw new Exception("场次停止失败！");
							}
							return true;
						}
						Constant.retentionMoney = (float) resultMap.get("retentionMoney");//保留价
						Constant.map.put("carMoney", resultMap.get("askingPrice"));//起拍价
						Constant.map.put("carId", resultMap.get("id"));//车辆id
						Constant.map.put("auctionMoney", resultMap.get("askingPrice"));//车价
						Constant.light = 0;
						Constant.map.put("light", Constant.light);
						Constant.result_Map.put("carId", resultMap.get("id"));//车辆id
						Constant.result_Map.put("carMoney", resultMap.get("askingPrice"));//起拍价
						Constant.result_Map.put("title",
								resultMap.get("cars") == null ? ""
										: resultMap.get("cars").toString() + resultMap.get("carModel") == null ? ""
												: resultMap.get("carModel").toString());
						Constant.biddingMoney = (float) (resultMap.get("money") == null ? 0f : resultMap.get("money"));
						String account = resultMap.get("account") == null ? null : resultMap.get("account").toString();
						if (account != null) {
							Constant.result_Map.put("account",
									account.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
						}
						if (tCarBasisInfoDao.setCarStatus(2, (int) resultMap.get("id")) <= 0) {
							throw new Exception("更改车辆状态失败！");
						}
						DTimer.getSingletonInstance().schedule(new TimerTask() {
							public void run() {
								Constant.pm--;
								if (Constant.pm == 0) {
									try {
										Constant.end = false;
										Constant.pm = 25;
										Constant.tempTime = 25;
										createAuctionOrder();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						}, 1000, 1000);// 设定指定的时间time,此处为1000毫秒
						return true;
					} catch (Exception e) {
						e.printStackTrace();
						throw new Exception("场次开拍失败！");
					}
	}

		   /**
		    * 创建订单
		    * @param serv
		    */
		@SuppressWarnings("rawtypes")
		@Transactional(rollbackFor = Exception.class)
		public void createAuctionOrder() throws Exception{
			    Map resultMap=null;
			    Map<String,Object> map=Constant.map;//获取拍卖信息
				try {
					
				    	   if (Constant.light >0) {
								AuctionOrderEntity auctionOrderEntity = new AuctionOrderEntity();
								auctionOrderEntity.setAuserId(Integer.parseInt(map.get("auserId").toString()));
								auctionOrderEntity.setCarId(Integer.parseInt(map.get("carId").toString()));
								auctionOrderEntity.setOrderState(1);
								auctionOrderEntity.setOrderTime(new Date());
								auctionOrderEntity.setAchieveMoney(Float.parseFloat(map.get("carMoney").toString()) );
								auctionOrderEntity.setTotalMoney(Float.parseFloat(map.get("auctionMoney").toString()));
								auctionOrderEntity.setAuctionId((int)map.get("asid"));
								auctionOrderEntity.setRegistFee(Constant.registFee);
								auctionOrderEntity.setServerMoney((int)Constant.result_Map.get("serviceCharge"));
								//((AuctionSessionServiceImpl)AopContext.currentProxy()).addAuctionOrder(auctionOrderEntity);
								addAuctionOrder(auctionOrderEntity);
							}
						    else{
						    	tCarBasisInfoDao.setCarStatus(1,Integer.parseInt(map.get("carId").toString()));	
						    }
					resultMap =auctionSessionDao.getTCarBasisinfo(Integer.parseInt(map.get("asid").toString()),6);//根据场次获取车辆id
					if(resultMap!=null && resultMap.get("id")!=null){
						tCarBasisInfoDao.setCarStatus(2,(int)resultMap.get("id"));
						Constant.result_Map.put("carId",resultMap.get("id"));//车辆id
						Constant.result_Map.put("status",1);
						Constant.result_Map.put("carMoney", resultMap.get("askingPrice"));//起拍价
						pushMessage(map);
						Constant.light=0;
						Constant.map.put("light", Constant.light);//保留价标识
						Constant.result_Map=new HashMap<>();
						Constant.result_Map.put("title",resultMap.get("cars")==null?"":resultMap.get("cars").toString()+resultMap.get("carModel")==null?"":resultMap.get("carModel").toString());//车辆信息
						RedisClient.restRedisList("AuctionCarMoney");
						Constant.retentionMoney=((float)resultMap.get("retentionMoney"));//保留价
						Constant.map.put("carMoney", resultMap.get("askingPrice"));//起拍价
						Constant.map.put("carId",resultMap.get("id"));//车辆id
						Constant.biddingMoney=(float)(resultMap.get("money")==null?0f:resultMap.get("money"));
				        String account=resultMap.get("account")==null?null:resultMap.get("account").toString();
				            if(account!=null){
				            	Constant.result_Map.put("account",account.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
				            }
					}
					else{
						       Constant.result_Map.put("status",2);//1还有下一辆2为没有3此辆车一拍过0正常加价
							   if(auctionSessionDao.updAuctionOver(3,new Date(),Integer.parseInt(map.get("asid").toString()))<=0){//更改场次拍卖时间和状态
						        	throw new Exception("场次停止失败！");
						        }
							   pushMessage(map);
							   RedisClient.restRedisList("AuctionCarMoney");
							   Constant.result_Map=new HashMap<>();
							   Constant.map=new HashMap<>();
							   DTimer.getSingletonInstance().cancel();
							   DTimer.timer=null;
				    }
					
				} catch (Exception e) {
					e.printStackTrace();
					//RedisClient.restRedisList("AuctionCarMoney");
					resultMap =auctionSessionDao.getTCarBasisinfo(Integer.parseInt(map.get("asid").toString()),6);//根据场次获取车辆id
					Constant.result_Map=new HashMap<>();
					Constant.result_Map.put("status", 1);
					Constant.result_Map.put("carId",resultMap.get("id"));//车辆id
					Constant.map=new HashMap<>();
					DTimer.getSingletonInstance().cancel();
					DTimer.timer=null;
					for (WebSocket item :WebSocket.webSocketSet) {
						  item.sendMessage(JSONObject.fromObject(Constant.result_Map).toString());
					}
					auctionSessionDao.updAuctionOver(1,new Date(),Integer.parseInt(map.get("asid").toString()));//场次停止
					getAuctionCar(Integer.parseInt(map.get("asid").toString()));
				}
			}
		//推送消息
		private void pushMessage(Map<String, Object> map ){
			Constant.end=true;//车辆开始竞拍
			// 群发消息
			for (WebSocket item :WebSocket.webSocketSet) {
				try {
					 if(map!=null && Constant.map.get("session")==item.session){
											if( Constant.biddingMoney>=Float.parseFloat(map.get("carMoney").toString()) && Constant.retentionMoney<Constant.biddingMoney){//预报价大于竞价
											    Constant.result_Map.put("carMoney", Constant.biddingMoney);
											    Constant.result_Map.put("bidOrAuct", 1);
											}else if(Constant.light>0){//竞拍大于预报
											    Constant.result_Map.put("carMoney",Float.parseFloat(map.get("carMoney").toString()));
											    Constant.result_Map.put("bidOrAuct", 2);//竞价大于预备价
											} 
											else{
												 Constant.result_Map.put("bidOrAuct", 0);//流拍
											}
								   
								  Constant.result_Map.put("bidding",1);
								
						 }else{
							  Constant.result_Map.put("bidding",0);
						 }
							  Constant.result_Map.put("end", 1);//流拍
							  item.sendMessage(JSONObject.fromObject(Constant.result_Map).toString());
				} catch (IOException e) {
					e.printStackTrace();
					continue;
				}
			}
		}

	/**
	 * 获取车辆状态
	 * @param carId
	 * @return
	 */
	@Override
	public int getAuctionCarStatus(int carId) {
		Integer status=tCarBasisInfoDao.getAuctionCarStatus(carId);
		if(status==null){
			status=0;
		}
		  return status;
	}
	/***
	 * 获取车辆损伤图片
	 * @param carId
	 * @return
	 */
		@Override
		public List<Map> getRestsPicture(int carId) {
			return tCarBasisInfoDao.getRestsPicture(carId);
		}

	/**
	 * 获取拍卖订单状态
	 */
	@Override
	public Integer getAuctionStatus(int status) {
		return  auctionSessionDao.getAuctionStatus(2);
	}

	/**
	 * 获取车辆信息
	 */
	@Override
	public TCarBasisInfoEntity getTCarBasisInfoID(int carId) {
		TCarBasisInfoEntity basisInfoEntity=auctionSessionDao.getTCarBasisInfoID(carId);
		if(basisInfoEntity!=null){
			basisInfoEntity.setDcount(tCarBasisInfoDao.getCountDominant(carId));
		}
		return basisInfoEntity;
	}
   /**
    * 获取分页信息
    */
	@Override
	public Integer queryAuctionCarPage(int userId, int asid, int status, Date dateStart) {
		Integer count=auctionSessionDao.queryAuctionCarPage(userId,asid,status,dateStart);
		return count;
	}
   /**
    * 获取订单分页信息
    */
	@Override
	public Integer getAuctionOrderPage(int userId) {
		return auctionOrderDao.getAuctionOrderPage(userId);
	}

	/**
	 * 获取车辆显性损伤
	 * @throws Exception 
	 */
	@Override
	public List<CarDominantEntity> getCarDominant(int carId) throws Exception {
		try {
		
			List<CarDominantEntity> carDoms = tCarBasisInfoDao.getCarDominant(carId);
			return carDoms;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取失败");
		}
	}
	
	@Override
	public ShowAuctionDto getCarInfo() {
		ShowAuctionDto showAuctionDto = auctionSessionDao.showAuction();
		if (showAuctionDto==null) {
			showAuctionDto = auctionSessionDao.getCarInfo();
		}
		return showAuctionDto;
	}
	
	
}

package Common;

import cn.dingd.dd.biz.backgroud.dao.DictionaryDao;
import cn.dingd.dd.biz.backgroud.dao.OrganizationInfoMapper;
import cn.dingd.dd.biz.common.entity.DdDictEntity;
import cn.dingd.dd.biz.common.entity.OrganizationInfo;
import cn.dingd.dd.biz.common.entity.OrganizationInfoExample;
import cn.dingd.dd.biz.common.entity.OrganizationInfoExample.Criteria;
import cn.dingd.dd.common.dao.CommonDao;
import cn.dingd.dd.common.entity.*;
import cn.dingd.dd.common.service.impl.CommonServiceImpl;
import cn.dingd.dd.common.util.CF;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.detection.dao.DetectOrderDao;
import cn.dingd.dd.detection.service.impl.DetectOrderServiceImpl;
import cn.dingd.dd.management.dao.*;
import net.sf.json.JSONObject;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年9月20日 上午11:10:35 类说明
 */
public class CommonTest {

	@Value("#{configProperties['salt']}")
	private String salt;
	private ClassPathXmlApplicationContext context;
	private static int level = 0;

	@Test
	public void test81() {
		Double meony = -1D;
		Double aDouble = CF.oderFL(null);
		System.out.println(aDouble);
	}
	@Test
	public void test80() {
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		OrganizationInfoMapper dao = (OrganizationInfoMapper) context.getBean("organizationInfoMapper");
		OrganizationInfoExample example = new OrganizationInfoExample();// 生成查找实体
		Criteria criteria = example.createCriteria();// 生成查找条件
		criteria.andNameLike("%" + "部" + "%")
		.andParentIdIsNotNull();// 查询条件拼接
		List<OrganizationInfo> selectByExample = dao.selectByExample(example);
		System.out.println(selectByExample);
		 selectByExample.stream().map(OrganizationInfo::getId).collect(Collectors.toSet())
				.forEach(System.out::println);
	}
	@Test
	public void test76() {
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		DictionaryDao dao = (DictionaryDao) context.getBean("dictionaryDao");
		List<DdDictEntity> dictionary = dao.selectAll();
		Map<Integer, List<DdDictEntity>> collect = dictionary.stream()
				.collect(Collectors.groupingBy(DdDictEntity::getParentId));
		Set<Integer> keySet = collect.keySet();
		List<DdDictEntity> list = collect.get(0);
		test78(collect, list, keySet);
		System.out.println(list);
		test79(list);
	}

	public void test79(List<DdDictEntity> list) {
		for (DdDictEntity tree : list) {
			String string="";
			for (int i = 0; i <level; i++) {
				string+="-";
			}
			if(tree.getParentId()!=0) {
				System.out.println("|"+string+tree.getDictName() + ":" + level);
			}else {
				System.out.println(tree.getDictName() + ":" + level);
			}
			if (tree.getChildList() != null) {
				++level;
				test79(tree.getChildList());
				--level;
			}
		}
	}

	public void test78(Map<Integer, List<DdDictEntity>> collect, List<DdDictEntity> list, Set<Integer> keySet) {
		for (DdDictEntity tree : list) {
			if (keySet.contains(tree.getId())) {// 如果分组集合中,有父级ID则获取集合放入父级
				tree.setChildList(collect.get(tree.getId()));
				test78(collect, tree.getChildList(), keySet);// 把子级看做父级放入方法
			}
		}
	}

	@Test
	public void test75() {
		/** 查询用户id */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		DetectOrderDao dao = (DetectOrderDao) context.getBean("detectOrderDao");
		System.out.println(dao.findVIN("浙AB4J99", "LFV4A24F593078948"));
	}

	@Test
	public void test77() {
		/** 查询用户id */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageAuctionsDao dao = (ManageAuctionsDao) context.getBean("manageAuctionsDao");
		System.out.println(dao.State(16));
	}

	@Test
	public void test74() {
		/** 查询用户id */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		MamageOrderDao dao = (MamageOrderDao) context.getBean("mamageOrderDao");
		System.out.println(dao.findAuctionOrderEntity(61));
	}

	@Test
	public void test73() {
		/** 解冻资金 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		MamageOrderDao dao = (MamageOrderDao) context.getBean("mamageOrderDao");
		System.out.println(dao.RemoveMoney(61, 2000));
	}

	@Test
	public void test72() {
		/** 查询车辆详细 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		SecondsDao dao = (SecondsDao) context.getBean("secondsDao");
		System.out.println(dao.findCarId(15));
	}

	@Test
	public void test71() {
		/** 查询车辆状态 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		CommonDao dao = (CommonDao) context.getBean("commonDao");
		System.out.println(dao.findCarState(15));
	}

	@Test
	public void test69() {
		/** 查询冻结记录 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageMoneyDao dao = (ManageMoneyDao) context.getBean("manageMoneyDao");
		PageObject pageObject = new PageObject();
		pageObject.setPageSize(15);
		System.out.println(dao.findFreeze(5, "", pageObject));
	}

	@Test
	public void test68() {
		/** 查询提现记录 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageMoneyDao dao = (ManageMoneyDao) context.getBean("manageMoneyDao");
		PageObject pageObject = new PageObject();
		pageObject.setPageSize(15);
		System.out.println(dao.findWithdrawalPageCount(2, ""));
	}

	@Test
	public void test67() {
		/** 查询提现记录 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageMoneyDao dao = (ManageMoneyDao) context.getBean("manageMoneyDao");
		PageObject pageObject = new PageObject();
		pageObject.setPageSize(15);
		System.out.println(dao.findWithdrawal(2, "", pageObject));
	}

	@Test
	public void test66() {
		/** 当前余额 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageMoneyDao dao = (ManageMoneyDao) context.getBean("manageMoneyDao");
		System.out.println(dao.UpdateWithdrawalCurrentBalance(46));
	}

	@Test
	public void test65() {
		/** 当前余额 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageMoneyDao dao = (ManageMoneyDao) context.getBean("manageMoneyDao");
		System.out.println(dao.FindBalance(2));
	}

	@Test
	public void test64() {
		/** 更新当前余额 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageMoneyDao dao = (ManageMoneyDao) context.getBean("manageMoneyDao");
		System.out.println(dao.UpdateCurrentBalance(20));
	}

	@Test
	public void test63() {
		/** 资金账户充值 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		CommonDao dao = (CommonDao) context.getBean("commonDao");
		System.out.println(dao.UpdateBalance(2, 1));
	}

	@Test
	public void test62() {
		/** 资金账户 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageMoneyDao dao = (ManageMoneyDao) context.getBean("manageMoneyDao");
		PageObject pageObject = new PageObject();
		pageObject.setPageSize(15);
		System.out.println(dao.FindMoneyPageCount(""));
	}

	@Test
	public void test61() {
		/** id超找员工电话 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageStaffDao dao = (ManageStaffDao) context.getBean("manageStaffDao");
		System.out.println(dao.FindStaffId("17313178516"));
	}

	@Test
	public void test60() {
		/** 修改员工 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageStaffDao dao = (ManageStaffDao) context.getBean("manageStaffDao");
		StaffInfoEntity staffInfoEntity = new StaffInfoEntity();
		staffInfoEntity.setId(15);
		staffInfoEntity.setuDuty(3);
		System.out.println(dao.UpdateStaff(staffInfoEntity));
	}

	@Test
	public void test59() {
		/** 查询员工 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageStaffDao dao = (ManageStaffDao) context.getBean("manageStaffDao");
		System.out.println(dao.FindStaff(11));
	}

	@Test
	public void test58() {
		/** 查询员工是否存在 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageStaffDao dao = (ManageStaffDao) context.getBean("manageStaffDao");
		System.out.println(dao.FindStaffPhone("17313178512"));
	}

	@Test
	public void test57() {
		/** 查询最后员工号 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageStaffDao dao = (ManageStaffDao) context.getBean("manageStaffDao");
		System.out.println(dao.FindStaffNumber());
	}

	@Test
	public void test56() {
		/** 员工查询 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageStaffDao dao = (ManageStaffDao) context.getBean("manageStaffDao");
		StaffInfoEntity staffInfoEntity = new StaffInfoEntity();
		System.out.println(dao.FindStaffList(staffInfoEntity, "ASC", null));

	}

	@Test
	public void test55() {
		/** 专员跟踪 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		TrackingDao dao = (TrackingDao) context.getBean("trackingDao");
		System.out.println(dao.Tracking());
	}

	@Test
	public void test54() {
		/** 上传车辆信息 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		DetectOrderDao dao = (DetectOrderDao) context.getBean("detectOrderDao");
		TCarBasisInfoEntity tCarBasisInfoEntity = new TCarBasisInfoEntity();
		tCarBasisInfoEntity.setCarName("奥迪");
		tCarBasisInfoEntity.setCars("A4");
		tCarBasisInfoEntity.setCarModel("2016款");
		tCarBasisInfoEntity.setYearTime(new Date());
		tCarBasisInfoEntity.setReTime(new Date());
		tCarBasisInfoEntity.setChangeTime(new Date());
		tCarBasisInfoEntity.setManufacture(new Date());
		System.out.println(dao.addTCarInfo(tCarBasisInfoEntity));
	}

	@Test
	public void test53() {
		/** 详细 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageParticularsDao dao = (ManageParticularsDao) context.getBean("manageParticularsDao");
		System.out.println(dao.FindDetailed(21));
	}

	@Test
	public void test52() {
		/** 附件 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageParticularsDao dao = (ManageParticularsDao) context.getBean("manageParticularsDao");
		System.out.println(dao.FindAttachment(15));
	}

	@Test
	public void test51() {
		/** 显性损伤 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageParticularsDao dao = (ManageParticularsDao) context.getBean("manageParticularsDao");
		System.out.println(dao.FindDominant(15, 3, 1));
	}

	@Test
	public void test50() {
		/** 过户资料 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageParticularsDao dao = (ManageParticularsDao) context.getBean("manageParticularsDao");
		System.out.println(dao.FindRecord(15));
	}

	@Test
	public void test49() {
		/** 特写图片 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageParticularsDao dao = (ManageParticularsDao) context.getBean("manageParticularsDao");
		System.out.println(dao.FindPicture(26, 1));
	}

	@Test
	public void test48() {
		/** 流拍信息 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageParticularsDao dao = (ManageParticularsDao) context.getBean("manageParticularsDao");
		System.out.println(dao.FindAuction(15));
	}

	@Test
	public void test47() {
		/** 查询企业信息 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageParticularsDao dao = (ManageParticularsDao) context.getBean("manageParticularsDao");
		System.out.println(dao.FindCarPerson(25));
	}

	@Test
	public void test46() {
		/** 车辆基本信息 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageParticularsDao dao = (ManageParticularsDao) context.getBean("manageParticularsDao");
		TCarBasisInfoEntity tCarBasisInfoEntity = new TCarBasisInfoEntity();
		tCarBasisInfoEntity.setId(100);
		System.out.println(dao.CarInfo(tCarBasisInfoEntity));
	}

	@Test
	public void test45() {
		/** 查询扣款时间 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		MamageOrderDao dao = (MamageOrderDao) context.getBean("mamageOrderDao");
		System.out.println(dao.FindAbortTime(1, 1));
	}

	@Test
	public void test44() {
		/** 建档 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		CommonDao dao = (CommonDao) context.getBean("commonDao");
		System.out.println(dao.checkOrderRepetition(23));
	}

	@Test
	public void test43() {
		/** 新建档案图片 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		MamageOrderDao dao = (MamageOrderDao) context.getBean("mamageOrderDao");
		List<RecordPictureEntity> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			RecordPictureEntity recordPictureEntity = new RecordPictureEntity();
			recordPictureEntity.setRecordId(i);
			recordPictureEntity.setTypeNumber(i);
			recordPictureEntity.setUrl(i + "");
			list.add(recordPictureEntity);
		}
		System.out.println(dao.addRecordImg(list));
	}

	@Test
	public void test42() {
		/** 新建档案 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		MamageOrderDao dao = (MamageOrderDao) context.getBean("mamageOrderDao");
		RecordEntity recordEntity = new RecordEntity();
		recordEntity.setRegion(1);
		recordEntity.setCarId(1);
		recordEntity.setStaffId(2);
		System.out.println(dao.addRecord(recordEntity));
		System.out.println(recordEntity);
	}

	@Test
	public void test41() {
		/** 更新拍卖订单状态 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		CommonDao dao = (CommonDao) context.getBean("commonDao");
		System.out.println(dao.UpdateOrder(1, 4, "今天"));
	}

	@Test
	public void test40() {
		/** 查询拍卖订单条目数 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		MamageOrderDao dao = (MamageOrderDao) context.getBean("mamageOrderDao");
		CheckQueryEntity checkQueryEntity = new CheckQueryEntity();
		checkQueryEntity.setOrderState(1);
		System.out.println(dao.FindOrderRowCount(checkQueryEntity));
	}

	@Test
	public void test39() {
		/** 查询拍卖订单 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		MamageOrderDao dao = (MamageOrderDao) context.getBean("mamageOrderDao");
		CheckQueryEntity checkQueryEntity = new CheckQueryEntity();
		checkQueryEntity.setOrderState(1);
		PageObject pageObject = new PageObject();
		pageObject.setPageSize(15);
		System.out.println(dao.FindOrder(checkQueryEntity, pageObject));
	}

	@Test
	public void test38() {
		/** 修改场次 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		CommonDao dao = (CommonDao) context.getBean("commonDao");
		System.out.println(dao.UpdateFirstField(1, 3));
	}

	@Test
	public void test37() {
		/** 查询第一场 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		CommonDao dao = (CommonDao) context.getBean("commonDao");
		System.out.println(dao.firstField());
	}

	@Test
	public void test36() {
		/** 查询场次时间 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageAuctionsDao dao = (ManageAuctionsDao) context.getBean("manageAuctionsDao");

		System.out.println(dao.FindFieldTime(1));
	}

	@Test
	public void test35() {
		/** 添加场次车辆 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageAuctionsDao dao = (ManageAuctionsDao) context.getBean("manageAuctionsDao");
		AuctionCarEntity auctionCarEntity = new AuctionCarEntity();
		auctionCarEntity.setAuctionId(1);
		System.out.println(dao.FindFieldCars(auctionCarEntity));
	}

	@Test
	public void test34() {
		/** 当前场次车辆分页 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageAuctionsDao dao = (ManageAuctionsDao) context.getBean("manageAuctionsDao");
		AuctionCarEntity auctionCarEntity = new AuctionCarEntity();
		auctionCarEntity.setAuctionId(5);
		System.out.println(dao.FindFieldCarsIdRowCount(auctionCarEntity, 1));
	}

	@Test
	public void test33() {
		/** 当前场次车辆 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageAuctionsDao dao = (ManageAuctionsDao) context.getBean("manageAuctionsDao");
		AuctionCarEntity auctionCarEntity = new AuctionCarEntity();
		auctionCarEntity.setAuctionId(2);
		PageObject pageObject = new PageObject();
		pageObject.setPageSize(15);
		List<Map> lisMap = dao.FindFieldCarsId(auctionCarEntity, 1, pageObject);
		System.out.println(lisMap);
	}

	@Test
	public void test32() {
		/** 统计车辆 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		CommonDao dao = (CommonDao) context.getBean("commonDao");
		List<Map> listMap = dao.statisticalCars();
		Map<Object, Object> resultMap = new HashMap<>();
		for (Map map : listMap) {
			System.out.println(map);
			// System.out.println(map.get("carId"));
			// System.out.println(map.get("count"));
			resultMap.put(map.get("carId"), map.get("count"));
		}
		System.out.println(resultMap);
		System.out.println(resultMap.get(55));
	}

	@Test
	public void test31() {
		/** 拍卖-库存管理-查询车库信息 -查询条目数 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageStockDao dao = (ManageStockDao) context.getBean("manageStockDao");
		CheckQueryEntity checkQueryEntity = new CheckQueryEntity();
		checkQueryEntity.setCarState(1);
		checkQueryEntity.setRetrieval("18780251634");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 7);
		Date date = calendar.getTime();
		System.out.println(date);
		checkQueryEntity.setCreateTimeOver(date);
		checkQueryEntity.setCreateTimeSort("DESC");
		System.out.println(dao.getFindStockRowCount(checkQueryEntity));
	}

	@Test
	public void test30() {
		/** 拍卖-库存管理-查询车库信息 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageStockDao dao = (ManageStockDao) context.getBean("manageStockDao");
		CheckQueryEntity checkQueryEntity = new CheckQueryEntity();
		checkQueryEntity.setCarState(1);
		checkQueryEntity.setRetrieval("18780251634");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 7);
		Date date = calendar.getTime();
		System.out.println(date);
		checkQueryEntity.setCreateTimeOver(date);
		checkQueryEntity.setCreateTimeSort("DESC");
		PageObject pageObject = new PageObject();
		pageObject.setPageSize(10);
		System.out.println(dao.FindStock(checkQueryEntity, pageObject));
	}

	@Test
	public void test29() {
		/** 拍卖-发布管理-添加车辆-更新起拍价 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageAuctionsDao dao = (ManageAuctionsDao) context.getBean("manageAuctionsDao");
		TCarBasisInfoEntity tCarBasisInfoEntity = new TCarBasisInfoEntity();
		tCarBasisInfoEntity.setId(15);
		tCarBasisInfoEntity.setAskingPrice(4.02f);
		System.out.println(dao.UpdatePrice(tCarBasisInfoEntity));
	}

	@Test
	public void test28() {
		/** 拍卖-发布管理-添加车辆-查询车辆列表 */
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageAuctionsDao dao = (ManageAuctionsDao) context.getBean("manageAuctionsDao");
		System.out.println(dao.FindCars());
	}

	@Test
	public void test26() {
		// 查询场次
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManageAuctionsDao dao = (ManageAuctionsDao) context.getBean("manageAuctionsDao");
		List<Map> list = dao.FindField("2017-11-17");
		System.out.println(list);
	}

	@Test
	public void test25() {
		// 新建场次
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManagementDao dao = (ManagementDao) context.getBean("managementDao");
		AuctionSessionEntity auctionSessionEntity = new AuctionSessionEntity();
		auctionSessionEntity.setAuctionStart(new Date());
		auctionSessionEntity.setAuctionNum("1");
		auctionSessionEntity.setAuctionOver(new Date());
		auctionSessionEntity.setPrincipal("222");
		auctionSessionEntity.setAuctionState(1);
		System.out.println(dao.NewField(auctionSessionEntity));
	}

	@Test
	public void test24() {
		// 测试管理端查询检测订单返回总数
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManagementDao dao = (ManagementDao) context.getBean("managementDao");
		CheckQueryEntity checkQueryEntity = new CheckQueryEntity();
		checkQueryEntity.setCheckStatus(1);
		checkQueryEntity.setAppointmentTime("DESC");
		checkQueryEntity.setRetrieval("");
		System.out.println(checkQueryEntity);
		int i = dao.getRowCount(checkQueryEntity);
		System.out.println(i);
	}

	@Test
	public void test() {
		// 查询检测师
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManagementDao dao = (ManagementDao) context.getBean("managementDao");
		System.out.println(dao.FindDetect());
	}

	@Test
	public void test23() {
		// pc端新建检测订单
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManagementDao dao = (ManagementDao) context.getBean("managementDao");
		CheckBillEntity checkBillEntity = new CheckBillEntity();
		checkBillEntity.setAddress("大源");
		int i = dao.NewOrderPc(checkBillEntity);
		System.out.println(i);
	}

	@Test
	public void test21() {
		// 测试管理端查询检测订单
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManagementDao dao = (ManagementDao) context.getBean("managementDao");
		CheckQueryEntity checkQueryEntity = new CheckQueryEntity();
		checkQueryEntity.setCheckStatus(2);
		checkQueryEntity.setAppointmentTime("DESC");
		checkQueryEntity.setRetrieval("");
		System.out.println(checkQueryEntity);
		List<Map> map = dao.FindPageObjects(checkQueryEntity, null);
		System.out.println(map);
	}

	@Test
	public void test20() {
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		DetectOrderDao dao = (DetectOrderDao) context.getBean("detectOrderDao");
		TCarBasisInfoEntity tCarBasisInfoEntity = new TCarBasisInfoEntity();
		tCarBasisInfoEntity.setCheckBillId(3);
		System.out.println(dao.detectUpload(tCarBasisInfoEntity.getCheckBillId()));
	}

	@Test
	public void test18() {
		// 插入检测信息
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManagementDao dao = (ManagementDao) context.getBean("managementDao");
		CheckBillEntity checkBillEntity = new CheckBillEntity();
		checkBillEntity.setTelephone("11111111111111");
		int i = dao.NewOrder(checkBillEntity);
		System.out.println(i);

	}

	@Test
	public void test17() {
		// 根据电话号码查询员工id
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		ManagementDao dao = (ManagementDao) context.getBean("managementDao");
		StaffInfoEntity staffInfoEntity = new StaffInfoEntity();
		staffInfoEntity.setuPhone("17313178512");
		int i = dao.GetStaff(staffInfoEntity.getuPhone());
		System.out.println(i);
	}

	@Test
	public void test16() {
		System.out.println(System.currentTimeMillis());
	}

	@Test
	public void test14() {
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		DetectOrderDao dao = (DetectOrderDao) context.getBean("detectOrderDao");
		TCarBasisInfoEntity tCarBasisInfoEntity = new TCarBasisInfoEntity();
		System.out.println(dao.getCarId(3));
	}

	@Test
	public void test13() {
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		DetectOrderDao dao = (DetectOrderDao) context.getBean("detectOrderDao");
		String string = "{\"appearance1\":{\"damageType\":\"1\",\"carDescribe\":\"1\",\"dominant\":\"1;2;3;4\",\"xy\":\"00;22\",\"recessive\":\"2\",\"imgAppearance1\":\"\"},"
				+ "\"interior2\":{\"damageType\":\"2\",\"carDescribe\":\"1\",\"dominant\":\"1;2;3;4\",\"xy\":\"00;22\",\"recessive\":\"2\",\"imgInterior1\":\"\"},	"
				+ "\"skeleton3\":{\"damageType\":\"3\",\"carDescribe\":\"2\",\"dominant\":\"1;4;5;9\",\"xy\":\"33;44\",\"recessive\":\"2\",\"imgSkeleton1\":\"\"}}";
		JSONObject json = JSONObject.fromObject(string);
		DetectOrderServiceImpl detectOrderServiceImpl = new DetectOrderServiceImpl();
		// List<CarDamageEntity> list = detectOrderServiceImpl.CarDamageEntityJson(json,
		// null, 0);
		// System.out.println(list);
		// for (CarDamageEntity c : list) {
		// System.out.println(c);
		// }
		// dao.UploadCarDamage(list);
	}

	@Test
	public void test10() {
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		DetectOrderDao dao = (DetectOrderDao) context.getBean("detectOrderDao");
		CarBrandsInfoEntity carBrandsInfoEntity = new CarBrandsInfoEntity();
		carBrandsInfoEntity.setBrandsName("众");
		System.out.println(carBrandsInfoEntity);
		List<CarBrandsInfoEntity> list = dao.CarInfoAll(carBrandsInfoEntity);
		for (CarBrandsInfoEntity e : list) {
			System.out.println(e);
		}

	}

	@Test
	public void test9() {
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		DetectOrderDao dao = (DetectOrderDao) context.getBean("detectOrderDao");
		CheckBillEntity chec = new CheckBillEntity();
		chec.setId(1);
		chec.setAppointmentTime(new Date());
		System.out.println(dao.UpdateTime(chec));

	}

	@Test
	public void test8() {
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		DetectOrderDao dao = (DetectOrderDao) context.getBean("detectOrderDao");
		StaffInfoEntity staffInfo = new StaffInfoEntity();
		staffInfo.setuPhone("17313178513");
		PageObject pageObject = new PageObject();
		Integer integer = 1;
		System.out.println(dao.MyDetectOrder(staffInfo, pageObject, integer));

	}

	@Test
	public void test7() {
		Map<String, Object> map = new HashMap<>();
		map.put("1", "2");
		System.out.println(map.get("2"));
	}

	@Test
	public void test6() {
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		CommonDao dao = (CommonDao) context.getBean("commonDao");
		System.out.println(dao.FindSmsTemplate(1));
	}

	@Test
	public void test5() {
		context = new ClassPathXmlApplicationContext("spring-mvc.xml", "spring-pool.xml", "spring-mybatis.xml");
		CommonDao dao = (CommonDao) context.getBean("commonDao");
		System.out.println(dao.UserNameCheck("134382267071"));
	}

	@Test
	public void test4() {
		CommonServiceImpl common = new CommonServiceImpl();
		System.out.println(common.RandomCode());

	}

	@Test
	public void test3() {
		// ByteSource credentialsSalt =
		// ByteSource.Util.bytes("e1$dYHxW*OdEiUOu");
		String algorithmName = "MD5";
		Object source = "964312";
		Object salt = "e1$dYHxW*OdEiUOu";
		int hashIterations = 1024;
		Object result = new SimpleHash(algorithmName, source, salt, hashIterations);
		System.out.println(result);

	}

	@Test
	public void test1() {
		System.out.println(System.currentTimeMillis());
	}
}

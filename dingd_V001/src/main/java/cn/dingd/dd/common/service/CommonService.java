package cn.dingd.dd.common.service;

import cn.dingd.dd.common.entity.*;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


/**
* @author 作者 Name:CaoGang
* @version 创建时间：2017年10月11日 下午1:05:02
* 类说明
*/
public interface CommonService {

	/** 获取车辆状态 */
	public int findCarState(Integer carId);
	/**A端账户提现修改资金表*/
	public int subtractionBalance(Integer id,Integer money);
	/**A端账户充值修改资金表*/
	public int UpdateBalance(Integer id,Integer money);
	/**查询当日开始场次数据*/
	public List<AuctionSessionEntity> firstFieldAll();
	/**检查建档时重复提交*/
	public int checkOrderRepetition(int carId) ;
	/**修改拍卖订单状态*/
	public int UpdateOrder(int id,int state,String remarks);
	/**修改场次状态*/
	public int UpdateFirstField(int id,int state);
	/**查询当日开始场次第一条数据*/
	public AuctionSessionEntity firstField();
	/**统计车辆流拍次数*/
	public Map<Object, Object> statisticalCars();
	/**修改车辆状态*/
	public int UpdateCarState(TCarBasisInfoEntity tCarBasisInfoEntity) ;
	/** ORC图像识别行驶证 */
	public Map<String, Object> GetVehicleORC(MultipartFile[] file);
	/**城市ID查询下属地区*/
	public List<CityMapEntiyt> GetAreaId(CityMapEntiyt cityMapEntiyt);
	/**查询缓存中的验证码*/
	public String GetCacheNumber(String username);
	/**查询员工信息*/
	public StaffInfoEntity isExist(String username) ;
	/**短信验证码匹配*/
	public Boolean RandomCodeCheck(String userName,String PassWord);
	/** 短信验证码 第一个时间控制访问后生存时间 第二个参数时间控制生成后生存时间 MD5_State  0-不加密 1-MD5加密*/
	public String RandomCodeOut(String account,Integer message_template,Integer MD5_State);
	/** 生成随机验证码 */
	public String RandomCode() ;

	/** 检查A端账号是否存在 */
	public Boolean UserNameCheck(String account) ;
	/**
	 * 发送短信到阿里云
	 * 
	 * @throws ClientException
	 */
	public Map<String, Object> doPostCode(VerificationCode verificationCode) throws ClientException ;
	/** 查找短信模板 */
	public VerificationCode FindSmsTemplate(Integer id) ;
	/** MD5加密 */
	public String GetMD5(String password) ;
	
	/**查询检测单图片属性*/
	public List<CarDictionaryEntity> GetImgInfo(List ls)throws Exception ;
	/**获取需要执行的订单*/
	public List<AuctionOrderEntity> getAuctionOrders()throws Exception;
	
}
package cn.dingd.dd.management.service.impl;

import cn.dingd.dd.auction.service.AuctionSessionService;
import cn.dingd.dd.common.entity.*;
import cn.dingd.dd.common.service.CommonService;
import cn.dingd.dd.common.util.CF;
import cn.dingd.dd.common.util.DateUtils;
import cn.dingd.dd.common.util.Variable;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.management.dao.MamageOrderDao;
import cn.dingd.dd.management.service.MamageOrderService;
import cn.dingd.dd.management.service.ManageMoneyService;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年12月13日 下午3:29:31 类说明 管理端-拍卖订单
 */
@Service
public class MamageOrderServiceImpl implements MamageOrderService {
    @Resource
    private MamageOrderDao mamageOrderDao;
    @Resource
    private CommonService commonService;
    @Resource
    private AuctionSessionService auctionSessionService;
    @Resource
    private ManageMoneyService manageMoneyService;
    /**
     * 时间: 2018/5/7 11:14
     * 功能描述:过户成功计算返利发送短信通知
     * 根据建档车辆ID查询商家电话号码
     */
    public void rebate_SMS(Integer carId) {
        Map<String, Object> stringStringMap = mamageOrderDao.rebate_SMS(carId);//查询商家电话号码和车辆对应的保留价
        if (stringStringMap!=null){
            String account = (String) stringStringMap.get("account");//获取电话
            Object retentionMoney = stringStringMap.get("retentionMoney");//获取车辆保留价
            BigDecimal b = new BigDecimal(String.valueOf(retentionMoney));//float转double
            double d = b.doubleValue();
            if (account!=null&&!account.equals("")){
                Double aDouble = CF.oderFL(d);//获取对应的奖励
                VerificationCode sms = CF.SMS(Variable.SMS_TZ);//获取通知模板
                sms.setCode(String.valueOf(aDouble));
                sms.setPhoneNumbers(account);//封装短信号码
                sms.setTemplateParam("{\"code\":\"" + String.valueOf(aDouble) + "\"}");//封装类容
                try {
                    commonService.doPostCode(sms);//发送短信
                } catch (ClientException e) {
                    e.printStackTrace();
                    throw  new NullPointerException("发送交易成功通知失败!");
                }
            }
        }
    }

    /**
     * 管理端-拍卖管理-查找操作记录
     */
    public AuctionOrderTimeEntity findOperating(AuctionOrderTimeEntity auctionOrderTimeEntity) {
        return mamageOrderDao.findOperating(auctionOrderTimeEntity);
    }

    /**
     * 管理端-拍卖管理-更新写入操作记录
     */
    public Integer upOperating(AuctionOrderTimeEntity auctionOrderTimeEntity) {
        return mamageOrderDao.upOperating(auctionOrderTimeEntity);
    }

    /**
     * 管理端-拍卖管理-写入操作记录
     */
    public Integer addOperating(AuctionOrderTimeEntity auctionOrderTimeEntity) {
        return mamageOrderDao.addOperating(auctionOrderTimeEntity);
    }

    /**
     * 管理端-拍卖管理-查询订单扣款时间 状态1-截止付款时间 2-生成时间
     */
    public Date FindAbortTime(int id, int state) {
        return mamageOrderDao.FindAbortTime(id, state);
    }

    /**
     * 管理端-拍卖管理-修改时间
     */
    public int UpdateOrderTime(AuctionOrderEntity auctionOrderEntity) {
        return mamageOrderDao.UpdateOrderTime(auctionOrderEntity);
    }

    /**
     * 管理端-拍卖管理-创建档案
     */
    @Transactional(rollbackFor = Exception.class) // 事物控制
    public int addRecord(Integer id, RecordEntity recordEntity, List<RecordPictureEntity> list) {
        // 建档
        if (mamageOrderDao.addRecord(recordEntity) != 1) {
            throw new NullPointerException("建档失败!");
        }
        for (RecordPictureEntity e : list) {
            e.setRecordId(recordEntity.getId());
        }
        // 修改订单状态
        AuctionOrderEntity auctionOrderEntity = new AuctionOrderEntity();
        auctionOrderEntity.setId(id);
        auctionOrderEntity.setOrderState(3);
        if (UPdateOrder(auctionOrderEntity, null) != 1) {
            throw new NullPointerException("修改订单状态失败!");
        }
        // 修改车辆状态
        TCarBasisInfoEntity tCarBasisInfoEntity = new TCarBasisInfoEntity();
        tCarBasisInfoEntity.setId(recordEntity.getCarId());
        tCarBasisInfoEntity.setCarState(3);
        if (commonService.UpdateCarState(tCarBasisInfoEntity) != 1) {
            throw new NullPointerException("修改车辆状态失败!");
        }
        // 上传图片信息
        int i = mamageOrderDao.addRecordImg(list);
        rebate_SMS(recordEntity.getCarId());//发送消息通知!
        return i;
    }

    /**
     * 管理端-拍卖管理-订单状态 1-拍卖订单 2-已付款 3-已成交 4-已撤销 5-超时扣款 6-仲裁中
     */
    @Transactional(rollbackFor = Exception.class) // 事物控制
    public int UPdateOrder(AuctionOrderEntity auctionOrderEntity, AuctionOrderTimeEntity auctionOrderTimeEntity) {
        Integer orderState = auctionOrderEntity.getOrderState();
        // 付款
        if (orderState == 2) {
            // 付款
            if (commonService.UpdateOrder(auctionOrderEntity.getId(), auctionOrderEntity.getOrderState(), null) != 1) {
                throw new NullPointerException("订单状态修改失败(拍卖订单ID:" + auctionOrderEntity.getId() + ")!");
            }
            // 解冻
            if (mamageOrderDao.RemoveMoney(auctionOrderEntity.getId(), 2000) != 1) {
                throw new NullPointerException("解冻资金失败(拍卖订单ID:" + auctionOrderEntity.getId() + ")!");
            }
            try {
                // 充值
                AuctionOrderEntity aEntity = mamageOrderDao.findAuctionOrderEntity(auctionOrderEntity.getId());
                manageMoneyService.AddMoney(aEntity.getAuserId(), 2000, "付款成功,解冻资金返回,拍卖订单号:" + aEntity.getOrderNum(), 3,
                        String.valueOf(auctionOrderEntity.getId()), aEntity.getCarId());
            } catch (Exception e) {
                throw new NullPointerException("解冻资金回冲可用资金失败(拍卖订单ID:" + auctionOrderEntity.getId() + ")!");
            }
            // 订单变更记录
        } else if (orderState == 3) {
            // 建档
            if (commonService.UpdateOrder(auctionOrderEntity.getId(), auctionOrderEntity.getOrderState(), null) != 1) {
                throw new NullPointerException("(拍卖订单ID:" + auctionOrderEntity.getId() + "),建档修改车辆状态失败!");
            }

        } else if (orderState == 4) {
            // 关闭订单
            if (commonService.UpdateOrder(auctionOrderEntity.getId(), auctionOrderEntity.getOrderState(),
                    auctionOrderEntity.getRemarks()) != 1) {
                throw new NullPointerException("(拍卖订单ID:" + auctionOrderEntity.getId() + "),修改订单状态失败!");
            }
            AuctionOrderTimeEntity upAuctionOrderTimeEntity = new AuctionOrderTimeEntity();
            upAuctionOrderTimeEntity.setAuctionOrderId(auctionOrderEntity.getId());
            upAuctionOrderTimeEntity.setType(6);
            upAuctionOrderTimeEntity.setOperatingState(0);
            // 更新操作记录
            if (upOperating(upAuctionOrderTimeEntity) != 1) {
                throw new NullPointerException("(拍卖订单ID:" + auctionOrderEntity.getId() + "),修改操作记录状态失败!");
            }
            // 状态 1--冻结车辆 2--不冻结,
            if (auctionOrderTimeEntity.getFreeze() == 1) {
                // 冻结车辆
                TCarBasisInfoEntity tCarBasisInfoEntity = new TCarBasisInfoEntity();
                // 获取车辆id
                tCarBasisInfoEntity.setId(auctionOrderEntity.getCarId());
                // 修改车辆状态
                tCarBasisInfoEntity.setCarState(4);
                // 更新冻结车辆
                if (commonService.UpdateCarState(tCarBasisInfoEntity) != 1) {
                    throw new NullPointerException("(拍卖订单ID:" + auctionOrderEntity.getId() + "),修改车辆状态失败!");
                }
            }
        } else if (orderState == 6) {
            // 仲裁
            if (commonService.UpdateOrder(auctionOrderEntity.getId(), auctionOrderEntity.getOrderState(),
                    null) != 1) {
                throw new NullPointerException("(拍卖订单ID:" + auctionOrderEntity.getId() + "),修改订单状态失败!");
            }
        } else if (orderState == 7) {
            // 继续交易
            AuctionOrderTimeEntity findTrading = new AuctionOrderTimeEntity();
            findTrading.setAuctionOrderId(auctionOrderEntity.getId());
            findTrading.setType(6);
            findTrading.setOperatingState(1);
            AuctionOrderTimeEntity findAuctionOrderTimeEntity = findOperating(findTrading);
            if (findAuctionOrderTimeEntity == null) {
                throw new NullPointerException("(拍卖订单ID:" + auctionOrderEntity.getId() + "),查询操作记录失败!");
            }
            //更新拍卖订单
            if (commonService.UpdateOrder(auctionOrderEntity.getId(), findAuctionOrderTimeEntity.getTypeOld(),
                    null) != 1) {
                throw new NullPointerException("(拍卖订单ID:" + auctionOrderEntity.getId() + "),修改订单状态失败!");
            }
            //更新操作记录为继续交易
            findTrading.setOperatingState(2);
            if (upOperating(findTrading) != 1) {
                throw new NullPointerException("(拍卖订单ID:" + auctionOrderEntity.getId() + "),修改操作记录状态失败!");
            }
        } else {
            throw new NullPointerException("(拍卖订单ID:" + auctionOrderEntity.getId() + "),状态参数不正确!");
        }
        // 写入操作记录
        if (orderState != 3) {
            if (mamageOrderDao.addOperating(auctionOrderTimeEntity) != 1) {
                throw new NullPointerException("(拍卖订单ID:" + auctionOrderEntity.getId() + "),操作记录写入失败!");
            }
        }
        return 1;
    }

    /**
     * 管理端-拍卖管理-拍卖订单查询 1-拍卖订单 2-已付款 3-已成交 4-已撤销 5-超时扣款 6-仲裁中
     */
    public Map<String, Object> FindOrder(CheckQueryEntity checkQueryEntity, PageObject pageObject) {
        if (checkQueryEntity.getSort() == null || checkQueryEntity.getSort().equals("")) {
            checkQueryEntity.setSort("ASC");
        }
        Map<String, Object> map = new HashMap<>();
        // 查询分页信息
        pageObject.setRowCount(mamageOrderDao.FindOrderRowCount(checkQueryEntity));
        // 返回信息
        List<Map<String, Object>> list = mamageOrderDao.FindOrder(checkQueryEntity, pageObject);
        List<Map<String, Object>> orderList = new ArrayList<>();
        // 查询订单状态==1
        if (checkQueryEntity.getOrderState() == 1) {
            for (Map<String, Object> order : list) {
                // 获取超时扣款时间
                Date abortTime = (Date) order.get("abortTime");
                // 获取订单生成时间
                Date orderTime = (Date) order.get("orderTime");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(orderTime);
                // 时间规则/过期时间
                calendar.add(Calendar.HOUR_OF_DAY, DateUtils.OUTTIME);
                // 计算扣款时间
                Date date = DateUtils.getTimeout(calendar);
                // 现在扣款时间对比计算扣款时间
                if (abortTime.getTime() > date.getTime()) {
                    order.put("modify", true);
                } else {
                    order.put("modify", false);
                }
                orderList.add(order);
            }
            map.put("list", orderList);
        } else {
            map.put("list", list);
        }
        map.put("pageObject", pageObject);
        return map;
    }
}

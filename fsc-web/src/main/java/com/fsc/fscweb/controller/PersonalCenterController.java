package com.fsc.fscweb.controller;

import com.fsc.fscweb.entity.MyRecord;
import com.fsc.fscweb.entity.MyWallet;
import com.fsc.fscweb.entity.UserName;
import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.service.PersonalCenterService;
import com.fsc.fscweb.service.TokenService;
import com.fsc.fscweb.util.CommonUtil;
import com.fsc.fscweb.util.JsonResult;
import com.fsc.fscweb.util.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 作者:  CG
 * 时间： 2018/7/4 15:09
 * 功能描述:个人中心
 */
@RestController
@RequestMapping("myPersonal")
@CrossOrigin
public class PersonalCenterController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PersonalCenterService personalCenterService;
    /**
     * 作者: Solace
     * 时间: 2018/7/12 0:52
     * 功能: 获取所有人的实名认证信息
     * 参数:
     */
    @RequestMapping("myCardNoAll")
    public JsonResult myCardNoAll(String email) {
        List<UserName> userNames = personalCenterService.myCardNoAll(email);
        for (UserName index:userNames
             ) {
            index.setUserPassword("******");
        }
        return new JsonResult(userNames);
    }
    /**
     * 作者: Solace
     * 时间: 2018/7/12 0:44
     * 功能: 我的实名认证
     * 参数:
     */
    @RequestMapping("myCardNo")
    public JsonResult myCardNo() {
        UserName userLogin = tokenService.getUserLogin();
        UserName userName = personalCenterService.myCardNo(userLogin);
        return new JsonResult(userName);
    }
    /**
     * 作者: Solace
     * 时间: 2018/7/4 23:52
     * 功能: 我的资金列表
     * 参数:
     */
    @RequestMapping("myMoney")
    public JsonResult myMoney() {
        UserName userLogin = tokenService.getUserLogin();
        MyWallet myWallet = personalCenterService.myMoney(userLogin);
        return new JsonResult(myWallet);
    }
    /**
      * 作者:  CG
      * 时间： 2018/7/4 17:54
      * 功能描述:实名认证
      */
    @RequestMapping("checkCardNo")
    public JsonResult checkCardNo(UserName userName) throws IsConformException{
        if (CommonUtil.checkCardNo(userName.getIdentity()))
            throw new IsConformException("请核实身份证信息后在进行认证!");
        if (CommonUtil.checkStr(userName.getPassportType()))
            throw new IsConformException("请输入护照类型!");
        if (CommonUtil.checkStr(userName.getPassportNumber()))
            throw new IsConformException("请输入护照号码!");
        if (CommonUtil.checkStr(userName.getCompellation()))
            throw new IsConformException("请输入姓名!");
        if (userName.getBirthTime()==null)
            throw new IsConformException("请输入出生日期!");
        if (userName.getSex()!=1){
            userName.setSex((byte) 2);
        }
        if (CommonUtil.checkStr(userName.getBirthplace()))
            throw new IsConformException("请输入出生地!");
        if (userName.getPassportTime()==null)
            throw new IsConformException("请输签发日期!");
        if (userName.getPassportTimeOver()==null)
            throw new IsConformException("请输到期日期!");
        if (CommonUtil.checkStr(userName.getEmail()))
            throw new IsConformException("请输入电话邮箱!");
        try {
            if (userName.getPhone().length()!=11)
                throw new IsConformException("请输入手机号!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new IsConformException("请输入手机号!");
        }
        if (CommonUtil.checkStr(userName.getMyToken()))
            throw new IsConformException("请输入钱包地址!");
        userName.setIscheck(Variable.cardNo);//代表已经实名认证过
        userName.setUserName(null);
        userName.setUserPassword(null);
        Boolean aBoolean = personalCenterService.checkCardNo(userName);
        return new JsonResult(aBoolean);
    }
    /**
     * 作者:  CG
     * 时间： 2018/7/4 17:14
     * 功能描述:邀请好友
     */
    @RequestMapping("myInvitation")
    public JsonResult myInvitation() {
        UserName userLogin = tokenService.getUserLogin();
        Map <String, Object> map = personalCenterService.myInvitation(userLogin);
        return new JsonResult(map);
    }

    /**
     * 作者:  CG
     * 时间： 2018/7/4 16:11
     * 功能描述:充值记录
     */
    @RequestMapping("myTopUp")
    public JsonResult myTopUp() {
        UserName userLogin = tokenService.getUserLogin();
        List <MyRecord> myRecords = personalCenterService.myTopUp(userLogin);
        return new JsonResult(myRecords);
    }

    /**
     * 作者:  CG
     * 时间： 2018/7/4 16:11
     * 功能描述:提现记录
     */
    @RequestMapping("myWithdrawal")
    public JsonResult myWithdrawal() {
        UserName userLogin = tokenService.getUserLogin();
        List <MyRecord> myRecords = personalCenterService.myWithdrawal(userLogin);
        return new JsonResult(myRecords);
    }

    /**
     * 作者:  CG
     * 时间： 2018/7/4 15:10
     * 功能描述:认购记录
     */
    @RequestMapping("mySubscribe")
    public JsonResult mySubscribe() {
        UserName userLogin = tokenService.getUserLogin();
        List <Map <String, Object>> maps = personalCenterService.mySubscribe(userLogin);
        return new JsonResult(maps);
    }
}

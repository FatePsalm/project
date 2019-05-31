package com.fsc.fscweb.controller;

import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.service.MyWalletService;
import com.fsc.fscweb.util.CommonUtil;
import com.fsc.fscweb.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
  * 作者:  CG
  * 时间： 2018/7/4 11:34
  * 功能描述:资金管理
  */
@RestController
@CrossOrigin
@RequestMapping("pjBZmAV1sVinHxYvT46bEzSjtCFoQB4viQqJ8auL4t64v0JKBfp3cXcGixgxJtXR7n4mA8QReNyUfpbvGe6rYAboDQQ2wuDMxCO")
public class MyWalletController {
    @Autowired
    private MyWalletService myWalletService;
    /**
      * 作者:  CG
      * 时间： 2018/7/10 16:09
      * 功能描述:获取所有的充值记录
      */
    @RequestMapping("getAllTopUp")
    public JsonResult getAllTopUp(String email){
        List <Map> allTopUp = myWalletService.getAllTopUp(email);
        return new JsonResult(allTopUp);
    }

    /**
     * 作者:  CG
     * 时间： 2018/7/10 16:09
     * 功能描述:获取所有的提现记录
     */
    @RequestMapping("getAllWithdrawal")
    public JsonResult getAllWithdrawal(String email){
        List <Map> allWithdrawal = myWalletService.getAllWithdrawal(email);
        return new JsonResult(allWithdrawal);
    }
    /**
      * 作者:  CG
      * 时间： 2018/7/4 11:35
      * 功能描述:充值
      */
    @RequestMapping("topUp")
    public JsonResult topUp(String email,Integer number){
        if (CommonUtil.checkEmail(email))
            throw new IsConformException("邮箱地址格式不正确!");
        if (CommonUtil.checkNumber(number))
            throw new IsConformException("充值金额不正确!");
        Boolean aBoolean = myWalletService.topUp(email, number);
        return new JsonResult(aBoolean);
    }
    /**
     * 作者:  CG
     * 时间： 2018/7/4 11:44
     * 功能描述:提现
     */
    @RequestMapping("withdrawal")
    public JsonResult withdrawal(String email, Integer number){
        if (CommonUtil.checkEmail(email))
            throw new IsConformException("邮箱地址格式不正确!");
        if (CommonUtil.checkNumber(number))
            throw new IsConformException("提现金额不正确!");
        Boolean withdrawal = myWalletService.withdrawal(email, number);
        return new JsonResult(withdrawal);

    }
    /**
     * 作者:  CG
     * 时间： 2018/7/4 11:44
     * 功能描述:冻结
     */
    @RequestMapping("freeze")
    public JsonResult freeze(String email, Integer number){
        if (CommonUtil.checkEmail(email))
            throw new IsConformException("邮箱地址格式不正确!");
        if (CommonUtil.checkNumber(number))
            throw new IsConformException("冻结金额不正确!");
        Boolean freeze = myWalletService.freeze(email, number);
        return new JsonResult(freeze);
    }
    /**
     * 作者:  CG
     * 时间： 2018/7/4 11:44
     * 功能描述:解冻
     */
    @RequestMapping("thaw")
    public JsonResult thaw(String email, Integer number){
        if (CommonUtil.checkEmail(email))
            throw new IsConformException("邮箱地址格式不正确!");
        if (CommonUtil.checkNumber(number))
            throw new IsConformException("解冻金额不正确!");
        Boolean thaw = myWalletService.thaw(email, number);
        return new JsonResult(thaw);
    }
}

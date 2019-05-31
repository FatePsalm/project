package cn.dingd.dd.common.util;

import cn.dingd.dd.common.entity.VerificationCode;
import cn.dingd.dd.common.web.PageObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年4月24日 下午6:32:45 类说明
 * 公用方法
 */

public class CF {
    /**
     * 时间: 2018/5/7 11:10
     * 功能描述:短信模板-验证码短信模板
     */

    public static VerificationCode SMS(Integer id) {
        if (id == null || id <= 0) {
            throw  new NullPointerException("未知短信模板!");
        }
        Map<String, String> SMS = new HashMap<>();
        VerificationCode verificationCode = new VerificationCode();
        if (id==Variable.SMS_YZM){
            verificationCode.setSignName("叮当师傅");
            verificationCode.setTemplateCode("SMS_116755343");
        }else if (id==Variable.SMS_TZ){
            verificationCode.setSignName("叮当拍车");
            verificationCode.setTemplateCode("SMS_133979946");
        }else{
            throw  new NullPointerException("未知短信模板!");
        }
        return verificationCode;
    }

    /**
     * 时间: 2018/5/6 17:35
     * 功能描述:过户成功,计算返利,规则如下:(保留价)
     * 返利规则: 标准：1.5万以下的车辆，酬劳奖金500元；
     * 1.5万（含1.5万）-5万的车辆，酬劳奖金800元；
     * 5（含5万）-10万的车辆，酬劳奖金1500元；
     * 10万以上（含10万）的车辆，酬劳奖金2000元。
     * 商家订单状态短信通知:
     * 过户成功,向商家发送短信提示:恭喜!您的车辆已出售,获取***元奖励.
     */
    public static Double oderFL(Double rebate) {
        if (rebate == null || rebate <= 0D) {
            return 0D;
        }
        if (rebate < Variable.rebate_15000) {
            return Variable.rebate_500;
        } else if (rebate >= Variable.rebate_15000 && rebate < Variable.rebate_50000) {
            return Variable.rebate_800;
        } else if (rebate >= Variable.rebate_50000 && rebate < Variable.rebate_100000) {
            return Variable.rebate_1500;
        } else {
            return Variable.rebate_2000;
        }
    }

    /**
     * 时间: 2018/4/28 17:15 功能描述:判断分页信息
     */
    public static boolean isPage(PageObject pg) {
        if (pg.getPageCurrent() <= 0) {
            return true;
        } else if (pg.getPageSize() <= 0) {
            return true;
        }
        return false;
    }

    /**
     * @param ob
     * @return 如果对象为空则返回空字符串
     */
    public static Object isNullS(Object ob) {
        return ob == null ? "" : ob;
    }

    /**
     * @param ob 对象判断
     * @return 对象为空返回true 否则返回false
     */
    public static boolean isOj(Object ob) {
        return ob == null ? true : false;
    }

    /**
     * @param integer 数据库保存时返回的数据
     * @return 如果数据!=1返回true 否则返回false
     */
    public static boolean mysqlSave(Integer integer) {
        return integer == null || integer != 1 ? true : false;
    }

    /**
     * @param str 字符串
     * @return null或者"" 返回 true !null返回false
     */
    public static boolean isStr(String str) {
        return str == null || str.equals("") ? true : false;
    }

    /**
     * @param integer 数字
     * @return null或者0 返回true !null返回false
     * 不含0
     */
    public static boolean isNum(Integer integer) {
        return integer == null || integer <= 0 ? true : false;
    }

    /**
     * @param integer 数字
     * @return null或者0 返回true !null返回false
     * 包含0
     */
    public static boolean isNumZ(Integer integer) {
        return integer == null || integer < 0 ? true : false;
    }
}

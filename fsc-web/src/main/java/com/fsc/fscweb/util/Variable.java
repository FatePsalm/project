package com.fsc.fscweb.util;
/**
 * 作者: Solace
 * 时间: 2018/6/30 23:40
 * 功能: 常量
 * 参数:
 */
public class Variable {
    /**
      * 作者:  CG
      * 时间： 2018/7/4 18:26
      * 功能描述:实名认证是否进行过--  1验证过
      */
    public static final  int cardNo =1;
    /**    
     * 作者: Solace
     * 时间: 2018/7/4 0:06  
     * 功能: 操作日志-订单状态-订单状态1-完成 2-取消 3-挂起
     * 参数:   
     */
    public static final  int record_wc =1;
    /**
     * 作者: Solace
     * 时间: 2018/7/4 0:06
     * 功能: 操作日志-订单状态-订单状态1-完成 2-取消 3-挂起
     * 参数:
     */
    public static final  int record_qx =2;
    /**
     * 作者: Solace
     * 时间: 2018/7/4 0:06
     * 功能: 操作日志-订单状态-订单状态1-完成 2-取消 3-挂起
     * 参数:
     */
    public static final  int record_gq =3;
    /**
     * 作者: Solace
     * 时间: 2018/7/4 0:06
     * 功能: 操作日志-订单状态-订单类型 1-充值记录  2-体现记录 3-认购记录 4-冻结 5-解冻
     * 参数:
     */
    public static final  int record_type_cz =1;
    /**
     * 作者: Solace
     * 时间: 2018/7/4 0:06
     * 功能: 操作日志-订单状态-订单类型 1-充值记录  2-体现记录 3-认购记录 4-冻结 5-解冻
     * 参数:
     */
    public static final  int record_type_tx =2;
    /**
     * 作者: Solace
     * 时间: 2018/7/4 0:06
     * 功能: 操作日志-订单状态-订单类型 1-充值记录  2-体现记录 3-认购记录 4-冻结 5-解冻
     * 参数:
     */
    public static final  int record_type_rg =3;
    /**
     * 作者: Solace
     * 时间: 2018/7/4 0:06
     * 功能: 操作日志-订单状态-订单类型 1-充值记录  2-体现记录 3-认购记录 4-冻结 5-解冻
     * 参数:
     */
    public static final  int record_type_dj =4;
    /**
     * 作者: Solace
     * 时间: 2018/7/4 0:06
     * 功能: 操作日志-订单状态-订单类型 1-充值记录  2-体现记录 3-认购记录 4-冻结 5-解冻
     * 参数:
     */
    public static final  int record_type_jd =5;
    /**
     * 作者: Solace
     * 时间: 2018/7/3 23:31
     * 功能: 金额初始化
     * 参数:
     */
    public static final  int money =0;
    /**
     * 作者: Solace
     * 时间: 2018/7/3 23:24
     * 功能: 用户等级-普通用户
     * 参数:
     */
    public static final  int userType =1;
    /**
     * 作者: Solace
     * 时间: 2018/7/3 23:24
     * 功能: 用户等级-管理员
     * 参数:
     */
    public static final  int userTypeMgmt =100;
    /**
     * 作者: Solace
     * 时间: 2018/7/1 15:47
     * 功能: 保持登录时间
     * 参数:
     */
    public static final  int LoginTime =7;
    /**
     * 作者: Solace
     * 时间: 2018/7/1 15:43
     * 功能: JWTToken  key值
     * 参数:
     */
    public static final  String JWTTOKEN ="JWTTOKEN";
    public static final  String userName ="userName";
    /**
     * 作者: Solace
     * 时间: 2018/7/1 15:41
     * 功能: 保存用户登录信息到redis索引
     * 参数:
     */
    public static final  String loginToken ="loginToken_8pRJQUkW_";
    /**
     * 作者: Solace
     * 时间: 2018/7/1 1:37
     * 功能: 邀请码长度
     * 参数:
     */
    public final  static int invitationCode=12;
    /**    
     * 作者: Solace
     * 时间: 2018/7/1 1:24  
     * 功能: 数据唯一性
     * 参数:   
     */
    public final  static int uniqueness=0;
    public final  static int uniquenessOne=1;
    /**
     * 作者: Solace
     * 时间: 2018/7/1 0:17
     * 功能: 邮箱注册验证码redis区别码/时间
     * 参数:
     */
    public static final  String registerCodeRedis ="registerCodeRedisName";
    public static final  int registerCodeRedisTime =5;
    /**
     * 作者: Solace
     * 时间: 2018/6/30 23:40
     * 功能: 注册产生随机的验证码
     * 参数:
     */
   public static final  int registerLeng =6;
   /**
    * 作者: Solace
    * 时间: 2018/6/30 23:59
    * 功能: 邮件主题
    * 参数:
    */
   public static final  String emailTheme ="FSC链注册码";
   public static final  String emailBody ="尊敬的FSC链 用户\n" +
           "注册安全代码：";
}

package cn.dingd.dd.common.util;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年4月18日 上午11:09:28 类说明
 */
public class Variable {
    /**
     * 时间: 2018/5/7 17:57
     * 功能描述:数据字典-购置税
     * 年检标志
     * 环保标志
     */
    public static int dd_pj =2;
    /**
     * 时间: 2018/5/7 17:57
     * 功能描述:数据字典-身份证/营业执照/机构
     * 行驶证/上
     * 行驶证/下
     * 行驶证/副本
     * 登记证
     * 票据
     * 交强险
     * 商业险
     */
    public static int dd_zj =7;
    /**
     * 时间: 2018/5/7 17:57
     * 功能描述:数据字典-损伤外观-隐形
     */
    public static int dd_WG_YX =6;
    /**
     * 时间: 2018/5/7 17:50
     * 功能描述:数据字典-损伤外观-显性
     */
    public static int dd_WG =3;
    /**
     * 时间: 2018/5/7 17:50
     * 功能描述:数据字典-骨架
     */
    public static int dd_GJ = 4;
    /**
     * 时间: 2018/5/7 17:50
     * 功能描述:数据字典-内饰
     */
    public static int dd_NS = 5;
    /**
     * 时间: 2018/5/7 16:32
     * 功能描述:车辆损伤-外观
     */
    public static int damage_WG = 1;
    /**
     * 时间: 2018/5/7 16:32
     * 功能描述:车辆损伤-骨架
     */
    public static int damage_GJ = 2;
    /**
     * 时间: 2018/5/7 16:32
     * 功能描述:车辆损伤-内饰
     */
    public static int damage_NS = 3;
    /**
     * 时间: 2018/5/7 11:10
     * 功能描述:短信模板-验证码短信模板
     */
    public static int SMS_YZM = 1;
    /**
     * 时间: 2018/5/7 11:10
     * 功能描述:短信模板-验证码短信模板
     */
    public static int SMS_TZ = 2;
    /**
     * 时间: 2018/5/7 10:11 功能描述:我的订单(待检测)
     */
    public static int check_DJC = 1;
    /**
     * 时间: 2018/5/7 10:11 功能描述:待上传(检测中)
     */
    public static int check_JCZ = 2;
    /**
     * 时间: 2018/5/7 10:11 功能描述:完成检测
     */
    public static int check_WC = 3;
    /**
     * 时间: 2018/5/7 10:11 功能描述:未分配
     */
    public static int check_WFP = 4;
    /**
     * 时间: 2018/5/7 10:11 功能描述:取消
     */
    public static int check_QX = 5;
    /**
     * 时间: 2018/5/7 10:11 功能描述:订单状态-拍卖订单
     */
    public static int order_CJDD = 1;
    /**
     * 时间: 2018/5/7 10:11 功能描述:订单状态-已付款
     */
    public static int order_FK = 2;
    /**
     * 时间: 2018/5/7 10:11 功能描述:订单状态-已成交
     */
    public static int order_CJ = 3;
    /**
     * 时间: 2018/5/7 10:11 功能描述:订单状态-已撤销
     */
    public static int order_CX = 4;
    /**
     * 时间: 2018/5/7 10:11 功能描述:订单状态-超时扣款
     */
    public static int order_CSKK = 5;
    /**
     * 时间: 2018/5/7 9:53 功能描述:车辆状态-车库
     */
    public static int carInfo_CK = 1;
    /**
     * 时间: 2018/5/7 9:53 功能描述:车辆状态-拍卖中
     */
    public static int carInfo_PaiM = 2;
    /**
     * 时间: 2018/5/7 9:53 功能描述:车辆状态-成交
     */
    public static int carInfo_CJ = 3;
    /**
     * 时间: 2018/5/7 9:53 功能描述:车辆状态-冻结
     */
    public static int carInfo_DJ = 4;
    /**
     * 时间: 2018/5/7 9:53 功能描述:车辆状态-下架
     */
    public static int carInfo_XJ = 5;
    /**
     * 时间: 2018/5/7 9:53 功能描述:车辆状态-待拍卖
     */
    public static int carInfo_DPM = 6;
    /**
     * 时间: 2018/5/7 9:53 功能描述:车辆状态-建立拍卖订单
     */
    public static int carInfo_JLDD = 7;

    /**
     * PC新建检测订单类型
     */
    public static int checkBill_PC = 1;
    /**
     * 检测APP新建检测订单类型
     */
    public static int checkBill_JC = 2;
    /**
     * 商家新建检测订单类型
     */
    public static int checkBill_SJ = 3;
    /**
     * 树形层级
     */
    public static int TreeLV = 0;
    /**
     * 时间: 2018/5/3 14:34 功能描述:行驶里程--当此值=10000时显示万公里,当此值=1时显示公里
     */
    public static float Mileage = 10000;
    /**
     * 时间: 2018/5/6 17:48 功能描述:(保留价) 返利规则: 标准：1.5万以下的车辆，酬劳奖金500元； * 1.5万（含1.5万）-5万的车辆，酬劳奖金800元； *
     * 5（含5万）-10万的车辆，酬劳奖金1500元； 10万以上（含10万）的车辆，酬劳奖金2000元。 商家订单状态短信通知:
     * 过户成功,向商家发送短信提示:恭喜!您的车辆已出售,获取***元奖励.
     */
    public static Double rebate_15000 = 15000D;
    public static Double rebate_50000 = 50000D;
    public static Double rebate_100000 = 100000D;
    public static Double rebate_500 = 500D; // 酬劳500
    public static Double rebate_800 = 800D; // 酬劳800
    public static Double rebate_1500 = 1500D; // 酬劳1500
    public static Double rebate_2000 = 2000D; // 酬劳2000
}

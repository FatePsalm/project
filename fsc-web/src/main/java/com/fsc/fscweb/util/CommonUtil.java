package com.fsc.fscweb.util;

import com.fsc.fscweb.handler.exception.IsConformException;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 作者: Solace
 * 时间: 2018/6/30 22:52
 * 功能: 通用类
 * 参数:
 */
public class CommonUtil {
    /**
     * @see 验证手机号是否合法
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobile){
        if (mobile.length() != 11)
        {
            return false;
        }else{
            /**
             * 移动号段正则表达式
             */
            String pat1 = "^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|(1705)\\d{7}$";
            /**
             * 联通号段正则表达式
             */
            String pat2  = "^((13[0-2])|(145)|(15[5-6])|(176)|(18[5,6]))\\d{8}|(1709)\\d{7}$";
            /**
             * 电信号段正则表达式
             */
            String pat3  = "^((133)|(153)|(177)|(18[0,1,9])|(149)|(199))\\d{8}$";
            /**
             * 虚拟运营商正则表达式
             */
            String pat4 = "^((170))\\d{8}|(1718)|(1719)\\d{7}$";

            Pattern pattern1 = Pattern.compile(pat1);
            Matcher match1 = pattern1.matcher(mobile);
            boolean isMatch1 = match1.matches();
            if(isMatch1){
                return true;
            }
            Pattern pattern2 = Pattern.compile(pat2);
            Matcher match2 = pattern2.matcher(mobile);
            boolean isMatch2 = match2.matches();
            if(isMatch2){
                return true;
            }
            Pattern pattern3 = Pattern.compile(pat3);
            Matcher match3 = pattern3.matcher(mobile);
            boolean isMatch3 = match3.matches();
            if(isMatch3){
                return true;
            }
            Pattern pattern4 = Pattern.compile(pat4);
            Matcher match4 = pattern4.matcher(mobile);
            boolean isMatch4 = match4.matches();
            if(isMatch4){
                return true;
            }
            return false;
        }
    }
    /**
     * 作者:  CG
     * 时间： 2018/7/4 18:06
     * 功能描述:身份证验证
     */
    public static boolean checkCardNo(String cardNo) {
        //String cardNo = "360481197512040035"; // 36900119751204003X // 360481197512040035
        // 1.将身份证号码前面的17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2

        try {
            int[] intArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
            int sum = 0;
            for (int i = 0; i < intArr.length; i++) {
                // 2.将这17位数字和系数相乘的结果相加。
                sum += Character.digit(cardNo.charAt(i), 10) * intArr[i];
                // System.out.println((cardNo.charAt(i) - '0') + " x " + intArr[i] + " = " + (cardNo.charAt(i) - '0') *
                // intArr[i]);
            }
            System.out.println("Totally sum：" + sum);
            // 3.用加出来和除以11，看余数是多少？
            int mod = sum % 11;
            System.out.println("Totally sum%11 = " + mod);
            // 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
            int[] intArr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int[] intArr3 = {1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2};
            String matchDigit = "";
            for (int i = 0; i < intArr2.length; i++) {
                int j = intArr2[i];
                if (j == mod) {
                    matchDigit = String.valueOf(intArr3[i]);
                    if (intArr3[i] > 57) {
                        matchDigit = String.valueOf((char) intArr3[i]);
                    }
                }
            }

            if (matchDigit.equals(cardNo.substring(cardNo.length() - 1))) {
                System.out.println("ID Card Verify Sucsess!");
                return false;
            } else {
                System.out.println("ID Card Verify Faild!");
            }
            // 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
        } catch (Exception e) {
            e.printStackTrace();
           return true;
        }
        return true;
    }

    /**
     * 作者: Solace
     * 时间: 2018/7/1 2:10
     * 功能: MD5
     * 参数:
     */
    public static String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    /**
     * 作者: Solace
     * 时间: 2018/6/30 23:37
     * 功能: length用户要求产生字符串的长度
     * 参数:
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 作者: Solace
     * 时间: 2018/6/30 23:09
     * 功能: 验证数组是否大于零(包含0)
     * 参数:
     */
    public static boolean checkNumberZero(Integer number) {
        return number == null || number < 0 ? true : false;
    }

    /**
     * 作者: Solace
     * 时间: 2018/6/30 23:09
     * 功能: 验证数组是否大于零(不包含0)
     * 参数:
     */
    public static boolean checkNumber(Integer number) {
        return number == null || number < 1 ? true : false;
    }

    /**
     * 作者: Solace
     * 时间: 2018/6/30 23:09
     * 功能: 验证字符串是否为空
     * 参数:
     */
    public static boolean checkStr(String str) {
        return str == null || str.equals("") ? true : false;
    }

    /**
     * 作者: Solace
     * 时间: 2018/6/30 22:53
     * 功能: 邮箱验证
     * 参数:
     */
    public static boolean checkEmail(String email) {
        if (email == null || email.equals("")) {
            return true;
        }
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        return !Pattern.matches(regex, email);
    }
}

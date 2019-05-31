package com.dingdang.biz.service.Impl;

import com.dingdang.biz.entity.VerificationCode;

import java.util.Map;

/**
 * @author zoucong
 * @data 2018/5/4 16:40
 * 短信服务类
 */
public interface MessageService {

    /**
     * 发送短信到阿里云
     */
    Map<String, Object> doPostCode(VerificationCode verificationCode);

    /** 查找短信模板 */
    VerificationCode FindSmsTemplate(Integer id) ;

}

package com.fsc.fscweb.service.impl;

import com.fsc.fscweb.handler.exception.IsConformException;
import com.fsc.fscweb.service.EmailService;
import com.fsc.fscweb.util.CommonUtil;
import com.fsc.fscweb.util.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public Boolean registerCode(String email) {
        Long expire = redisTemplate.getExpire(Variable.registerCodeRedis + email, TimeUnit.SECONDS);//根据key获取过期时间并换算成指定单位
        System.out.println(expire);
        if (expire > 0) {
            throw new IsConformException("验证码有效期" + expire + "秒");
        }
        try {
            String randomString = CommonUtil.getRandomString(Variable.registerLeng);
            SimpleMailMessage message = new SimpleMailMessage();
            //邮件设置
            message.setSubject(Variable.emailTheme);//主题
            message.setText(Variable.emailBody + randomString);//内容
            message.setTo(email);//发送地址
            message.setFrom(from);//发送者
            mailSender.send(message);//发送
            //写入redis
            redisTemplate.opsForValue().set(Variable.registerCodeRedis + email, randomString, Variable.registerCodeRedisTime, TimeUnit.MINUTES);
        } catch (MailException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

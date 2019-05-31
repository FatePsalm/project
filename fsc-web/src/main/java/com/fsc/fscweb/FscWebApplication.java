package com.fsc.fscweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //开启基于注解的定时任务
@MapperScan(value = "com.fsc.fscweb.dao")
public class FscWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FscWebApplication.class, args);
    }
}

package com.fsc.fscweb;

import com.fsc.fscweb.util.CommonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FscWebApplicationTests {

    @Test
    public void contextLoads() {
        String randomString = CommonUtil.getRandomString(6);
        System.out.println(
                randomString
        );
    }

}

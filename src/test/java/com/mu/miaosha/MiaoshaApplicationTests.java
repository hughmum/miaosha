package com.mu.miaosha;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static com.mu.miaosha.utils.JwtUtils.createToken;
import static com.mu.miaosha.utils.JwtUtils.verifyToken;
import static com.mu.miaosha.utils.MD5Utils.encode;

@SpringBootTest
class MiaoshaApplicationTests {

    @Test
    void contextLoads() {
        //测试token解析
        String token = createToken(11111L,1);
        System.out.println(token);
        System.out.println(verifyToken(token));

        //md5
        System.out.println(encode("dsfd"));
    }

}

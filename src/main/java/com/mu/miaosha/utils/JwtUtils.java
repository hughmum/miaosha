package com.mu.miaosha.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author 沐
 * Date: 2023-03-10 11:04
 * version: 1.0
 */
@Slf4j
public class JwtUtils {
    private static final String TOKEN_SECRET = "adfsdgfsdgsd";

    /**
     * generate token by userid
     * @param userId
     * @param expireTime
     * @return
     */
    public static String createToken(Long userId, int expireTime) {
        try {
            Date date = new Date(System.currentTimeMillis() + (expireTime * 1000L));
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            return JWT.create()
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            log.error("JwtUtils: token创建失败");
            return null;
        }
    }

    public static Long verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token)
                .getClaim("userId")
                .asLong();
    }
}

package com.mu.miaosha.interceptor;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.mu.miaosha.dao.UserDOMapper;
import com.mu.miaosha.entity.UserDO;
import com.mu.miaosha.utils.JwtUtils;
import com.mu.miaosha.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;

import static com.mu.miaosha.common.contants.UserConstants.USER_PREFIX;

/**
 * @author 沐
 * Date: 2023-03-10 10:00
 * version: 1.0
 */
@Component("loginInterceptor")
@Slf4j
public class LoginInterceptor  implements HandlerInterceptor {

    @Resource
    private UserDOMapper userDOMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserDO userDO =

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    public UserDO parseToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        Long id = null;
        try {
            //TODO: 2023/3/10 处理token问题
            id = JwtUtils.verifyToken(token);
        } catch (JWTVerificationException e) {
            log.error("token parse error: {}",e.getMessage());
            return null;
        }
        assert id != null;
        UserDO userDO = RedisUtils.get(USER_PREFIX + id);
        if (userDO == null) {
            userDO = userDOMapper.selectByPrimaryKey(id);
            //TODO: 2023/3/10 缓存时间应该统一配置
            RedisUtils
        }


    }
}

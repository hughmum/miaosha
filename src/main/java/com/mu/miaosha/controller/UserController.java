package com.mu.miaosha.controller;

import com.mu.miaosha.common.Result;
import com.mu.miaosha.common.annotations.Access;
import com.mu.miaosha.common.dto.resp.UserDTO;
import com.mu.miaosha.entity.UserDO;
import com.mu.miaosha.excption.BusinessException;
import com.mu.miaosha.service.UserService;
import com.mu.miaosha.utils.MD5Utils;
import com.mu.miaosha.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 沐
 * Date: 2023-03-10 11:29
 * version: 1.0
 */
@RestController()
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    private static final String OPT_PREFIX = "opt_";
    private static final String USER_PREFIX = "user_";


    @ApiOperation("注册接口")
    @PostMapping(value = "/register")
    @Access
    public Result<Object> register(@RequestParam(name = "telephone") String telephone,
                                   @RequestParam(name = "optCode") String otpCode,
                                   @RequestParam(name = "name") String name,
                                   @RequestParam(name = "gender") Integer gender,
                                   @RequestParam(name = "age") Integer age,
                                   @RequestParam(name = "password") String password) throws BusinessException {
        if (otpCode == null) {
            throw new BusinessException(500, "验证码不能为空");
        }
        String opt = RedisUtils.get(OPT_PREFIX + telephone);
        if (!otpCode.equals(opt)) {
            throw new BusinessException(500, "验证码错误");
        }
        UserDO user = userService.getUserByPhone(telephone);
        if (user != null) {
            throw new BusinessException(500, "用户已经注册");
        }
        UserDTO userDto = new UserDTO();

        userDto.setName(name);
        userDto.setTelphone(telephone);
        userDto.setGender(new Byte(String.valueOf(gender.intValue())));
        userDto.setAge(age);
        userDto.setRegisterMode("byphone");
        userDto.setEncrptPassword(MD5Utils.encode(password));

        userService.register(userDto);
        return Result.build(200, "注册成功", null);
    }


}

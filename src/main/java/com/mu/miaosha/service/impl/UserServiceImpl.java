package com.mu.miaosha.service.impl;

import com.mu.miaosha.common.dto.resp.UserDTO;
import com.mu.miaosha.dao.UserDOMapper;
import com.mu.miaosha.dao.UserPasswordDOMapper;
import com.mu.miaosha.entity.UserDO;
import com.mu.miaosha.entity.UserPasswordDO;
import com.mu.miaosha.excption.BusinessException;
import com.mu.miaosha.service.UserService;
import com.mu.miaosha.utils.BeanUtils;
import com.mu.miaosha.utils.IdUtils;

import javax.annotation.Resource;

/**
 * @author 沐
 * Date: 2023-03-10 11:28
 * version: 1.0
 */
public class UserServiceImpl implements UserService {

    @Resource
    private UserDOMapper userDOMapper;

    @Resource
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public void register(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO, userDO);
        long userId = IdUtils.generatrId();
        userDO.setId(userId);
        userDOMapper.insert(userDO);

        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setId(IdUtils.generatrId());
        userPasswordDO.setUserId(userId);
        userPasswordDO.setEncrptPassword(userDTO.getEncrptPassword());
        userPasswordDOMapper.insertSelective(userPasswordDO);
    }

    @Override
    public UserDO getUserById(Long id) {
        return null;
    }

    @Override
    public UserDO validateLogin(String telephone, String password) throws BusinessException {
        return null;
    }

    @Override
    public UserDO getUserByPhone(String telephone) {
        return userDOMapper.selectByTelphone(telephone);
    }
}

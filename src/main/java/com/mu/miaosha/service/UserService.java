package com.mu.miaosha.service;

import com.mu.miaosha.common.dto.resp.UserDTO;
import com.mu.miaosha.entity.UserDO;
import com.mu.miaosha.excption.BusinessException;

/**
 * @author Mr.xin
 */
public interface UserService {
    void register(UserDTO userDto);

    UserDO getUserById(Long id);

    UserDO validateLogin(String telephone, String password) throws BusinessException;

    UserDO getUserByPhone(String telephone);
}

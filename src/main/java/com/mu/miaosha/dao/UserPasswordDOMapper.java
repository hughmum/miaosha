package com.mu.miaosha.dao;

import com.mu.miaosha.entity.UserPasswordDO;

/**
 * @author 沐
 * Date: 2023-03-10 10:02
 * version: 1.0
 */
public interface UserPasswordDOMapper {
    int insertSelective(UserPasswordDO record);
}

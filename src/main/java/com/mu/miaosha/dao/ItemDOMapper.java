package com.mu.miaosha.dao;

import com.mu.miaosha.entity.ItemDO;

public interface ItemDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemDO record);

    int insertSelective(ItemDO record);

    ItemDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemDO record);

    int updateByPrimaryKey(ItemDO record);
}
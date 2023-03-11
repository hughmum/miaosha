package com.mu.miaosha.dao;

import com.mu.miaosha.entity.ItemStockDO;

public interface ItemStockDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemStockDO record);

    int insertSelective(ItemStockDO record);

    ItemStockDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemStockDO record);

    int updateByPrimaryKey(ItemStockDO record);
}
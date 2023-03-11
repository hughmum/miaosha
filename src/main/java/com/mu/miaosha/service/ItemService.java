package com.mu.miaosha.service;

import com.mu.miaosha.entity.ItemDO;

/**
 * @author 沐
 * Date: 2023-03-10 11:25
 * version: 1.0
 */
public interface ItemService {
    /**
     * 创建商品
     * @param itemDO 商品实体对象
     */
    boolean createItem(ItemDO itemDO);


    /**
     * 查询商品
     * @param id 商品id
     * @return 商品实体
     */
    ItemDO queryGoods(Long id);
}

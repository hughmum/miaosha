package com.mu.miaosha.service;

import com.mu.miaosha.excption.BusinessException;

import java.util.concurrent.ExecutionException;

/**
 * @author 沐
 * Date: 2023-03-10 11:26
 * version: 1.0
 */
public interface OrderService {
    //使用1,通过前端url上传过来秒杀活动id，然后下单接口内校验对应id是否属于对应商品且活动已开始
    //    //2.直接在下单接口内判断对应的商品是否存在秒杀活动，若存在进行中的则以秒杀价格下单
    String createOrder(Long userId, Long itemId, Long promoId, Integer amount) throws BusinessException, ExecutionException;

    int getOrderStatus(String orderId);
}

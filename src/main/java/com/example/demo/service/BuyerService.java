package com.example.demo.service;

import com.example.demo.dto.OrderDTO;

/**
 * Description:买家订单
 * User: SaintChan
 * Date: 2018-02-09
 * Time: 下午 3:42
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}

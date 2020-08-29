package com.sunrise.service;

import com.sunrise.dto.OrderDTO;

/**
 * interface
 *
 * @author Andy
 * @date 2020/8/29
 */

public interface BuyerService {

    /**
     * 查询一个订单
     * @param openId
     * @param OrderId
     * @return
     */
    OrderDTO findOrderOne(String openId, String OrderId);

    /**
     * 取消订单
     * @param OpenId
     * @param OrderId
     * @return
     */
    OrderDTO cancelOrder(String OpenId, String OrderId);

}

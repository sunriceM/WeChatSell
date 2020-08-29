package com.sunrise.service.impl;

import com.sunrise.dto.OrderDTO;
import com.sunrise.enums.ResultEnum;
import com.sunrise.exception.SellException;
import com.sunrise.service.BuyerService;
import com.sunrise.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class
 *
 * @author Andy
 * @date 2020/8/29
 */

@Slf4j
@Service
public class BuyerServiseImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openId, String orderId) {

        return checkOrderOwner(openId, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openId, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openId, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】 查不到该订单， orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openId, String orderId) {

        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        if(!orderDTO.getBuyerOpenid().equals(openId)) {
            log.error("【查询订单】 订单openid与查询不一致， orderDTO={}， openId={}", orderDTO, openId);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}

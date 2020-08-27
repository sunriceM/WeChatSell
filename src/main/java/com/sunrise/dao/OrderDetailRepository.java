package com.sunrise.dao;

import com.sunrise.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * interface
 *
 * @author Andy
 * @date 2020/8/23
 */

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 根据订单id查询订单详情（订单中的商品列表
     * @param orderId 订单id
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}

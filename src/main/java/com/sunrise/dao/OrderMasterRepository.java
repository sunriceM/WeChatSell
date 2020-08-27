package com.sunrise.dao;

import com.sunrise.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * interface
 *
 * @author Andy
 * @date 2020/8/23
 */

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 根据买家的openId分页查询订单
     * @param buyerOpenid 买家微信openId
     * @param pageable 分页
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}

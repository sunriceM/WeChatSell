package com.sunrise.service.impl;

import com.sun.org.apache.regexp.internal.RE;
import com.sunrise.dto.OrderDTO;
import com.sunrise.entity.OrderDetail;
import com.sunrise.enums.OrderStatusEnum;
import com.sunrise.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "ch521";

    private final String ORDER_ID = "1598360965933269303";
    @Test
    public void createOrder() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("qwedfg");
        orderDTO.setBuyerName("asdf");
        orderDTO.setBuyerPhone("sdfgds");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> orderDetails  =new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("qwerasdfzxcv");
        orderDetail.setProductQuantity(2);

        orderDetails.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetails);

        OrderDTO result = orderService.createOrder(orderDTO);
        log.info("【创建订单】 result = {}", result);
    }

    @Test
    public void findOne() {

        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】 result={}", result);
        assertEquals(ORDER_ID, result.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest pageRequest = PageRequest.of(0, 2);

        Page<OrderDTO> list = orderService.findList(BUYER_OPENID, pageRequest);

        assertNotEquals(0, list.getSize());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());

    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}
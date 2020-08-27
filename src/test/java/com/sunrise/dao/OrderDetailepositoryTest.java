package com.sunrise.dao;

import com.sunrise.entity.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567897654");
        orderDetail.setOrderId("123456");
        orderDetail.setProductId("123");
        orderDetail.setProductIcon("asdgh");
        orderDetail.setProductName("sdfgh");
        orderDetail.setProductPrice(new BigDecimal(34.5));
        orderDetail.setProductQuantity(2);

        OrderDetail result = repository.save(orderDetail);

        assertNotNull(result);
    }

    @Test
    public void findByOrderId() {

        List<OrderDetail> orderDetailList = repository.findByOrderId("123456");

        assertNotEquals(0, orderDetailList.size());
    }
}
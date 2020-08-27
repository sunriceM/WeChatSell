package com.sunrise.dao;

import com.sunrise.entity.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("875421");
        orderMaster.setBuyerName("chenhuan");
        orderMaster.setBuyerPhone("12345");
        orderMaster.setBuyerAddress("asdfgh");
        orderMaster.setBuyerOpenid("124sdf");
        orderMaster.setOrderAmount(new BigDecimal(521.5));

        OrderMaster result = repository.save(orderMaster);

        assertNotNull(result);

    }


    @Test
    public void findByBuyerOpenid() {

        PageRequest pageRequest = PageRequest.of(0, 1);

        Page<OrderMaster> result = repository.findByBuyerOpenid("124sdf", pageRequest);

        System.out.println(result.getTotalElements());

    }
}
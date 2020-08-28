package com.sunrise.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sunrise.dto.OrderDTO;
import com.sunrise.entity.OrderDetail;
import com.sunrise.enums.ResultEnum;
import com.sunrise.exception.SellException;
import com.sunrise.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * class
 *
 * @author Andy
 * @date 2020/8/27
 */

@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {

        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenId());

        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {}.getType());
        }catch (Exception e) {
            log.error("【对象转换】 错误，String={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

}

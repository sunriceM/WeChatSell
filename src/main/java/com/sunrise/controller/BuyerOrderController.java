package com.sunrise.controller;

import com.sunrise.VO.ResultVO;
import com.sunrise.converter.OrderForm2OrderDTOConverter;
import com.sunrise.dto.OrderDTO;
import com.sunrise.enums.ResultEnum;
import com.sunrise.exception.SellException;
import com.sunrise.form.OrderForm;
import com.sunrise.service.BuyerService;
import com.sunrise.service.OrderService;
import com.sunrise.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class
 *
 * @author Andy
 * @date 2020/8/27
 */

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    /**
     * 创建订单
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> createOrder (@Valid OrderForm orderForm,
                                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】 参数不正确，orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO creatOrderResult = orderService.createOrder(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", creatOrderResult.getOrderId());

        return ResultVoUtil.success(map);

    }

    /**
     * 订单列表
     */
    @PostMapping("/list")
    public ResultVO<List<OrderDTO>> ListOrder(@RequestParam("openId") String openId,
                                              @RequestParam(value = "page", defaultValue = "0") Integer page,
                                              @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openId)) {
            log.error("【查询订单列表】 openId 为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openId, request);

        return ResultVoUtil.success(orderDTOPage.getContent());
    }


    /**
     * 订单详情
     */
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        OrderDTO order = buyerService.findOrderOne(openid, orderId);

        return ResultVoUtil.success(order);
    }


    /**
     * 取消订单
     */
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openId") String openId,
                           @RequestParam("orderId") String orderId) {

        buyerService.cancelOrder(openId, orderId);

        return ResultVoUtil.success();
    }
}

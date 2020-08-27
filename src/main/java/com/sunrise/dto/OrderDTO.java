package com.sunrise.dto;

import com.sunrise.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * class
 *
 * @author Andy
 * @date 2020/8/24
 */

@Data
public class OrderDTO {

    /** 订单id */
    private String orderId;

    /** 买家姓名 */
    private String buyerName;

    /** 买家手机 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信id */
    private String buyerOpenid;

    /** 订单金额 */
    private BigDecimal orderAmount;

    /** 订单状态 , 默认新下单*/
    private Integer orderStatus;

    /** 支付状态， 默认未支付 */
    private Integer payStatus;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    List<OrderDetail> orderDetailList;

}

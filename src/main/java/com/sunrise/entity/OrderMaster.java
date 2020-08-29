package com.sunrise.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sunrise.enums.OrderStatusEnum;
import com.sunrise.enums.PayStatusEnum;
import com.sunrise.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * class
 *
 * @author Andy
 * @date 2020/8/23
 */

@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /** 订单id */
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态， 默认未支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

}

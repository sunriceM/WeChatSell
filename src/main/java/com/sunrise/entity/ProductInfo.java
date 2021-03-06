package com.sunrise.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sunrise.utils.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * class
 *
 * @author Andy
 * @date 2020/8/22
 */

@Entity
@Data
public class ProductInfo {

    @Id
    private String ProductId;

    /** 名称 */
    private String productName;

    /** 单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图 */
    private String productIcon;

    /** 商品状态 0正常 1下架 */
    private Integer productStatus;

    /** 类目编号 */
    private Integer categoryType;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    public ProductInfo() {
    }
}

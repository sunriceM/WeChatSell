package com.sunrise.dto;

import lombok.Data;

/**
 * class
 *
 * @author Andy
 * @date 2020/8/24
 */

@Data
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 库存
     */
    private Integer productQuantity;

    public CartDTO(String productId) {
        this.productId = productId;
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}

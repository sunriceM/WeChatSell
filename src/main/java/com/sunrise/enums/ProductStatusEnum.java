package com.sunrise.enums;

import lombok.Getter;

/**
 * 商品状态
 *
 * @author Andy
 * @date 2020/8/22
 */

@Getter
public enum ProductStatusEnum {

    Up(0, "在架"),
    Down(1, "下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

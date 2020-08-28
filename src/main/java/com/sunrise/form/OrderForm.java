package com.sunrise.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * class
 *
 * @author Andy
 * @date 2020/8/27
 */

@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家送回家号
     */
    @NotEmpty(message = "送回家号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址不能为空")
    private String address;

    /**
     * 买家微信openId
     */
    @NotEmpty
    private String openId;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}

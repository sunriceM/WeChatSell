package com.sunrise.exception;

import com.sunrise.enums.ResultEnum;

/**
 * class
 *
 * @author Andy
 * @date 2020/8/24
 */

public class SellException extends RuntimeException {

    private Integer code;

    private String message;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}

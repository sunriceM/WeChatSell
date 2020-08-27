package com.sunrise.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 *
 * @author Andy
 * @date 2020/8/23
 */

@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String message;

    /** 返回的具体内容 */
    private T Data;
}

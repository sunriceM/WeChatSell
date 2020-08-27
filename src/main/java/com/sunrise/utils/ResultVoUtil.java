package com.sunrise.utils;

import com.sunrise.VO.ResultVO;

/**
 * class
 *
 * @author Andy
 * @date 2020/8/23
 */

public class ResultVoUtil {

    public static ResultVO success(Object object)  {

        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMessage("失败");

        return resultVO;
    }

}

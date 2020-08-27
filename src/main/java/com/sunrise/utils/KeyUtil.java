package com.sunrise.utils;

import java.util.Random;

/**
 * class
 *
 * @author Andy
 * @date 2020/8/24
 */

public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }

}

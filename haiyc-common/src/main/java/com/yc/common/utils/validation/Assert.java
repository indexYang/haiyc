package com.yc.common.utils.validation;

import com.yc.common.utils.exception.BaseException;

/**
 * @Description: 断言
 * @author 村子里最好的剑
 * @date 2020年10月30日
 */
public class Assert {
    //断言为空
    public static void isNull( ViolationMessage object, Integer code) {
        if (object != null) {
            throw new BaseException(code, "", object.getMessage());
        }
    }

}


package com.yc.controller.common;

import com.yc.common.exception.BaseException;
import com.yc.common.result.Result;
import com.yc.common.result.ResultCodeEnum;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description 公共控制器
 * @Author yangch
 * @Date 2020-10-20 10:36:05
 */
@RequestMapping("/common")
@RestController
public class CommonController {

    /**
     * 未授权跳转方法
     * @return
     */
    @RequestMapping("/unauth")
    public Result unauth(){
        SecurityUtils.getSubject().logout();
        return Result.success("未授权跳转方法");
    }

    /**
     * 被踢出后跳转方法
     * @return
     */
    @RequestMapping("/kickout")
    public void kickout(){
        throw new BaseException(ResultCodeEnum.HASLOGIN_OTHER);
    }
}

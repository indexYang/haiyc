package com.yc.controller;

import com.yc.dto.login.LoginInfo;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.shiro.SecurityUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 基类controller<br>
 * 〈功能详细描述〉
 *
 * @author yangch
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BaseController {

    /**
     * 获取用户登录信息
     * @return
     */
    public LoginInfo getUserInfo(){
        LoginInfo userInfo =  new LoginInfo();
        try {
            PropertyUtils.copyProperties(userInfo, SecurityUtils.getSubject().getPrincipal());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return userInfo;
    }
}

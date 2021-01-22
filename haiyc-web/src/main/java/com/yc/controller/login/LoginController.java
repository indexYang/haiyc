package com.yc.controller.login;

import com.yc.common.exception.BaseException;
import com.yc.common.result.ResponseResult;
import com.yc.common.result.Result;
import com.yc.common.result.ResultCodeEnum;
import com.yc.dto.login.LoginInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 用户信息控制器
 * @Author 村子里最好的剑
 * @Date 2020-10-29 16:41
 */
@RestController
public class LoginController {

    /**
     * 登录接口
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping("/login.do")
    @ResponseResult
    public Object login (String username, String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken upToken = new UsernamePasswordToken(username, password);
        try {
            subject.login(upToken);
            LoginInfo loginInfo = (LoginInfo)SecurityUtils.getSubject().getPrincipal();
            loginInfo.setToken((String) subject.getSession().getId());
            loginInfo.setPassword(null);
            SecurityUtils.getSubject().getSession().setTimeout(4 * 60 * 60 * 1000L);
            return loginInfo;
        } catch (UnknownAccountException e) {
            throw new BaseException(ResultCodeEnum.ACCOUNT_NOT_EXISTING);
        } catch (IncorrectCredentialsException e) {
            throw new BaseException(ResultCodeEnum.PASSWORD_ERR);
        } catch (LockedAccountException e) {
            throw new BaseException(ResultCodeEnum.ACCOUNT_LOCK);
        } catch (AuthenticationException e) {
            throw new BaseException(ResultCodeEnum.FAIL);
        }
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return Result.success("退出成功");
    }
}

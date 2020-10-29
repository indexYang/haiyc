package com.yc.controller.login;

import com.yc.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description 用户信息控制器
 * @Author 村子里最好的剑
 * @Date 2020-10-29 16:41
 */
@RestController
public class LoginController {

    @Autowired
    private BaseUserService baseUserService;
}

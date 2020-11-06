package com.yc.dto.login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 *@function 登录用户信息
 *@author 村子里最好的剑
 *@date 2020年08月26日 15:20
 */
@Setter
@Getter
@ToString
public class LoginInfo implements Serializable {

    //用户编号
    private String userNo;

    //用户名
    private String userName;

    //密码
    private String password;

    //头像
    private String imgHead;

    //转态 0-删除 1-未删除 2-锁定
    private Integer status;

    //token
    private String token;
}

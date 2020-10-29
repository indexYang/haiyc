package com.yc.service.impl;

import com.yc.dao.user.BaseUserDao;
import com.yc.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 用户信息serviceImpl
 * @Author 村子里最好的剑
 * @Date 2020-10-29 16:40
 */
@Service
public class BaseUserServiceImpl implements BaseUserService {

    @Autowired
    private BaseUserDao baseUserDao;

}

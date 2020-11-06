package com.yc.service.user.impl;

import com.yc.dao.user.BaseUserRoleDao;
import com.yc.service.user.BaseUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yangch
 * @Date 2020-07-28 02:15:34
 */
@Service
public class BaseUserRoleServiceImpl implements BaseUserRoleService {

   @Autowired
   private BaseUserRoleDao baseUserRoleDao;

}

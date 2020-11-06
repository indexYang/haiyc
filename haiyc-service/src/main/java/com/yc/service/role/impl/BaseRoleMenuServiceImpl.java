package com.yc.service.role.impl;

import com.yc.dao.role.BaseRoleMenuDao;
import com.yc.service.role.BaseRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yangch
 * @Date 2020-07-28 02:15:34
 */
@Service
public class BaseRoleMenuServiceImpl implements BaseRoleMenuService {

   @Autowired
   private BaseRoleMenuDao baseRoleMenuDao;

}

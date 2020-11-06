package com.yc.service.menu.impl;

import com.yc.dao.menu.BaseMenuDao;
import com.yc.entity.menu.BaseMenuPermissionEntity;
import com.yc.service.menu.BaseMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author yangch
 * @Date 2020-07-28 02:15:34
 */
@Service
public class BaseMenuServiceImpl implements BaseMenuService {

   @Autowired
   private BaseMenuDao baseMenuDao;

   /**
    * 查询该用户的所有按钮权限
    * @param userNo 用户编号
    * @Author haiyc
    * @Date 2020-08-26 17:26
    * @return
    */
   @Override
   public List<BaseMenuPermissionEntity> listPermission(String userNo) {
      return this.baseMenuDao.listPermission(userNo);
   }
}

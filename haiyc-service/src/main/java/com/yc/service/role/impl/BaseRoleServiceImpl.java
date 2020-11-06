package com.yc.service.role.impl;

import com.yc.common.constant.Constant;
import com.yc.dao.role.BaseRoleDao;
import com.yc.entity.role.BaseRoleEntity;
import com.yc.service.role.BaseRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 角色逻辑处理层
 * @Author yangch
 * @Date 2020-07-28 02:15:34
 */
@Service
public class BaseRoleServiceImpl implements BaseRoleService {

   @Autowired
   private BaseRoleDao baseRoleDao;

   /**
    * 查询某用户所有的角色
    * @param userNo 用户编号
    * @Date 2020-08-24 17:23
    * @return
    */
   @Override
   public List<BaseRoleEntity> queryUserRoles(String userNo) {
      return baseRoleDao.queryUserRoles(userNo);
   }

   /**
    * 查询所有的角色
    * @param
    * @Date 2020-09-27 13:50
    * @return List<BaseRoleEntity>
    */
   @Override
   public List<BaseRoleEntity> listAllRoles() {
      BaseRoleEntity baseRoleEntity = new BaseRoleEntity();
      baseRoleEntity.setStatus(Constant.NUM_1);
      return baseRoleDao.select(baseRoleEntity);
   }
}

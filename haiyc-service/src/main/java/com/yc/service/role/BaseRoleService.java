package com.yc.service.role;

import com.yc.entity.role.BaseRoleEntity;

import java.util.List;

/**
 * @Description 角色service层
 * @Author yangch
 * @Date 2020-07-28 02:15:07
 */
public interface BaseRoleService {

    /**
     * 查询某用户所有的角色
     * @param userNo 用户编号
     * @Date 2020-08-24 17:23
     * @return
     */
    List<BaseRoleEntity> queryUserRoles(String userNo);

    /**
     * 查询所有的角色
     * @param
     * @Date 2020-09-27 13:50
     * @return List<BaseRoleEntity>
     */
    List<BaseRoleEntity> listAllRoles();
}

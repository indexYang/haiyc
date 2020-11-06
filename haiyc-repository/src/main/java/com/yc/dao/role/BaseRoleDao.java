package com.yc.dao.role;

import com.yc.entity.role.BaseRoleEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @Description 角色dao层
 * @Author yangch
 * @Date 2020-07-28 02:14:42
 */
public interface BaseRoleDao extends Mapper<BaseRoleEntity>, MySqlMapper<BaseRoleEntity> {

    /**
     * 查询某用户所有的角色
     * @param userNo 用户编号
     * @Date 2020-08-24 17:23
     * @return
     */
    List<BaseRoleEntity> queryUserRoles(String userNo);

}

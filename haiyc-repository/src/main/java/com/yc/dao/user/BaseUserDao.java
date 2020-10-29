package com.yc.dao.user;

import com.yc.entity.user.BaseUserEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description 用户信息交互dao
 * @Author 村子里最好的剑
 * @Date 2020-10-29 16:38
 */
public interface BaseUserDao extends Mapper<BaseUserEntity>, MySqlMapper<BaseUserEntity> {

}

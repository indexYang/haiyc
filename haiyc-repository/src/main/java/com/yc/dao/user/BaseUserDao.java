package com.yc.dao.user;

import com.yc.dto.login.LoginInfo;
import com.yc.dto.user.BaseUserDto;
import com.yc.entity.user.BaseUserEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

/**
 * @Description 用户信息交互dao
 * @Author 村子里最好的剑
 * @Date 2020-10-29 16:38
 */
public interface BaseUserDao extends Mapper<BaseUserEntity>, MySqlMapper<BaseUserEntity> {


    /**
     * 查询登录信息
     * @param username 用户名
     * @Date 2020-08-24 17:23
     * @return
     */
    LoginInfo loginUser(String username);

    /**
     * 查询用户列表
     * @param params
     * @Date 2020-09-27 09:41
     * @return List<BaseUserDto>
     */
    List<BaseUserDto> listUsers(Map params);

    /**
     * 查询用户的总条数
     * @param params
     * @Date 2020-09-27 09:42
     * @return int
     */
    int countUsers(Map params);

    /**
     * 用户详情
     * @param userNo 用户编码
     * @Date 2020-09-27 10:00
     * @return BaseUserDto
     */
    BaseUserDto getUser(String userNo);

    /**
     * 查询用户是否存在
     * @param userNo 用户编码
     * @param userName 用户名称
     * @Date 2020-10-09 15:05
     * @return BaseUserEntity
     */
    BaseUserEntity findUserName(String userNo, String userName);

    /**
     * 查询用户是否存在
     * @param userNo 用户编码
     * @param phone 手机号码
     * @Date 2020-10-09 15:14
     * @return BaseUserEntity
     */
    BaseUserEntity findUserPhone(String userNo, String phone);

}

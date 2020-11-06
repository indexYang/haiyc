package com.yc.service.user;

import com.yc.dto.login.LoginInfo;
import com.yc.dto.user.BaseUserDto;
import com.yc.dto.user.UserRolePermissionsDto;
import com.yc.entity.user.BaseUserEntity;

import java.util.List;

/**
 * @Description 用户信息service
 * @Author 村子里最好的剑
 * @Date 2020-10-29 16:39
 */
public interface BaseUserService {

    /**
     * 查询登录信息
     * @param username 用户名
     * @Date 2020-08-24 17:23
     * @return LoginInfo
     */
    LoginInfo loginUser(String username);

    /**
     * 查询用户的菜单权限与按钮权限
     * @param userNo 用户编号
     * @Date 2020-08-26 16:18
     * @return UserRolePermissionsDto
     */
    UserRolePermissionsDto userRolePermission(String userNo);

    /**
     * 查询用户列表
     * @param correctPage 起始页
     * @param correctSize 页大小
     * @param baseUserDto
     * @Date 2020-09-27 09:41
     * @return List<BaseUserDto>
     */
    List<BaseUserDto> listUsers(int correctPage, int correctSize, BaseUserDto baseUserDto);

    /**
     * 查询用户的总条数
     * @param baseUserDto
     * @Date 2020-09-27 09:42
     * @return int
     */
    int countUsers(BaseUserDto baseUserDto);

    /**
     * 新增用户
     * @param baseUserDto
     * @Date 2020-09-27 09:58
     * @return void
     */
    void addUser(BaseUserDto baseUserDto);

    /**
     * 修改用户
     * @param baseUserDto
     * @Date 2020-09-27 09:59
     * @return void
     */
    void modifyUser(BaseUserDto baseUserDto);

    /**
     * 用户详情
     * @param userNo 用户编码
     * @Date 2020-09-27 10:00
     * @return BaseUserDto
     */
    BaseUserDto getUser(String userNo);

    /**
     * 用户删除
     * @param baseUserEntity
     * @Date 2020-09-27 10:03
     * @return void
     */
    void delUser(BaseUserEntity baseUserEntity);

    /**
     * 修改密码
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @param confirmPwd 确认密码
     * @param userNo 用户编码
     * @Date 2020-10-10 13:28
     * @return void
     */
    void doUpdatePwd(String oldPwd, String newPwd, String confirmPwd, String userNo);

    /**
     * 重置密码
     * @param userNo 用户编码
     * @param loginUserNo 登录人的用户编码
     * @Date 2020-10-10 13:46
     * @return void
     */
    void doResetPwd(String userNo, String loginUserNo);

}

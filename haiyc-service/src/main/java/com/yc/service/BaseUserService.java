package com.yc.service;

import com.yc.dto.user.BaseUserDto;

import java.util.List;

/**
 * @Description 用户信息service
 * @Author 村子里最好的剑
 * @Date 2020-10-29 16:39
 */
public interface BaseUserService {

    /**
     * 查询用户列表
     * @param correctPage 起始页
     * @param correctSize 页大小
     * @param baseUserDto
     * @Date 2020-10-30 09:28
     * @return List<BaseUserDto>
     */
    List<BaseUserDto> listPageUsers(int correctPage, int correctSize, BaseUserDto baseUserDto);

    /**
     * 查询用户的总条数
     * @param baseUserDto
     * @Date 2020-10-30 09:29
     * @return int
     */
    int countUsers(BaseUserDto baseUserDto);
}

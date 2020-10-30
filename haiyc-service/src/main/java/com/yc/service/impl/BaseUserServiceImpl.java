package com.yc.service.impl;

import com.yc.common.utils.result.ResultCodeEnum;
import com.yc.common.utils.validation.Assert;
import com.yc.common.utils.validation.SaveGroup;
import com.yc.common.utils.validation.ValidationUtils;
import com.yc.common.utils.validation.ViolationMessage;
import com.yc.dao.user.BaseUserDao;
import com.yc.dto.user.BaseUserDto;
import com.yc.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 用户信息serviceImpl
 * @Author 村子里最好的剑
 * @Date 2020-10-29 16:40
 */
@Service
public class BaseUserServiceImpl implements BaseUserService {

    @Autowired
    private BaseUserDao baseUserDao;

    /**
     * 查询用户列表
     * @param correctPage 起始页
     * @param correctSize 页大小
     * @param baseUserDto
     * @Date 2020-10-30 09:28
     * @return List<BaseUserDto>
     */
    @Override
    public List<BaseUserDto> listPageUsers(int correctPage, int correctSize, BaseUserDto baseUserDto) {
        // 1.校验字段
        ViolationMessage object = ValidationUtils.validate(baseUserDto, SaveGroup.class);
        Assert.isNull(object, ResultCodeEnum.FAIL.code());


        return null;
    }

    /**
     * 查询用户的总条数
     * @param baseUserDto
     * @Date 2020-10-30 09:29
     * @return int
     */
    @Override
    public int countUsers(BaseUserDto baseUserDto) {
        return 0;
    }
}

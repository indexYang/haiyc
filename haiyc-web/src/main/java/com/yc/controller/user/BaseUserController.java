package com.yc.controller.user;

import com.yc.common.utils.PagerWrapper;
import com.yc.common.utils.result.ResponseResult;
import com.yc.dto.user.BaseUserDto;
import com.yc.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description 用户信息控制器
 * @Author 村子里最好的剑
 * @Date 2020-10-29 16:59
 */

@RestController
@RequestMapping("/user")
public class BaseUserController {

    @Autowired
    private BaseUserService baseUserService;

    /**
     * 分页查询用户列表
     * @param pageParam
     * @param baseUserDto
     * @Author 村子里最好的剑
     * @Date 2020-10-29 17:01
     * @return PagerWrapper<BaseUserDto>
     */
    @RequestMapping("listPageUsers.htm")
    @ResponseResult
    public PagerWrapper<BaseUserDto> listPageUsers(PagerWrapper<BaseUserDto> pageParam, BaseUserDto baseUserDto){
        int correctPage = PagerWrapper.correctPage(pageParam.getPage());
        int correctSize = PagerWrapper.correctSize(pageParam.getSize());
        //查询用户信息的列表
        List<BaseUserDto> listPageUsers = this.baseUserService.listPageUsers(correctPage, correctSize, baseUserDto);
        //查询用户信息总条数
        int totalCnt = this.baseUserService.countUsers(baseUserDto);
        return PagerWrapper.create(listPageUsers, correctPage, correctSize).putTotalCnt(totalCnt);
    }

}

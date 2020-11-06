package com.yc.controller.user;

import com.yc.common.constant.Constant;
import com.yc.common.utils.PagerWrapper;
import com.yc.common.result.ResponseResult;
import com.yc.controller.BaseController;
import com.yc.dto.user.BaseUserDto;
import com.yc.dto.user.UserRolePermissionsDto;
import com.yc.entity.user.BaseUserEntity;
import com.yc.service.user.BaseUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description 用户信息控制器
 * @Author 村子里最好的剑
 * @Date 2020-10-29 16:59
 */

@RestController
@RequestMapping("/user")
public class BaseUserController extends BaseController {

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
    @RequestMapping("listUsers.htm")
    @ResponseResult
    public PagerWrapper<BaseUserDto> listUsers(PagerWrapper<BaseUserDto> pageParam, BaseUserDto baseUserDto){
        int correctPage = PagerWrapper.correctPage(pageParam.getPage());
        int correctSize = PagerWrapper.correctSize(pageParam.getSize());
        //查询用户信息的列表
        List<BaseUserDto> listPageUsers = this.baseUserService.listUsers(correctPage, correctSize, baseUserDto);
        //查询用户信息总条数
        int totalCnt = this.baseUserService.countUsers(baseUserDto);
        return PagerWrapper.create(listPageUsers, correctPage, correctSize).putTotalCnt(totalCnt);
    }

    /**
     * 新增修改用户信息
     * @Author 村子里最好的剑
     * @Date 2020-09-27 09:33
     * @return void
     */
    @PostMapping("addOrModifyUser.do")
    @ResponseResult
    public void addOrModifyUser(@RequestBody BaseUserDto baseUserDto){
        baseUserDto.setModifierId(getUserInfo().getUserNo());
        baseUserDto.setModifyDate(new Date());
        if(StringUtils.isEmpty(baseUserDto.getUserNo())){
            baseUserDto.setStatus(Constant.NUM_1);
            baseUserDto.setCreatorId(getUserInfo().getUserNo());
            baseUserDto.setCreateDate(new Date());
            this.baseUserService.addUser(baseUserDto);
        }else{
            this.baseUserService.modifyUser(baseUserDto);
        }
    }

    /**
     * 获取用户信息
     * @param userNo 用户编码
     * @Author 村子里最好的剑
     * @Date 2020-09-27 09:34
     * @return BaseUserDto
     */
    @GetMapping("getUser.htm")
    @ResponseResult
    public BaseUserDto getUser(String userNo){
        return baseUserService.getUser(userNo);
    }

    /**
     * 删除用户信息
     * @param userNo 用户编码
     * @Author 村子里最好的剑
     * @Date 2020-09-27 10:01
     * @return void
     */
    @PostMapping("delUser.do")
    @ResponseResult
    public void delUser(String userNo){
        if(StringUtils.isNotEmpty(userNo)){
            BaseUserEntity baseUserEntity = new BaseUserEntity();
            baseUserEntity.setUserNo(userNo);
            baseUserEntity.setModifierId(getUserInfo().getUserNo());
            baseUserEntity.setModifyDate(new Date());
            baseUserEntity.setStatus(Constant.NUM_0);
            baseUserService.delUser(baseUserEntity);
        }
    }

    /**
     * 修改密码
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @param confirmPwd 确认密码
     * @Author 村子里最好的剑
     * @Date 2020-10-10 13:28
     * @return void
     */
    @PostMapping("doUpdatePwd.do")
    @ResponseResult
    public void doUpdatePwd(String oldPwd, String newPwd, String confirmPwd){
        this.baseUserService.doUpdatePwd(oldPwd, newPwd, confirmPwd, getUserInfo().getUserNo());
    }

    /**
     * 重置密码
     * @param userNo 用户编码
     * @Author 村子里最好的剑
     * @Date 2020-10-10 13:45
     * @return void
     */
    @PostMapping("doResetPwd.do")
    @ResponseResult
    public void doResetPwd(String userNo){
        this.baseUserService.doResetPwd(userNo, getUserInfo().getUserNo());
    }

    /**
     * 查询用户的菜单权限与按钮权限
     * @Author 村子里最好的剑
     * @Date 2020-08-26 16:18
     * @return UserRolePermissionsDto
     */
    @GetMapping("userRolePermission.htm")
    @ResponseResult(name = "HAIYC-INTF-002")
//   @RequiresPermissions("sys:user:vies")
    public UserRolePermissionsDto userRolePermission(){
        //根据用户编号查询该用户的菜单权限以及按钮权限
        return this.baseUserService.userRolePermission(getUserInfo().getUserNo());
    }

}

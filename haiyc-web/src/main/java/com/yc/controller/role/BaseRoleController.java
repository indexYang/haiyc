package com.yc.controller.role;

import com.yc.common.result.ResponseResult;
import com.yc.controller.BaseController;
import com.yc.entity.role.BaseRoleEntity;
import com.yc.service.role.BaseRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description 角色控制器
 * @Author yangch
 * @Date 2020-07-28 03:00:00
 */
@RestController
@RequestMapping("/role")
public class BaseRoleController extends BaseController {

    @Autowired
    private BaseRoleService baseRoleService;;

    /**
     * 查询所有的角色列表
     * @param
     * @Author yangch
     * @Date 2020-09-27 13:49
     * @return void
     */
    @GetMapping("listAllRoles.htm")
    @ResponseResult
    public List<BaseRoleEntity> listAllRoles(){
        return baseRoleService.listAllRoles();
    }
}

package com.yc.dto.user;

import com.yc.dto.menu.UserMenuDto;
import com.yc.entity.menu.BaseMenuPermissionEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *@function 用户权限
 *@author 村子里最好的剑
 *@date 2020年08月26日 16:08
 */
@Getter
@Setter
public class UserRolePermissionsDto {

    //菜单权限集
    private List<UserMenuDto> listMenus;

    //按钮权限集
    private List<BaseMenuPermissionEntity> listPermissions;

}

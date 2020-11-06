package com.yc.dao.menu;

import com.yc.dto.menu.UserMenuDto;
import com.yc.entity.menu.BaseMenuPermissionEntity;

import java.util.List;

/**
 * @Description
 * @Author yangch
 * @Date 2020-07-28 02:14:42
 */
public interface BaseMenuDao {

    /**
     * 查询用户的菜单权限
     * @param userNo 用户编号
     * @Author haiyc
     * @Date 2020-08-26 16:30
     * @return
     */
    List<UserMenuDto> listUserMenu(String userNo);

    /**
     * 查询该用户的所有按钮权限
     * @param userNo 用户编号
     * @Author haiyc
     * @Date 2020-08-26 17:26
     * @return
     */
    List<BaseMenuPermissionEntity> listPermission(String userNo);
}

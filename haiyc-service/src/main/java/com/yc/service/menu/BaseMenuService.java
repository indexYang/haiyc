package com.yc.service.menu;

import com.yc.entity.menu.BaseMenuPermissionEntity;

import java.util.List;

/**
 * @Description
 * @Author yangch
 * @Date 2020-07-28 02:15:07
 */
public interface BaseMenuService {

    /**
     * 查询该用户的所有按钮权限
     * @param userNo 用户编号
     * @Author haiyc
     * @Date 2020-08-26 17:26
     * @return
     */
    List<BaseMenuPermissionEntity> listPermission(String userNo);
}

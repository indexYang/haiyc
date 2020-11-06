package com.yc.dto.menu;

import com.yc.entity.menu.BaseMenuEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *@function 用户菜单dto
 *@author 村子里最好的剑
 *@date 2020年08月26日 15:20
 */
@Setter
@Getter
public class UserMenuDto extends BaseMenuEntity {

    private List<UserMenuDto> child;
}

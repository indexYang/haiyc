package com.yc.entity.menu;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 菜单按钮权限基础表
 * @Author 村子里最好的剑
 * @Date 2020-11-03 11:30
 */
@Setter
@Getter
@ToString
@Table(name = "base_menu_permission")
public class BaseMenuPermissionEntity implements Serializable {

    private static final long serialVersionUID =  4118527403532287180L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键")
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "菜单id")
    @Column(name = "menuId")
    private Long menuId;

    @ApiModelProperty(value = "权限URL")
    @Column(name = "permissionUrl")
    private String permissionUrl;

    @ApiModelProperty(value = "权限名称")
    @Column(name = "permissionName")
    private String permissionName;

    @ApiModelProperty(value = "权限码:根据用户登录时判断页面的操作时否显示")
    @Column(name = "permissionCode")
    private String permissionCode;

    @ApiModelProperty(value = "状态 1:有效 2:无效")
    @Column(name = "status")
    private Integer status;

}
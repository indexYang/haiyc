package com.yc.entity.menu;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 基础菜单表
 * @Author 村子里最好的剑
 * @Date 2020-11-03 11:27
 */
@Setter
@Getter
@ToString
@Table(name = "base_menu")
public class BaseMenuEntity implements Serializable {

    private static final long serialVersionUID =  1868617572498309403L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键")
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "菜单名称")
    @Column(name = "menuName")
    private String menuName;

    @ApiModelProperty(value = "菜单url")
    @Column(name = "menuUrl")
    private String menuUrl;

    @ApiModelProperty(value = "父级菜单id")
    @Column(name = "parentMenuId")
    private Long parentMenuId;

    @ApiModelProperty(value = "菜单序号")
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(value = "菜单层级，1：一级，2：二级")
    @Column(name = "level")
    private Integer level;

    @ApiModelProperty(value = "菜单图片")
    @Column(name = "menuImage")
    private String menuImage;

    @ApiModelProperty(value = "状态，1：启用，0：禁用")
    @Column(name = "status")
    private Integer status;


}

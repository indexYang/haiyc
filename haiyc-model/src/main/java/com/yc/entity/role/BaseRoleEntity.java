package com.yc.entity.role;

import com.yc.entity.CommonEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 角色信息表
 * @Author 村子里最好的剑
 * @Date 2020-10-29 16:50
 */
@Setter
@Getter
@ToString
@ApiModel(description = "角色信息")
@Table(name = "base_role")
public class BaseRoleEntity extends CommonEntity implements Serializable {

    @Id
    @ApiModelProperty(value = "主键")
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "角色名称")
    @Column(name = "roleName")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    @Column(name = "roleDescribe")
    private String roleDescribe;

    @ApiModelProperty(value = "状态 0-删除 1-未删除")
    @Column(name = "status")
    private Integer status;

}

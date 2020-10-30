package com.yc.entity.user;

import com.yc.common.utils.validation.SaveGroup;
import com.yc.entity.CommonEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description 用户信息表
 * @Author 村子里最好的剑
 * @Date 2020-10-28 15:23
 */
@Getter
@Setter
@ToString
@ApiModel(description = "用户信息")
@Table(name = "base_user")
public class BaseUserEntity extends CommonEntity implements Serializable {

    @Id
    @ApiModelProperty(value = "用户编码")
    @Column(name = "userNo")
    private String userNo;

    @ApiModelProperty(value = "用户名")
    @Column(name = "userName")
    @NotNull(message = "用户名不能为空", groups={SaveGroup.class})
    private String userName;

    @ApiModelProperty(value = "密码")
    @Column(name = "password")
    private String password;

    @ApiModelProperty(value = "加密盐")
    @Column(name = "salt")
    private String salt;

    @ApiModelProperty(value = "手机号码")
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(value = "性别 0-女孩 1-男孩 2-变态 3-人妖")
    @Column(name = "age")
    private Integer age;

    @ApiModelProperty(value = "出生日期")
    @Column(name = "birthDate")
    private Date birthDate;

    @ApiModelProperty(value = "头像")
    @Column(name = "imgHead")
    private String imgHead;

    @ApiModelProperty(value = "状态 0-删除 1-未删除 2-锁定")
    @Column(name = "status")
    private Integer status;
}
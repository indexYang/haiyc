package com.yc.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
/**
 * @Description 用户实体
 * @Author 村子里最好的剑
 * @Date 2020-09-03 03:23:52
 */

@Getter
@Setter
@Entity(name = "base_user")
@org.hibernate.annotations.Table(appliesTo = "base_user", comment = "用户信息表")
public class BaseUserEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "userNo", columnDefinition = "VARCHAR(20) NOT NULL COMMENT '用户编码'")
    private String userNo;

    @Column(name = "userName", columnDefinition = "VARCHAR(50) DEFAULT NULL COMMENT '用户名'")
    private String userName;

    @Column(name = "password", columnDefinition = "VARCHAR(50) DEFAULT NULL COMMENT '密码'")
    private String password;

    @Column(name = "status", columnDefinition = "TINYINT(1) DEFAULT NULL COMMENT '状态 0-删除 1-未删除 2-锁定'")
    private Integer status;

    @Column(name = "createDate", columnDefinition = "DATETIME DEFAULT NULL COMMENT '创建时间'")
    private Date createDate;

    @Column(name = "modifyDate", columnDefinition = "DATETIME DEFAULT NULL COMMENT '修改时间'")
    private Date modifyDate;

    @Column(name = "creatorId", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '创建人ID'")
    private String creatorId;

    @Column(name = "modifierId", columnDefinition = "VARCHAR(20) DEFAULT NULL COMMENT '修改人ID'")
    private String modifierId;
}

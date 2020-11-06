package com.yc.entity.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 用户角色中间表
 * @Author 村子里最好的剑
 * @Date 2020-11-03 13:25:00
 */
@Setter
@Getter
@ToString
@Table(name = "base_user_role")
public class BaseUserRoleEntity implements Serializable {

	private static final long serialVersionUID =  3673371683844300534L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键")
	@Column(name = "id")
	private Long id;

	@ApiModelProperty(value = "用户编码")
	@Column(name = "userNo")
	private String userNo;

	@ApiModelProperty(value = "角色id")
	@Column(name = "roleId")
	private Long roleId;

	public BaseUserRoleEntity(){

	}

	public BaseUserRoleEntity(String userNo){
		this.userNo = userNo;
	}
}

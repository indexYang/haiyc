package com.yc.entity.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 角色菜单中间表
 * @Author 村子里最好的剑
 * @Date 2020-09-03 09:56:00
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "base_role_menu")
public class BaseRoleMenuEntity implements Serializable {

	private static final long serialVersionUID =  8379595141354787220L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键")
	@Column(name = "id")
	private Long id;

	@ApiModelProperty(value = "角色id")
	@Column(name = "roleId")
	private Long roleId;

	@ApiModelProperty(value = "菜单id")
	@Column(name = "menuId")
	private Long menuId;


}

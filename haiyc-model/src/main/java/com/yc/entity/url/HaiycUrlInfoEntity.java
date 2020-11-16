package com.yc.entity.url;

import com.yc.entity.CommonEntity;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 网址信息表
 * @Author 村子里最好的剑
 * @Date 2020-11-16 15:10
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "haiyc_url_info")
public class HaiycUrlInfoEntity extends CommonEntity implements Serializable {

	private static final long serialVersionUID =  2604471208346059978L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value = "编号")
	@Column(name = "id")
	private Long id;

	@ApiModelProperty(value = "名称")
	@Column(name = "name")
	private String name;

	@ApiModelProperty(value = "账号")
	@Column(name = "account")
	private String account;

	@ApiModelProperty(value = "密码")
	@Column(name = "password")
	private String password;

	@ApiModelProperty(value = "url地址")
	@Column(name = "url")
	private String url;

	@ApiModelProperty(value = "备注")
	@Column(name = "remark")
	private String remark;

	@ApiModelProperty(value = "状态 0-删除 1-未删除 ")
	@Column(name = "status")
	private Integer status;
}

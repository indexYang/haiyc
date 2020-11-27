package com.yc.entity.car.card;

import com.yc.entity.CommonEntity;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 汽修-项目信息
 * @Author 村子里最好的剑
 * @Date 2020-11-18 13:33
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "car_project_info")
public class CarProjectInfoEntity extends CommonEntity implements Serializable {

	private static final long serialVersionUID =  8743281022486351251L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键")
	@Column(name = "id")
	private Long id;

	@ApiModelProperty(value = "项目名称")
	@Column(name = "projectName")
	private String projectName;

	@ApiModelProperty(value = "项目内容")
	@Column(name = "projectContent")
	private String projectContent;

	@ApiModelProperty(value = "备注")
	@Column(name = "remark")
	private String remark;

	@ApiModelProperty(value = "状态 0-删除 1-有效 2-失效")
	@Column(name = "status")
	private Integer status;
}

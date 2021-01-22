package com.yc.entity.car.card;

import lombok.*;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description car_level_project
 * @Author HaiYc
 * @Date 2021-01-22 01:32:25
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "car_level_project")
public class CarLevelProjectEntity implements Serializable {

	private static final long serialVersionUID =  4332822225696943858L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键")
	@Column(name = "id")
	private Long id;

	@ApiModelProperty(value = "会员卡等级id")
	@Column(name = "levelId")
	private Long levelId;

	@ApiModelProperty(value = "项目id")
	@Column(name = "projectId")
	private Long projectId;

	@ApiModelProperty(value = "次数")
	@Column(name = "nums")
	private Integer nums;

}

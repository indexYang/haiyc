package com.yc.entity.car.card;

import com.yc.entity.CommonEntity;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 汽修-会员卡等级实体
 * @Author HaiYc
 * @Date 2021-01-07 04:33:34
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "car_card_level")
public class CarCardLevelEntity extends CommonEntity implements Serializable {

	private static final long serialVersionUID =  1940394619765591289L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键")
	@Column(name = "id")
	private Long id;

	@ApiModelProperty(value = "等级名称")
	@Column(name = "levelName")
	private String levelName;

	@ApiModelProperty(value = " 备注")
	@Column(name = "remark")
	private String remark;

	@ApiModelProperty(value = "状态 0-删除 1-有效 2-失效")
	@Column(name = "status")
	private Integer status;
}

package com.yc.entity.car.card;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yc.entity.CommonEntity;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 汽修-卡号_项目绑定
 * @Author 村子里最好的剑
 * @Date 2020-11-18 13:34
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "car_card_project")
public class CarCardProjectEntity extends CommonEntity implements Serializable {

	private static final long serialVersionUID =  3199735501177332205L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value = "项目名称")
	@Column(name = "id")
	private Long id;

	@ApiModelProperty(value = "会员卡id")
	@Column(name = "cardId")
	private Long cardId;

	@ApiModelProperty(value = "项目id")
	@Column(name = "projectId")
	private Long projectId;

	@ApiModelProperty(value = "次数")
	@Column(name = "nums")
	private Integer nums;

	@ApiModelProperty(value = "有效时间")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "limiteDate")
	private Date limiteDate;

	@ApiModelProperty(value = "状态 0-删除 1-有效 2-失效")
	@Column(name = "status")
	private Integer status;
}

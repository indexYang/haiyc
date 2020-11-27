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
 * @Description 车修-卡会员信息
 * @Author 村子里最好的剑
 * @Date 2020-11-18 13:31
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "car_card_info")
public class CarCardInfoEntity extends CommonEntity implements Serializable {

	private static final long serialVersionUID =  8030638950022145097L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键")
	@Column(name = "id")
	private Long id;

	@ApiModelProperty(value = "会员卡号")
	@Column(name = "cardNo")
	private String cardNo;

	@ApiModelProperty(value = "会员姓名")
	@Column(name = "userName")
	private String userName;

	@ApiModelProperty(value = "手机号码")
	@Column(name = "phone")
	private String phone;

	@ApiModelProperty(value = "车牌号")
	@Column(name = "carNum")
	private String carNum;

	@ApiModelProperty(value = "级别 1-洗车卡")
	@Column(name = "level")
	private Integer level;

	@ApiModelProperty(value = "折扣")
	@Column(name = "discount")
	private Double discount;

	@ApiModelProperty(value = "可用储值")
	@Column(name = "money")
	private Double money;

	@ApiModelProperty(value = "有效时间")
	@Column(name = "limiteDate")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date limiteDate;

	@ApiModelProperty(value = "备注")
	@Column(name = "remark")
	private String remark;

	@ApiModelProperty(value = "状态 0-删除 1-有效 2-失效")
	@Column(name = "status")
	private Integer status;
}

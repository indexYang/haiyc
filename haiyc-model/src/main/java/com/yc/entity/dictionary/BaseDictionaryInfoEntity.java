package com.yc.entity.dictionary;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 字典
 * @Author 村子里最好的剑
 * @Date 2020-11-12 15:55
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "base_dictionary_info")
public class BaseDictionaryInfoEntity implements Serializable {

	private static final long serialVersionUID =  8568121232585606952L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键")
	@Column(name = "id")
	private Long id;

	@ApiModelProperty(value = "类型代码")
	@Column(name = "typeCode")
	private String typeCode;

	@ApiModelProperty(value = "类型名称")
	@Column(name = "typeName")
	private String typeName;

	@ApiModelProperty(value = "数据数值")
	@Column(name = "valueId")
	private Integer valueId;

	@ApiModelProperty(value = "数值名称")
	@Column(name = "valueName")
	private String valueName;

	@ApiModelProperty(value = "状态 0-暂用 1-使用")
	@Column(name = "status")
	private Integer status;


}

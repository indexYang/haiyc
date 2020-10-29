package com.yc.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

/**
 * @Description 共有的实体字段
 * @Author 村子里最好的剑
 * @Date 2020-10-29 09:29
 */
@Getter
@Setter
public class CommonEntity {

    @ApiModelProperty(value = "创建时间", name = "createDate")
    @Column(name = "createDate")
    private Date createDate;

    @ApiModelProperty(value = "修改时间", name = "modifyDate")
    @Column(name = "modifyDate")
    private Date modifyDate;

    @ApiModelProperty(value = "创建人ID", name = "creatorId")
    @Column(name = "creatorId")
    private String creatorId;

    @ApiModelProperty(value = "修改人ID", name = "modifierId")
    @Column(name = "modifierId")
    private String modifierId;
}

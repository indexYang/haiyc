package com.yc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @ApiModelProperty(value = "创建时间")
    @Column(name = "createDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createDate;

    @ApiModelProperty(value = "修改时间")
    @Column(name = "modifyDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date modifyDate;

    @ApiModelProperty(value = "创建人ID")
    @Column(name = "creatorId")
    private String creatorId;

    @ApiModelProperty(value = "修改人ID")
    @Column(name = "modifierId")
    private String modifierId;
}

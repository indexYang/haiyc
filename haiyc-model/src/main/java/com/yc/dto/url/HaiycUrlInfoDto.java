package com.yc.dto.url;

import com.yc.entity.url.HaiycUrlInfoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description 网址信息表
 * @Author 村子里最好的剑
 * @Date 2020-11-16 15:13
 */
@Getter
@Setter
public class HaiycUrlInfoDto extends HaiycUrlInfoEntity {

    //创建人
    private String creatorName;

    //修改人
    private String modifierName;

}

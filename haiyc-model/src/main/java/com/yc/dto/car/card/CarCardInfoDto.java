package com.yc.dto.car.card;

import com.yc.common.constant.Constant;
import com.yc.entity.car.card.CarCardInfoEntity;
import lombok.*;

/**
 * @Description 车修-卡会员dto
 * @Author 村子里最好的剑
 * @Date 2020-11-18 13:31
 */
public class CarCardInfoDto extends CarCardInfoEntity {

    //级别名称
    private String valueName;

    private String statusView;

    //创建人
    private String creatorName;

    //修改人
    private String modifierName;

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getStatusView() {
        if(null != getStatus()){
            switch(getStatus()){
                case Constant.NUM_0:
                    statusView = "删除";
                    break;
                case Constant.NUM_1:
                    statusView = "有效";
                    break;
                case Constant.NUM_2:
                    statusView = "失效";
                    break;
            }
        }
        return statusView;
    }

    public void setStatusView(String statusView) {
        this.statusView = statusView;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }
}

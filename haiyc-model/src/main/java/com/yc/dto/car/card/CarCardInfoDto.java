package com.yc.dto.car.card;

import com.yc.common.constant.Constant;
import com.yc.entity.car.card.CarCardInfoEntity;

/**
 * @Description 车修-卡会员dto
 * @Author 村子里最好的剑
 * @Date 2020-11-18 13:31
 */
public class CarCardInfoDto extends CarCardInfoEntity {

    //级别名称
    private String valueName;

    //状态展示 0-删除 1-有效 2-失效
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
                case Constant.STATUS_ZERO:
                    statusView = Constant.STATUS_ZERO_VIEW;
                    break;
                case Constant.STATUS_ONE:
                    statusView = Constant.STATUS_ONE_VIEW;
                    break;
                case Constant.STATUS_TWO:
                    statusView = Constant.STATUS_TWO_VIEW;
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

package com.yc.dto.car.card;

import com.yc.common.constant.Constant;
import com.yc.entity.car.card.CarProjectInfoEntity;

/**
 * @Description 汽修-项目信息
 * @Author 村子里最好的剑
 * @Date 2020-11-18 13:33
 */
public class CarProjectInfoDto extends CarProjectInfoEntity {

    //状态展示 0-删除 1-有效 2-失效
    private String statusView;

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
}

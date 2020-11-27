package com.yc.dto.car.card;

import com.yc.common.constant.Constant;
import com.yc.entity.car.card.CarProjectInfoEntity;

/**
 * @Description 汽修-项目信息
 * @Author 村子里最好的剑
 * @Date 2020-11-18 13:33
 */
public class CarProjectInfoDto extends CarProjectInfoEntity {

    private String statusView;

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
}

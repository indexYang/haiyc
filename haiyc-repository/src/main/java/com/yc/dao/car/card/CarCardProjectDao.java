package com.yc.dao.car.card;

import com.yc.entity.car.card.CarCardProjectEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description 汽修-卡号_项目绑定dao
 * @Author 村子里最好的剑
 * @Date 2020-11-18 11:40:39
 */
public interface CarCardProjectDao extends Mapper<CarCardProjectEntity>, MySqlMapper<CarCardProjectEntity> {

}

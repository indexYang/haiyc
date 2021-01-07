package com.yc.dao.car.card;

import com.yc.entity.car.card.CarCardLevelEntity;
import com.yc.dto.car.card.CarCardLevelDto;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author HaiYc
 * @Date 2021-01-06 05:13:35
 */
public interface CarCardLevelDao extends Mapper<CarCardLevelEntity>, MySqlMapper<CarCardLevelEntity> {

   /**
    * 查询***列表
    * @param params
    * @Date 2021-01-06 05:13:35
    * @return List<CarCardLevelDto>
    */
   List<CarCardLevelDto> listCarCardLevel(Map params);

   /**
    * 查询***总数
    * @param params
    * @Date 2021-01-06 05:13:35
    * @return int
    */
   int countCarCardLevel(Map params);

   /**
    * 查询***详情
    * @param id 主键
    * @Date 2021-01-06 05:13:35
    * @return int
    */
   CarCardLevelDto getCarCardLevel(Long id);
}

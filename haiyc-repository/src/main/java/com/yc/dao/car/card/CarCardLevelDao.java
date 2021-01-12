package com.yc.dao.car.card;

import com.yc.entity.car.card.CarCardLevelEntity;
import com.yc.dto.car.card.CarCardLevelDto;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

/**
 * @Description CarCardLevel
 * @Author HaiYc
 * @Date 2021-01-12 04:44:15
 */
public interface CarCardLevelDao extends Mapper<CarCardLevelEntity>, MySqlMapper<CarCardLevelEntity> {

   /**
    * SELECT CarCardLevel PAGE
    * @param params
    * @Date 2021-01-12 04:44:15
    * @return List<CarCardLevelDto>
    */
   List<CarCardLevelDto> listCarCardLevel(Map params);

   /**
    * SELECT CarCardLevel COUNT
    * @param params
    * @Date 2021-01-12 04:44:15
    * @return int
    */
   int countCarCardLevel(Map params);

   /**
    * INFO CarCardLevel
    * @param id 主键
    * @Date 2021-01-12 04:44:15
    * @return int
    */
   CarCardLevelDto getCarCardLevel(Long id);
}

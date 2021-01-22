package com.yc.dao.car.card;

import com.yc.entity.car.card.CarLevelProjectEntity;
import com.yc.dto.car.card.CarLevelProjectDto;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

/**
 * @Description CarLevelProject
 * @Author HaiYc
 * @Date 2021-01-22 01:32:59
 */
public interface CarLevelProjectDao extends Mapper<CarLevelProjectEntity>, MySqlMapper<CarLevelProjectEntity> {

   /**
    * SELECT CarLevelProject PAGE
    * @param params
    * @Date 2021-01-22 01:32:59
    * @return List<CarLevelProjectDto>
    */
   List<CarLevelProjectDto> listCarLevelProject(Map params);

   /**
    * SELECT CarLevelProject COUNT
    * @param params
    * @Date 2021-01-22 01:32:59
    * @return int
    */
   int countCarLevelProject(Map params);

   /**
    * INFO CarLevelProject
    * @param id 主键
    * @Date 2021-01-22 01:32:59
    * @return int
    */
   CarLevelProjectDto getCarLevelProject(Long id);
}

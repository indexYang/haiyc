package com.yc.service.car.card;

import com.yc.entity.car.card.CarCardLevelEntity;
import com.yc.dto.car.card.CarCardLevelDto;

import java.util.List;

/**
 * @Description CarCardLevel
 * @Author HaiYc
 * @Date 2021-01-12 04:44:31
 */
public interface CarCardLevelService {

   /**
    * SELECT CarCardLevel PAGE
    * @param correctPage
    * @param correctSize
    * @param carCardLevel
    * @Date 2021-01-12 04:44:31
    * @return List<CarCardLevelDto>
    */
   List<CarCardLevelDto> listCarCardLevel(int correctPage, int correctSize, CarCardLevelDto carCardLevel);

   /**
    * SELECT CarCardLevel COUNT
    * @param carCardLevel
    * @Date 2021-01-12 04:44:31
    * @return int
    */
   int countCarCardLevel(CarCardLevelDto carCardLevel);

   /**
    * INFO CarCardLevel
    * @param id 主键
    * @Date 2021-01-12 04:44:31
    * @return CarCardLevelDto
    */
   CarCardLevelDto getCarCardLevel(Long id);

   /**
    * ADD CarCardLevel
    * @param carCardLevel
    * @Date 2021-01-12 04:44:31
    * @return void
    */
   void addCarCardLevel(CarCardLevelDto carCardLevel);

   /**
    * UPDATE CarCardLevel
    * @param carCardLevel
    * @Date 2021-01-12 04:44:31
    * @return void
    */
   void modifyCarCardLevel(CarCardLevelDto carCardLevel);

   /**
    * DEL CarCardLevel
    * @param carCardLevel
    * @Date 2021-01-12 04:44:31
    * @return void
    */
   void delCarCardLevel(CarCardLevelEntity carCardLevel);
}

package com.yc.service.car.card;

import com.yc.entity.car.card.CarCardLevelEntity;
import com.yc.dto.car.card.CarCardLevelDto;

import java.util.List;

/**
 * @Description
 * @Author HaiYc
 * @Date 2021-01-07 03:49:20
 */
public interface CarCardLevelService {

   /**
    * 查询***列表
    * @param correctPage 起始�?
    * @param correctSize 页大�?
    * @param carCardLevel
    * @Date 2021-01-07 03:49:20
    * @return List<CarCardLevelDto>
    */
   List<CarCardLevelDto> listCarCardLevel(int correctPage, int correctSize, CarCardLevelDto carCardLevel);

   /**
    * 查询***总数
    * @param carCardLevel
    * @Date 2021-01-07 03:49:20
    * @return int
    */
   int countCarCardLevel(CarCardLevelDto carCardLevel);

   /**
    * 查询***详情
    * @param id 主键
    * @Date 2021-01-07 03:49:20
    * @return CarCardLevelDto
    */
   CarCardLevelDto getCarCardLevel(Long id);

   /**
    * 新增***
    * @param carCardLevel
    * @Date 2021-01-07 03:49:20
    * @return void
    */
   void addCarCardLevel(CarCardLevelDto carCardLevel);

   /**
    * 修改***
    * @param carCardLevel
    * @Date 2021-01-07 03:49:20
    * @return void
    */
   void modifyCarCardLevel(CarCardLevelDto carCardLevel);

   /**
    * 删除***
    * @param carCardLevel
    * @Date 2021-01-07 03:49:20
    * @return void
    */
   void delCarCardLevel(CarCardLevelEntity carCardLevel);
}

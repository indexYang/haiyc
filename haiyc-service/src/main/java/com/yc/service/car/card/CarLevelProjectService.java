package com.yc.service.car.card;

import com.yc.entity.car.card.CarLevelProjectEntity;
import com.yc.dto.car.card.CarLevelProjectDto;

import java.util.List;

/**
 * @Description CarLevelProject
 * @Author HaiYc
 * @Date 2021-01-22 01:33:17
 */
public interface CarLevelProjectService {

   /**
    * SELECT CarLevelProject PAGE
    * @param correctPage
    * @param correctSize
    * @param carLevelProject
    * @Date 2021-01-22 01:33:17
    * @return List<CarLevelProjectDto>
    */
   List<CarLevelProjectDto> listCarLevelProject(int correctPage, int correctSize, CarLevelProjectDto carLevelProject);

   /**
    * SELECT CarLevelProject COUNT
    * @param carLevelProject
    * @Date 2021-01-22 01:33:17
    * @return int
    */
   int countCarLevelProject(CarLevelProjectDto carLevelProject);

   /**
    * INFO CarLevelProject
    * @param id 主键
    * @Date 2021-01-22 01:33:17
    * @return CarLevelProjectDto
    */
   CarLevelProjectDto getCarLevelProject(Long id);

   /**
    * ADD CarLevelProject
    * @param carLevelProject
    * @Date 2021-01-22 01:33:17
    * @return void
    */
   void addCarLevelProject(CarLevelProjectDto carLevelProject);

   /**
    * UPDATE CarLevelProject
    * @param carLevelProject
    * @Date 2021-01-22 01:33:17
    * @return void
    */
   void modifyCarLevelProject(CarLevelProjectDto carLevelProject);

   /**
    * DEL CarLevelProject
    * @param carLevelProject
    * @Date 2021-01-22 01:33:17
    * @return void
    */
   void delCarLevelProject(CarLevelProjectEntity carLevelProject);
}

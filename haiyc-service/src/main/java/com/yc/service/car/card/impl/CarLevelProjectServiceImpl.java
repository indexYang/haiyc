package com.yc.service.car.card.impl;

import com.yc.dao.car.card.CarLevelProjectDao;
import com.yc.service.car.card.CarLevelProjectService;
import com.yc.dto.car.card.CarLevelProjectDto;
import com.yc.entity.car.card.CarLevelProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yc.common.utils.CommonUtils;
import com.yc.common.utils.PagerWrapper;
import com.yc.common.constant.Constant;
import com.yc.common.exception.BaseException;
import com.yc.common.result.ResultCodeEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description CarLevelProject
 * @Author HaiYc
 * @Date 2021-01-22 01:33:32
 */
@Service
public class CarLevelProjectServiceImpl implements CarLevelProjectService {

   @Autowired
   private CarLevelProjectDao carLevelProjectDao;

   /**
    * SELECT CarLevelProject PAGE
    * @param correctPage
    * @param correctSize
    * @param carLevelProject
    * @Date 2021-01-22 01:33:32
    * @return List<CarLevelProjectDto>
    */
   @Override
   public List<CarLevelProjectDto> listCarLevelProject(int correctPage, int correctSize, CarLevelProjectDto carLevelProject){
       Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_2));
       params.put("correctStart", PagerWrapper.correctStart(correctPage, correctSize));
       params.put("correctSize", correctSize);
       return carLevelProjectDao.listCarLevelProject(params);
   }

   /**
    * SELECT CarLevelProject COUNT
    * @param carLevelProject
    * @Date 2021-01-22 01:33:32
    * @return int
    */
   @Override
   public int countCarLevelProject(CarLevelProjectDto carLevelProject){
       Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_1));
       return carLevelProjectDao.countCarLevelProject(params);
   }

   /**
    * INFO CarLevelProject
    * @param id 主键
    * @Date 2021-01-22 01:33:32
    * @return CarLevelProjectDto
    */
   @Override
   public CarLevelProjectDto getCarLevelProject(Long id){
       return carLevelProjectDao.getCarLevelProject(id);
   }

   /**
    * ADD CarLevelProject
    * @param carLevelProject
    * @Date 2021-01-22 01:33:32
    * @return void
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void addCarLevelProject(CarLevelProjectDto carLevelProject){
       //参数校验

       CarLevelProjectEntity carLevelProjectEntity = CommonUtils.transform(carLevelProject, CarLevelProjectEntity.class);
       carLevelProjectDao.insertSelective(carLevelProjectEntity);
   }

   /**
    * UPDATE CarLevelProject
    * @param carLevelProject
    * @Date 2021-01-22 01:33:32
    * @return void
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void modifyCarLevelProject(CarLevelProjectDto carLevelProject){
       //参数校验

       CarLevelProjectEntity carLevelProjectEntity = carLevelProjectDao.selectByPrimaryKey(carLevelProject.getId());
       if(null == carLevelProjectEntity){
           throw new BaseException(ResultCodeEnum.FAIL.code(), "", "该信息不存在，请核实");
       }
       //参数SET

      carLevelProjectDao.updateByPrimaryKey(carLevelProjectEntity);
   }

   /**
    * DEL CarLevelProject
    * @param carLevelProject
    * @Date 2021-01-22 01:33:32
    * @return void
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void delCarLevelProject(CarLevelProjectEntity carLevelProject){
      carLevelProjectDao.updateByPrimaryKeySelective(carLevelProject);
   }
}

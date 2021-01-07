package com.yc.service.car.card.impl;

import com.yc.dao.car.card.CarCardLevelDao;
import com.yc.service.car.card.CarCardLevelService;
import com.yc.dto.car.card.CarCardLevelDto;
import com.yc.entity.car.card.CarCardLevelEntity;
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
 * @Description
 * @Author HaiYc
 * @Date 2021-01-07 03:49:11
 */
@Service
public class CarCardLevelServiceImpl implements CarCardLevelService {

   @Autowired
   private CarCardLevelDao carCardLevelDao;

   /**
    * 查询***列表
    * @param correctPage 起始�?
    * @param correctSize 页大�?
    * @param carCardLevel
    * @Date 2021-01-07 03:49:11
    * @return List<CarCardLevelDto>
    */
   @Override
   public List<CarCardLevelDto> listCarCardLevel(int correctPage, int correctSize, CarCardLevelDto carCardLevel){
       Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_2));
       params.put("correctStart", PagerWrapper.correctStart(correctPage, correctSize));
       params.put("correctSize", correctSize);
       return carCardLevelDao.listCarCardLevel(params);
   }

   /**
    * 查询***总数
    * @param carCardLevel
    * @Date 2021-01-07 03:49:11
    * @return int
    */
   @Override
   public int countCarCardLevel(CarCardLevelDto carCardLevel){
       Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_1));
       return carCardLevelDao.countCarCardLevel(params);
   }

   /**
    * 查询***详情
    * @param id 主键
    * @Date 2021-01-07 03:49:11
    * @return CarCardLevelDto
    */
   @Override
   public CarCardLevelDto getCarCardLevel(Long id){
       return carCardLevelDao.getCarCardLevel(id);
   }

   /**
    * 新增***
    * @param carCardLevel
    * @Date 2021-01-07 03:49:11
    * @return void
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void addCarCardLevel(CarCardLevelDto carCardLevel){
       //参数校验

       CarCardLevelEntity carCardLevelEntity = CommonUtils.transform(carCardLevel, CarCardLevelEntity.class);
       carCardLevelDao.insertSelective(carCardLevelEntity);
   }

   /**
    * 修改***
    * @param carCardLevel
    * @Date 2021-01-07 03:49:11
    * @return void
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void modifyCarCardLevel(CarCardLevelDto carCardLevel){
       //参数校验

       CarCardLevelEntity carCardLevelEntity = carCardLevelDao.selectByPrimaryKey(carCardLevel.getId());
       if(null == carCardLevelEntity){
           throw new BaseException(ResultCodeEnum.FAIL.code(), "", "该信息不存在，请核实");
       }
       //参数赋�??

       //根据主键更新实体全部字段，null值会被更�?
      carCardLevelDao.updateByPrimaryKey(carCardLevelEntity);
   }

   /**
    * 删除***
    * @param carCardLevel
    * @Date 2021-01-07 03:49:11
    * @return void
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void delCarCardLevel(CarCardLevelEntity carCardLevel){
       //根据主键更新属�?�不为null的�??/
      carCardLevelDao.updateByPrimaryKeySelective(carCardLevel);
   }
}

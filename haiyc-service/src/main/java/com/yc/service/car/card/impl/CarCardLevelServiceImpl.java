package com.yc.service.car.card.impl;

import com.yc.dao.car.card.CarCardLevelDao;
import com.yc.service.car.card.CarCardLevelService;
import com.yc.dto.car.card.CarCardLevelDto;
import com.yc.entity.car.card.CarCardLevelEntity;
import org.apache.commons.lang3.StringUtils;
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
 * @Description CarCardLevel
 * @Author HaiYc
 * @Date 2021-01-12 04:44:38
 */
@Service
public class CarCardLevelServiceImpl implements CarCardLevelService {

   @Autowired
   private CarCardLevelDao carCardLevelDao;

   /**
    * SELECT CarCardLevel PAGE
    * @param correctPage
    * @param correctSize
    * @param carCardLevel
    * @Date 2021-01-12 04:44:38
    * @return List<CarCardLevelDto>
    */
   @Override
   public List<CarCardLevelDto> listCarCardLevel(int correctPage, int correctSize, CarCardLevelDto carCardLevel){
       Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_4));
       params.put("correctStart", PagerWrapper.correctStart(correctPage, correctSize));
       params.put("correctSize", correctSize);
       if(StringUtils.isNotEmpty(carCardLevel.getLevelName())){
           params.put("levelName", carCardLevel.getLevelName());
       }
       if(null != carCardLevel.getStatus()){
           params.put("status", carCardLevel.getStatus());
       }
       return carCardLevelDao.listCarCardLevel(params);
   }

   /**
    * SELECT CarCardLevel COUNT
    * @param carCardLevel
    * @Date 2021-01-12 04:44:38
    * @return int
    */
   @Override
   public int countCarCardLevel(CarCardLevelDto carCardLevel){
       Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_2));
       if(StringUtils.isNotEmpty(carCardLevel.getLevelName())){
           params.put("levelName", carCardLevel.getLevelName());
       }
       if(null != carCardLevel.getStatus()){
           params.put("status", carCardLevel.getStatus());
       }
       return carCardLevelDao.countCarCardLevel(params);
   }

   /**
    * INFO CarCardLevel
    * @param id 主键
    * @Date 2021-01-12 04:44:38
    * @return CarCardLevelDto
    */
   @Override
   public CarCardLevelDto getCarCardLevel(Long id){
       CarCardLevelEntity carCardLevelEntity = carCardLevelDao.selectByPrimaryKey(id);
       return CommonUtils.transform(carCardLevelEntity, CarCardLevelDto.class);
   }

   /**
    * ADD CarCardLevel
    * @param carCardLevel
    * @Date 2021-01-12 04:44:38
    * @return void
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void addCarCardLevel(CarCardLevelDto carCardLevel){
       //参数校验
       checkParamsCarCardLevel(carCardLevel);
       CarCardLevelEntity carCardLevelEntity = CommonUtils.transform(carCardLevel, CarCardLevelEntity.class);
       carCardLevelDao.insertSelective(carCardLevelEntity);
   }

    /**
     * 校验参数
     * @param carCardLevel
     */
    private void checkParamsCarCardLevel(CarCardLevelDto carCardLevel) {
        if(StringUtils.isEmpty(carCardLevel.getLevelName())){
            throw new BaseException(ResultCodeEnum.FAIL.code(), "", "等级名称必填");
        }else{
            //校验等级名称是否存在
            CarCardLevelEntity carCardLevelEntity = carCardLevelDao.findLevelName(carCardLevel.getId(), carCardLevel.getLevelName());
            if(null != carCardLevelEntity){
                throw new BaseException(ResultCodeEnum.FAIL.code(), "", "等级名称不能重复，亲");
            }
        }

        if(null == carCardLevel.getStatus()){
            throw new BaseException(ResultCodeEnum.FAIL.code(), "", "是否有限类型必填");
        }
    }

   /**
    * UPDATE CarCardLevel
    * @param carCardLevel
    * @Date 2021-01-12 04:44:38
    * @return void
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void modifyCarCardLevel(CarCardLevelDto carCardLevel){
       //参数校验
       checkParamsCarCardLevel(carCardLevel);
       CarCardLevelEntity carCardLevelEntity = carCardLevelDao.selectByPrimaryKey(carCardLevel.getId());
       if(null == carCardLevelEntity){
           throw new BaseException(ResultCodeEnum.FAIL.code(), "", "该信息不存在，请核实");
       }
       //参数
       carCardLevelEntity.setLevelName(carCardLevel.getLevelName());
       carCardLevelEntity.setRemark(carCardLevel.getRemark());
       carCardLevelEntity.setStatus(carCardLevel.getStatus());
       carCardLevelEntity.setModifierId(carCardLevel.getModifierId());
       carCardLevelEntity.setModifyDate(carCardLevel.getModifyDate());
       carCardLevelDao.updateByPrimaryKey(carCardLevelEntity);
   }

    /**
    * DEL CarCardLevel
    * @param carCardLevel
    * @Date 2021-01-12 04:44:38
    * @return void
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void delCarCardLevel(CarCardLevelEntity carCardLevel){
      carCardLevelDao.updateByPrimaryKeySelective(carCardLevel);
   }
}

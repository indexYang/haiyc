package com.yc.service.car.card.impl;

import com.yc.common.constant.Constant;
import com.yc.common.exception.BaseException;
import com.yc.common.result.ResultCodeEnum;
import com.yc.common.utils.CommonUtils;
import com.yc.common.utils.PagerWrapper;
import com.yc.dao.car.card.CarProjectInfoDao;
import com.yc.dto.car.card.CarProjectInfoDto;
import com.yc.entity.car.card.CarProjectInfoEntity;
import com.yc.service.car.card.CarProjectInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 汽修-项目信息serviceImpl
 * @Author 村子里最好的剑
 * @Date 2020-11-18 11:42:00
 */
@Service
public class CarProjectInfoServiceImpl implements CarProjectInfoService {

   @Autowired
   private CarProjectInfoDao carProjectInfoDao;

   /**
    * 查询项目信息列表
    * @param correctPage 起始页
    * @param correctSize 页大小
    * @param carProjectInfoDto
    * @Date 2020-11-18 14:54
    * @return List<CarProjectInfoDto>
    */
   @Override
   public List<CarProjectInfoDto> listCarProjectInfo(int correctPage, int correctSize, CarProjectInfoDto carProjectInfoDto) {
      Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_4));
      params.put("correctStart", PagerWrapper.correctStart(correctPage, correctSize));
      params.put("correctSize", correctSize);
      if(StringUtils.isNotEmpty(carProjectInfoDto.getProjectName())){
         params.put("projectName", carProjectInfoDto.getProjectName());
      }
      if(null != carProjectInfoDto.getStatus()){
         params.put("status", carProjectInfoDto.getStatus());
      }
      return carProjectInfoDao.listCarProjectInfo(params);
   }

   /**
    * 查询项目信息总数
    * @param carProjectInfoDto
    * @Date 2020-11-18 14:55
    * @return int
    */
   @Override
   public int countCarProjectInfo(CarProjectInfoDto carProjectInfoDto) {
      Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_2));
      if(StringUtils.isNotEmpty(carProjectInfoDto.getProjectName())){
         params.put("projectName", carProjectInfoDto.getProjectName());
      }
      if(null != carProjectInfoDto.getStatus()){
         params.put("status", carProjectInfoDto.getStatus());
      }
      return carProjectInfoDao.countCarProjectInfo(params);
   }

   /**
    * 新增项目信息
    * @param carProjectInfoDto
    * @Date 2020-11-18 14:56
    * @return void
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void addCarProjectInfo(CarProjectInfoDto carProjectInfoDto) {
      checkCarProjectInfo(carProjectInfoDto);
      CarProjectInfoEntity carProjectInfoEntity = CommonUtils.transform(carProjectInfoDto, CarProjectInfoEntity.class);
      this.carProjectInfoDao.insertSelective(carProjectInfoEntity);
   }

   /**
    * 校验
    * @param carProjectInfoDto
    */
   private void checkCarProjectInfo(CarProjectInfoDto carProjectInfoDto){
      if(StringUtils.isEmpty(carProjectInfoDto.getProjectName())){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "项目名称不能为空");
      }else{
         //校验项目是否已经存在
         CarProjectInfoEntity carProjectInfoEntity= carProjectInfoDao.findProjectName(carProjectInfoDto.getId(), carProjectInfoDto.getProjectName());
         if (carProjectInfoEntity != null){
            throw new BaseException(ResultCodeEnum.FAIL.code(), "", "该项目已经存在了,清醒点");
         }
      }
      if(null == carProjectInfoDto.getStatus()){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "是否有效字段不能为空");
      }
   }

   /**
    * 修改项目信息
    * @param carProjectInfoDto
    * @Date 2020-11-18 14:57
    * @return void
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void modifyCarProjectInfo(CarProjectInfoDto carProjectInfoDto) {
      checkCarProjectInfo(carProjectInfoDto);
      CarProjectInfoEntity carProjectInfoEntity = carProjectInfoDao.selectByPrimaryKey(carProjectInfoDto.getId());
      if(null == carProjectInfoEntity){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "该项目不存在,请核实");
      }
      carProjectInfoEntity.setProjectName(carProjectInfoDto.getProjectName());
      carProjectInfoEntity.setProjectContent(carProjectInfoDto.getProjectContent());
      carProjectInfoEntity.setRemark(carProjectInfoDto.getRemark());
      carProjectInfoEntity.setModifyDate(carProjectInfoDto.getModifyDate());
      carProjectInfoEntity.setModifierId(carProjectInfoDto.getModifierId());
      carProjectInfoEntity.setStatus(carProjectInfoDto.getStatus());
      //根据主键更新实体全部字段，null值会被更新
      this.carProjectInfoDao.updateByPrimaryKey(carProjectInfoEntity);
   }

   /**
    * 查询项目信息详情
    * @param id 编号
    * @Date 2020-11-18 14:58
    * @return CarProjectInfoDto
    */
   @Override
   public CarProjectInfoDto getCarProjectInfo(Long id) {
      return carProjectInfoDao.getCarProjectInfo(id);
   }

   /**
    * 删除项目信息
    * @param carProjectInfoEntity
    * @Date 2020-11-18 14:59
    * @return void
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void delCarProjectInfo(CarProjectInfoEntity carProjectInfoEntity) {
      //根据主键更新属性不为null的值
      carProjectInfoDao.updateByPrimaryKeySelective(carProjectInfoEntity);
   }

   /**
    * 查询所有有限的项目
    * @Date 2021-01-13 14:34
    * @return List<CarProjectInfoEntity>
    */
   @Override
   public List<CarProjectInfoEntity> findAllCarProjectInfo() {
      CarProjectInfoEntity carProjectInfoEntity = new CarProjectInfoEntity();
      carProjectInfoEntity.setStatus(Constant.STATUS_ONE);
      return carProjectInfoDao.select(carProjectInfoEntity);
   }
}

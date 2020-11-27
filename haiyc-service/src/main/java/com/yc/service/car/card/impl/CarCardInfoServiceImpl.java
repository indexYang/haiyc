package com.yc.service.car.card.impl;

import com.yc.common.constant.Constant;
import com.yc.common.exception.BaseException;
import com.yc.common.result.ResultCodeEnum;
import com.yc.common.utils.CommonUtils;
import com.yc.common.utils.PagerWrapper;
import com.yc.dao.car.card.CarCardInfoDao;
import com.yc.dto.car.card.CarCardInfoDto;
import com.yc.entity.car.card.CarCardInfoEntity;
import com.yc.service.car.card.CarCardInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 车修-卡会员信息serviceImpl
 * @Author 村子里最好的剑
 * @Date 2020-11-18 11:42:00
 */
@Service
public class CarCardInfoServiceImpl implements CarCardInfoService {

   @Autowired
   private CarCardInfoDao carCardInfoDao;

   /**
    * 查询卡会员信息
    * @param correctPage 起始页
    * @param correctSize 页大小
    * @param carCardInfoDto
    * @Date 2020-11-18 14:37
    * @return List<CarCardInfoDto>
    */
   @Override
   public List<CarCardInfoDto> listCarCardInfo(int correctPage, int correctSize, CarCardInfoDto carCardInfoDto) {
      Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_7));
      params.put("correctStart", PagerWrapper.correctStart(correctPage, correctSize));
      params.put("correctSize", correctSize);
      checkParams(carCardInfoDto, params);
      return carCardInfoDao.listCarCardInfo(params);
   }

   /**
    * 查询卡会员信息总数
    * @param carCardInfoDto
    * @Date 2020-11-18 14:38
    * @return int
    */
   @Override
   public int countCarCardInfo(CarCardInfoDto carCardInfoDto) {
      Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_5));
      checkParams(carCardInfoDto, params);
      return carCardInfoDao.countCarCardInfo(params);
   }

   private void checkParams(CarCardInfoDto carCardInfoDto, Map params) {
      params.put("typeCode", Constant.LEVEL_CODE_TYPE);
      if(StringUtils.isNotEmpty(carCardInfoDto.getCardNo())){
         params.put("cardNo", carCardInfoDto.getCardNo());
      }
      if(StringUtils.isNotEmpty(carCardInfoDto.getPhone())){
         params.put("phone", carCardInfoDto.getPhone());
      }
      if(StringUtils.isNotEmpty(carCardInfoDto.getCarNum())){
         params.put("carNum", carCardInfoDto.getCarNum());
      }
      if(null != carCardInfoDto.getLevel()){
         params.put("level", carCardInfoDto.getLevel());
      }
      if(null != carCardInfoDto.getStatus()){
         params.put("status", carCardInfoDto.getStatus());
      }
   }

   /**
    * 新增卡会员信息
    * @param carCardInfoDto
    * @Date 2020-11-18 14:39
    * @return int
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void addCarCardInfo(CarCardInfoDto carCardInfoDto) {
      checkCarCardInfo(carCardInfoDto);
      CarCardInfoEntity carCardInfoEntity = CommonUtils.transform(carCardInfoDto, CarCardInfoEntity.class);
      this.carCardInfoDao.insertSelective(carCardInfoEntity);
   }

   /**
    * 校验
    * @param carCardInfoDto
    */
   private void checkCarCardInfo(CarCardInfoDto carCardInfoDto){
      if(StringUtils.isEmpty(carCardInfoDto.getCardNo())){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "会员卡号不能为空");
      }else{
         //校验卡号是否已经存在
         CarCardInfoEntity carCardInfoEntity= carCardInfoDao.findCardNo(carCardInfoDto.getId(), carCardInfoDto.getCardNo());
         if (carCardInfoEntity != null){
            throw new BaseException(ResultCodeEnum.FAIL.code(), "", "该会员卡号已经存在了,清醒点");
         }
      }

      if(StringUtils.isEmpty(carCardInfoDto.getPhone())){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "手机号码不能为空");
      }else{
         //校验手机号码是否已经存在
         CarCardInfoEntity carCardInfoEntity= carCardInfoDao.findPhone(carCardInfoDto.getId(), carCardInfoDto.getPhone());
         if (carCardInfoEntity != null){
            throw new BaseException(ResultCodeEnum.FAIL.code(), "", "该手机号码已经存在了,清醒点");
         }
      }

      if(null == carCardInfoDto.getLevel()){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "卡的级别不能为空");
      }

      if(null == carCardInfoDto.getDiscount()){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "折扣不能为空");
      }

      if(null == carCardInfoDto.getStatus()){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "是否有效不能为空");
      }
   }

   /**
    * 修改卡会员信息
    * @param carCardInfoDto
    * @Date 2020-11-18 14:40
    * @return int
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void modifyCarCardInfo(CarCardInfoDto carCardInfoDto) {
      checkCarCardInfo(carCardInfoDto);
      CarCardInfoEntity carCardInfoEntity = carCardInfoDao.selectByPrimaryKey(carCardInfoDto.getId());
      if(null == carCardInfoEntity){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "该卡不存在,请核实");
      }
      carCardInfoEntity.setCardNo(carCardInfoDto.getCardNo());
      carCardInfoEntity.setUserName(carCardInfoDto.getUserName());
      carCardInfoEntity.setPhone(carCardInfoDto.getPhone());
      carCardInfoEntity.setCarNum(carCardInfoDto.getCarNum());
      carCardInfoEntity.setLevel(carCardInfoDto.getLevel());
      carCardInfoEntity.setDiscount(carCardInfoDto.getDiscount());
      carCardInfoEntity.setMoney(carCardInfoDto.getMoney());
      carCardInfoEntity.setLimiteDate(carCardInfoDto.getLimiteDate());
      carCardInfoEntity.setRemark(carCardInfoDto.getRemark());
      carCardInfoEntity.setStatus(carCardInfoDto.getStatus());
      //根据主键更新实体全部字段，null值会被更新
      this.carCardInfoDao.updateByPrimaryKey(carCardInfoEntity);
   }

   /**
    * 查询卡会员信息详情
    * @param id 编号
    * @Date 2020-11-18 14:41
    * @return CarCardInfoDto
    */
   @Override
   public CarCardInfoDto getCarCardInfo(Long id) {
      return carCardInfoDao.getCarCardInfo(id);
   }

   /**
    * 删除卡会员信息
    * @param carCardInfoEntity
    * @Date 2020-11-18 14:42
    * @return void
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void delCarCardInfo(CarCardInfoEntity carCardInfoEntity) {
      //根据主键更新属性不为null的值
      carCardInfoDao.updateByPrimaryKeySelective(carCardInfoEntity);
   }
}

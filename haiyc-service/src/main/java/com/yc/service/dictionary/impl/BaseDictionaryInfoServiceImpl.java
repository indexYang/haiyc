package com.yc.service.dictionary.impl;

import com.yc.common.constant.Constant;
import com.yc.common.exception.BaseException;
import com.yc.common.result.ResultCodeEnum;
import com.yc.dao.dictionary.BaseDictionaryInfoDao;
import com.yc.entity.dictionary.BaseDictionaryInfoEntity;
import com.yc.service.dictionary.BaseDictionaryInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 字典serviceImpl
 * @Author 村子里最好的剑
 * @Date 2020-11-12 04:02:11
 */
@Service
public class BaseDictionaryInfoServiceImpl implements BaseDictionaryInfoService {

   @Autowired
   private BaseDictionaryInfoDao baseDictionaryInfoDao;

   /**
    * 查询字典类型所对应数据字典
    * @param typeCode code类型
    * @Date 2020-11-13 10:02
    * @return List<BaseDictionaryInfoEntity>
    */
   @Override
   public List<BaseDictionaryInfoEntity> queryDictionaryType(String typeCode) {
      if(StringUtils.isEmpty(typeCode)){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "字典类型参数不能为空");
      }
      BaseDictionaryInfoEntity baseDictionaryInfoEntity = new BaseDictionaryInfoEntity();
      baseDictionaryInfoEntity.setStatus(Constant.NUM_1);
      baseDictionaryInfoEntity.setTypeCode(typeCode);
      return baseDictionaryInfoDao.select(baseDictionaryInfoEntity);
   }
}

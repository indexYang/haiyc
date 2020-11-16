package com.yc.service.url.impl;

import com.yc.common.constant.Constant;
import com.yc.common.exception.BaseException;
import com.yc.common.result.ResultCodeEnum;
import com.yc.common.utils.CommonUtils;
import com.yc.common.utils.PagerWrapper;
import com.yc.dao.url.HaiycUrlInfoDao;
import com.yc.dto.url.HaiycUrlInfoDto;
import com.yc.entity.url.HaiycUrlInfoEntity;
import com.yc.service.url.HaiycUrlInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 网址信息serviceImpl
 * @Author 村子里最好的剑
 * @Date 2020-11-16 02:23:24
 */
@Service
public class HaiycUrlInfoServiceImpl implements HaiycUrlInfoService {

   @Autowired
   private HaiycUrlInfoDao haiycUrlInfoDao;

   /**
    * 查询网址信息
    * @param correctPage 当前页
    * @param correctSize 页大小
    * @param haiycUrlInfoDto
    * @Date 2020-11-16 15:25
    * @return PagerWrapper<HaiycUrlInfoDto>
    */
   @Override
   public List<HaiycUrlInfoDto> queryListUrlInfo(int correctPage, int correctSize, HaiycUrlInfoDto haiycUrlInfoDto) {
      Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_3));
      params.put("correctStart", PagerWrapper.correctStart(correctPage, correctSize));
      params.put("correctSize", correctSize);
      if(StringUtils.isNotEmpty(haiycUrlInfoDto.getName())){
         params.put("name", haiycUrlInfoDto.getName());
      }
      return haiycUrlInfoDao.queryListUrlInfo(params);
   }

   /**
    * 查询网址信息总条数
    * @param haiycUrlInfoDto
    * @Date 2020-11-16 15:26
    * @return int
    */
   @Override
   public int countUrlInfo(HaiycUrlInfoDto haiycUrlInfoDto) {
      Map params = new HashMap<>(CommonUtils.initialCapacity(Constant.NUM_1));
      if(StringUtils.isNotEmpty(haiycUrlInfoDto.getName())){
         params.put("name", haiycUrlInfoDto.getName());
      }
      return haiycUrlInfoDao.countUrlInfo(params);
   }

   /**
    * 新增网址信息
    * @param haiycUrlInfoDto
    * @Date 2020-11-16 15:27
    * @return int
    */
   @Override
   public void addUrlInfo(HaiycUrlInfoDto haiycUrlInfoDto) {
      checkUrlInfo(haiycUrlInfoDto);
      HaiycUrlInfoEntity haiycUrlInfoEntity = CommonUtils.transform(haiycUrlInfoDto, HaiycUrlInfoEntity.class);
      haiycUrlInfoDao.insertSelective(haiycUrlInfoEntity);
   }

   /**
    * 参数校验
    * @param haiycUrlInfoDto
    */
   private void checkUrlInfo(HaiycUrlInfoDto haiycUrlInfoDto){
      if(StringUtils.isEmpty(haiycUrlInfoDto.getName())){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "名称不能为空");
      }
      if(StringUtils.isEmpty(haiycUrlInfoDto.getAccount())){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "账号不能为空");
      }
      if(StringUtils.isEmpty(haiycUrlInfoDto.getPassword())){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "密码不能为空");
      }
      if(StringUtils.isEmpty(haiycUrlInfoDto.getUrl())){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "url不能为空");
      }
   }

   /**
    * 修改网址信息
    * @param haiycUrlInfoDto
    * @Date 2020-11-16 15:28
    * @return void
    */
   @Override
   public void modifyUrlInfo(HaiycUrlInfoDto haiycUrlInfoDto) {
      checkUrlInfo(haiycUrlInfoDto);
      HaiycUrlInfoEntity haiycUrlInfoEntity = haiycUrlInfoDao.selectByPrimaryKey(haiycUrlInfoDto.getId());
      if(null == haiycUrlInfoEntity){
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "该信息不存在，请核实");
      }
      haiycUrlInfoEntity.setName(haiycUrlInfoDto.getName());
      haiycUrlInfoEntity.setAccount(haiycUrlInfoDto.getAccount());
      haiycUrlInfoEntity.setPassword(haiycUrlInfoDto.getPassword());
      haiycUrlInfoEntity.setUrl(haiycUrlInfoDto.getUrl());
      haiycUrlInfoEntity.setRemark(haiycUrlInfoDto.getRemark());
      haiycUrlInfoDao.updateByPrimaryKey(haiycUrlInfoEntity);
   }

   /**
    * 查询网址信息详情
    * @param id 主键
    * @Date 2020-11-16 15:29
    * @return HaiycUrlInfoDto
    */
   @Override
   public HaiycUrlInfoDto getUrlInfo(Long id) {
      return haiycUrlInfoDao.getUrlInfo(id);
   }

   /**
    * 查询网址信息总条数
    * @param haiycUrlInfoEntity
    * @Date 2020-11-16 15:30
    * @return void
    */
   @Override
   public void delUrlInfo(HaiycUrlInfoEntity haiycUrlInfoEntity) {
      //根据主键更新属性不为null的值
      haiycUrlInfoDao.updateByPrimaryKeySelective(haiycUrlInfoEntity);
   }
}

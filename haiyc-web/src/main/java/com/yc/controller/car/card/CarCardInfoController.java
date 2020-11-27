package com.yc.controller.car.card;

import com.yc.common.constant.Constant;
import com.yc.common.result.ResponseResult;
import com.yc.common.utils.PagerWrapper;
import com.yc.controller.BaseController;
import com.yc.dto.car.card.CarCardInfoDto;
import com.yc.entity.car.card.CarCardInfoEntity;
import com.yc.service.car.card.CarCardInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description 车修-卡会员信息控制器
 * @Author 村子里最好的剑
 * @Date 2020-11-18 11:41:17
 */
@RestController
@RequestMapping("/card")
public class CarCardInfoController extends BaseController {

   @Autowired
   private CarCardInfoService carCardInfoService;

   /**
    * 查询卡会员信息
    * @Author 村子里最好的剑
    * @Date 2020-11-18 14:17
    * @return PagerWrapper<CarCardInfoDto>
    */
   @RequestMapping(value = "listCarCardInfo.htm", method = RequestMethod.GET)
   @ResponseResult
   public PagerWrapper<CarCardInfoDto> listCarCardInfo(PagerWrapper<CarCardInfoDto> pageParam, CarCardInfoDto carCardInfoDto){
      int correctPage = PagerWrapper.correctPage(pageParam.getPage());
      int correctSize = PagerWrapper.correctSize(pageParam.getSize());
      //查询卡会员信息列表
      List<CarCardInfoDto> listCarCardInfo = carCardInfoService.listCarCardInfo(correctPage, correctSize, carCardInfoDto);
      //查询卡会员信息总数
      int totalCnt = carCardInfoService.countCarCardInfo(carCardInfoDto);
      return PagerWrapper.create(listCarCardInfo, correctPage, correctSize).putTotalCnt(totalCnt);
   }

   /**
    * 新增或编辑卡会员信息
    * @Author 村子里最好的剑
    * @Date 2020-11-18 14:21
    * @return void
    */
   @RequestMapping(value = "addOrModifyCarCardInfo.do", method = RequestMethod.POST)
   @ResponseResult
   public void addOrModifyCarCardInfo(CarCardInfoDto carCardInfoDto){
      carCardInfoDto.setModifierId(getUserInfo().getUserNo());
      carCardInfoDto.setModifyDate(new Date());
      if(null == carCardInfoDto.getId()){
         carCardInfoDto.setCreatorId(getUserInfo().getUserNo());
         carCardInfoDto.setCreateDate(new Date());
         this.carCardInfoService.addCarCardInfo(carCardInfoDto);
      }else{
         this.carCardInfoService.modifyCarCardInfo(carCardInfoDto);
      }
   }

   /**
    * 查询卡会员信息详情
    * @param id 编号
    * @Author 村子里最好的剑
    * @Date 2020-11-18 14:24
    * @return CarCardInfoDto
    */
   @GetMapping("getCarCardInfo.htm")
   @ResponseResult
   public CarCardInfoDto getCarCardInfo(Long id){
      return carCardInfoService.getCarCardInfo(id);
   }

   /**
    * 删除卡会员信息
    * @param id 编号
    * @Author 村子里最好的剑
    * @Date 2020-11-18 14:25
    * @return void
    */
   @PostMapping("delCarCardInfo.do")
   @ResponseResult
   public void delCarCardInfo(Long id){
      if(null != id){
         CarCardInfoEntity carCardInfoEntity = new CarCardInfoEntity();
         carCardInfoEntity.setId(id);
         carCardInfoEntity.setModifierId(getUserInfo().getUserNo());
         carCardInfoEntity.setModifyDate(new Date());
         carCardInfoEntity.setStatus(Constant.NUM_0);
         carCardInfoService.delCarCardInfo(carCardInfoEntity);
      }
   }
}

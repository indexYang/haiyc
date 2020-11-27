package com.yc.controller.car.card;

import com.yc.common.constant.Constant;
import com.yc.common.result.ResponseResult;
import com.yc.common.utils.PagerWrapper;
import com.yc.controller.BaseController;
import com.yc.dto.car.card.CarProjectInfoDto;
import com.yc.entity.car.card.CarProjectInfoEntity;
import com.yc.service.car.card.CarProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description 汽修-项目信息控制器
 * @Author 村子里最好的剑
 * @Date 2020-11-18 11:41:17
 */
@RestController
@RequestMapping("/project")
public class CarProjectInfoController extends BaseController {

   @Autowired
   private CarProjectInfoService carProjectInfoService;

   /**
    * 查询项目信息
    * @Author 村子里最好的剑
    * @Date 2020-11-18 14:45
    * @return PagerWrapper<CarProjectInfoDto>
    */
   @RequestMapping(value = "listCarProjectInfo.htm", method = RequestMethod.GET)
   @ResponseResult
   public PagerWrapper<CarProjectInfoDto> listCarProjectInfo(PagerWrapper<CarProjectInfoDto> pageParam, CarProjectInfoDto carProjectInfoDto){
      int correctPage = PagerWrapper.correctPage(pageParam.getPage());
      int correctSize = PagerWrapper.correctSize(pageParam.getSize());
      //查询项目信息列表
      List<CarProjectInfoDto> listCarProjectInfo = carProjectInfoService.listCarProjectInfo(correctPage, correctSize, carProjectInfoDto);
      //查询项目信息总数
      int totalCnt = carProjectInfoService.countCarProjectInfo(carProjectInfoDto);
      return PagerWrapper.create(listCarProjectInfo, correctPage, correctSize).putTotalCnt(totalCnt);
   }

   /**
    * 新增或编辑项目信息
    * @Author 村子里最好的剑
    * @Date 2020-11-18 14:50
    * @return void
    */
   @RequestMapping(value = "addOrModifyCarProjectInfo.do", method = RequestMethod.POST)
   @ResponseResult
   public void addOrModifyCarProjectInfo(CarProjectInfoDto carProjectInfoDto){
      carProjectInfoDto.setModifierId(getUserInfo().getUserNo());
      carProjectInfoDto.setModifyDate(new Date());
      if(null == carProjectInfoDto.getId()){
         carProjectInfoDto.setCreatorId(getUserInfo().getUserNo());
         carProjectInfoDto.setCreateDate(new Date());
         this.carProjectInfoService.addCarProjectInfo(carProjectInfoDto);
      }else{
         this.carProjectInfoService.modifyCarProjectInfo(carProjectInfoDto);
      }
   }

   /**
    * 查询项目信息详情
    * @param id 编号
    * @Author 村子里最好的剑
    * @Date 2020-11-18 14:52
    * @return CarProjectInfoDto
    */
   @GetMapping("getCarProjectInfo.htm")
   @ResponseResult
   public CarProjectInfoDto getCarProjectInfo(Long id){
      return carProjectInfoService.getCarProjectInfo(id);
   }

   /**
    * 删除项目信息
    * @param id 编号
    * @Author 村子里最好的剑
    * @Date 2020-11-18 14:53
    * @return void
    */
   @PostMapping("delCarProjectInfo.do")
   @ResponseResult
   public void delCarProjectInfo(Long id){
      if(null != id){
         CarProjectInfoEntity carProjectInfoEntity = new CarProjectInfoEntity();
         carProjectInfoEntity.setId(id);
         carProjectInfoEntity.setModifierId(getUserInfo().getUserNo());
         carProjectInfoEntity.setModifyDate(new Date());
         carProjectInfoEntity.setStatus(Constant.NUM_0);
         carProjectInfoService.delCarProjectInfo(carProjectInfoEntity);
      }
   }
}

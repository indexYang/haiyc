package com.yc.controller.car.card;

import com.yc.dto.car.card.CarLevelProjectDto;
import com.yc.service.car.card.CarCardLevelService;
import com.yc.dto.car.card.CarCardLevelDto;
import com.yc.entity.car.card.CarCardLevelEntity;
import com.yc.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.yc.common.utils.PagerWrapper;
import com.yc.common.result.ResponseResult;
import com.yc.common.constant.Constant;

import java.util.List;
import java.util.Date;

/**
 * @Description CarCardLevel
 * @Author HaiYc
 * @Date 2021-01-12 04:44:53
 */
@RestController
@RequestMapping("/carCardLevel")
@Slf4j
public class CarCardLevelController extends BaseController{

   @Autowired
   private CarCardLevelService carCardLevelService;

   /**
    * SELECT CarCardLevel PAGE
    * @Author HaiYc
    * @Date 2021-01-12 04:44:53
    * @return PagerWrapper<CarCardLevelDto>
    */
   @GetMapping(value = "listCarCardLevel.htm")
   @ResponseResult
   public PagerWrapper<CarCardLevelDto> listCarCardLevel(PagerWrapper<CarCardLevelDto> pageParam, CarCardLevelDto carCardLevelDto){
       int correctPage = PagerWrapper.correctPage(pageParam.getPage());
       int correctSize = PagerWrapper.correctSize(pageParam.getSize());
       //SELECT CarCardLevel LIST
       List<CarCardLevelDto> listCarCardLevel = carCardLevelService.listCarCardLevel(correctPage, correctSize, carCardLevelDto);
       //SELECT CarCardLevel COUNT
       int totalCnt = carCardLevelService.countCarCardLevel(carCardLevelDto);
       return PagerWrapper.create(listCarCardLevel, correctPage, correctSize).putTotalCnt(totalCnt);
   }

   /**
    * ADD OR UPDATE CarCardLevel
    * @Author HaiYc
    * @Date 2021-01-12 04:44:53
    * @return void
    */
   @PostMapping(value = "addOrModifyCarCardLevel.do")
   @ResponseResult
   public void addOrModifyCarCardLevel(CarCardLevelDto carCardLevelDto){
       carCardLevelDto.setModifierId(getUserInfo().getUserNo());
       carCardLevelDto.setModifyDate(new Date());
       if(null == carCardLevelDto.getId()){
           carCardLevelDto.setCreatorId(getUserInfo().getUserNo());
           carCardLevelDto.setCreateDate(new Date());
           carCardLevelService.addCarCardLevel(carCardLevelDto);
       }else{
           carCardLevelService.modifyCarCardLevel(carCardLevelDto);
       }
   }

   /**
    * INFO CarCardLevel
    * @Author HaiYc
    * @Date 2021-01-12 04:44:53
    * @return CarCardLevelDto
    */
   @GetMapping(value = "getCarCardLevel.htm")
   @ResponseResult
   public CarCardLevelDto getCarCardLevel(Long id){
       return carCardLevelService.getCarCardLevel(id);
   }

   /**
    * DEL CarCardLevel
    * @Author HaiYc
    * @Date 2021-01-12 04:44:53
    * @return void
    */
   @PostMapping(value = "delCarCardLevel.do")
   @ResponseResult
   public void delCarCardLevel(Long id){
       if(null != id){
           CarCardLevelEntity carCardLevelEntity = new CarCardLevelEntity();
           carCardLevelEntity.setId(id);
           carCardLevelEntity.setModifierId(getUserInfo().getUserNo());
           carCardLevelEntity.setModifyDate(new Date());
           carCardLevelEntity.setStatus(Constant.NUM_0);
           carCardLevelService.delCarCardLevel(carCardLevelEntity);
       }
   }

    /**
     * 查询会员卡等级对应的次数
     * @Author HaiYc
     * @Date 2021-01-22 13:53:53
     * @return List<CarLevelProjectDto>
     */
    @GetMapping(value = "selectLevelProject.do")
    @ResponseResult
    public List<CarLevelProjectDto> selectLevelProject(Long id, List<CarLevelProjectDto> list){

        return null;
    }
}

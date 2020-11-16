package com.yc.controller.url;

import com.yc.common.constant.Constant;
import com.yc.common.exception.BaseException;
import com.yc.common.result.ResponseResult;
import com.yc.common.result.ResultCodeEnum;
import com.yc.common.utils.PagerWrapper;
import com.yc.controller.BaseController;
import com.yc.dto.url.HaiycUrlInfoDto;
import com.yc.entity.url.HaiycUrlInfoEntity;
import com.yc.service.url.HaiycUrlInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description 网址信息控制器
 * @Author 村子里最好的剑
 * @Date 2020-11-16 02:23:42
 */
@RestController
@RequestMapping("/url")
public class HaiycUrlInfoController extends BaseController {

   @Autowired
   private HaiycUrlInfoService haiycUrlInfoService;

   /**
    * 查询网址信息
    * @param pageParam
    * @param haiycUrlInfoDto
    * @Author 村子里最好的剑
    * @Date 2020-11-16 15:25
    * @return PagerWrapper<BaseUserDto>
    */
   @RequestMapping("queryListUrlInfo.htm")
   @ResponseResult
   public PagerWrapper<HaiycUrlInfoDto> queryListUrlInfo(PagerWrapper<HaiycUrlInfoDto> pageParam, HaiycUrlInfoDto haiycUrlInfoDto){
      int correctPage = PagerWrapper.correctPage(pageParam.getPage());
      int correctSize = PagerWrapper.correctSize(pageParam.getSize());
      //查询网址信息列表
      List<HaiycUrlInfoDto> queryListUrlInfo = this.haiycUrlInfoService.queryListUrlInfo(correctPage, correctSize, haiycUrlInfoDto);
      //查询网址信息总条数
      int totalCnt = this.haiycUrlInfoService.countUrlInfo(haiycUrlInfoDto);
      return PagerWrapper.create(queryListUrlInfo, correctPage, correctSize).putTotalCnt(totalCnt);
   }

   /**
    * 新增修改网址信息
    * @Author 村子里最好的剑
    * @Date 2020-11-16 15:28
    * @return void
    */
   @PostMapping("addOrModifyUrlInfo.do")
   @ResponseResult
   public void addOrModifyUrlInfo(HaiycUrlInfoDto haiycUrlInfoDto){
      haiycUrlInfoDto.setModifierId(getUserInfo().getUserNo());
      haiycUrlInfoDto.setModifyDate(new Date());
      if(null == haiycUrlInfoDto.getId()){
         haiycUrlInfoDto.setStatus(Constant.NUM_1);
         haiycUrlInfoDto.setCreatorId(getUserInfo().getUserNo());
         haiycUrlInfoDto.setCreateDate(new Date());
         this.haiycUrlInfoService.addUrlInfo(haiycUrlInfoDto);
      }else{
         this.haiycUrlInfoService.modifyUrlInfo(haiycUrlInfoDto);
      }
   }

   /**
    * 获取网址信息
    * @param id 主键
    * @Author 村子里最好的剑
    * @Date 2020-11-16 15:31
    * @return HaiycUrlInfoDto
    */
   @GetMapping("getUrlInfo.htm")
   @ResponseResult
   public HaiycUrlInfoDto getUrlInfo(Long id){
      return haiycUrlInfoService.getUrlInfo(id);
   }

   /**
    * 删除网址信息
    * @param id 主键
    * @Author 村子里最好的剑
    * @Date 2020-11-16 15:32
    * @return void
    */
   @PostMapping("delUrlInfo.do")
   @ResponseResult
   public void delUrlInfo(Long id){
      if(null != id){
         HaiycUrlInfoEntity haiycUrlInfoEntity = new HaiycUrlInfoEntity();
         haiycUrlInfoEntity.setId(id);
         haiycUrlInfoEntity.setModifierId(getUserInfo().getUserNo());
         haiycUrlInfoEntity.setModifyDate(new Date());
         haiycUrlInfoEntity.setStatus(Constant.NUM_0);
         haiycUrlInfoService.delUrlInfo(haiycUrlInfoEntity);
      }else{
         throw new BaseException(ResultCodeEnum.FAIL.code(), "", "删除失败");
      }
   }
}

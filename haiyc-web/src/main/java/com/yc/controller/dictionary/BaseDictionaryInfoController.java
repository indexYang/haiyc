package com.yc.controller.dictionary;

import com.yc.common.result.ResponseResult;
import com.yc.entity.dictionary.BaseDictionaryInfoEntity;
import com.yc.service.dictionary.BaseDictionaryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description 字典控制器
 * @Author 村子里最好的剑
 * @Date 2020-11-12 04:02:22
 */
@RestController
@RequestMapping("/dictionary")
public class BaseDictionaryInfoController {

   @Autowired
   private BaseDictionaryInfoService baseDictionaryInfoService;

   /**
    * 查询字典类型所对应数据字典
    * @param typeCode code类型
    * @Author 村子里最好的剑
    * @Date 2020-11-13 10:02
    * @return List<StationDictionaryInfoEntity>
    */
   @GetMapping("queryDictionaryType.htm")
   @ResponseResult
   public List<BaseDictionaryInfoEntity> queryDictionaryType(String typeCode){
      return baseDictionaryInfoService.queryDictionaryType(typeCode);
   }

}

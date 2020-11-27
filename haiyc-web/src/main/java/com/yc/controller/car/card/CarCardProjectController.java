package com.yc.controller.car.card;

import com.yc.controller.BaseController;
import com.yc.service.car.card.CarCardProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 汽修-卡号_项目绑定控制器
 * @Author 村子里最好的剑
 * @Date 2020-11-18 11:41:17
 */
@RestController
@RequestMapping("/cardProject")
public class CarCardProjectController extends BaseController {

   @Autowired
   private CarCardProjectService carCardProjectService;

}

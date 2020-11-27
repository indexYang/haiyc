package com.yc.service.car.card.impl;

import com.yc.dao.car.card.CarCardProjectDao;
import com.yc.service.car.card.CarCardProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 汽修-卡号_项目绑定serviceImpl
 * @Author 村子里最好的剑
 * @Date 2020-11-18 11:42:00
 */
@Service
public class CarCardProjectServiceImpl implements CarCardProjectService {

   @Autowired
   private CarCardProjectDao carCardProjectDao;

}

package com.yc.controller.role;

import com.yc.service.role.BaseRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author yangch
 * @Date 2020-07-28 03:00:00
 */
@RestController
public class BaseRoleMenuController {

   @Autowired
   private BaseRoleMenuService baseRoleMenuService;

}

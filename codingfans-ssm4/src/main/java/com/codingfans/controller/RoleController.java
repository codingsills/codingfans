package com.codingfans.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codingfans.service.RoleService;

/**
 * 类功能描述<br>
 * RoleController.java
 *
 * @date 2016年1月8日
 * 
 * @author Saber
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    
    @Resource(name="roleService")
    private RoleService roleService;
    
    @RequestMapping(value="/query.action")
    public ModelAndView query(){
        ModelAndView mav = new ModelAndView("role/list");
        return mav;
    }
    
    @RequestMapping(value="/addView.action")
    public ModelAndView addView(){
        ModelAndView mav = new ModelAndView("role/add");
        return mav;
    }
    
    @RequestMapping(value="/editView.action")
    public ModelAndView editView(){
        ModelAndView mav = new ModelAndView("role/edit");
        return mav;
    }
}

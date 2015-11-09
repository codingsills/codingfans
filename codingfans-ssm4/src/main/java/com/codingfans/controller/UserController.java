/**
 * 创建于: 2015年10月21日 下午2:06:11<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:UserController.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类功能描述
 * UserController.java
 *
 * @date 2015年10月21日 Saber
 * 
 * @author Saber
 * @version 0.1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @RequestMapping(value="/list.action")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("user/list");
        //TODO 查询用户列表
        return mav;
    }
    
    @RequestMapping(value="/addView.action")
    public ModelAndView toAddView(){
        ModelAndView mav = new ModelAndView("user/add");
        return mav;
    }
    
    @RequestMapping(value="/editView.action")
    public ModelAndView toEditView(){
        ModelAndView mav = new ModelAndView("user/edit");
        return mav;
    }
}

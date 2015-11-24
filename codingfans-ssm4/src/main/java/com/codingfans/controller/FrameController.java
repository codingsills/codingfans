/**
 * 创建于: 2015年11月24日 上午10:44:37<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:FrameController.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类功能描述
 * FrameController.java
 *
 * @date 2015年11月24日 Saber
 * 
 * @author Saber
 * @version 0.1.0
 */
@Controller
@RequestMapping(value="/frame")
public class FrameController {
    
    @RequestMapping(value="/index.action")
    public String index(){
        return "frame/login";
    }
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ModelAndView login(String username,String password){
        ModelAndView mav = new ModelAndView("frame/login");
        
        //TODO 如果用户名、密码正确
        if("admin".equals(username) && "123456".equals(password)){
            mav = new ModelAndView("user/list");
        }else{
            mav.addObject("flag", "false");
        }
        
        return mav;
    }
}

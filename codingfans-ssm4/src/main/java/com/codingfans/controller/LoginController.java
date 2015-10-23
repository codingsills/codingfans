/**
 * 创建于: 2015年10月21日 下午2:09:29<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:LoginController.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类功能描述
 * LoginController.java
 *
 * @date 2015年10月21日 Saber
 * 
 * @author Saber
 * @version 0.1.0
 */
@Controller
@RequestMapping("/")
public class LoginController {
    
    
    @RequestMapping(method=RequestMethod.GET)
    public String index(){
        return "user/login";
    }
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(String userName,String password,
            Model model){
        if("admin".equals(userName) && "123456".equals(password)){
            model.addAttribute("userName", userName);
            return "user/main";
        }else{
            return "user/login";
        }
    }

    
    
}

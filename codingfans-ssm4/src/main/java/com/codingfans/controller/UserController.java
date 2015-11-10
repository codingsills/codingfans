/**
 * 创建于: 2015年10月21日 下午2:06:11<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:UserController.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codingfans.model.User;
import com.codingfans.service.UserService;
import com.codingfans.vo.UserVO;
import com.google.gson.Gson;

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
    
    @Resource(name="userService")
    private UserService userService;
    
    @RequestMapping(value="/list.action")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("user/list");
        //TODO 查询用户列表
        List<User> list = userService.queryUserList(null);
        mav.addObject("list", list);
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
    
    @RequestMapping(value="/addUser.action")
    public ModelAndView addUser(@ModelAttribute(value="user")UserVO userVo){
        ModelAndView mav = new ModelAndView("user/list");
        //TODO 新增用户
        userVo.setPassword(userVo.getPlainPwd());
        userVo.setSalt("faelkflejzjpfjep");
        userVo.setStatus(1);
        userService.insert(userVo);
        
        return mav;
    }
}

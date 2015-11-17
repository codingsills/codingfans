/**
 * 创建于: 2015年10月21日 下午2:06:11<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:UserController.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.codingfans.model.User;
import com.codingfans.service.UserService;
import com.codingfans.utils.PageObject;
import com.codingfans.vo.UserVO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

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
    
    @RequestMapping(value="list.action")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("user/list");
        return mav;
    }
    @RequestMapping(value="/query.action")
    @ResponseBody
    public Object list(@ModelAttribute(value="user")UserVO userVo,@ModelAttribute(value="page")PageObject page){
        PageObject pageObj = userService.getPageList(userVo, new PageBounds(page.getCPage(), page.getLimit()));
        return pageObj;
    }
    
    @RequestMapping(value="/addView.action")
    public ModelAndView toAddView(){
        ModelAndView mav = new ModelAndView("user/add");
        return mav;
    }
    
    @RequestMapping(value="/editView.action")
    public ModelAndView toEditView(@RequestParam(name="userId")String userId){
        ModelAndView mav = new ModelAndView("user/edit");
        User user = userService.read(userId);
        mav.addObject("user", user);
        return mav;
    }
    
    @RequestMapping(value="/addUser.action")
    public ModelAndView addUser(@ModelAttribute(value="user")UserVO userVo){
        ModelAndView mav = new ModelAndView("redirect:/user/list.action");
        //TODO 新增用户
        userVo.setPassword(userVo.getPlainPwd());
        userVo.setSalt("faelkflejzjpfjep");
        userVo.setStatus(1);
        userService.insert(userVo);
        
        return mav;
    }
    
    
    
    @RequestMapping(value="/mainView.action")
    public String mainView(){
        return "user/main";
    }
}

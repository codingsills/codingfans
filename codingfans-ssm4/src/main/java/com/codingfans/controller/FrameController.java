/**
 * 创建于: 2015年11月24日 上午10:44:37<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:FrameController.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codingfans.service.PermissionService;
import com.codingfans.vo.TreeVO;

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
@RequestMapping
public class FrameController {
    
    @Resource
    private PermissionService pmService;
    
    @RequestMapping(value="/")
    public String index(){
        return "frame/login";
    }
    
    @RequestMapping(value="/login.action")
    public ModelAndView login(String username,String password){
        ModelAndView mav = new ModelAndView("frame/login");
        
        //TODO 如果用户名、密码正确
        if("admin".equals(username) && "123456".equals(password)){
            mav = new ModelAndView("frame/frame");
            //菜单数据
            List<TreeVO> menuTree = pmService.initMenu();
//            menuTree.get(0).getNodes().get(0).setSelectable("T");
//            menuTree.get(0).getNodes().get(0).getNodes().get(0).setSelectable("T");
            mav.addObject("menus", menuTree);
        }else{
            mav.addObject("flag", "false");
        }
        
        return mav;
    }
}

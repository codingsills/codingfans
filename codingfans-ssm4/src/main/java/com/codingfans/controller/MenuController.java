/**
 * 创建于: 2015年11月26日 下午3:38:43<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:MenuController.java
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

import com.codingfans.model.Permission;
import com.codingfans.service.PermissionService;
import com.codingfans.utils.Menu;
import com.codingfans.vo.MenuVO;

/**
 * 类功能描述
 * MenuController.java
 *
 * @date 2015年11月26日 Saber
 * 
 * @author Saber
 * @version 0.1.0
 */
@Controller
@RequestMapping(value="/menu")
public class MenuController {
    
    @Resource
    private PermissionService pmService;
    
    /**
     * 展示菜单树
     * */
    @RequestMapping(value="/menuTree.action")
    @ResponseBody
    public Object showMenu(){
        return  pmService.initMenu();
    }
    
    @RequestMapping(value="/menuView.action")
    public String menuView(){
        return "menu/menuView";
    }
    
    @RequestMapping(value="/toAddView.action")
    public ModelAndView toAddView(@RequestParam(name="parentId") String parentId){
        ModelAndView mav = new ModelAndView("menu/addMenu");
        mav.addObject("parentId", parentId);
        
        return mav;
    }
    
    @RequestMapping(value="/addMenu.action")
    public ModelAndView addMenu(@ModelAttribute(value="menuVO") MenuVO menuVO){
        ModelAndView mav = new ModelAndView("menu/menuView");
        //TODO 新增菜单
        menuVO.setPmType(Menu.MenuType.ISMENU.getType());
        pmService.insert(menuVO);
        
        
        return mav;
    }
    
    @RequestMapping(value="/toModifyView.action")
    public ModelAndView toModifyView(@RequestParam(name="menuId") String menuId){
        ModelAndView mav = new ModelAndView("menu/modifyMenu");
        Permission pm = pmService.read(menuId);
        mav.addObject("menu", pm);
        
        return mav;
    }
    
    @RequestMapping(value="/modifyMenu.action")
    public ModelAndView modifyMenu(@ModelAttribute(value="menuVO") MenuVO menuVO){
        ModelAndView mav = new ModelAndView("menu/menuView");
        menuVO.setPmType(Menu.MenuType.ISMENU.getType());
        pmService.update(menuVO);
        return mav;
    }
    
    
}

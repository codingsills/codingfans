/**
 * 创建于: 2015年11月26日 下午3:38:43<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:MenuController.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.codingfans.model.Permission;
import com.codingfans.service.PermissionService;
import com.codingfans.utils.Menu.MenuType;
import com.codingfans.vo.MenuVO;
import com.codingfans.vo.TreeVO;

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
        Permission permission = new Permission();
        permission.setPmType(MenuType.ISMENU.getType());
        List<Permission> list = pmService.queryPermissionList(permission);
        List<TreeVO> menuTree = initMenuJson(list);
        
        return menuTree;
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
        
        return mav;
    }
    
    private List<TreeVO> initMenuJson(List<Permission> list){
        List<TreeVO> menuTree = new ArrayList<TreeVO>();
        if(list != null && list.size() > 0){
            for(Permission pm : list){
                TreeVO treeVO = new TreeVO(pm);
                Permission permission1 = new Permission();
                permission1.setPmType(MenuType.ISMENU.getType());
                permission1.setParentId(pm.getPmId());
                List<Permission> childList = pmService.queryPermissionList(permission1);
                initMenuJson(childList);
                menuTree.add(treeVO);
            }
        }
        
        return menuTree;
    }
    
}

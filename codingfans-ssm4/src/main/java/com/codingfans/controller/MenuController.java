/**
 * 创建于: 2015年11月26日 下午3:38:43<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:MenuController.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codingfans.model.Permission;
import com.codingfans.service.PermissionService;
import com.codingfans.utils.Menu.MenuType;

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
        if(list != null && !list.isEmpty()){
            for(Permission pm : list){
                permission.setParentId(pm.getPmId());
                List<Permission> childList = pmService.queryPermissionList(permission);
            }
        }
        
        return list;
    }
    
    @RequestMapping(value="menuView.action")
    public String menuView(){
        return "menu/menuView";
    }
    
}

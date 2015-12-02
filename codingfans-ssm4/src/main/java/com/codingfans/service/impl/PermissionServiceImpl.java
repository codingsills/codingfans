package com.codingfans.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.codingfans.repository.mybatis.PermissionMapper;
import com.codingfans.model.Permission;
import com.codingfans.service.PermissionService;
import com.codingfans.utils.Menu.MenuType;
import com.codingfans.vo.TreeVO;

/**
 * Permission Service 实现类
 * 
 * @author Saber
 * 
 * @date 2015-11-09 14:13:51
 * 
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Resource
  	private PermissionMapper permissionMapper;

	@Override
	public Permission read(String id) {
		return permissionMapper.read(id);
	}

	@Override
	public void insert(Permission permission) {
		permissionMapper.insert(permission);
	}

	@Override
	public void update(Permission permission) {
		permissionMapper.update(permission);
	}

	@Override
	public void delete(Integer id) {
		permissionMapper.delete(id);
	}

	@Override
	public Integer queryPermissionCount(Permission permission) {
		return permissionMapper.queryPermissionCount(permission);
	}

	@Override
	public List<Permission> queryPermissionList(Permission permission) {
		return permissionMapper.queryPermissionList(permission);
	}

    @Override
    public List<TreeVO> initMenu() {
        Permission permission = new Permission();
        permission.setPmType(MenuType.ISMENU.getType());
        permission.setPmName("M+");
        List<Permission> list = permissionMapper.queryPermissionList(permission);
        List<TreeVO> menuTree = new ArrayList<>();
        if(list != null && !list.isEmpty()){
            for(Permission pm : list){
                TreeVO tVO = new TreeVO(pm);
                
                iteratorMenu(tVO,pm);
                
                menuTree.add(tVO);
            }
        }
        return menuTree;
    }
    
    private void iteratorMenu(TreeVO ptVO,Permission pm){
        Permission permission1 = new Permission();
        permission1.setPmType(MenuType.ISMENU.getType());
        permission1.setParentId(pm.getPmId());
        List<Permission> childList = permissionMapper.queryPermissionList(permission1);
        if(childList  != null && !childList.isEmpty()){
            List<TreeVO> childTree = new ArrayList<>();
            for(Permission childPM : childList){
                TreeVO childTVO = new TreeVO(childPM);
                iteratorMenu(childTVO, childPM);
                
                childTree.add(childTVO);
            }
            ptVO.setNodes(childTree);
        }
    }
}

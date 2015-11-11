package com.codingfans.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.codingfans.repository.mybatis.RolePermissionMapper;
import com.codingfans.model.RolePermission;
import com.codingfans.service.RolePermissionService;

/**
 * RolePermission Service 实现类
 * 
 * @author Saber
 * 
 * @date 2015-11-09 14:13:51
 * 
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {

    @Resource
  	private RolePermissionMapper rolePermissionMapper;

	@Override
	public RolePermission read(Integer id) {
		return rolePermissionMapper.read(id);
	}

	@Override
	public void insert(RolePermission rolePermission) {
		rolePermissionMapper.insert(rolePermission);
	}

	@Override
	public void update(RolePermission rolePermission) {
		rolePermissionMapper.update(rolePermission);
	}

	@Override
	public void delete(Integer id) {
		rolePermissionMapper.delete(id);
	}

	@Override
	public Integer queryRolePermissionCount(RolePermission rolePermission) {
		return rolePermissionMapper.queryRolePermissionCount(rolePermission);
	}

	@Override
	public List<RolePermission> queryRolePermissionList(RolePermission rolePermission) {
		return rolePermissionMapper.queryRolePermissionList(rolePermission);
	}
}

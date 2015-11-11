package com.codingfans.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.codingfans.repository.mybatis.PermissionMapper;
import com.codingfans.model.Permission;
import com.codingfans.service.PermissionService;

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
	public Permission read(Integer id) {
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
}

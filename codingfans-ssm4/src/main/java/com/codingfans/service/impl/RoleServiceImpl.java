package com.codingfans.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.codingfans.repository.mybatis.RoleMapper;
import com.codingfans.model.Role;
import com.codingfans.service.RoleService;

/**
 * Role Service 实现类
 * 
 * @author Saber
 * 
 * @date 2015-11-09 14:13:51
 * 
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

  	@Resource
  	private RoleMapper roleMapper;

	@Override
	public Role read(Integer id) {
		return roleMapper.read(id);
	}

	@Override
	public void insert(Role role) {
		roleMapper.insert(role);
	}

	@Override
	public void update(Role role) {
		roleMapper.update(role);
	}

	@Override
	public void delete(Integer id) {
		roleMapper.delete(id);
	}

	@Override
	public Integer queryRoleCount(Role role) {
		return roleMapper.queryRoleCount(role);
	}

	@Override
	public List<Role> queryRoleList(Role role) {
		return roleMapper.queryRoleList(role);
	}
}

package com.codingfans.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.codingfans.repository.mybatis.UserRoleMapper;
import com.codingfans.model.UserRole;
import com.codingfans.service.UserRoleService;

/**
 * UserRole Service 实现类
 * 
 * @author Saber
 * 
 * @date 2015-11-09 14:13:51
 * 
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
  	private UserRoleMapper userRoleMapper;

	@Override
	public UserRole read(Integer id) {
		return userRoleMapper.read(id);
	}

	@Override
	public void insert(UserRole userRole) {
		userRoleMapper.insert(userRole);
	}

	@Override
	public void update(UserRole userRole) {
		userRoleMapper.update(userRole);
	}

	@Override
	public void delete(Integer id) {
		userRoleMapper.delete(id);
	}

	@Override
	public Integer queryUserRoleCount(UserRole userRole) {
		return userRoleMapper.queryUserRoleCount(userRole);
	}

	@Override
	public List<UserRole> queryUserRoleList(UserRole userRole) {
		return userRoleMapper.queryUserRoleList(userRole);
	}
}

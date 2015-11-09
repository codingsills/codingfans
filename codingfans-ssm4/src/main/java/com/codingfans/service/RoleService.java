package com.codingfans.service;

import java.util.List;
import com.codingfans.model.Role;

/**
 * 
 * Role Service 接口
 * 
 * @author Saber
 * 
 * @date 2015-11-09 14:13:51
 * 
 */
public interface RoleService {

	/**
	 * 根据Id获取Role
	 * 
	 * @param id
	 * @return
	 */
	public Role read(Integer id);

	/**
	 * 新增Role
	 * 
	 * @param role
	 */
	public void insert(Role role);

	/**
	 * 更新Role
	 * 
	 * @param role
	 */
	public void update(Role role);

	/**
	 * 删除Role
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 查询Role数量
	 * 
	 * @param Role
	 * @return
	 */
	public Integer queryRoleCount(Role role);

	/**
	 * 查询Role列表
	 * 
	 * @param role
	 * @return
	 */
	public List<Role> queryRoleList(Role role);

}

package com.codingfans.service;

import java.util.List;
import com.codingfans.model.RolePermission;

/**
 * 
 * RolePermission Service 接口
 * 
 * @author Saber
 * 
 * @date 2015-11-09 14:13:51
 * 
 */
public interface RolePermissionService{

	/**
	 * 根据Id获取RolePermission
	 * 
	 * @param id
	 * @return
	 */
	public RolePermission read(Integer id);

	/**
	 * 新增RolePermission
	 * 
	 * @param rolePermission
	 */
	public void insert(RolePermission rolePermission);

	/**
	 * 更新RolePermission
	 * 
	 * @param rolePermission
	 */
	public void update(RolePermission rolePermission);

	/**
	 * 删除RolePermission
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 查询RolePermission数量
	 * 
	 * @param RolePermission
	 * @return
	 */
	public Integer queryRolePermissionCount(RolePermission rolePermission);

	/**
	 * 查询RolePermission列表
	 * 
	 * @param rolePermission
	 * @return
	 */
	public List<RolePermission> queryRolePermissionList(RolePermission rolePermission);

}

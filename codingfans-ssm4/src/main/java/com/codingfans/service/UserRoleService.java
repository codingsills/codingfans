package com.codingfans.service;

import java.util.List;
import com.codingfans.model.UserRole;

/**
 * 
 * UserRole Service 接口
 * 
 * @author Saber
 * 
 * @date 2015-11-09 14:13:51
 * 
 */
public interface UserRoleService {

	/**
	 * 根据Id获取UserRole
	 * 
	 * @param id
	 * @return
	 */
	public UserRole read(Integer id);

	/**
	 * 新增UserRole
	 * 
	 * @param userRole
	 */
	public void insert(UserRole userRole);

	/**
	 * 更新UserRole
	 * 
	 * @param userRole
	 */
	public void update(UserRole userRole);

	/**
	 * 删除UserRole
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 查询UserRole数量
	 * 
	 * @param UserRole
	 * @return
	 */
	public Integer queryUserRoleCount(UserRole userRole);

	/**
	 * 查询UserRole列表
	 * 
	 * @param userRole
	 * @return
	 */
	public List<UserRole> queryUserRoleList(UserRole userRole);

}

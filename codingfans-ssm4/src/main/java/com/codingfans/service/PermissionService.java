package com.codingfans.service;

import java.util.List;
import com.codingfans.model.Permission;
import com.codingfans.vo.TreeVO;

/**
 * 
 * Permission Service 接口
 * 
 * @author Saber
 * 
 * @date 2015-11-09 14:13:51
 * 
 */
public interface PermissionService{

	/**
	 * 根据Id获取Permission
	 * 
	 * @param id
	 * @return
	 */
	public Permission read(String id);

	/**
	 * 新增Permission
	 * 
	 * @param permission
	 */
	public void insert(Permission permission);

	/**
	 * 更新Permission
	 * 
	 * @param permission
	 */
	public void update(Permission permission);

	/**
	 * 删除Permission
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 查询Permission数量
	 * 
	 * @param Permission
	 * @return
	 */
	public Integer queryPermissionCount(Permission permission);

	/**
	 * 查询Permission列表
	 * 
	 * @param permission
	 * @return
	 */
	public List<Permission> queryPermissionList(Permission permission);
	
	public List<TreeVO> initMenu();

}

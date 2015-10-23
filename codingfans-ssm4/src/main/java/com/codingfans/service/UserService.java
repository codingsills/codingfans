package com.codingfans.service;

import java.util.List;

import com.codingfans.model.User;

/**
 * 
 * User Service 接口
 * 
 * @author Saber
 * 
 * @date 2015-10-20 17:11:14
 * 
 */
public interface UserService {

	/**
	 * 根据Id获取User
	 * 
	 * @param id
	 * @return
	 */
	public User read(String userId);

	/**
	 * 新增User
	 * 
	 * @param user
	 */
	public void insert(User user);

	/**
	 * 更新User
	 * 
	 * @param user
	 */
	public void update(User user);

	/**
	 * 删除User
	 * 
	 * @param id
	 */
	public void delete(String userId);

	/**
	 * 查询User数量
	 * 
	 * @param User
	 * @return
	 */
	public Integer queryUserCount(User user);

	/**
	 * 查询User列表
	 * 
	 * @param user
	 * @return
	 */
	public List<User> queryUserList(User user);
	
	/**
	 * 根据用户名查询用户
	 * @param userName
	 * @return 
	 * */
	public User queryByUserName(String userName);

}

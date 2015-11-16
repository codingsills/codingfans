package com.codingfans.service;

import java.util.List;
import java.util.Map;

import com.codingfans.model.User;
import com.codingfans.utils.PageObject;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 
 * User Service 接口
 * 
 * @author Saber
 * 
 * @date 2015-10-20 17:11:14
 * 
 */
public interface UserService{

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
	
	/**
     * 分页查询
     * 
     * @param user
     * @param pageBounds
     * 
     * */
    public PageObject getPageList(User user,PageBounds pageBounds);

}

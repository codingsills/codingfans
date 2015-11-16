package com.codingfans.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.codingfans.model.User;
import com.codingfans.repository.mybatis.UserMapper;
import com.codingfans.service.UserService;
import com.codingfans.utils.PageObject;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * User Service 实现类
 * 
 * @author Saber
 * 
 * @date 2015-10-20 17:11:14
 * 
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    
    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;

    @Resource
    private UserMapper userMapper;

    @Override
    public User read(String userId) {

        return userMapper.read(userId);
    }

    @Override
    public void insert(User user) {

        userMapper.insert(user);
    }

    @Override
    public void update(User user) {

        userMapper.update(user);
    }

    @Override
    public void delete(String userId) {

        userMapper.delete(userId);
    }

    @Override
    public Integer queryUserCount(User user) {

        return userMapper.queryUserCount(user);
    }

    @Override
    public List<User> queryUserList(User user) {

        return userMapper.queryUserList(user);
    }

    @Override
    public User queryByUserName(String userName) {

        return userMapper.queryByUserName(userName);
    }

    @Override
    public PageObject getPageList(User user, PageBounds pageBounds) {
        PageList<User> pageList = userMapper.getPageList(user, pageBounds);
        PageObject pageObj = new PageObject(pageList);
        return pageObj;
    }

   
}

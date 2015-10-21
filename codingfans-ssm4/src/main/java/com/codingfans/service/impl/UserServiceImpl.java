package com.codingfans.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.codingfans.model.User;
import com.codingfans.repository.mybatis.UserMapper;
import com.codingfans.service.UserService;

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

    @Resource
    private UserMapper userMapper;

    @Override
    public User read(Integer id) {

        return userMapper.read(id);
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
    public void delete(Integer id) {

        userMapper.delete(id);
    }

    @Override
    public Integer queryUserCount(User user) {

        return userMapper.queryUserCount(user);
    }

    @Override
    public List<User> queryUserList(User user) {

        return userMapper.queryUserList(user);
    }
}

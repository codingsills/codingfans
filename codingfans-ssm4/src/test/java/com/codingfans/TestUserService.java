/**
 * 创建于: 2015年10月21日 下午2:12:56<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:TestUserService.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codingfans.model.User;
import com.codingfans.service.UserService;
import com.google.gson.Gson;

/**
 * 类功能描述
 * TestUserService.java
 *
 * @date 2015年10月21日 Saber
 * 
 * @author Saber
 * @version 0.1.0
 */
@ActiveProfiles({"dev","test"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/applicationContext.xml")
public class TestUserService {
    
    @Resource
    private UserService userService;
    
    @Test
    public void testInsert(){
        User user = new User();
        user.setPlainPwd("123456");
        user.setPwd("123456");
        user.setUserName("admin");
        user.setRealName("张三");
        user.setStatus(1);
        user.setEmail("599237023@qq.com");
        user.setSalt("abc");
        userService.insert(user);
    }
    
    @Test
    public void testQueryList(){
        User user = new User();
        user.setUserName("admin");
        List<User> userList = userService.queryUserList(user);
        System.out.println(new Gson().toJson(userList));
    }
    
    @Test
    public void testQueryUser(){
        User user = userService.queryByUserName("admin");
        System.out.println(new Gson().toJson(user));
    }
    
}

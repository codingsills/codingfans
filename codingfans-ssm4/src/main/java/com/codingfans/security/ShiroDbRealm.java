/**
 * 创建于: 2015年10月23日 上午9:52:40<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:ShiroDbRealm.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.security;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.codingfans.model.User;
import com.codingfans.service.UserService;
import com.codingfans.service.impl.UserServiceImpl;


/**
 * 类功能描述
 * ShiroDbRealm.java
 *
 * @date 2015年10月23日 Saber
 * 
 * @author Saber
 * @version 0.1.0
 */
public class ShiroDbRealm extends AuthorizingRealm {
    
    protected UserService userService;

    /**
     * 授权回调方法
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        User user = userService.queryByUserName(shiroUser.userName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //TODO 根据用户ID查询用户权限
//        info.addRoles(roles);
//        info.addStringPermissions(user.get);
        return info;
    }

    /**
     * 认证回调方法，登录时调用
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = userService.queryByUserName(token.getUsername());
        if(user != null){
            byte[] salt = Hex.decode(user.getSalt().getBytes());
            return new SimpleAuthenticationInfo(
                    new ShiroUser(user.getUserId(), user.getUserName(), user.getRealName()),
                    user.getPwd(),ByteSource.Util.bytes(salt),getName());
        }else{
            return null;
        }
    }
    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(UserServiceImpl.HASH_ALGORITHM);
        matcher.setHashIterations(UserServiceImpl.HASH_INTERATIONS);

        setCredentialsMatcher(matcher);
    }
    
    public void setUserService(UserService userService) {
    
        this.userService = userService;
    }

    /**
     * 
     * */
    public static class ShiroUser implements Serializable {

        private static final long serialVersionUID = 1645038435142304009L;
        public String id;
        public String userName;
        public String realName;

        /**
         * ShiroDbRealm.java 默认构造
         */
        public ShiroUser(String id, String userName, String realName) {
            super();
            this.id = id;
            this.userName = userName;
            this.realName = realName;
        }

        public String getRealName() {
            return realName;
        }

        /**
         * 本函数输出将作为默认的<shiro:principal/>输出.
         */
        @Override
        public String toString() {
            return userName;
        }

        /**
         * 重载hashCode,只计算loginName;
         */
        @Override
        public int hashCode() {
            return Objects.hashCode(userName);
        }

        /**
         * 重载equals,只计算loginName;
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            ShiroUser other = (ShiroUser) obj;
            if (userName == null) {
                if (other.userName != null) {
                    return false;
                }
            } else if (!userName.equals(other.userName)) {
                return false;
            }
            return true;
        }
    }
}

package com.codingfans.model;

import java.io.Serializable;

/**
 * 用户类
 *
 * @author Saber
 * @date 2015-10-20 17:11:14
 */
public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3574849894180631930L;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户密码（未加密）
     */
    private String plainPwd;

    /**
     * 用户密码（加密）
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 盐（加密的佐料）
     */
    private String salt;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 用户名
     */
    private String userName;

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
    
    public String getUserId() {
    
        return userId;
    }

    
    public void setUserId(String userId) {
    
        this.userId = userId;
    }

    public String getPlainPwd() {

        return plainPwd;
    }

    public void setPlainPwd(String plainPwd) {

        this.plainPwd = plainPwd;
    }

    public String getPassword() {
    
        return password;
    }

    
    public void setPassword(String password) {
    
        this.password = password;
    }

    public String getRealName() {

        return realName;
    }

    public void setRealName(String realName) {

        this.realName = realName;
    }

    public String getSalt() {

        return salt;
    }

    public void setSalt(String salt) {

        this.salt = salt;
    }

    public Integer getStatus() {

        return status;
    }

    public void setStatus(Integer status) {

        this.status = status;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }
}

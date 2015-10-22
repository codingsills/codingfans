package com.codingfans.model;

import java.io.Serializable;

/**
 * 
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
     * 
     */
    private String email;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String plainPwd;

    /**
     * 
     */
    private String pwd;

    /**
     * 
     */
    private String realName;

    /**
     * 
     */
    private String salt;

    /**
     * 
     */
    private Integer status;

    /**
     * 
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

    public String getPwd() {

        return pwd;
    }

    public void setPwd(String pwd) {

        this.pwd = pwd;
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

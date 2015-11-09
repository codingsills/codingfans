package com.codingfans.model;

import java.io.Serializable;

/**
 * 
 *
 * @author Saber
 * @date 2015-11-09 14:13:51
 */
public class UserRole implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7620375909419574278L;

    /**
     * 
     */
    private String roleId;
    
    /**
     * 
     */
    private String userId;
    
    public String getRoleId() {
        return roleId;
    }
        
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    
    public String getUserId() {
        return userId;
    }
        
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
}

package com.codingfans.model;

import java.io.Serializable;

/**
 * 
 *
 * @author Saber
 * @date 2015-11-09 14:13:51
 */
public class Role implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5864846179705891077L;

    /**
     * 
     */
    private String description;
    
    /**
     * 
     */
    private String roleId;
    
    /**
     * 
     */
    private String roleName;
    
    /**
     * 
     */
    private String status;
    
    public String getDescription() {
        return description;
    }
        
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getRoleId() {
        return roleId;
    }
        
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    
    public String getRoleName() {
        return roleName;
    }
        
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public String getStatus() {
        return status;
    }
        
    public void setStatus(String status) {
        this.status = status;
    }
    
}

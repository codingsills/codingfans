package com.codingfans.model;

import java.io.Serializable;

/**
 * 
 *
 * @author Saber
 * @date 2015-11-09 14:13:51
 */
public class RolePermission implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8369750548666715580L;

    /**
     * 
     */
    private String pmId;
    
    /**
     * 
     */
    private String roleId;
    
    public String getPmId() {
        return pmId;
    }
        
    public void setPmId(String pmId) {
        this.pmId = pmId;
    }
    
    public String getRoleId() {
        return roleId;
    }
        
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    
}

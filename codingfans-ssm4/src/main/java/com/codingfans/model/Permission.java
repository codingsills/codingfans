package com.codingfans.model;

import java.io.Serializable;

/**
 * 
 *
 * @author Saber
 * @date 2015-11-09 14:13:51
 */
public class Permission implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -393677528152419639L;

    /**
     * 
     */
    private String description;
    
    /**
     * 
     */
    private String pmId;
    
    /**
     * 
     */
    private String pmName;
    
    /**
     * 
     */
    private String pmType;
    
    /**
     * 
     */
    private String rule;
    
    public String getDescription() {
        return description;
    }
        
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getPmId() {
        return pmId;
    }
        
    public void setPmId(String pmId) {
        this.pmId = pmId;
    }
    
    public String getPmName() {
        return pmName;
    }
        
    public void setPmName(String pmName) {
        this.pmName = pmName;
    }
    
    public String getPmType() {
        return pmType;
    }
        
    public void setPmType(String pmType) {
        this.pmType = pmType;
    }
    
    public String getRule() {
        return rule;
    }
        
    public void setRule(String rule) {
        this.rule = rule;
    }
    
}

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
     * 描述
     */
    private String description;
    
    /**
     * ID
     */
    private String pmId;
    
    /**
     * 名称
     */
    private String pmName;
    
    /**
     * 类型
     */
    private String pmType;
    
    /**
     * 路径
     */
    private String rule;
    
    /**
     * 父节点ID
     */
    private String parentId;
    
    /**
     * 是否叶子
     */
    private String isLeaf;
    
    /**
     * 权重
     */
    private Integer weight;
    
    /**
     * 图标
     * */
    private String icon;
    
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

    
    public String getParentId() {
    
        return parentId;
    }

    
    public void setParentId(String parentId) {
    
        this.parentId = parentId;
    }

    
    public String getIsLeaf() {
    
        return isLeaf;
    }

    
    public void setIsLeaf(String isLeaf) {
    
        this.isLeaf = isLeaf;
    }

    
    public Integer getWeight() {
    
        return weight;
    }

    
    public void setWeight(Integer weight) {
    
        this.weight = weight;
    }

    
    public String getIcon() {
    
        return icon;
    }

    
    public void setIcon(String icon) {
    
        this.icon = icon;
    }
    
}

/**
 * 创建于: 2015年11月9日 下午4:38:52<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:UserVO.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.vo;

import java.util.List;

import com.codingfans.model.User;

/**
 * 用户页面模型类
 * UserVO.java
 *
 * @date 2015年11月9日 Saber
 * 
 * @author Saber
 * @version 0.1.0
 */
public class UserVO extends User{

    /**
     * 
     */
    private static final long serialVersionUID = -121176665088549966L;
    
    private List<RoleVO> roles;

    
    public List<RoleVO> getRoles() {
    
        return roles;
    }

    
    public void setRoles(List<RoleVO> roles) {
    
        this.roles = roles;
    }
    
    

}

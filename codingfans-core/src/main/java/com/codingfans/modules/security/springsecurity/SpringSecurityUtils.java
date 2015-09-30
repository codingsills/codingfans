/**
 * 项目名: CodingFans
 * 包  名: org.codingfans.modules.spring.springsecurity
 * 文件名: SpringSecurityUtils.java
 * 日  期: 2014年8月4日 下午2:45:47
 * Copyright (c) 2014-2014梦想天堂工作室-版权所有
 * 
 * @author Administrator
 * @version [V1.0]
 */
package com.codingfans.modules.security.springsecurity;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

/**
 *
 * @ClassName SpringSecurityUtils
 * @author Administrator
 * @date 2014年8月4日 下午2:45:47
 */

public class SpringSecurityUtils
{
    
    /**
     *
     * 构造方法 SpringSecurityUtils. 
     */
    public SpringSecurityUtils()
    {
    }
    /**
     * 取得当前用户, 返回值为SpringSecurity的User类或其子类, 如果当前用户未登录则返回null.
     */
    @SuppressWarnings("unchecked")
    public static <T extends User>T getCurrentUser(){
        Authentication authentication = getAuthentication();
        
        if(authentication == null){
            return null;
        }
        
        Object principal = authentication.getPrincipal();
        if(!(principal instanceof User)){
            return null;
        }
        return (T)principal;
    }
    
    /**
     * 获取当前用户名，如果当前用户没登陆则返回空字符串
     * */
    public static String getCurrentUserName(){
        Authentication authentication = getAuthentication();
        if(authentication == null || authentication.getPrincipal() == null){
            return "";
        }
        
        return authentication.getName();
        
    }
    
    /**
     * 取得当前用户登录IP, 如果当前用户未登录则返回空字符串.
     */
    public static String getCurrentUserIp(){
        Authentication authentication = getAuthentication();
        if(authentication == null){
            return "";
        }
        
        Object details = authentication.getDetails();
        if(!(details instanceof WebAuthenticationDetails)){
            return "";
        }
        
        WebAuthenticationDetails webDetails = (WebAuthenticationDetails)details;
        
        return webDetails.getRemoteAddress();
    }
    
    /**
     * 判断用户是否拥有角色, 如果用户拥有参数中的任意一个角色则返回true.
     */
    public static boolean hasAnyRole(String... roles){
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return false;
        }
        for(String role : roles){
            for(GrantedAuthority authority : authentication.getAuthorities()){
                if(role.equals(authority.getAuthority())){
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    /**
     * 将UserDetail保存到Security Context中
     * 
     * @param userDetails 已初始化好的用户信息.
     * @param request 用于获取用户IP地址信息,可为Null.
     * */
    public static void saveUserDetailsToContext(UserDetails userDetails, HttpServletRequest request){
        PreAuthenticatedAuthenticationToken pAuthenticationToken =
                new PreAuthenticatedAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        if(request != null){
            pAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
        }
        
        SecurityContextHolder.getContext().setAuthentication(pAuthenticationToken);
    }
    
    /**
     * 取得Authentication, 如当前SecurityContext为空时返回null.
     */
    private static Authentication getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();

        if (context == null) {
            return null;
        }

        return context.getAuthentication();
    }
    
}

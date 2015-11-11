/**
 * 创建于: 2015年11月11日 下午2:23:15<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:PaginatorSupport.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.utils;

import java.util.Collection;

import com.github.miemiedev.mybatis.paginator.domain.Paginator;

/**
 * 类功能描述
 * PaginatorSupport.java
 *
 * @date 2015年11月11日 Saber
 * 
 * @author Saber
 * @version 0.1.0
 */
public class PageObject<E> {
    /**
     * 分页返回参数    
     */
    private Paginator paginator;
    
    /**
     * 分页数据对象
     */
    private Collection<E> list;
    
    
    /**
     * PageObject.java 默认构造
     */
    public PageObject(Paginator paginator, Collection<E> list) {
        super();
        this.paginator = paginator;
        this.list = list;
    }


    public Paginator getPaginator() {
    
        return paginator;
    }

    
    public void setPaginator(Paginator paginator) {
    
        this.paginator = paginator;
    }

    
    public Collection<E> getList() {
    
        return list;
    }

    
    public void setList(Collection<E> list) {
    
        this.list = list;
    }
    
}

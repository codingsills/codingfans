/**
 * 创建于: 2015年11月11日 下午2:23:15<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:PaginatorSupport.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.utils;

import java.util.Collection;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
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
public class PageObject {
    
    private Integer page;
    
    /**
     * 分页数据对象
     */
    private Collection<?> rows;
    
    /**
     * 数据总条数
     * */
    private Integer total;
    
    /**
     * 每页条数
     * */
    private Integer limit;
    
    private Integer offset;
    
    private String order;
    
    private String sort;

    
    /**
     * PageObject.java 默认构造
     */
    public PageObject(PageList<?> pageList) {
        super();
        Paginator paginator = pageList.getPaginator();
        this.page = paginator.getPage();
        this.rows = pageList;
        this.total = paginator.getTotalCount();
    }
    
    public PageObject(Integer limit,Integer offset){
        this.limit = limit;
        this.offset = offset;
    }
    
    public PageObject(){
        
    }


    public Integer getPage() {
    
        return page;
    }

    
    public void setPage(Integer page) {
    
        this.page = page;
    }

    
    public Collection<?> getRows() {
    
        return rows;
    }

    
    public void setRows(Collection<?> rows) {
    
        this.rows = rows;
    }

    
    public Integer getTotal() {
    
        return total;
    }

    
    public void setTotal(Integer total) {
    
        this.total = total;
    }


    
    public Integer getLimit() {
    
        return limit;
    }


    
    public void setLimit(Integer limit) {
    
        this.limit = limit;
    }


    
    public Integer getOffset() {
    
        return offset;
    }


    
    public void setOffset(Integer offset) {
    
        this.offset = offset;
    }
    
    
    public String getOrder() {
    
        return order;
    }


    
    public void setOrder(String order) {
    
        this.order = order;
    }


    
    public String getSort() {
    
        return sort;
    }


    
    public void setSort(String sort) {
    
        this.sort = sort;
    }


    public Integer getCPage(){
        return (getOffset()/getLimit())+1;
    }
    
}

/**
 * 项目名: CodingFans
 * 包  名: org.codingfans.modules.orm
 * 文件名: PageDomainDao.java
 * 日  期: 2014年7月30日 下午4:10:16
 * Copyright (c) 2014-2014梦想天堂工作室-版权所有
 * 
 * @author FrancisAlice
 * @version [V1.0]
 */
package org.codingfans.modules.orm;

import java.util.List;
import java.util.Map;

import org.codingfans.modules.orm.PropertyFilter.MatchType;
import org.hibernate.criterion.Criterion;

/**
 * 扩展查询接口
 * @Description 扩展功能包括分页查询,按属性过滤条件列表查询.
 * @ClassName PageDomainDao
 * @author FrancisAlice
 * @date 2014年7月30日 下午4:10:16
 */

public interface ExtSimpleDao<T>
{
    /**
     * 分页获取全部对象
     * 
     * @param page 分页对象
     * 
     * @return Page<T>
     * */
    public Page<T> getAll(final Page<T> page);

    /**
     * 按HQL分页查询.
     * 
     * @param page 分页参数. 注意不支持其中的orderBy参数.
     * @param hql hql语句.
     * @param values 数量可变的查询参数,按顺序绑定.
     * 
     * @return 分页查询结果, 附带结果列表及所有查询输入参数.
     */
    public Page<T> findPage(final Page<T> page, final String hql, final Object... values);
    
    /**
     * 按HQL分页查询.
     * 
     * @param page 分页参数. 注意不支持其中的orderBy参数.
     * @param hql hql语句.
     * @param values 命名参数,按名称绑定.
     * 
     * @return 分页查询结果, 附带结果列表及所有查询输入参数.
     */
    public Page<T> findPage(final Page<T> page, final String hql, final Map<String, ?> values);
    
    /**
     * 按Criteria分页查询.
     * 
     * @param page 分页参数.
     * @param criterions 数量可变的Criterion.
     * 
     * @return 分页查询结果.附带结果列表及所有查询输入参数.
     */
    public Page<T> findPage(final Page<T> page, final Criterion... criterions);

    /**
     * 按属性过滤条件列表分页查找对象.
     * 
     * @param page 分页参数
     * @param filters 属性过滤条件
     * 
     * @return Page<T>
     */    
    public Page<T> findPage(final Page<T> page, final List<PropertyFilter> filters);
    
    /**
     * 按属性过滤条件列表查找对象列表.
     * 
     * @param filters 属性过滤条件
     * 
     * @return List<T>
     */
    public List<T> find(final List<PropertyFilter> filters);
    
    /**
     * 按属性查找对象列表,支持多种匹配方式.
     * 
     * @param propertyName 属性名
     * @param value 属性值
     * @param matchType 匹配方式,目前支持的取值见PropertyFilter的MatcheType enum.
     * 
     * @return List<T>
     */
    public List<T> findBy(final String propertyName, final Object value, final MatchType matchType);
}

package org.codingfans.modules.orm;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;

/**
 * 简单dao层抽象接口
 * */
public interface SimpleDao<T, PK extends Serializable> {
	
	/**
	 * 新增对象
	 * 
	 * @param T(新增对象)
	 * 
	 * @return PK(新增对象ID)
	 * */
	public void save(final T entity); 
	
	/**
     * 新增多个对象
     * 
     * @param entities(对象集合)
     * 
     * @return 新增个数
     * */
	public int save(final T[] entities);
	
	/**
	 * 新增多个对象
	 * 
	 * @param entities(对象集合)
	 * 
	 * @return 新增个数
	 * */
	public int save(final Collection<T> entities);
	
	/**
	 * 删除对象
	 * 
	 * @param entity
	 * 
	 * */
	public void delete(final T entity);
	
	/**
	 * 删除对象(根据ID)
	 * 
	 * @param id(对象ID)
	 * */
	public void delete(final PK id);
	
	/**
	 * 获取对象
	 * 
	 * @param id(对象ID)
	 * 
	 * @return T
	 * */
	public T get(final PK id);
	
	/**
	 * 根据ID集合获取多个对象
	 * 
	 * @param ids(对象ID集合)
	 * 
	 * @return List<T>
	 * */
	public List<T> get(final Collection<PK> ids);
	
	/**
	 * 获取所有对象
	 * 
	 * @return List<T>
	 * */
	public List<T> getAll();
	
	/**
	 * 获取所有对象(支持按属性排序)
	 * 
	 * @param property (排序属性)
	 * 
	 * @param isAsc (排序规则 -> true:asc,false:desc)
	 * 
	 * @return List<T>
	 * */
	public List<T> getAll(final String property, boolean isAsc);
	
	/**
	 * 按属性查找对象列表, 匹配方式为相等
	 * 
	 * @param propertyName 属性名
	 * 
	 * @param value 属性值
	 * 
	 * @return List<T> 对象列表 
	 * */
	public List<T> findBy(final String propertyName, final Object value);
	
	/**
	 * 按属性查找唯一对象, 匹配方式为相等
	 * 
	 * @param propertyName 属性名
	 * 
	 * @param value 属性值
	 * 
	 * @return T 对象
	 * */
	public T findUniqueBy(final String propertyName, final Object value);
	
	/**
	 * 按HQL查询对象列表
	 * 
	 * @param hql HQL查询语句
	 * 
	 * @param values 数量可变的参数,按顺序绑定
	 * eg:hql-> from User u where u.name = ?0 and u.age = ?1
	 * 
	 * @return
	 * */
	public <X> List<X> find(final String hql, final Object... values);
	
	/**
     * 按HQL查询唯一对象
     * 
     * @param hql HQL查询语句
     * 
     * @param values 数量可变的参数,按顺序绑定
     * eg:hql-> from User u where u.name = ?0 and u.age = ?1
     * 
     * @return
     * */
	public <X> X findUnique(final String hql, final Object... values);
	
	/**
     * 按HQL查询唯一对象.
     * 
     * @param hql HQL查询语句
     * 
     * @param values 命名参数,按名称绑定
     * eg:hql -> from User u where u.name = :name and u.age = :age
     * 
     * @return
     */
	public <X> X findUnique(final String hql, final Map<String,?> values);

	/**
     * 按Criteria查询对象列表
     * 
     * @param criterions 数量可变的Criterion
     * 
     * @return List<T>
     */
	public List<T> find(final Criterion... criterions);
	
	/**
     * 按Criteria查询唯一对象
     * 
     * @param criterions 数量可变的Criterion
     * 
     * @return T
     */
	public T findUnique(final Criterion... criterions);
	
	/**
     * 执行HQL进行批量修改/删除操作
     * 
     * @param hql HQL语句
     * 
     * @param values 数量可变的参数,按顺序绑定
     * eg:hql -> from User u where u.name = ?0 and u.age = ?1
     * 
     * @return 操作总数
     */
	public int batchExecute(final String hql, final Object... values);
	
	/**
     * 执行HQL进行批量修改/删除操作
     * 
     * @param hql HQL语句
     * 
     * @param values 命名参数,按名称绑定
     * eg:hql -> from User u where u.name = :name and u.age = :age
     * 
     * @return 更新记录数
     */
	public int batchExecute(final String hql, final Map<String,?> values);
	
    /**
     * 根据查询HQL与参数列表创建Query对象
     * 与find()函数可进行更加灵活的操作
     * 
     * @param values 数量可变的参数,按顺序绑定
     * eg:hql -> from User u where u.name = ?0 and u.age = ?1
     * 
     * @return Query
     */
	public Query createQuery(String hql, Object... values);
	
	/**
     * 根据查询HQL与参数列表创建Query对象
     * 与find()函数可进行更加灵活的操作
     * 
     * @param values 命名参数,按名称绑定
     * eg:hql -> from User u where u.name = :name and u.age = :age
     * 
     * @return Query
     */
	public Query createQuery(String hql, Map<String,?> values);
	
	/**
     * 根据Criterion条件创建Criteria.
     * 与find()函数可进行更加灵活的操作.
     * 
     * @param criterions 数量可变的Criterion.
     */
	public Criteria createCriteria(Criterion... criterions);
	
	
}

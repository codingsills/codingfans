/**
 * 创建于: 2015年11月10日 下午4:39:57<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:PaginationServer.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 类功能描述
 * PaginationServer.java
 *
 * @date 2015年11月10日 Saber
 * 
 * @author Saber
 * @version 0.1.0
 */
public class PaginationServer implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -5265524711539687224L;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    protected SqlSessionFactoryBean sqlSessionFactory;

    /**
     * 查询分页数据
     * 
     * @param mapperClass
     * @param sqlId
     * @param sqlParameter
     * @param pageBounds
     * @return
     * @throws Exception
     */
    protected List<?> getPageList(Class<?> mapperClass, String sqlId,
            Object sqlParameter, PageBounds pageBounds) throws Exception {
        SqlSession session = null;
        try {
            SqlSessionFactory sessionFactory = sqlSessionFactory.getObject();
            
            session = SqlSessionUtils.getSqlSession(sessionFactory);
            
            return session.selectList(mapperClass.getName() + "." + sqlId,
                    sqlParameter, pageBounds);
        } finally {
            session.close();
        }

    }

}

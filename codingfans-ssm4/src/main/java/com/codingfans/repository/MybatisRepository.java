/**
 * 创建于: 2015年10月8日 下午2:54:26<br>
 * 所属项目:TPS
 * 文件名称:MyBatisRepository.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.repository;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * 标识MyBatis的DAO,方便{@link org.mybatis.spring.mapper.MapperScannerConfigurer}的扫描。
 * MyBatisRepository.java
 *
 * @date 2015年10月8日 Saber
 * 
 * @author Saber
 * @version 0.1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MybatisRepository {
    String value() default "";
}

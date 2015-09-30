package com.codingfans.modules.test;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.test.context.ContextConfiguration;

import com.codingfans.modules.test.spring.SpringTxTestCase;
import com.codingfans.modules.test.utils.DbUnitUtils;

@ContextConfiguration(locations = { "/applicationContext-core-test.xml" })
public class DbUnitUtilsTest extends SpringTxTestCase {

	@Test
	public void normal() throws BeansException, Exception {
		jdbcTemplate.update("drop all objects");

		executeSqlScript("classpath:/schema.sql", false);

		DbUnitUtils.appendData((DataSource) applicationContext.getBean("dataSource"), "classpath:/test-data.xml");
		assertEquals(6, countRowsInTable("SS_USER"));

		DbUnitUtils.loadData((DataSource) applicationContext.getBean("dataSource"), "classpath:/test-data.xml");
		assertEquals(6, countRowsInTable("SS_USER"));

		DbUnitUtils.removeData((DataSource) applicationContext.getBean("dataSource"), "classpath:/test-data.xml");
		assertEquals(0, countRowsInTable("SS_USER"));
	}
}

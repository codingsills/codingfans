package com.codingfans.modules.utils.spring;

import static org.junit.Assert.*;

import org.codingfans.modules.utils.reflection.ReflectionUtils;
import org.codingfans.modules.utils.spring.SpringContextHolder;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextHolderTest {

	@Test
	public void testGetBean() {

		SpringContextHolder.clear();
		try {
			SpringContextHolder.getBean("foo");
			fail("No exception throw for applicationContxt hadn't been init.");
		} catch (IllegalStateException e) {

		}

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext-core-test.xml");
		assertNotNull(SpringContextHolder.getApplicationContext());

		SpringContextHolder holderByName = SpringContextHolder.getBean("springContextHolder");
		assertEquals(SpringContextHolder.class, holderByName.getClass());

		SpringContextHolder holderByClass = SpringContextHolder.getBean(SpringContextHolder.class);
		assertEquals(SpringContextHolder.class, holderByClass.getClass());

		context.close();
		assertNull(ReflectionUtils.getFieldValue(holderByName, "applicationContext"));

	}
}

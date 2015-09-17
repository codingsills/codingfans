package com.codingfans.modules.orm.hibernate;

import static org.junit.Assert.*;

import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.junit.Test;

import com.codingfans.modules.orm.hibernate.IgnorePrefixReverseEngineeringStrategy;
import com.codingfans.modules.utils.reflection.ReflectionUtils;

public class IgnorePrefixReverseEngineeringStrategyTest {

	public static class MyIgnorePrefixReverseEngineeringStrategy extends IgnorePrefixReverseEngineeringStrategy {
		public MyIgnorePrefixReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
			super(delegate);
		}

		@Override
		protected int getPrefixLength() {
			return 5;
		}
	}

	@Test
	public void normal() {

		MyIgnorePrefixReverseEngineeringStrategy strategy = new MyIgnorePrefixReverseEngineeringStrategy(null);

		String className = (String) ReflectionUtils.invokeMethod(strategy, "ignorePrefix",
				new Class[] { String.class }, new Object[] { "org.springside.TACCTHello" });
		assertEquals("org.springside.Hello", className);
	}
}

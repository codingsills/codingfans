package com.codingfans.modules.log;

import static org.junit.Assert.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.codingfans.modules.log.Log4jMBean;
import org.junit.Test;

public class Log4jMBeanTest {

	@Test
	public void testRootLoggerLevel() {
		Log4jMBean mbean = new Log4jMBean();

		String orgLevel = mbean.getRootLoggerLevel();
		Logger.getRootLogger().setLevel(Level.FATAL);

		assertEquals("FATAL", mbean.getRootLoggerLevel());

		mbean.setRootLoggerLevel("TRACE");
		assertEquals("TRACE", mbean.getRootLoggerLevel());

		mbean.setRootLoggerLevel(orgLevel);
	}

	@Test
	public void testLoggerLevel() {

		String loggerName = "org.springside.modules";
		Log4jMBean mbean = new Log4jMBean();
		String orgLevel = mbean.getLoggerLevel(loggerName);

		Logger.getLogger(loggerName).setLevel(Level.FATAL);
		assertEquals("FATAL", mbean.getLoggerLevel(loggerName));

		mbean.setLoggerLevel(loggerName, "TRACE");
		assertEquals("TRACE", mbean.getLoggerLevel(loggerName));

		mbean.setLoggerLevel(loggerName, "WRONG_LEVEL_NAME");
		assertEquals("DEBUG", mbean.getLoggerLevel(loggerName));

		mbean.setLoggerLevel(loggerName, orgLevel);
	}
}

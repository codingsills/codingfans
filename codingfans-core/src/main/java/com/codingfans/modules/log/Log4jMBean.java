package com.codingfans.modules.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * 基于JMX动态配置Logger日志等级, 获取Logger Appender的MBean.
 * @date 2014-07-12
 * */
@ManagedResource(objectName = Log4jMBean.LOG4J_MBEAN_NAME,description = "Log4j Management Bean")
public class Log4jMBean {
	
	/**
	 * Log4jMBean的注册名称
	 * */
	public static final String LOG4J_MBEAN_NAME = "Log4j:name=log4j";
	
	private static org.slf4j.Logger mbeanLogger = LoggerFactory.getLogger(Log4jMBean.class);
	
	/**
	 * 获取Root Logger的日志级别
	 * */
	@ManagedAttribute(description="Logging level of the root logger")
	public String getRootLoggerLevel(){
		Logger root = Logger.getRootLogger();
		Level level = root.getLevel();
		return level.toString();
	}
	
	/**
	 * 设置Root logger的日志级别
	 * 如果日志级别名称错误,设为DEBUG
	 * */
	@ManagedAttribute(description="Logging level of the root logger")
	public void setRootLoggerLevel(String newLevel){
		Logger root = Logger.getRootLogger();
		//转换日志级别,名称不对默认设为DEBUG
		Level level = Level.toLevel(newLevel);
		//设置Root Logger 日志级别
		root.setLevel(level);
		mbeanLogger.info("设置Root Logger的级别到{}",newLevel);
	}
	
	/**
	 * 获取Logger的日志级别
	 * */
	@ManagedOperation(description = "Get logging level of logger")
	@ManagedOperationParameters({@ManagedOperationParameter(name="loggerName",description="Logger Name")})
	public String getLoggerLevel(String loggerName){
		Logger logger = Logger.getLogger(loggerName);
		Level level = logger.getEffectiveLevel();
		return level.toString();
	}
	/**
	 * 设置Logger日志级别
	 * */
	@ManagedOperation(description = "Set new logging level to the logger")
	@ManagedOperationParameters({@ManagedOperationParameter(name="loggerName",description="Logger Name"),
		@ManagedOperationParameter(name="newLevel",description="New Level")})
	public void setLoggerLevel(String loggerName,String newLevel){
		Logger logger = Logger.getLogger(loggerName);
		Level level = Level.toLevel(newLevel);
		logger.setLevel(level);
		mbeanLogger.info("设置{}的级别到{}", loggerName, newLevel);
	}
}

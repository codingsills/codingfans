package org.codingfans.modules.log;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

/**
 * 在List中保存日志的Appender,用于测试日志输出
 * 
 * 在测试开始前,使用addToLogger方法将此appender添加到需要侦听的logger.
 * */
public class MockLog4jAppender extends AppenderSkeleton {
	
	private List<LoggingEvent> logs = new ArrayList<LoggingEvent>();
	
	/**
	 * 返回之前append的第一个log事件
	 * */
	public LoggingEvent getFirstLog(){
		if(logs.isEmpty()){
			return null;
		}
		return logs.get(0);
	}

	/**
	 * 返回之前append的最后一个log事件
	 * */
	public LoggingEvent getLastLog(){
		if(logs.isEmpty()){
			return null;
		}
		return logs.get(logs.size() - 1);
	}
	
	/**
	 * 返回之前append的log事件list
	 * */
	public List<LoggingEvent> getAllLogs(){
		return logs;
	}
	
	/**
	 * 清楚之前append的log事件list
	 * */
	public void clearLogs(){
		logs.clear();
	}
	
	/**
	 * 将此appender添加到logger中
	 * */
	public void addToLogger(String loggerName){
		Logger logger = Logger.getLogger(loggerName);
		logger.addAppender(this);
	}
	
	/**
	 * 将此appender添加到logger中
	 * */
	public void addToLogger(Class<?> loggerClass){
		Logger logger = Logger.getLogger(loggerClass);
		logger.addAppender(this);
	}
	
	/**
	 * 将此appender从logger中移除
	 * */
	public void removeFromLogger(String loggerName){
		Logger logger = Logger.getLogger(loggerName);
		logger.removeAppender(this);
	}
	
	/**
	 * 将此appender从logger中移除
	 * */
	public void removeFromLogger(Class<?> loggerClass){
		Logger logger = Logger.getLogger(loggerClass);
		logger.removeAppender(this);
	}
	
	public void close() {

	}

	public boolean requiresLayout() {
		return false;
	}

	/**
	 * 实现AppenderSkeleton的append方法, 将log事件加入到内部的List.
	 */
	@Override
	protected void append(LoggingEvent event) {
		logs.add(event);
	}

}

package com.codingfans.modules.exception;

/**
 * 公共异常类
 * */
public class CommonException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4747983297143180069L;
	
	/**
	 * 错误信息对象
	 * */
	private CommonErrInfo errInfo = null;
	/**
	 * 错误描述
	 * */
	private String errDesc ;
	/**
	 * 错误信息
	 * */
	private String msg;
	/**
	 * 错误码
	 * */
	private String errorCode;
	/**
	 * 动态参数
	 * */
	private Object[] dynamicParam;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public CommonErrInfo getErrInfo() {
		//设置错误信息描述
		this.errInfo.setErrDesc(this.errDesc);
		//设置动态信息描述
		this.errInfo.setDynamicParam(getDynamicParam());
		return this.errInfo;
	}
	public String getErrDesc() {
		return errDesc;
	}
	public Object[] getDynamicParam() {
		return dynamicParam;
	}
	/**
	 * 构造方法
	 * @param errInfo 错误信息
	 * */
	public CommonException(CommonErrInfo errInfo) {
		super(errInfo.toString());
		this.errInfo = errInfo;
	}
	/**
	 * 构造方法
	 * @param errInfo 错误信息
	 * @param errDesc 错误描述
	 * */
	public CommonException(CommonErrInfo errInfo, String errDesc) {
		super(errInfo.toString() + "[" + errDesc + "]");
		this.errInfo = errInfo;
		this.errDesc = errDesc;
	}
	/**
	 * 构造方法
	 * @param errInfo 错误信息
	 * @param dynamicParam 动态参数信息
	 * */
	public CommonException(CommonErrInfo errInfo, Object[] dynamicParam) {
		super(errInfo.toString());
		this.errInfo = errInfo;
		this.dynamicParam = dynamicParam;
	}

	/**
	 * 构造方法
	 * @param errInfo 错误信息
	 * @param e 原始异常
	 * */
	public CommonException(CommonErrInfo errInfo, Throwable e) {
		super(errInfo.toString(), e);
		this.errInfo = errInfo;
	}

	/**
	 * 构造方法
	 * @param errInfo 错误信息
	 * @param errDesc 错误描述
	 * @param e 原始异常
	 * */
	public CommonException(CommonErrInfo errInfo, String errDesc, Throwable e) {
		super(errInfo.toString() + "[" + errDesc + "]", e);
		this.errInfo = errInfo;
		this.errDesc = errDesc;
	}
	/**
	 * 构造方法
	 * @param ex 
	 * */
	public CommonException(CommonException ex){
		this(ex.getErrInfo(), ex.getCause());
	}
	
	/**
	 * 构造方法
	 * @param msg 错误信息
	 * @param errCode 错误码
	 * */
	public CommonException(String msg, String errCode){
		this.msg = msg;
		this.errorCode = errCode;
	}
	
}

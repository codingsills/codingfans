package org.codingfans.modules.exception;

import org.apache.commons.lang3.StringUtils;
/**
 * 公用异常类,所特有组件异常的父类，定义公共系统错误码和其对应错误信息
 * */
public class CommonErrInfo {
    /**
     * 错误码
     */
    private String errCode;
    
    /**
     * 错误码对应消息
     */
    private String errMsg;
    
    /**
     * 扩展的错误描述
     */
    private String errDesc;
    
    /**
     * 动态参数
     */
    private Object[] dynamicParam;
    
    public Object[] getDynamicParam()
    {
        return dynamicParam;
    }
    
    public void setDynamicParam(Object[] dynamicParam)
    {
        this.dynamicParam = dynamicParam;
    }
    
    /**
     * 获取自定义扩充信息
     * @return 
     *
     */
    public String getErrDesc()
    {
        return errDesc;
    }
    
    public void setErrDesc(String errDesc)
    {
        this.errDesc = errDesc;
    }
    
    /**
     * 初始化构造函数
     */
    public CommonErrInfo(String errCode, String errMsg)
    {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
    
    /**
     *未知异常，code：sys_10001
     */
    public static final CommonErrInfo UNKOWN_ERROR = new CommonErrInfo(
            "sys_10001", "未知异常");
    
    /**
     *系统连接异常，code：sys_10002
     */
    public static final CommonErrInfo CONNECTION_ERROR = new CommonErrInfo(
            "sys_10002", "系统连接异常");
    
    /**
     * 数据库异常，code：sys_10003
     */
    public static final CommonErrInfo DB_ERROR = new CommonErrInfo(
            "sys_10003", "数据库异常");
    
    /**
     * 文件读取异常，code：sys_10004
     */
    public static final CommonErrInfo FILE_IO_ERROR = new CommonErrInfo(
            "sys_10004", "文件读取异常");
    
    /**
     * 内存溢出异常,code：sys_10005
     */
    public static final CommonErrInfo OUTOF_MEMERY_ERROR = new CommonErrInfo(
            "sys_10005", "内存溢出异常");
    
    /**
     * 类型转换异常,code：sys_10006
     */
    public static final CommonErrInfo CLASSCAST_ERROR = new CommonErrInfo(
            "sys_10006", "类型转换异常");
    
    /**
     * 空指针异常,code：sys_10007
     */
    public static final CommonErrInfo NULL_POINTER_ERROR = new CommonErrInfo(
            "sys_10007", "空指针异常");
    
    /**
     * 文件不存在,code：sys_10008
     */
    public static final CommonErrInfo FILE_NOT_EXSITS = new CommonErrInfo(
            "sys_10008", "文件不存在");
    
    /**
     * XML解析异常,code：sys_10009
     */
    public static final CommonErrInfo XML_PARSE_ERROR = new CommonErrInfo(
            "sys_10009", "XML解析异常");
    
    /**
     * 创建文件路径异常,code：sys_10010
     */
    public static final CommonErrInfo CREATE_PATH_ERROR = new CommonErrInfo(
            "sys_10010", "创建文件路径异常");
    
    /**
     * 对象转换XML异常,code：sys_10011
     */
    public static final CommonErrInfo OBJECT_TO_XML_ERROR = new CommonErrInfo(
            "sys_10011", "对象转换XML异常");
    
    public static final CommonErrInfo TIME_OUT_ERROR = new CommonErrInfo(
            "sys_10012", "超时异常");
    
    public static final CommonErrInfo INTERRUPTED_ERROR = new CommonErrInfo(
            "sys_10013", "中断异常");
    
    public static final CommonErrInfo ILLEGAL_STATE_ERROR = new CommonErrInfo(
            "sys_10014", "状态非法异常");
    
    public static final CommonErrInfo RESP_RE_ERROR = new CommonErrInfo(
            "202", "反馈消息异常");
    
    /**
     * SQL异常，code：sys_10015
     */
    public static final CommonErrInfo SQL_ERROR = new CommonErrInfo(
            "sys_10015", "SQL异常");
    
    /**
     * 输入参数不能为空，code：sys_10016
     */
    public static final CommonErrInfo PARAMETER_IS_NULL = new CommonErrInfo(
            "sys_10016", "输入参数不能为空");
    
    /**
     * 获取错误码
     * @return 
     *
     */
    public String getErrCode()
    {
        return errCode;
    }
    
    /**
     * 错误码中的错误信息
     * @return 
     *
     */
    public String getErrMsg()
    {
        return errMsg;
    }
    
    /**
     * 包括错误码中的错误信息和自定义扩充的信息
     * @return 
     *
     */
    public String getDetailErrMsg()
    {
        return errMsg + "," + getErrDesc();
    }
    
    /**
     * 
     * @return
     */
    public String toString()
    {
        if (StringUtils.isNotBlank(this.getErrDesc()))
        {
            return "[ERROR CODE:" + this.getErrCode() + "]" + this.getErrMsg()
                    + " ,DETAIL:" + this.getErrDesc();
        }
        return "[ERROR CODE:" + this.getErrCode() + "]" + this.getErrMsg();
    }
}

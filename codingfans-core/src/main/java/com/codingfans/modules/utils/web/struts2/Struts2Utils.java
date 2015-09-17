/**
 * 项目名: CodingFans
 * 包  名: org.codingfans.modules.utils.web.struts2
 * 文件名: Struts2Utils.java
 * 日  期: 2014年8月4日 下午8:16:10
 * Copyright (c) 2014-2014梦想天堂工作室-版权所有
 * 
 * @author Administrator
 * @version [V1.0]
 */
package com.codingfans.modules.utils.web.struts2;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.codingfans.modules.utils.web.ServletUtils;

/**
 *
 * @ClassName Struts2Utils
 * @author Administrator
 * @date 2014年8月4日 下午8:16:10
 */

public class Struts2Utils
{
    //-- header 常量定义 --//
    private static final String HEADER_ENCODING = "encoding";
    private static final String HEADER_NOCACHE = "no-cache";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final boolean DEFAULT_NOCACHE = true; 

    /**
     * 取得HttpSession的简化函数.
     */
    public static HttpSession getSession() {
        return ServletActionContext.getRequest().getSession();
    }
    /**
     * 取得HttpSession的简化函数.
     */
    public static HttpSession getSession(boolean isNew) {
        return ServletActionContext.getRequest().getSession(isNew);
    }
    
    /**
     * 取得HttpSession中Attribute的简化函数.
     */
    public static Object getSessionAttribute(String name) {
        HttpSession session = getSession(false);
        return (session != null ? session.getAttribute(name) : null);
    }
    
    /**
     * 取得HttpRequest的简化函数.
     */
    public static HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }
    
    /**
     * 取得HttpRequest中Parameter的简化方法.
     */
    public static String getParameter(String name) {
        return getRequest().getParameter(name);
    }
    
    /**
     * 取得HttpResponse的简化函数.
     */
    public static HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }
    
    /**
     * 取得Writer的简化函数
     * */
    public static Writer getWriter() throws IOException{
        return getResponse().getWriter();
    }
    
    //-- 绕过jsp/freemaker直接输出文本的函数 --//
    /**
     * 直接输出内容的简便函数.

     * eg.
     * render("text/plain", "hello", "encoding:GBK");
     * render("text/plain", "hello", "no-cache:false");
     * render("text/plain", "hello", "encoding:GBK", "no-cache:false");
     * 
     * @param headers 可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为UTF-8和true.
     */
    public static void render(final String contentType, final String content, final String... headers) {
        HttpServletResponse response = initResponseHeader(contentType, headers);
        try {
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    /**
     * 直接输出文本.
     * @see #render(String, String, String...)
     */
    public static void renderText(final String text, final String... headers) {
        render(ServletUtils.TEXT_TYPE, text, headers);
    }

    /**
     * 直接输出HTML.
     * @see #render(String, String, String...)
     */
    public static void renderHtml(final String html, final String... headers) {
        render(ServletUtils.HTML_TYPE, html, headers);
    }

    /**
     * 直接输出XML.
     * @see #render(String, String, String...)
     */
    public static void renderXml(final String xml, final String... headers) {
        render(ServletUtils.XML_TYPE, xml, headers);
    }

    /**
     * 直接输出JSON.
     * 
     * @param jsonString json字符串.
     * @see #render(String, String, String...)
     */
    public static void renderJson(final String jsonString, final String... headers) {
        render(ServletUtils.JSON_TYPE, jsonString, headers);
    }
    
    /**
     * 直接输出JSON,使用fastjson转换Java对象.
     * 
     * @param data 可以是List<POJO>, POJO[], POJO, 也可以Map名值对.
     * @see #render(String, String, String...)
     */
    public static void renderJson(final Object data, final String... headers) {
        HttpServletResponse response = initResponseHeader(ServletUtils.JSON_TYPE, headers);
        try {
//            mapper.writeValue(response.getWriter(), data);
            response.getWriter().write(JSON.toJSONString(data));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 直接输出支持跨域Mashup的JSONP.
     * 
     * @param callbackName callback函数名.
     * @param object Java对象,可以是List<POJO>, POJO[], POJO ,也可以Map名值对, 将被转化为json字符串.
     */
    public static void renderJsonp(final String callbackName, final Object object, final String... headers) {
        String jsonString = null;
//        try {
//            jsonString = mapper.writeValueAsString(object);
//        } catch (IOException e) {
//            throw new IllegalArgumentException(e);
//        }
        jsonString = JSON.toJSONString(object);

        String result = new StringBuilder().append(callbackName).append("(").append(jsonString).append(");").toString();

        //渲染Content-Type为javascript的返回内容,输出结果为javascript语句, 如callback197("{html:'Hello World!!!'}");
        render(ServletUtils.JS_TYPE, result, headers);
    }
    
    /**
     * 分析并设置contentType与headers.
     */
    private static HttpServletResponse initResponseHeader(final String contentType, final String... headers) {
        //分析headers参数
        String encoding = DEFAULT_ENCODING;
        boolean noCache = DEFAULT_NOCACHE;
        for (String header : headers) {
            String headerName = StringUtils.substringBefore(header, ":");
            String headerValue = StringUtils.substringAfter(header, ":");

            if (StringUtils.equalsIgnoreCase(headerName, HEADER_ENCODING)) {
                encoding = headerValue;
            } else if (StringUtils.equalsIgnoreCase(headerName, HEADER_NOCACHE)) {
                noCache = Boolean.parseBoolean(headerValue);
            } else {
                throw new IllegalArgumentException(headerName + "不是一个合法的header类型");
            }
        }

        HttpServletResponse response = ServletActionContext.getResponse();

        //设置headers参数
        String fullContentType = contentType + ";charset=" + encoding;
        response.setContentType(fullContentType);
        if (noCache) {
            ServletUtils.setDisableCacheHeader(response);
        }

        return response;
    }
    
}

package com.codingfans.interceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 打印参数拦截器，用来打印请求参数信息
 * PrintParamsInterceptor.java
 *
 * @date 2016年1月6日
 * 
 * @author Saber
 */
public class PrintParamsInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger("Request Params-->>>");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception{
        String requestUrl = request.getRequestURI();
        logger.debug("URI:{},Referer:{}", requestUrl, request.getHeader("Referer"));
        Map<String, String[]> map = request.getParameterMap();
        for(Entry<String, String[]> entry : map.entrySet()){
            String pName = entry.getKey();
            String[] pValues = entry.getValue();
            if(pValues == null || pValues.length <= 0){
                continue;
            }
            if(SensitiveWords.stwords.contains(pName)){
                logger.debug(pName + ":***");
                continue;
            }
            logger.debug(pName + ":" + Arrays.toString(pValues));
        }
        return true;
    }

    enum SensitiveWords{
        PWD("password"), ID("id");

        private String value;

        private static List<String> stwords = null;

        static{
            stwords = new ArrayList<String>();
            for(SensitiveWords stword : SensitiveWords.values()){
                stwords.add(stword.getValue());
            }
        }

        private SensitiveWords(String value){
            this.value = value;
        }

        private String getValue(){
            return this.value;
        }
    }
}

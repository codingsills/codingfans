/**
 * 创建于: 2015年11月19日 下午5:14:44<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:HplusController.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类功能描述
 * HplusController.java
 *
 * @date 2015年11月19日 Saber
 * 
 * @author Saber
 * @version 0.1.0
 */
@Controller
@RequestMapping(value="/demo")
public class DemoController {
    
    @RequestMapping(value="/main.action")
    public String mainView(){
        return "demo/main";
    }

}

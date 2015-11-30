/**
 * 创建于: 2015年11月26日 下午3:50:23<br>
 * 所属项目:codingfans-ssm4
 * 文件名称:MenuEnum.java
 * 作者:Saber
 * 版权信息:
 */
package com.codingfans.utils;


/**
 * 菜单常量
 * Menu.java
 *
 * @date 2015年11月26日 Saber
 * 
 * @author Saber
 * @version 0.1.0
 */
public class Menu {
    
    /**
     * 菜单类型
     * */
    public enum MenuType{
        
        ISMENU("0","菜单"),ISBTN("1","按钮");
        
        private String type;
        
        private String name;
        
        /**
         * MenuTypeEnum.java 默认构造
         */
        private MenuType(String type, String name) {
            this.type = type;
            this.name = name;
        }
        
        public String getType(){
            return this.type;
        }
        
        public String getName(){
            return this.name;
        }
    }
    
    /**
     * 根、叶子
     * */
    public enum RLeaf{
        ROOT("0","根"),LEAF("1","叶子");
        
        private String type;
        
        private String name;

        /**
         * Menu.java 默认构造
         */
        private RLeaf(String type, String name) {
            this.type = type;
            this.name = name;
        }
        public String getType(){
            return this.type;
        }
        
        public String getName(){
            return this.name;
        }  
        
    }
    
}

--
--权限信息表
--表名：tb_permission
--说明：权限信息
-- 

CREATE TABLE tb_permission
(
    PM_ID CHARACTER(25) NOT NULL,	--ID
    PM_NAME VARCHAR(64) NOT NULL,	--权限名
    RULE VARCHAR(255) NOT NULL,	--权限规则（如：url、/user/*/*.jsp、规则等）
    PM_TYPE CHARACTER(1) NOT NULL,	--权限类型（如：菜单、按钮、静态资源等）
    PARENT_ID CHARACTER(25),	--父节点ID
    DESCRIPTION VARCHAR(255),	--描述
    WEIGHT BIGINT,
    ICON VARCHAR(255),
    PRIMARY KEY (pm_id)
);
    
CREATE sequence PM_ID AS INTEGER START WITH 1 increment BY 1 minvalue 1 no
maxvalue no cycle cache 20 no ORDER;
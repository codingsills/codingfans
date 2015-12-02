--
--用户信息表
--表名：tb_user
--说明：用户信息
-- 

CREATE TABLE tb_user
(
    USER_ID CHARACTER(25) NOT NULL,	--用户ID
    USER_NAME VARCHAR(30) NOT NULL,	--用户名
    REAL_NAME VARCHAR(50) NOT NULL,	--真实姓名
    PLAIN_PWD VARCHAR(50) NOT NULL,	--明文密码
    PASSWORD VARCHAR(50) NOT NULL,	--加密密码
    SALT VARCHAR(32) NOT NULL,	--
    STATUS CHARACTER(1) NOT NULL,	--用户状态
    EMAIL VARCHAR(64),	--邮件
    PRIMARY KEY (user_id)
);
    
CREATE sequence USER_ID AS INTEGER START WITH 1 increment BY 1 minvalue 1 no
maxvalue no cycle cache 20 no ORDER;
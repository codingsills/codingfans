--
--用户信息表
--表名：tb_user
--说明：用户信息
-- 

CREATE TABLE tb_user
(
    user_id CHARACTER(25) NOT NULL,	--用户ID
    user_name VARCHAR(30) NOT NULL,	--用户名
    real_name VARCHAR(50) NOT NULL,	--真实姓名
    plain_pwd VARCHAR(50) NOT NULL,	--明文密码
    password VARCHAR(50) NOT NULL,	--加密密码
    salt VARCHAR(32) NOT NULL,	--
    status CHARACTER(1) NOT NULL,	--用户状态
    email VARCHAR(64),	--邮件
    PRIMARY KEY (user_id)
);
    
CREATE sequence user_id AS INTEGER START WITH 1 increment BY 1 minvalue 1 no
maxvalue no cycle cache 20 no ORDER;
--
--角色表
--表名：tb_role
--说明：系统角色信息
-- 

CREATE TABLE tb_role
(
    role_id CHARACTER(25) NOT NULL,	--角色ID
    role_name VARCHAR(64) NOT NULL,	--角色名称
    status CHARACTER(4) NOT NULL, --角色状态
    description VARCHAR(255) NOT NULL, --角色描述
    PRIMARY KEY (role_id)
);
    
CREATE sequence role_id AS INTEGER START WITH 1 increment BY 1 minvalue 1 no
maxvalue no cycle cache 20 no ORDER;
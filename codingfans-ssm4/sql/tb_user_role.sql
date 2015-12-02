--
--用户角色关联表
--表名：tb_user_role
--说明：用户与角色对应关系
-- 

CREATE TABLE tb_user_role
(
	USER_ID CHARACTER(25) NOT NULL,	--用户ID
    ROLE_ID CHARACTER(25) NOT NULL	--角色ID
);

--
--角色权限关联表
--表名：tb_role_permission
--说明：角色与权限关联关系
-- 

CREATE TABLE tb_role_permission
(
    ROLE_ID CHARACTER(25) NOT NULL,	--角色ID
    PM_ID CHARACTER(25) NOT NULL	--权限ID
);

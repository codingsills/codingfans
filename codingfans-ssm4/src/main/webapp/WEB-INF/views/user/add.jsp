<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>新增用户</title>
</head>
	
<body>
	<div class="easyui-panel" title="新增用户">
		<form id="addForm" method="post" action="${ctx}/user/addUser.action">
		<table>
			<tr>
				<td>用户名：</td>
				<td>
					<input class="easyui-validatebox" type="text" name="userName" data-options="required:true" />
				</td>
			</tr>
			<tr>
				<td for="realName">姓名：</td>
				<td>
					<input class="easyui-validatebox" type="text" name="realName" data-options="required:true" />
				</td>
			</tr>
			<tr>
				<td for="plainPwd">密码：</td>
				<td>
					<input class="easyui-validatebox" type="password" name="plainPwd" data-options="required:true" />
				</td>
			</tr>
			<tr>
				<td for="roles">角色：</td>
				<td>
					<input class="easyui-validatebox" type="text" name="roles" data-options="required:false" />
				</td>
			</tr>
		</table>
		</form>
	</div>
	<script type="text/javascript">

	</script>
</body>
</html>

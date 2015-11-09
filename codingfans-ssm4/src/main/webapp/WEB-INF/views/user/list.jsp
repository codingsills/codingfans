<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>用户管理</title>
</head>
	
<body>
	<table id="grid"></table>
	<script type="text/javascript">
		var grid ;
		var toolbar = [{
			iconCls:'icon-add',
			text:'新增',
			handler:function(){
				window.location.href='${ctx}/user/addView.action';
			}
		},'-',{
			iconCls:'icon-edit',
			text:'修改',
			handler:function(){
				alert('修改');
			}
		},'-',{
			iconCls:'icon-remove',
			text:'删除',
			handler:function(){
				alert('删除');
			}
		}];
		$(function(){
			grid = $('#grid').datagrid({
				title:'用户列表',
				url:'${ctx}/user/list.action',
				toolbar:toolbar,
				height:500,
				columns:[[
		          {field:'userId',title:'ID',width:50},
		          {field:'userName',title:'用户名',width:120},
		          {field:'email',title:'邮箱',width:120},
		          {field:'opt',title:'操作',width:100}
				]]
			});
		});
	</script>
</body>
</html>

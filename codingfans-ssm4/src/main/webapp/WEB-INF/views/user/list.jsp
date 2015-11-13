<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>用户管理</title>
</head>
	
<body>
	<table id="t_grid"></table>
	<div id="toolbar">
		<button id="b_add" class="btn btn-primary">
            <i class="glyphicon glyphicon-plus"></i>新增
        </button>
		<button id="b_remove" class="btn btn-danger" disabled>
            <i class="glyphicon glyphicon-remove"></i>删除
        </button>
	</div>
	<script type="text/javascript">
		var grid;
		function initBtn(){
			$('#b_add').unbind().bind('click',function(){
				window.location.href='${ctx}/user/addView.action';
			});
			$('#b_remove').unbind().bind('click',function(){
				//window.location.href='${ctx}/user/addView.action';
			});			
		}
		$(function(){
			grid = $("#t_grid").bootstrapTable({
				url:'${ctx}/user/query.action',
				columns:[
		         {field:'userId',title:'ID'},
		         {field:'userName',title:'用户名'},
		         {field:'email',title:'邮箱'},
		         {field:'opt',title:'操作'}
		        ],
		        toolbar:'#toolbar',
		        pagination:true,
		        sidePagination:'server',
		        pageNumber:1,
		        pageSize:10,
		        pageList:[10,25,50],
		        showPaginationSwitch:true,
		        width:300
			});
			initBtn();
		})
	</script>
</body>
</html>

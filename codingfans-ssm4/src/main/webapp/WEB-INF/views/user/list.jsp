<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>用户管理</title>
</head>
	
<body>
	<div id="toolbar">
		<button id="b_add" class="btn btn-primary">
            <i class="glyphicon glyphicon-plus"></i>新增
        </button>
		<button id="b_remove" class="btn btn-danger" disabled>
            <i class="glyphicon glyphicon-remove"></i>删除
        </button>
	</div>
	<table id="table" data-url="${ctx}/user/query.action"></table>
		
		
<script type="text/javascript">
	var $table;
	function initBtn(){
		$('#b_add').unbind().bind('click',function(){
			window.location.href='${ctx}/user/addView.action';
		});
		$('#b_remove').unbind().bind('click',function(){
			//window.location.href='${ctx}/user/addView.action';
		});			
	}
	$(function(){
		$table = $('#table').bootstrapTable({
			height:getHeight(),
			columns:[
	         	{field:'userId',title:'ID'},
	         	{field:'userName',title:'用户名'},
	         	{field:'email',title:'邮箱'},
	         	{field:'opt',title:'操作'}
	        ],
 	        toolbar:'#toolbar',
	        pagination:true,
	        sidePagination:'server',
	        pageList:[10, 15, 25, 100]
		});
		initBtn();
	})
</script>
</body>
</html>

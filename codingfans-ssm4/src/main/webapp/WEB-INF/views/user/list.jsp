<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title>用户管理</title>
<!-- bootstrap table js -->
<script src="${ctx}/static/bootstrap/table/bootstrap-table.min.js" type="text/javascript" ></script>
<script src="${ctx}/static/bootstrap/table/bootstrap-table-zh-CN.min.js" type="text/javascript" ></script>
</head>
	
<body>
	<div>
		<div id="toolbar">
			<button id="b_add" class="btn btn-primary">
	            <i class="glyphicon glyphicon-plus"></i>新增
	        </button>
			<button id="b_remove" class="btn btn-danger" disabled>
	            <i class="glyphicon glyphicon-remove"></i>删除
	        </button>
		</div>
		<table id="table" data-url="${ctx}/user/query.action"></table>
	</div>
		
<script type="text/javascript">
	var $table,selections;
	function initBtn(){
		$('#b_add').on('click',function(){
			window.location.href='${ctx}/user/addView.action';
		});
		$('#b_remove').on('click',function(){
			//window.location.href='${ctx}/user/addView.action';
			console.log('Ids', selections);
		});		
	}
	//checkbox选中激活delete按钮，未选中时禁用
	function checkboxInit(){
		$table.on('check.bs.table uncheck.bs.table ' +
                'check-all.bs.table uncheck-all.bs.table', function () {
			$('#b_remove').prop('disabled', !$table.bootstrapTable('getSelections').length);
            selections = getIdSelections();
        });
	}
	//获取当前页选中记录IDs
	function getIdSelections() {
        return $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.userId
        });
    }
	$(function(){
		$table = $('#table').bootstrapTable({
			//height:getHeight(),
			columns:[
	         	{field:'state',checkbox:true,align:'center',valign:'middle'},
	         	{field:'userId',title:'ID'},
	         	{field:'userName',title:'用户名'},
	         	{field:'email',title:'邮箱'},
	         	{field:'opt',title:'操作',
	         		formatter:function(value,row,index){
	         			var str = '';
	         			str += formatStr('<a href="${ctx}/user/editView.action?userId={0}" title="修改"><i class="glyphicon glyphicon-edit"></i></a>',row.userId);
	         			str += '&emsp;'+formatStr('<a href="${ctx}/user/editView.action?userId={0}" title="删除"><i class="glyphicon glyphicon-remove"></i></a>',row.userId);
						return str;		
	         		}
	         	}
	        ],
	        search:true,
 	        toolbar:'#toolbar',
	        pagination:true,
	        idField:'userId',
	        sidePagination:'server',
	        pageList:[10, 15, 25, 100]
		});

		initBtn();
		checkboxInit();
	});
</script>
</body>
</html>

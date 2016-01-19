<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../frame/tag.jsp"%>
<html>
<head>
	<%@ include file="../frame/common.jsp" %>
	<link href="${ctx}/static/bootstrap/treeview/bootstrap-treeview.min.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/static/bootstrap/treeview/bootstrap-treeview.min.js" type="text/javascript" ></script>
	<title>新增角色</title>
</head>
	
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="panel-heading">新增角色</div>
		<div class="panel-body">
			<form id="addForm" method="post" action="${ctx}/role/addRole.action" class="form-horizontal">
				<div class="form-group">
					<label class="col-lg-3 control-label">角色名</label>
					<div class="col-lg-5">
						<input class="form-control" type="text" name="roleName"  />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">角色描述</label>
					<div class="col-lg-5">
						<input class="form-control" type="text" name="description" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">角色权限</label>
					<div class="col-lg-5">
						<div id="tree"></div>
					</div>
				</div>
				<div class="form-group">
                    <div class="col-lg-9 col-lg-offset-3">
                        <button type="submit" class="btn btn-primary">新&emsp;增</button>
                        <button id="toBack" type="button" class="btn btn-default">返&emsp;回</button>
                    </div>
                </div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function initBtn(){
			$('#toBack').on('click',function(){
				window.location.href='${ctx}/user/list.action';
			});
		}
		function getTree(){
			var menuJson;
			$.ajax({
				url:'${ctx}/menu/menuTree.action',
				async:false,
				success:function(data){
					menuJson = data;
				}
			});
			return menuJson;
		}
		$(function(){
			$('#addForm').bootstrapValidator({
				message: '参数无效',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields:{
					roleName:{
						message:'角色名无效',
						validators:{
							notEmpty:{
								message:'用户名不能为空'
							}
						}
					}
				}
			});
			initBtn();

			$('#tree').treeview({
				data: getTree(),
				showCheckbox:true,
				multiSelect:true,
				onNodeChecked:function(event,data){
					var nodeId = data.nodeId;
					$('#tree').treeview('selectNode',[data.nodeId,{silent:true}]);
				},
				onNodeUnchecked:function(event,data){
					var nodeId = data.nodeId;
					$('#tree').treeview('unselectNode',[data.nodeId,{silent:true}]);
				}
			});
		});
	</script>
</body>
</html>

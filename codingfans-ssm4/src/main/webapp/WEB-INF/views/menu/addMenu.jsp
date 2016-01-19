<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../frame/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../frame/common.jsp" %>
<title>新增菜单</title>
</head>
<body class="white-bg">
	<form class="form-horizontal" action="${ctx}/menu/addMenu.action" method="post">
		<div class="form-group" hidden>
	    <label for="menu_parentId" class="col-sm-2 control-label">父节点ID</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="parentId" value="${parentId}" id="menu_parentId" placeholder="父节点ID">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="menu_name" class="col-sm-2 control-label">菜单名称</label>
	    <div class="col-sm-10">
	      <input type="text" name="pmName" class="form-control" id="menu_name" placeholder="菜单名称">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="menu_link" class="col-sm-2 control-label">菜单路径</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="rule" id="menu_link" placeholder="菜单路径">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="menu_icon" class="col-sm-2 control-label">菜单图标</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="icon" id="menu_icon" placeholder="菜单图标">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="menu_weight" class="col-sm-2 control-label">菜单权重</label>
	    <div class="col-sm-10">
	      <input type="number" class="form-control" name="weight" id="menu_weight" placeholder="菜单权重">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="menu_desc" class="col-sm-2 control-label">描述</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="description" id="menu_desc" placeholder="描述">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-primary">新增</button>
	      <button id="toBack" type="button" class="btn btn-default">返回</button>
	    </div>
	  </div>
	</form>
<script type="text/javascript">
	function toBack(){
		$('#toBack').on('click',function(){
			window.location.href='${ctx}/menu/menuView.action';
		});
	}
	$(function(){
		toBack();
	});
</script>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../frame/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../frame/common.jsp" %>
<link href="${ctx}/static/bootstrap/treeview/bootstrap-treeview.min.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/static/bootstrap/treeview/bootstrap-treeview.min.js" type="text/javascript" ></script>
<script src="${ctx}/static/bootstrap/contextmenu/bootstrap-contextmenu.js" type="text/javascript" ></script>
<title>菜单管理</title>
</head>
<body class="white-bg">
	<div id="tree"></div>
	<div id="context-menu">
	  <ul class="dropdown-menu" role="menu">
	    <li><a tabindex="0" href="${ctx}/menu/toAddView.action?parentId="><i class="fa fa-plus fa-lg"></i>&nbsp;新增</a></li>
	    <li><a tabindex="1" href="${ctx}/menu/toModifyView.action?menuId="><i class="fa fa-pencil fa-lg"></i>&nbsp;修改</a></li>
	    <li><a tabindex="2" href="${ctx}/menu/toDelete.action?menuId="><i class="fa fa-remove fa-lg"></i>&nbsp;删除</a></li>
	  </ul>
	</div>
	<input id="p_id" type="text" hidden/>
	<script type="text/javascript">
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
		var menuId = 0;
		$('#tree').treeview({
			data: getTree()
		});
 		$('#tree').contextmenu({
			target:'#context-menu',
			onItem: function(context,e) {
			    var target = e.currentTarget;
			    var children = target.children;
			    children[0].href = children[0].href + menuId;
			    console.log(children[0].href);
			}
		});
		$('#context-menu').on('show.bs.context', function (e) {
	        var selectedNodes = $('#tree').treeview('getSelected');
	        if(selectedNodes.length > 0){
	        	menuId = selectedNodes[0].id;
	        	console.log(selectedNodes[0].text);
	        }else{
	        	e.preventDefault();
	        	$(this).closemenu();
	            return false;
	        }
	    });
	})
	</script>
</body>
</html>
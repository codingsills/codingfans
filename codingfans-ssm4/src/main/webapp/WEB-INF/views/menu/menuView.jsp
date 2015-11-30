<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../frame/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../frame/common.jsp" %>
<link href="${ctx}/static/bootstrap/treeview/bootstrap-treeview.min.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/static/bootstrap/treeview/bootstrap-treeview.min.js" type="text/javascript" ></script>
<title>菜单管理</title>
</head>
<body class="white-bg">
	<div id="tree"></div>
	
	<script type="text/javascript">
	var tree = [
	            {
	              text: "Parent 1",
	              icon: "glyphicon glyphicon-stop",
	              selectedIcon: "glyphicon glyphicon-stop",
	              color: "#000000",
	              backColor: "#FFFFFF",
	              nodes: [
	                {
	                  text: "Child 1",
	                  nodes: [
	                    {
	                      text: "Grandchild 1"
	                    },
	                    {
	                      text: "Grandchild 2"
	                    }
	                  ]
	                },
	                {
	                  text: "Child 2"
	                }
	              ]
	            },
	            {
	              text: "Parent 2",
	              icon: "glyphicon glyphicon-stop",
	              selectedIcon: "glyphicon glyphicon-stop",
	              color: "#000000",
	              backColor: "#FFFFFF",
	            },
	            {
	              text: "Parent 3"
	            },
	            {
	              text: "Parent 4"
	            },
	            {
	              text: "Parent 5"
	            }
	          ];
	$(function(){
		$('#tree').treeview({data: tree});
	})
	</script>
</body>
</html>
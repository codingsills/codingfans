<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tags/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<title>SSM4示例：<sitemesh:write property='title' /></title>
<sitemesh:write property='head' /> 
</head>
<body>
	<div class="easyui-layout" style="width:100%;height:100%;">
		<div data-options="region:'north'" style="height:50px">
			<%@ include file="/WEB-INF/layouts/header.jsp"%>
		</div>
		<div data-options="region:'west',split:true" title="菜单管理" style="width:100px;">
			菜单
		</div>
		<div data-options="region:'center',title:'主页'">
			<sitemesh:write property='body' />
		</div>
		<div data-options="region:'south',split:true" style="height:50px;">
			<%@ include file="/WEB-INF/layouts/footer.jsp"%>
		</div>
	</div>
</body>
</html>
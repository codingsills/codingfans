<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tags/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<title>SSM4示例：<sitemesh:write property='title' /></title>
<sitemesh:write property='head' /> 
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<sitemesh:write property='body' />
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
</body>
</html>
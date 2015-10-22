<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<%-- <link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon"> --%>
<link href="${ctx}/static/bootstrap/3.3.5/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/messages_zh.js" type="text/javascript"></script>
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
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<!------------------------------------- 公用样式引入 ------------------------------------>
<!-- bootstrap css -->
<link rel="stylesheet" type="text/css" href="${ctx}/static/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- bootstrap table css -->
<link rel="stylesheet" type="text/css" href="${ctx}/static/bootstrap/table/bootstrap-table.min.css">
<!-- bootstrap validator css -->
<link rel="stylesheet" type="text/css" href="${ctx}/static/bootstrap/validator-0.4.5/bootstrapValidator.min.css">
<!-- metisMenu css -->
<link rel="stylesheet" type="text/css" href="${ctx}/static/bootstrap/metisMenu/metisMenu.min.css">

<!------------------------------------- 公用JS引入 ------------------------------------->
<!-- jquery js -->
<script src="${ctx}/static/jquery/jquery-2.1.4.min.js" type="text/javascript" ></script>
<!-- bootstrap js -->
<script src="${ctx}/static/bootstrap/3.3.5/js/bootstrap.min.js" type="text/javascript" ></script>
<!-- bootstrapValidator js -->
<script src="${ctx}/static/bootstrap/validator-0.4.5/bootstrapValidator.min.js" type="text/javascript" ></script>
<!-- bootstrap table js -->
<script src="${ctx}/static/bootstrap/table/bootstrap-table.min.js" type="text/javascript" ></script>
<script src="${ctx}/static/bootstrap/table/bootstrap-table-zh-CN.min.js" type="text/javascript" ></script>
<script src="${ctx}/static/bootstrap/table/extensions/editable/bootstrap-table-editable.min.js" type="text/javascript"></script>
<!-- metisMenu js -->
<script src="${ctx}/static/bootstrap/metisMenu/metisMenu.min.js" type="text/javascript" ></script>
<!-- common js -->
<script src="${ctx}/static/common/js/common.js" type="text/javascript" ></script>

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
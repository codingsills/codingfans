<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!------------------------------------- 公用样式引入 ------------------------------------>

<!-- easyui css -->
<link rel="stylesheet" type="text/css" href="${ctx}/static/easyui-1.4.4/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/easyui-1.4.4/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/easyui-1.4.4/themes/color.css">

<!------------------------------------- 公用JS引入 ------------------------------------->

<!-- jquery js -->
<script src="${ctx}/static/jquery/jquery-2.1.4.min.js" type="text/javascript" ></script>
<!-- jquery-validation js -->
<script src="${ctx}/static/jquery-validation/jquery.validate.min.js" type="text/javascript" ></script>
<script src="${ctx}/static/jquery-validation/messages_zh.js" type="text/javascript" ></script>
<!-- easyui js -->
<script src="${ctx}/static/easyui-1.4.4/jquery.easyui.min.js" type="text/javascript" ></script>
<script src="${ctx}/static/easyui-1.4.4/easyui-lang-zh_CN.js" type="text/javascript" ></script>





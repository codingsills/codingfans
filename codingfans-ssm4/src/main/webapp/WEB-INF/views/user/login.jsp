<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>登录页</title>
</head>
	
<body>
	<form action="/login.action">
	  <div class="form-group">
	    <label for="userName">用户名</label>
	    <input type="text" class="form-control" id="userName" placeholder="用户名">
	  </div>
	  <div class="form-group">
	    <label for="password">密码</label>
	    <input type="password" class="form-control" id="password" placeholder="密码">
	  </div>
	  <div class="checkbox">
	    <label>
	      <input type="checkbox"> Check me out
	    </label>
	  </div>
	  <button type="submit" class="btn btn-default">登录</button>
	</form>
</body>
</html>

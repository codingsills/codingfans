<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<title>登录页</title>
</head>
	
<body>
	<form action="/login.action" method="POST">
	  <div class="form-group">
	    <label for="userName">用户名</label>
	    <input type="text" class="form-control" id="userName" name="userName" placeholder="用户名">
	  </div>
	  <div class="form-group">
	    <label for="password">密码</label>
	    <input type="password" class="form-control" id="password" name="password" placeholder="密码">
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

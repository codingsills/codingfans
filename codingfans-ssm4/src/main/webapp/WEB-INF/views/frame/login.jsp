<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>MPLUS | 登录</title>

    <link href="${ctx}/static/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet">

    <link href="${ctx}/static/common/css/animate.min.css" rel="stylesheet">
    <link href="${ctx}/static/common/css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name">M+</h1>
            </div>
            <h3>欢迎使用MPLUS</h3>
            <form class="m-t" role="form" action="${ctx}/login.action" method="POST">
                <div class="form-group">
                    <input type=text name="username" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="密码" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登录</button>

                <p class="text-muted text-center">
                	<a href="#"><small>忘记密码了？</small></a>|
	                <a href="register.html">注册一个新账号</a>
                </p>
            </form>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="${ctx}/static/jquery/jquery-2.1.4.min.js"></script>
    <script src="${ctx}/static/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>

</html>

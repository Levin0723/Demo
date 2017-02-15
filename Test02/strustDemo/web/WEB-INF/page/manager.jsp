<%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-1-23
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
</head>
<body>
<br/>
<br/>
<h1 align="center" style="width: 200px;margin: auto">后台管理</h1>
<hr style="width: 80%;margin: auto"/>
<h3 align="center" style="width: 200px;margin: auto">欢迎您：${sessionScope.user.username}</h3>
<br/>
<h2 align="center" style="width: 200px;margin: auto;color: red">已经登录的用户才能访问的页面</h2>
</body>
</html>

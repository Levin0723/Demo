<%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-2-9
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
请登录
<form action="/courses/doLogin" method="post">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="submit" value="登录"/>&nbsp;&nbsp;
    <input type="reset" value="取消"/>
</form>
</body>
</html>

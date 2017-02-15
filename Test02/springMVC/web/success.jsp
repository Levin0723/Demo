<%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-2-2
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<table>
    <tr>
        <td>用户名：</td>
        <td>${user.username}</td>
    </tr>
    <tr>
        <td>密码：</td>
        <td>${user.password}</td>
    </tr>
    <tr>
        <td>邮箱：</td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td>电话号码：</td>
        <td>${user.tel}</td>
    </tr>
    <tr>
        <td>地址：</td>
        <td>${user.address}</td>
    </tr>
    <tr>
        <td>爱好：</td>
        <td>${user.favor}</td>
    </tr>
</table>
</body>
</html>

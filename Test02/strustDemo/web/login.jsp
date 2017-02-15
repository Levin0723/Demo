<%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-1-22
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<br/>
<h1 align="center">欢迎登录</h1>
<br/>
<hr style="width: 60%;margin: auto;" color="coral"/>
<br/>
<form action="login.action" method="post">
    <table align="center" cellspacing="10px">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" size="15px"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" size="15px"/>
            </td>
        </tr>
        <tr id="sub">
            <td colspan="2" align="center">
                <input type="submit" value="登录"/>
                <input type="reset" value="取消"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">${sessionScope.loginError}</td>
        </tr>
    </table>
</form>
<s:form action="login" method="POST">
    <s:textarea name="user.username" title="用户名：" rows="1"/>
    <s:textarea name="user.password" title="密码：" rows="1"/>
    <s:submit value="登录"/><s:reset value="重置"/>
</s:form>
</body>
</html>

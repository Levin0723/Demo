<%--
  Created by IntelliJ IDEA.
  User: 黄桂道
  Date: 2017-2-2
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>登录信息</title>
</head>
<body>
<legend><b style="color: red">登录信息</b>->联系信息->兴趣爱好/legend>
<form:form>
    <table border="0">
        <tr>
            <td>用户名</td>
            <td>
                <form:input path="username" cssClass="fromStyle"/>
                <form:errors path="username" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <form:password path="password" size="21"/>
                <form:errors path="password" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td>
                <form:password path="pass" size="21"/>
                <form:errors path="pass" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <form:input path="email"/>
                <form:errors path="email" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="_target1" value="下一步"/>
                <input type="submit" name="_cancel" value="取消"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
